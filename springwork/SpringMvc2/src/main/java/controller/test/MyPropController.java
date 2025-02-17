package controller.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import data.dto.MyCloudProps;
import data.dto.MyPropDto;
import lombok.AllArgsConstructor;

@Controller
//@AllArgsConstructor // 모든 멤버 변수에 자동 주입
public class MyPropController {

	@Autowired
	MyPropDto propDto;
	
	@Autowired
    private MyCloudProps myCloudProps;
	
	
	@Value("${server.port}")
	int port;
	
	@Value("${emp.addr}")
	String addr;
	
	
	@GetMapping("/prop1") // prop1,2는 hello.jsp에서 지정해줬었음.
	public String prop1(Model model)
	{
		model.addAttribute("addr", propDto.getAddr());
		model.addAttribute("hp", propDto.getHp());
		model.addAttribute("msg", "서버 포트는 "+port+"이고 지역은 "+addr+"입니다.");
		return "result3"; // 페이지 연결을 어디에서 하나 했는데 여기였네ㅎ;
	}
	
	@GetMapping("/prop2")
	public String prop2(Model model)
	{
		model.addAttribute("db", myCloudProps.getDb());
        model.addAttribute("username", myCloudProps.getUsername());
        model.addAttribute("password", myCloudProps.getPassword());
        
        return "result4";
	}
}
