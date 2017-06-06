package com.faith.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.faith.pojo.Blog;
import com.faith.service.inter.IBlogService;

@Controller
@Scope("prototype")
public class BlogController {
	
	
	private IBlogService bloSer;
	
	//查看所有文章
	@RequestMapping(path="/blog/list")
	public String blog_home(HttpServletRequest request,Model model){
		model.addAttribute("list",bloSer.findAll());
		return "blog_list";
	}
	
	//查看单个文章
	@RequestMapping(path="/blog/{blog_Id}", method = RequestMethod.GET)
	public String blog_detail(@PathVariable String blog_id,Model model){
		model.addAttribute("blog",bloSer.findById(blog_id));
		return "blog_detail";
	}
	
	//后台查看所有文章
	@RequestMapping(path="/manage_blog/list")
	public String list_blog(HttpServletRequest request,Model model){
		model.addAttribute("list",bloSer.findAll());
		return "manage_blog_list";
	}
	
	//添加文章
	@RequestMapping(path="/manage_blog/add", method = RequestMethod.POST)
	public String add_blog(Blog b,Model model){
		if(b==null||bloSer.save(b).getBlog_id()==null){
			model.addAttribute("blog",b);
			return "add_form";
		}
		return "redirect:/manage_blog/list";
	}
	
	//删除文章
	@RequestMapping(path="/manage_blog/delete/{blog_Id}", method = RequestMethod.GET)
	public String del_blog(@PathVariable String blog_id, RedirectAttributes attr){		
		attr.addAttribute("flag",bloSer.delete(blog_id)?"删除成功":"删除失败！");//带参数重定向
		return "redirect:/manage_blog/list";
	}
	
	//更新文章
	@RequestMapping(path="/manage_blog/update", method = RequestMethod.POST)
	public String upd_blog(Blog b,Model model){
		if(b==null||!bloSer.update(b)){
			model.addAttribute("blog",b);
			return "add_form";
		}
		return "redirect:/manage_blog/list";
	}

	public IBlogService getBloSer() {
		return bloSer;
	}
	
	@Autowired
	public void setBloSer(IBlogService bloSer) {
		this.bloSer = bloSer;
	}
	
}
