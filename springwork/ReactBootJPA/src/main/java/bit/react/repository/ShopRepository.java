package bit.react.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import bit.react.data.ShopEntity;
import jakarta.transaction.Transactional;

public interface ShopRepository extends JpaRepository<ShopEntity, Integer> {
	@Query(value="""
			update jpashop set sangpum=:#{#entity.sangpum}, price=:#{#entity.price},
			color=:#{#entity.color}, sangguip=:#{#entity.sangguip}
			where num=:#{#entity.num}
			""", nativeQuery=true)
	@Modifying // 이건 insert, update, delete 뿐만 아니라 DDL 구문 사용할 때도 표기해줘야 함.
	@Transactional // 이건 update, delete를 할 때 표기를 해줘야 정상 실행이 됨.
	public void updateShopNoPhoto(@Param("entity") ShopEntity entity); // 수정 코드(photo는 제외)
}
