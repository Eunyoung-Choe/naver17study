package bit.react.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bit.react.data.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	Boolean existsByUsername(String username); // username이 존재하는지 true/false로 반환
	UserEntity findByUsername(String username); // 해당 username 정보를 UserEntity 타입으로 반환
}