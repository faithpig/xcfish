package com.faith.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faith.dao.inter.IBlogDao;



@Service
public class BlogService {
	
	@Autowired
	private IBlogDao bloDao;
	
}
