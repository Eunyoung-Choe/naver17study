package bit.react.repository;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import bit.react.data.UserEntity;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService{

	private final UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		// DB에서 조회
		UserEntity userData = userRepository.findByUsername(username);
		// DB에 존재할 경우 user 정보 반환
		if(userData!=null)
		{
			return new CustomUserDetails(userData);
		}
		// 존재하지 않으면 그냥 null 반환
		System.out.println("user 정보가 DB에 없습니다.");
		return null;
	}

}
