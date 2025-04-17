package bit.day0417.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bit.day0417.data.MycarCommentDto;
import bit.day0417.data.MycarDto;
import bit.day0417.service.MycarCommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

/*
 * 확인 방법
 * http://localhost:8080/swagger-ui/index.html
 */

@RestController
@RequiredArgsConstructor
public class MycarCommentController {

	final MycarCommentService commentService;
	@Operation(summary = "addcomment", description = "댓글(닉네임, 코멘트 추가 기능)")
//	@PostMapping("/addcomment")
//	public void addComment(@RequestParam("nickname") String nickname, @RequestParam("comment") String comment,
//						@RequestParam("num") Long num)
//	{
//		MycarDto dto = MycarDto.builder().num(num).build();
//		MycarCommentDto commentDto = MycarCommentDto.builder()
//				.nickname(nickname)
//				.comment(comment)
//				.mycar(dto)
//				.build();
//		
//		// DB insert
//		commentService.insertComment(commentDto);
//	}
	
	@PostMapping("/addcomment")
	public String addComment(@RequestBody MycarCommentDto dto)
	{
		MycarDto mycar = MycarDto.builder().num(dto.getNum()).build();
		MycarCommentDto commentDto = MycarCommentDto.builder()
				.mycar(mycar)
				.build();
		
		return "comment insert ok";
	}
	
	
	@GetMapping("/commentlist")
	public List<MycarCommentDto> commentList(@RequestParam("num") long num)
	{
		return commentService.getCommentList(num);
	}
	
	@Operation(summary = "commentdelete", description = "댓글 삭제 기능")
	@DeleteMapping("/commentdel")
	public String deleteComment(@RequestParam("idx") int idx)
	{
		commentService.deleteComment(idx);
		
		return "comment delete ok";
	}
}
