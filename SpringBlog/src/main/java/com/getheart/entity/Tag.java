package com.getheart.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Json
 * @date 2020-31-9:59
 */
@Data
@Entity
@Table(name = "t_tag")
public class Tag {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    /**
     * Blog实体类的集合
     *Tag-->Blog:多对多的关系
     */
    @ManyToMany(mappedBy = "tags")
    private List<Blog> blogs = new ArrayList<>();

}
