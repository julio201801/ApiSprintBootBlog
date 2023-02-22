package com.ngsystem.apisprintbootblog.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
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
public class UserBlogDTO {
    private Integer idUser;
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String nameUser;
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String lastnameUser;
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String usernameUser;
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String emailUser;
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String passwordUser;
    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String imageUser;
    @NotNull
    private boolean statusUser;
    @NotNull
    private int kindUser;
    @NotNull
    private LocalDateTime created_atUser;
}
