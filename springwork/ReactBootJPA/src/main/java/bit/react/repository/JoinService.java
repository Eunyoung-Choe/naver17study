package bit.react.repository;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import bit.react.data.JoinDto;
import bit.react.data.UserEntity;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class JoinService {
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void joinProcess(JoinDto dto)
	{
		String username = dto.getUsername();
		Boolean isExist = userRepository.existsByUsername(username);
		if(isExist)
		{
			System.out.println("DB에 이미 존재함. 가입 안 됨.");
			return;
		}
		UserEntity data = UserEntity.builder()
			.username(username)
			.password(bCryptPasswordEncoder.encode(dto.getPassword()))
			.role(dto.getRole())
			.address(dto.getAddress())
			.build();
		
		// DB에 저장
		userRepository.save(data);
	}
}
