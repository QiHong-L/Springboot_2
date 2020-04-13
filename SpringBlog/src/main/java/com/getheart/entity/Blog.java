package com.getheart.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Json
 * @date 2020-31-9:38
 */
@Data
@Entity
@Table(name = "t_blog")
public class Blog {
    /**
     * id:主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 标题
     */

    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 首图
     */
    private String firstPicture;
    /**
     * 标记
     */
    private String flag;
    /**
     * 浏览次数
     */
    private Integer views;
    /**
     * 赞赏是否开启
     */
    private boolean appreciation;
    /**
     * 版权开启
     */
    private boolean shareStatement;
    /**
     * 评论开启
     */
    private boolean commentabled;
    /**
     * 是否发布
     */
    private boolean published;
    /**
     * 评论
     */
    private boolean recommend;
    /**
     *创建时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date creaatTime;
    /**
     * 更新时间
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    /**
     * Type实体类
     * Blog-->Type:多对一的关系
     */
    @ManyToOne
    private Type type;
    /**
     * Tag实体类的集合
     * Blog-->Tag:多对多的关系
     */
    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags = new ArrayList<>();

    /**
     * User实体类
     * Blog-->User:多对一
     */
    @ManyToOne
    private User user;

    /**
     * Comment实体类集合
     * Blog-->Comment:一对多
     */
    @OneToMany(mappedBy = "blog")
    private List<Comment> comments = new ArrayList<>();

}
