package bit.day0417.data;

import jakarta.persistence.Transient;
import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "jpamycar_comment")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@JsonIgnoreProperties("hibernateLazyInitializer") // 오류날 경우 추가, 불필요한 직렬화를 막기 위한 어노테이션
public class MycarCommentDto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idx;
	
	/*
	 * 
	 */
	
	@ManyToOne // 댓글에는 이거?
	@JoinColumn(name = "num")
	@OnDelete(action = OnDeleteAction.CASCADE) // 부모 테이블 데이터를 지우면 댓글은 자동으로 삭제됨.
	private MycarDto mycar;

	@Column(length = 30)
	private String nickname;
	
	private String comment; // 생략 시 기본 컬럼명은 comment, length는 255가 됨.
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
	@Column(updatable = false)
	@CreationTimestamp // 엔티티가 생성되는 시점의 시간 자동 등록
	private Timestamp writeday;
	
	@Transient // 임시적
	private Long num;
}
