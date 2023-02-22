package com.ngsystem.apisprintbootblog.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.ngsystem.apisprintbootblog.model.Post;
import jakarta.persistence.Column;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentDTO {
    private Integer idComment;
    //@ManyToOne
    //@JoinColumn(name = "id_post", nullable = false, foreignKey = @ForeignKey(name = "FK_Post_Comment"))
    //private Post post;
    @NotNull
    @JsonIncludeProperties(value = {"id_post", "namePost"})
    private PostDTO post;
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String nameComment;
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String commentComment;
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String emailComment;
    //llave foranea de post
    @NotNull
    private LocalDateTime created_atComment;
    @NotNull
    private boolean statusComment;
}
