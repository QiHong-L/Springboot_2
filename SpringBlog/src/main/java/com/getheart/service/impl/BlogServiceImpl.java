package com.getheart.service.impl;

import com.getheart.dao.BlogDao;
import com.getheart.entity.Blog;
import com.getheart.entity.Type;
import com.getheart.handler.NotFoundException;
import com.getheart.service.BlogService;
import com.getheart.utils.MyBeanUtils;
import com.getheart.vol.BlogQuery;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Json
 * @date 2020-01-13:50
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogDao blogDao;
    @Override
    public Blog getBlogById(Long id) {
        return blogDao.getOne(id);
    }

    @Override
    public Page<Blog> listBlog(Pageable pageable, BlogQuery blog) {
        Page<Blog> pageblog = blogDao.findAll(new Specification<Blog>() {
            /**
             *
             * @param root： 所要查询的对象
             * @param cq： 放置要查询的条件
             * @param elem ：设置某一条件的表达式。例如：查询的like
             * @return
             */
            @Override
            public Predicate toPredicate(Root<Blog> root, CriteriaQuery<?> cq,
                                         CriteriaBuilder elem) {
                List<Predicate> predicates = new ArrayList<>();
                if (blog.getTitle() != null && !"".equals(blog.getTitle())) {
                    predicates.add(elem.like(root.<String>get("title"), "%" + blog.getTitle() + "%"));
                }
                if (blog.getTypeId() != null) {
                    predicates.add(elem.equal(root.<Type>get("type").get("id"), blog.getTypeId()));
                }
                if (blog.isRecommend()) {
                    predicates.add(elem.equal(root.<Boolean>get("recommend"), blog.isRecommend()));
                }
                cq.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        }, pageable);

        return pageblog;
    }

    @Transactional
    @Override
    public Blog saveBlog(Blog blog) {
        if(blog.getId() == null){
            blog.setCreaatTime(new Date());
            blog.setUpdateTime(new Date());
            blog.setViews(0);
        }else {
            blog.setUpdateTime(new Date());
        }
        return blogDao.save(blog);
    }
    @Transactional
    @Override
    public Blog updateBlog(Long id, Blog blog) {
        Blog blogone = blogDao.getOne(id);
        if(blogone == null){
            throw  new NotFoundException("该博客不存在");
        }
        BeanUtils.copyProperties(blog,blogone, MyBeanUtils.getNullPropertyNames(blog));
        blogone.setUpdateTime(new Date());
        return blogDao.save(blogone);
    }
    @Transactional
    @Override
    public void deletBlog(Long id) {
        blogDao.deleteById(id);
    }
}
