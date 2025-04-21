package bit.day0417.repository;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import bit.day0417.data.UserEntity;

public class CustomUserDetail implements UserDetails{
	
	private UserEntity userEntity;
	
	// 생성자
	public CustomUserDetail(UserEntity userEntity) {
	    this.userEntity = userEntity;
	}

	// 사용자의 권한에 대해 리턴하는 메서드
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Collection<GrantedAuthority> collection = new ArrayList<>();
		
		collection.add(new GrantedAuthority() {
			
			@Override
			public String getAuthority() {
				// TODO Auto-generated method stub
				return userEntity.getRole();
			}
		});
		return collection;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userEntity.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userEntity.getUsername();
	}

}
