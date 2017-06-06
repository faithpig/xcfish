package com.fatih.dao.inter;

import java.util.List;
import com.faith.pojo.Blog;

public interface IBlogDao extends IBaseDao<Blog>{
	
	List<Blog> findByTitle(String title);
}
