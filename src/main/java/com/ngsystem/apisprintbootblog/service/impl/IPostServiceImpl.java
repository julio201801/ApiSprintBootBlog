package com.ngsystem.apisprintbootblog.service.impl;

import com.ngsystem.apisprintbootblog.model.Post;
import com.ngsystem.apisprintbootblog.repo.IGenericRepo;
import com.ngsystem.apisprintbootblog.repo.IPostRepo;
import com.ngsystem.apisprintbootblog.service.IPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IPostServiceImpl extends CRUDImpl<Post,Integer> implements IPostService {
    private final IPostRepo repo;
    @Override
    protected IGenericRepo<Post, Integer> getRepo() {
        return repo;
    }
}
