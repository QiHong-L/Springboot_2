package com.getheart.service.impl;

import com.getheart.dao.TypeDao;
import com.getheart.dao.UserDao;
import com.getheart.entity.Type;
import com.getheart.handler.NotFoundException;
import com.getheart.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Json
 * @date 2020-31-20:15
 */
@Service
public class TypeServiceImpl implements TypeService {


    @Autowired
    TypeDao typeDao;

    /**
     * 保存博客类型
     * @param type
     * @return
     */
    @Transactional
    @Override
    public Type saveType(Type type) {

        return typeDao.save(type);
    }

    /**
     * 根据id查询博客类型
     * @param id
     * @return
     */
    @Transactional
    @Override
    public Type getType(Long id) {
        return typeDao.getOne(id);
    }

    /**
     * 更新博客类型
     * @param id
     * @param type
     * @return
     */
    @Transactional
    @Override
    public Type updateType(Long id, Type type) {

        Type tp = typeDao.findById(id).get();
        if(tp == null){
            throw new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(type,tp);
        return typeDao.save(tp);
    }

    /**
     *  分页显示博客类型
     * @param pageable
     * @return
     */
    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeDao.findAll(pageable);
    }

    /**
     * 根据id删除博客类型
     * @param id
     */
    @Transactional
    @Override
    public void deleteType(Long id) {
        typeDao.deleteById(id);
    }

    @Override
    public Type findTypeByName(String name) {
        return typeDao.findTypeByName(name);
    }

    @Override
    public List<Type> listtype() {
        return typeDao.findAll();
    }
}
