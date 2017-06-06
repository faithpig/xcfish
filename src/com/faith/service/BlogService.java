package com.faith.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.dao.inter.IBlogDao;
import com.faith.pojo.Blog;
import com.faith.service.inter.IBlogService;


@Service
public class BlogService implements IBlogService{
	
	private IBlogDao bloDao;

	@Override
	public Blog save(Blog b) {
		return bloDao.add(b);
	}

	@Override
	public boolean update(Blog b) {
		return bloDao.update(b);
	}

	@Override
	public boolean delete(String id) {
		return bloDao.delete(id);
	}

	@Override
	public Blog findById(String id) {
		return bloDao.findById(id);
	}

	@Override
	public List<Blog> findAll() {
		return bloDao.findAll();
	}
	
	public IBlogDao getBloDao() {
		return bloDao;
	}

	@Autowired
	public void setBloDao(IBlogDao bloDao) {
		this.bloDao = bloDao;
	}
	
	
	
}
