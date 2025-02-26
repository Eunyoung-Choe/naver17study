package board.controller;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import data.dto.BoardDto;
import data.dto.BoardFileDto;
import data.service.BoardFileService;
import data.service.BoardService;
import data.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
   
   final BoardService boardService;
   final BoardFileService fileService;
   final MemberService memberService;
   final NcpObjectStorageService storageService;
   
   //네이버 버켓이름
   private String bucketName="bitcamp-bucket-110";
   
   @GetMapping("/writeform")
   public String writeForm(
         //아래 4개의 값은 답글일떄만 넘어온다, 새글일떄는 null값이 넘어오므로
         //require 를 false 로 주거나 defaultValue 를 지정해야한다.
         
         @RequestParam(value="idx",defaultValue = "0")int idx,
         @RequestParam(value="regroup",defaultValue = "0")int regroup,
         @RequestParam(value="restep",defaultValue = "0")int restep,
         @RequestParam(value="relevel",defaultValue = "0")int relevel,
         @RequestParam(value="pageNum",defaultValue = "1")int pageNum,
         Model model
         ) 
   {
      
      model.addAttribute("idx", idx);
      model.addAttribute("regroup", regroup);
      model.addAttribute("restep", restep);
      model.addAttribute("relevel", relevel);
      model.addAttribute("pageNum", pageNum);
      
      return "board/writeform";
   }
   
   @PostMapping("/insert")
   public String insert(
         @ModelAttribute BoardDto dto,
         @RequestParam int pageNum,
         @RequestParam("upload") List<MultipartFile> upload,
         HttpSession session
         ) 
   {
      //세션으로 부터 아이디를 얻는다
      String myid=(String)session.getAttribute("loginid");
      
      //아이디를 이용해서 멤버 테이블에서 작성자를 얻는다(아이디와 작성자는 dto에 넣어야함)
      String writer=memberService.getSelectByMyid(myid).getMname();
      
      dto.setMyid(myid);
      dto.setWriter(writer);
      
      //게시판 내용을 일단 db에 저장(idx를 얻어올수 있기떄문에 내용을 db에 저장해야함)
      boardService.insertBoard(dto);
      
      //파일이 있는 경우에만 해당, 네이버 스토리지에 저장후 파일저장(idx,filename 필요함)
      //반복문 안에서 이루어져야만한다.
      BoardFileDto filedto = new BoardFileDto();
      for(MultipartFile file:upload) {
         if (!file.isEmpty()) {
            String filename = storageService.uploadFile(bucketName, "board", file);
            filedto.setIdx(dto.getIdx());
            filedto.setFilename(filename);
            
            fileService.insertBoardFile(filedto);            
         }
      }
      
      return "redirect:./list?pageNum="+pageNum;
   }
   
   @GetMapping("/detail")
   public String detail() {
      return "board/boarddetail";
   }
   
}
