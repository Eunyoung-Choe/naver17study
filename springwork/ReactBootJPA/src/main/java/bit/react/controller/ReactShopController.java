package bit.react.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import bit.react.data.ShopDto;
import bit.react.data.ShopEntity;
import bit.react.repository.ShopDao;
import lombok.RequiredArgsConstructor;
import naver.storage.NcpObjectStorageService;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/react")
public class ReactShopController {
	
	private final ShopDao shopDao;
	private final NcpObjectStorageService storageService;
	
	private String uploadFilename;
	
	// NCP 스토리지 버킷명 & 폴더명
	private String bucketName = "bitcamp-bucket-149";
	private String folderName = "jpashop";
	
	@PostMapping("/addshop")
	public String addShop(@RequestBody ShopDto dto) // json 데이터를 자바 객체로 변환
	{
		ShopEntity shopEntity = ShopEntity.builder()
				.sangpum(dto.getSangpum())
				.price(dto.getPrice())
				.sangguip(dto.getSangguip())
				.color(dto.getColor())
				.photo(uploadFilename)
				.build();
		// DB에 저장
		shopDao.insertShop(shopEntity);
		
		// 업로드 한 파일명은 초기화
		uploadFilename = null; // 기본은 null
		
		return "insert ok";
	}
	
	// 사진은 따로 업로드
	@PostMapping("/upload")
	public String uploadPhoto(@RequestParam("upload") MultipartFile upload)
	{
		System.out.println("업로드한 파일명:"+upload.getOriginalFilename());
	      if(uploadFilename!=null)
	         storageService.deleteFile(bucketName, bucketName, uploadFilename); //이전에 업로드한 사진 지우기
		
		// NCP에 업로드 하기
		uploadFilename = storageService.uploadFile(bucketName, folderName, upload);
		
		return uploadFilename;
	}
	
	@GetMapping("/detail")
	public ShopEntity getSelectData(@RequestParam("num") int num)
	{
		return shopDao.getData(num);
	}
	
	@GetMapping("/shoplist")
	public List<ShopEntity> selectAll()
	{
		return shopDao.getAllShops();
	}
	
	@DeleteMapping("/shopdelete")
	public String deleteShop(@RequestParam("num") int num)
	{
		// DB 삭제 전 스토리지의 사진 지우기
		String photoName = shopDao.getData(num).getPhoto();
		storageService.deleteFile(bucketName, folderName, photoName);
		
		shopDao.deleteShop(num);
		
		return "delete ok";
	}
	
	@PostMapping("shopupdate")
	public String updateShop(@RequestBody ShopDto dto) 
	{
		ShopEntity entity = ShopEntity.builder()
				.sangpum(dto.getSangpum())
				.color(dto.getColor())
				.price(dto.getPrice())
				.sangguip(dto.getSangguip())
				.num(dto.getNum())
				.photo(uploadFilename)
				.build();
		
		shopDao.updateShop(entity);
		uploadFilename = null;
		
		return "update ok";
	}
	
}
