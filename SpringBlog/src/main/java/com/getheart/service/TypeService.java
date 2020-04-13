package com.getheart.service;

import com.getheart.entity.Type;
import org.hibernate.sql.Update;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Json
 * @date 2020-31-20:10
 */
public interface TypeService {

    public Type saveType(Type type);

    public Type getType(Long id);

    public Type updateType(Long id, Type type);

    public Page<Type> listType(Pageable pageable);

    public void deleteType(Long id);

    public Type findTypeByName(String name);

    List<Type> listtype();


}
