package com.ngsystem.apisprintbootblog.controller;

import com.ngsystem.apisprintbootblog.dto.PostDTO;
import com.ngsystem.apisprintbootblog.model.Post;
import com.ngsystem.apisprintbootblog.service.IPostService;
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
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final IPostService service;// = new PostService();
    @Qualifier("postMapper")
    private final ModelMapper mapper;
    @GetMapping
    public ResponseEntity<List<PostDTO>> readAll() throws Exception{
        List<PostDTO> list = service.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Post obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<PostDTO> create(@Valid @RequestBody PostDTO dto) throws Exception {
        Post obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody PostDTO dto) throws Exception {
        dto.setIdPost(id);
        Post obj = service.update(convertToEntity(dto),id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    private PostDTO convertToDto(Post obj){
        return mapper.map(obj, PostDTO.class);
    }

    private Post convertToEntity(PostDTO dto){
        return mapper.map(dto, Post.class);
    }
}

