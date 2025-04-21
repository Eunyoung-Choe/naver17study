package bit.day0417.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bit.day0417.data.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity,Integer>{
	public boolean existsByUsername(String username); // 기본적으로 제공하는 함수
	public UserEntity findByUsername(String username);
}
