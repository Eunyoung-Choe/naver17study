package bit.day0417.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import bit.day0417.data.MycarDto;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class MycarDao {
	MycarRepository mycarRepository;
	
	public Long getTotalCount()
	{
//		return mycarRepository.count(); // 전체 개수 반환 
		return mycarRepository.getTotalMycount(); // 내가 직접 쿼리문으로 작성한 메서드, 결과 출력
	}
	
	public void insertCar(MycarDto dto)
	{
		// save()는 기본 제공 메서드인데 추가와 수정을 모두 담당해서 중요함.
		// num 값이 dto에 포함되어 있을 경우, 자동으로 수정. 없을 경우엔 추가가 됨.
		mycarRepository.save(dto);
	}
	
	public List<MycarDto> getAllCarList(){
//        return mycarRepository.findAll(); // 일반 출력
		return mycarRepository.findAll(Sort.by(Sort.Direction.DESC,"carprice")); // 단가 내림차순 정렬해서 출력 (반대는 ASC)
    }
	
	public Page<MycarDto> getAllPageCars(Pageable pageable) // 페이지에 필요한 만큼만 데이터 반환
	{
		return mycarRepository.findAll(pageable); 
	}
	
	public MycarDto getData(Long num)
	{
		return mycarRepository.getReferenceById(num);
	}
	
	public void updateCar(MycarDto dto)
	{
		mycarRepository.save(dto); // 이번에는 num이 포함되어 있으므로 수정이 됨.
	}
	
	public void deleteCar(Long num)
	{
		mycarRepository.deleteById(num);
	}
	
	// search
	public List<MycarDto> getSearchList(String search)
	{
		return mycarRepository.getSearchList(search);
	}
	
	public List<MycarDto> findByCarnameContaining(String search)
	{
		return mycarRepository.findByCarnameContaining(search);
	}
}
