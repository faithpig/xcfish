package com.faith.service.inter;

import java.util.List;

import com.faith.pojo.Blog;

public interface IBlogService {
	Blog save(Blog b);
	boolean update(Blog b);
	boolean delete(String id);
	Blog findById(String id);
	List<Blog> findAll();
}
