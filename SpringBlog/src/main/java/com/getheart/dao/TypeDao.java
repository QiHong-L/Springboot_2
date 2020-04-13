package com.getheart.dao;

import com.getheart.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Json
 * @date 2020-31-20:32
 */
public interface TypeDao extends JpaRepository<Type,Long> {

    public Type findTypeByName(String name);
}
