package bit.day0417.data;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
/*
 *  JPA(Java Persistence API)
 *  엔터티란 ?
 *  JPA에서 엔터티는 테이블에 대응하는 하나의 클래스라고 생각하면 된다.
 *  spring-boot-starter-data-jpa 의존성을 추가하고 @Entity 어노테이션을 붙이면 테이블과 자바 클래스가 매팅이 됩니다.
 * */

@Entity
@Table(name="jpamycar") //db에 jpamycar라는 테이블이 생성된다.
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MycarDto {
    @Id //각 엔터티를 구별할 수 있도록 식별 아이디를 갖도록 설계
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    //@Column(name = "dbcarname") //변수명과 달리 db 에는 dbcarname 으로 생성된다.
    @Column(length = 30) // name 은 생략시 변수명과 같은 이름으로 컴럼명이 생성된다.
    private String carname;

    private int carprice; //name은 같은 이름으로 생성할거라 필요없음 나머지 설정도 없다면 @Column 생략가능

    @Column(length = 30)
    private String carcolor;

    @Column(length = 20)
    private String carimage;

    @Column(length = 20)
    private String carguip;

    //writeday 는 자동으로 현재시간으로 추가되어야하고 수정시에는 제외되어야 한다.
    @CreationTimestamp
    @Column(updatable = false) //수정시 제외 어노테이션
    private Timestamp writeday;
    
    @Transient //@Transient : 테이블의 컬럼으로는 생성되지 않고 객체에서만 사용가능한 멤버변수
    private String message;

    @Transient //간단하게 말하면 테이블에 생성안되게하는 어노테이션
    private int commentcount;
}
