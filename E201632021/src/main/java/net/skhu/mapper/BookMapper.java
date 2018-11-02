package net.skhu.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import net.skhu.dto.Book;

@Mapper
public interface BookMapper {
	List<Book> findAll();
	void insert(Book book);
	Book findById(int id);
	void update(Book book);
	void delete(int id);
	List<Book> findJoinAll();
}
