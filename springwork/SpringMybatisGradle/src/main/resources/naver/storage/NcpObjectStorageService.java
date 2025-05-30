package naver.storage;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class NcpObjectStorageService implements ObjectStorageService {
	AmazonS3 s3;
	
	public NcpObjectStorageService(NaverConfig naverConfig) {
		System.out.println("NcpObjectStorageService 생성");
		s3 = AmazonS3ClientBuilder.standard()
				.withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(
						naverConfig.getEndPoint(), naverConfig.getRegionName()))
				.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(
						naverConfig.getAccessKey(), naverConfig.getSecretKey())))
				.build(); 
	}
	
	@Override
	public String uploadFile(String bucketName, String directoryPath, MultipartFile file) {
		System.out.println("uploadFile=" + file.getOriginalFilename());

		if (file.isEmpty()) {
			return null;
		}

		try (InputStream fileIn = file.getInputStream()) {
			// 파일명 형식: "yyyyMMddHHmm_UUID.확장자"
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmm_");
			String filename = sdf.format(new Date()) + UUID.randomUUID().toString().substring(0, 10)
					+ "." + file.getOriginalFilename().split("\\.")[1];

			// 파일 메타데이터 설정
			ObjectMetadata objectMetadata = new ObjectMetadata();
			objectMetadata.setContentType(file.getContentType());

			// S3 업로드 요청 객체 생성
			PutObjectRequest objectRequest = new PutObjectRequest(
					bucketName,
					directoryPath + "/" + filename,
					fileIn,
					objectMetadata).withCannedAcl(CannedAccessControlList.PublicRead);

			// S3에 파일 업로드
			s3.putObject(objectRequest);

			// 업로드된 파일명 반환
			return filename;

		} catch (Exception e) {
			throw new RuntimeException("파일 업로드 오류", e);
		}
	}


	@Override
	public void deleteFile(String bucketName, String directoryPath, String fileName) {
		String path = directoryPath + "/" + fileName;
		// 해당 파일이 존재하는지 확인
		boolean isfind = s3.doesObjectExist(bucketName, path);
		// 존재하면 삭제
		if (isfind) {
			s3.deleteObject(bucketName, path);
			System.out.println(path + ":삭제완료");
		}		
	}


}