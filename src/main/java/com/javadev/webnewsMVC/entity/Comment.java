package com.javadev.webnewsMVC.entity;

import com.javadev.webnewsMVC.entity.base.BaseEntity;
import com.javadev.webnewsMVC.entity.news.News;
import com.javadev.webnewsMVC.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comment")
public class Comment extends BaseEntity {

    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_ID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "new_ID")
    private News news;
}

