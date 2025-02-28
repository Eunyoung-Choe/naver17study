//Servlet과 같은 역할을 함
package controller.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.test.TestDto;

@Controller //bean 객체 자동등록.
//@RestController로 할 경우 무조건 json으로만 처리가능. forward/Redirect 안됨
//이 경우 @ResponseBody 안붙여도 됨
public class HelloController {
   
   //@RequestMapping(value="/", method=RequestMethod.GET) //스프링 모든 버전에서 가능
   //@RequestMapping("/") //method 방식 생략 시 기본이 GET
   @GetMapping("/") //Spring 5부터 가능
   @ResponseBody //json 형식으로 바로 브라우저에 출력
   public TestDto hello() {
      TestDto dto = new TestDto();
      dto.setName("최은영");
      dto.setAddr("동대문구");
      dto.setHp("010-1234-5678");
      System.out.println(dto); // ToString 메서드 호출 (콘솔에서 찍히는 거 확인용이라는데 왜 안 뜨냐)
      return dto;
   }
}
