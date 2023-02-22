package com.ngsystem.apisprintbootblog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPost;
    @ManyToOne
    @JoinColumn(name = "id_UserBlog", nullable = false, foreignKey = @ForeignKey(name = "FK_user_post"))
    private UserBlog userBlog;

    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false, foreignKey = @ForeignKey(name = "FK_category_post"))
    private Category category;

    @Column(nullable = false, length = 255)
    private String title;
    @Column(nullable = false, length = 255)
    private String brief;
    @Column(nullable = false, length = 511)
    private String content;
    @Column(nullable = false, length = 511)
    private String image;
    @Column(nullable = false)
    private LocalDateTime created_at;
    @Column(nullable = false)
    private boolean status;
    //clave foranea de categoria
    //clave foranea de user
}
