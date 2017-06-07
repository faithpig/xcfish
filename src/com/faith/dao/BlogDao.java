package com.faith.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.faith.dao.inter.IBlogDao;
import com.faith.pojo.Blog;

@Repository("blogDao")
public class BlogDao implements IBlogDao {
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
	@Override
	public Serializable add(Blog entity) {
		Serializable saveId = null;
		saveId = (String) sessionFactory.getCurrentSession().save(entity);
		return saveId;
	}

	@Override
	public boolean delete(String id) {
		try {
			sessionFactory.getCurrentSession().delete(findById(id));
		} catch (HibernateException e) {
			return false;
		}
		return true;
	}

	@Override
	public Blog findById(String id) {
		List<?> result= sessionFactory.getCurrentSession().createQuery
				("from Blog where blog_id = '"+id+"' order by blog_ctime desc").list();
		if(result.size()>=1) 
			return (Blog) result.get(0);
		else 
			return new Blog();
	}

	@Override
	public boolean update(Blog entity) {
		try {
			sessionFactory.getCurrentSession().update(entity);
		} catch (HibernateException e) {
			return false;
		}
		return true;
	}

	@Override
	public List<Blog> findByTitle(String title) {
		List<?> result= sessionFactory.getCurrentSession().createQuery
				("from Blog where title like '%"+title+"%' order by blog_ctime desc").list();
		if(result.size()>=1) 
			return (List<Blog>) result;
		else 
			return new ArrayList<Blog>();
	}

	@Override
	public List<Blog> findAll() {
		List<?> result= sessionFactory.getCurrentSession().createQuery("from Blog order by blog_ctime desc").list();
		if(result.size()>=1) 
			return (List<Blog>) result;
		else 
			return new ArrayList<Blog>();
	}

}
