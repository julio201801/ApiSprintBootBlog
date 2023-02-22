package com.ngsystem.apisprintbootblog.controller;

import com.ngsystem.apisprintbootblog.dto.UserBlogDTO;
import com.ngsystem.apisprintbootblog.model.UserBlog;
import com.ngsystem.apisprintbootblog.service.IUserBlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserBlogController {
    private final IUserBlogService service;// = new UserBlogService();

    @Qualifier("userblogMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<UserBlogDTO>> readAll() throws Exception{
        List<UserBlogDTO> list = service.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserBlogDTO> readById(@PathVariable("id") Integer id) throws Exception{
        UserBlog obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<UserBlogDTO> create(@Valid @RequestBody UserBlogDTO dto) throws Exception {
        UserBlog obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserBlogDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody UserBlogDTO dto) throws Exception {
        dto.setIdUser(id);
        UserBlog obj = service.update(convertToEntity(dto),id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    private UserBlogDTO convertToDto(UserBlog obj){
        return mapper.map(obj, UserBlogDTO.class);
    }

    private UserBlog convertToEntity(UserBlogDTO dto){
        return mapper.map(dto, UserBlog.class);
    }
}

