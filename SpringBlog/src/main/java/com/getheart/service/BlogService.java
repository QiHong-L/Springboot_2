package com.getheart.service;

import com.getheart.entity.Blog;
import com.getheart.vol.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Json
 * @date 2020-01-13:47
 */
public interface BlogService {

    Blog getBlogById(Long id);

    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id, Blog blog);

    void deletBlog(Long id);

}
