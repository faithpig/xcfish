package com.faith.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.faith.service.inter.IBlogService;
import com.fatih.service.BlogService;

@Controller
public class BlogController {
	
	@Autowired
	private IBlogService bloSer;
	
}
