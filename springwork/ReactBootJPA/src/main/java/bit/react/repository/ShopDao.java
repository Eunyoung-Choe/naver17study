package bit.react.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import bit.react.data.ShopEntity;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class ShopDao {
	private ShopRepository shopRepository;
	
	// 저장
	public void insertShop(ShopEntity shopEntity)
	{
		shopRepository.save(shopEntity); // num값이 포함되어 있지 않으면 추가됨.
	}
	
	// 전체 목록
	public List<ShopEntity> getAllShops()
	{
		return shopRepository.findAll(); // 추가한 순서대로 반환
	}
	
	// 한 개의 데이터 반환
	public ShopEntity getData(int num)
	{
		return shopRepository.getReferenceById(num);
	}
	
	// 삭제
	public void deleteShop(int num)
	{
		shopRepository.deleteById(num);
	}
	
	// 수정
	public void updateShop(ShopEntity shopEntity)
	{
		if(shopEntity.getPhoto()==null)
			shopRepository.updateShopNoPhoto(shopEntity); // photo 수정은 제외
		else
			shopRepository.save(shopEntity); // num이 포함되어 있으므로 수정됨.
	}
}
