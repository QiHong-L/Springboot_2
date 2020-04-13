package com.getheart.dao;

import com.getheart.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Json
 * @date 2020-01-13:51
 */
public interface BlogDao extends JpaRepository<Blog,Long> , JpaSpecificationExecutor<Blog> {

}
