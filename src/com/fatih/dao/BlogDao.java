package com.fatih.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.faith.pojo.Blog;
import com.fatih.dao.inter.IBlogDao;

@Transactional(rollbackFor={RuntimeException.class, Exception.class})
@Repository
public class BlogDao extends HibernateDaoSupport implements IBlogDao {

	@Override
	public boolean add(Blog entity) {
		try{
			getHibernateTemplate().save(entity);
		}
		catch (DataAccessException e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean delete(String id) {
		try {
			getHibernateTemplate().delete(findById(id));
		} catch (DataAccessException e) {
			return false;
		}
		return true;
	}

	@Override
	public Blog findById(String id) {
		List<?> result= getHibernateTemplate().findByNamedParam("from Blog where blog_id = :blog_id", "blog_id", id);
		if(result.size()>=1) 
			return (Blog) result.get(0);
		else 
			return new Blog();
	}

	@Override
	public boolean update(Blog entity) {
		try {
			getHibernateTemplate().update(entity);
		} catch (DataAccessException e) {
			return false;
		}
		return true;
	}

	@Override
	public List<Blog> findByTitle(String title) {
		List<?> result= getHibernateTemplate().findByNamedParam("from Blog where title like '%:title%'", "title", title);
		if(result.size()>=1) 
			return (List<Blog>) result;
		else 
			return new ArrayList<Blog>();
	}
	
}
