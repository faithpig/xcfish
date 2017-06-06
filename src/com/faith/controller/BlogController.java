package com.faith.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.faith.service.BlogService;
import com.faith.service.inter.IBlogService;

@Controller
public class BlogController {
	
	@Autowired
	private IBlogService bloSer;
	
}
