package bit.day0417.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.day0417.data.MycarDto;
import bit.day0417.service.MycarCommentService;
import bit.day0417.service.MycarService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MycarController {
	
	final MycarService mycarService;
	final MycarCommentService commentService;
	int pageSize = 0; 
	
	@GetMapping("/")
	public String home()
	{
		return "redirect:./carlist";
	}
	
	@GetMapping("/addform")
	public String addform()
	{
		return "mycar/addform";
	}
	
	@PostMapping("/insert")
	public String insertCar(@ModelAttribute MycarDto dto)
	{
		// DB 저장
		mycarService.insertCar(dto);
		
		// 목록으로 이동
		return "redirect:./carlist";
	}
	
	@GetMapping("/carlist")
    public String list(Model model, @RequestParam(value="more", defaultValue="0") int more)
	{
		// more값이 null일 경우(0으로 초기화) 페이지에 보여질 개수는 3개
		// 0이 아닐 경우 기본 페이지 개수에 추가해서 보여지게 함.
		if(more==0)
			pageSize = 3; // 3개의 글 출력
		else
			pageSize += more;
        //총 갯수 구하기
        Long totalCount=mycarService.getTotalCount();
        //전체 목록 가져오기
//        List<MycarDto> list=mycarService.getAllCarList();
        
        // 페이지에 필요한 만큼만 가져오기
        Pageable pageable = PageRequest.of(0, pageSize, Sort.by("num").ascending()); // num의 오름차순
        Page<MycarDto> result = mycarService.getAllPageCars(pageable);
        List<MycarDto> list = result.getContent();
        
        // 댓글 개수 저장하기
        for(int i=0; i<list.size(); i++) {
        	MycarDto dto = list.get(i);
        	int n = commentService.getCommentList(dto.getNum()).size();
        	dto.setCommentcount(n);
        }

//        model.addAttribute("totalCount", totalCount);
        model.addAttribute("list",list);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("totalCount",result.getTotalElements());
        model.addAttribute("totalPage",result.getTotalPages());
        
        return "mycar/carlist";
    }
	
	@GetMapping("/detail")
	public String detail(@RequestParam("num") Long num, Model model)
	{
		MycarDto dto = mycarService.getData(num);
		model.addAttribute("dto", dto);
		
		return "mycar/detail";
	}
	
	@GetMapping("/updateform")
	public String updateForm(@RequestParam("num") Long num, Model model)
	{
		MycarDto dto = mycarService.getData(num);
		model.addAttribute("dto", dto);
		
		return "mycar/updateform";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute MycarDto dto)
	{
		mycarService.updateCar(dto);
		return "redirect:./detail?num=" + dto.getNum();
	}
	
	@GetMapping("/delete")
	public String deleteCar(@RequestParam("num") Long num)
	{
		mycarService.deleteCar(num);
		
		return "redirect:./carlist";
	}
	
	@GetMapping("/searchpage")
	public String searchPage()
	{
		return "mycar/searchlist";
	}
	
	@Operation(summary="search carname", description="자동차명으로 검색하기")
	@GetMapping("/searchlist")
	@ResponseBody
	public List<MycarDto> searchList(@RequestParam(value="search",defaultValue="") String search)
	{
//		return mycarService.getSearchList(search); 방법 1
		return mycarService.findByCarnameContaining(search); // jpa에서 제공
		// -> swagger-ui에서 테스트 해보기
	}
}
