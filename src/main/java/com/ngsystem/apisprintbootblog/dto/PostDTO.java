package com.ngsystem.apisprintbootblog.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.ngsystem.apisprintbootblog.model.Category;
import com.ngsystem.apisprintbootblog.model.UserBlog;
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
public class PostDTO {
    private Integer idPost;

    @NotNull
    @JsonIncludeProperties(value = {"id_UserBlog", "nameUser"})
    private UserBlogDTO userBlog;

    //@ManyToOne
    //@JoinColumn(name = "id_category", nullable = false, foreignKey = @ForeignKey(name = "FK_category_post"))
    @NotNull
    @JsonIncludeProperties(value = {"id_category", "nameCategory"})
    private CategoryDTO category;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 255)
    private String titlePost;
    @NotEmpty
    @NotEmpty
    @Size(min=3, max=255)
    private String briefPost;
    @NotEmpty
    @NotEmpty
    @Size(min=3, max=255)
    private String contentPost;
    @NotEmpty
    @NotEmpty
    @Size(min=3, max=255)
    private String imagePost;
    @NotNull
    private LocalDateTime created_atPost;
    @NotNull
    private boolean statusPost;

}

