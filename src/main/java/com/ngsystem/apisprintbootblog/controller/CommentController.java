package com.ngsystem.apisprintbootblog.controller;

import com.ngsystem.apisprintbootblog.dto.CommentDTO;
import com.ngsystem.apisprintbootblog.model.Comment;
import com.ngsystem.apisprintbootblog.service.ICommentService;
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
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    private final ICommentService service;// = new CommentService();

    @Qualifier("commentMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<CommentDTO>> readAll() throws Exception{
        List<CommentDTO> list = service.readAll().stream().map(this::convertToDto).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> readById(@PathVariable("id") Integer id) throws Exception{
        Comment obj = service.readById(id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<CommentDTO> create(@Valid @RequestBody CommentDTO dto) throws Exception {
        Comment obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentDTO> update(@Valid @PathVariable("id") Integer id, @RequestBody CommentDTO dto) throws Exception {
        dto.setIdComment(id);
        Comment obj = service.update(convertToEntity(dto),id);
        return new ResponseEntity<>(convertToDto(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    private CommentDTO convertToDto(Comment obj){
        return mapper.map(obj, CommentDTO.class);
    }

    private Comment convertToEntity(CommentDTO dto){
        return mapper.map(dto, Comment.class);
    }
}

