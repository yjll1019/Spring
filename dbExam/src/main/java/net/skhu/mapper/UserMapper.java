package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.User;

@Mapper
public interface UserMapper {
	void insertUser(User user);
	User findUser(int id);
	List<User> findByAll();
	void updateUser(int id, String name);
	List<User> findByName(String name);
	List<User> findById(int id);
}
