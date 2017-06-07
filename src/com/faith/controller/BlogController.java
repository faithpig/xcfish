package com.faith.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.faith.pojo.Blog;
import com.faith.service.inter.IBlogService;

@Controller
//@Scope("prototype") 无需设置为多例模式
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
		Blog b = bloSer.findById(blog_id);
		model.addAttribute("blog", b);
		b.setBlog_vnum(b.getBlog_vnum()+1);
		bloSer.update(b);
		return "blog_detail";
	}
	
	//后台查看所有文章
	@RequestMapping(path="/manage_blog/list")
	public String list_blog(HttpServletRequest request,Model model){
		model.addAttribute("list",bloSer.findAll());
		return "manage/admin";
	}
	
	//添加文章
	@RequestMapping(path="/manage_blog/add", method = RequestMethod.POST)
	public String add_blog(Blog b,Model model,RedirectAttributes attr){
		if(b!=null) {
			b.setBlog_ctime(new Date());
			b.setBlog_vnum(0);
			b = bloSer.save(b);
			attr.addAttribute("flag",b.getBlog_id()!=null?"添加成功":"添加失败！");
		}else{
			model.addAttribute("blog",b);
			return "manage/admin";
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
	public String upd_blog(Blog b,Model model,RedirectAttributes attr){//requestbody注解可自动解析前台传来的json对象为javabean对象
		if(b!=null) {
			b.setBlog_utime(new Date());
			attr.addAttribute("flag",bloSer.update(b)?"更新成功":"更新失败！");
		}
		else{
			model.addAttribute("blog",b);
			return "manage/admin";
		}
		return "redirect:/manage_blog/list";
	}

	public IBlogService getBloSer() {
		return bloSer;
	}
	
	@Autowired
	@Qualifier("blogService")
	public void setBloSer(IBlogService bloSer) {
		this.bloSer = bloSer;
	}
	
}
