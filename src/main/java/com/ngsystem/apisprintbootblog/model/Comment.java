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
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idComment;
    @ManyToOne
    @JoinColumn(name = "id_post", nullable = false, foreignKey = @ForeignKey(name = "FK_Post_Comment"))
    private Post post;
    @Column(nullable = false,length = 255)
    private String name;
    @Column(nullable = false,length = 255)
    private String comment;
    @Column(nullable = false,length = 255)
    private String email;
    //llave foranea de post
    @Column(nullable = false)
    private LocalDateTime created_at;
    @Column(nullable = false)
    private boolean status;

}
