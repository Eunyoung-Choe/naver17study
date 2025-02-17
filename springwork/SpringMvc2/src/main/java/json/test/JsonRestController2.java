package json.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import data.dto.TestDto;

// @Controller는 기본 기능이 포워드 또는 리다이렉트
// (json 데이터로 반환하려면 @ResponseBody를 앞에 표기해야 함.)
@Controller
public class JsonRestController2 {

	@GetMapping("/test")
	@ResponseBody public TestDto test1() // @ResponseBody 없으면 오류
	{
		TestDto dto = new TestDto("최은영", "서울시", "여성");
		return dto; // json 데이터로 변환 
	}
}
