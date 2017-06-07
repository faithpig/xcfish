package com.faith.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "xc_blog")
public class Blog {

	private String blog_id;//博客id
	private String blog_title;//博客标题
	private String blog_content;//博客内容
	private Date blog_ctime;//博客创建时间
	private Date blog_utime;//博客最近更新时间
	private long blog_vnum;//博客浏览量
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	public String getBlog_id() {
		return blog_id;
	}
	
	public void setBlog_id(String blog_id) {
		this.blog_id = blog_id;
	}
	
	@Column(length = 20,nullable = false,unique = true)
	public String getBlog_title() {
		return blog_title;
	}
	
	public void setBlog_title(String blog_title) {
		this.blog_title = blog_title;
	}
	
	@Column(nullable = true,unique = false)
	public String getBlog_content() {
		return blog_content;
	}
	
	public void setBlog_content(String blog_content) {
		this.blog_content = blog_content;
	}
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getBlog_ctime() {
		return blog_ctime;
	}
	
	public void setBlog_ctime(Date blog_ctime) {
		this.blog_ctime = blog_ctime;
	}
	
	@Column(nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getBlog_utime() {
		return blog_utime;
	}
	
	public void setBlog_utime(Date blog_utime) {
		this.blog_utime = blog_utime;
	}
	
	@Column(nullable = false)
	public long getBlog_vnum() {
		return blog_vnum;
	}
	
	public void setBlog_vnum(long blog_vnum) {
		this.blog_vnum = blog_vnum;
	}
	
	
}
