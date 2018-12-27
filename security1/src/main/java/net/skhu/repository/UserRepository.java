package net.skhu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.skhu.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findOneByLoginId(String loginId); //User테이블에서 loginId 필드로 레코드 조회.
}
