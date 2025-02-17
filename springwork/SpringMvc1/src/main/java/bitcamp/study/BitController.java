package bitcamp.study;

import java.util.List;
import java.util.Vector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.test.TestDto;

@RestController
public class BitController {
	
//	@RestController는 json 출력 시 @ResponseBody 안 붙임.
	@GetMapping("/hello") // 매핑 주소명 내가 정하는 거임.
	public List<TestDto> list()
	{
		List<TestDto> list = new Vector<>();
		list.add(new TestDto("장원영", "서울","010100000"));
		list.add(new TestDto("카리나", "서울","010100000"));
		list.add(new TestDto("안유진", "대전","010100000"));
		
		return list;
	}
}
