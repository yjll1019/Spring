package net.skhu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.skhu.domain.User;
import net.skhu.repository.UserRepository;
import net.skhu.utils.Encryption;

//User와 관련된 작업이 구현된 클래스

@Service
public class UserService {
	@Autowired UserRepository userRepository;
	
	public User login(String loginId, String password) {
		User user = userRepository.findOneByLoginId(loginId);
		if(user == null) return null;
		//사용자가 입력한 비밀번호를 암호화하여 db에 저장된 비밀번호와 비교
		String pw = Encryption.encrypt(password, Encryption.MD5);
		if(user.getPassword().equals(pw)==false) return null;
		return user;
	}
}
