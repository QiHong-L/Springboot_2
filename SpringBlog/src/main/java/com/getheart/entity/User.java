package com.getheart.entity;

import lombok.Data;

import javax.persistence.*;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Json
 * @date 2020-31-10:04
 */
@Data
@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;

    private String username;

    private String password;

    private String email;

    private String avatar;

    private Integer type;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateTime;

    /**
     * Blog实体类集合
     * User-->Blog:一对多
     */
    @OneToMany(mappedBy = "user")
    private List<Blog> blogs = new ArrayList<>();
}
