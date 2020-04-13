package com.getheart.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * @author Json
 * @date 2020-31-10:00
 */
@Data
@Entity
@Table(name = "t_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;

    private String email;

    private String comment;

    private String avater;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    /**
     * Blog实体类
     * Comment-->Blog:多对一
     */
    @ManyToOne
    private Blog blog;

    @OneToMany(mappedBy = "parentComment")
    private List<Comment> replyComments = new ArrayList<>();

    @ManyToOne
    private Comment parentComment;
}
