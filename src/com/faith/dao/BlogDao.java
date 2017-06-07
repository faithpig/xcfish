package com.faith.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.faith.dao.inter.IBlogDao;
import com.faith.pojo.Blog;

@Repository("blogDao")
public class BlogDao extends HibernateDaoSupport implements IBlogDao {

	@Override
	public Blog add(Blog entity) {
		String saveId = null;
		try{
			saveId = (String) getHibernateTemplate().save(entity);
		}
		catch (DataAccessException e) {
			return new Blog();
		}
		return findById(saveId);
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
		List<?> result= getHibernateTemplate().findByNamedParam
				("from Blog where blog_id = :blog_id order by blog_ctime desc", "blog_id", id);
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
		List<?> result= getHibernateTemplate().findByNamedParam
				("from Blog where title like ':title' order by blog_ctime desc", "title", '%'+title+'%');
		if(result.size()>=1) 
			return (List<Blog>) result;
		else 
			return new ArrayList<Blog>();
	}

	@Override
	public List<Blog> findAll() {
		List<?> result= getHibernateTemplate().find("from Blog order by blog_ctime desc");
		if(result.size()>=1) 
			return (List<Blog>) result;
		else 
			return new ArrayList<Blog>();
	}
	
}
