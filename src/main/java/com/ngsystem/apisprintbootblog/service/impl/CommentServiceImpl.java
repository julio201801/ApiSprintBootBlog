package com.ngsystem.apisprintbootblog.service.impl;

import com.ngsystem.apisprintbootblog.model.Comment;
import com.ngsystem.apisprintbootblog.repo.ICategoryRepo;
import com.ngsystem.apisprintbootblog.repo.ICommentRepo;
import com.ngsystem.apisprintbootblog.repo.IGenericRepo;
import com.ngsystem.apisprintbootblog.service.ICategoryService;
import com.ngsystem.apisprintbootblog.service.ICommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl extends CRUDImpl<Comment,Integer> implements ICommentService {
    private final ICommentRepo repo;
    @Override
    protected IGenericRepo<Comment, Integer> getRepo() {
        return repo;
    }
}
