package com.getheart.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Json
 * @date 2020-31-9:56
 */
@Data
@Entity
@Table(name = "t_type")
public class Type {

    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 类型名称
     */
    @NotBlank(message = "分类名称不能为空！")
    private String name;
    /**
     * Blog实体类
     * Type-->Blog:一对多的关系
     */
    @OneToMany(mappedBy = "type")
    private List<Blog> blogs = new ArrayList<>();

}
