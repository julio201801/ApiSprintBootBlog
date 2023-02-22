package com.ngsystem.apisprintbootblog.service.impl;

import com.ngsystem.apisprintbootblog.model.UserBlog;
import com.ngsystem.apisprintbootblog.repo.IGenericRepo;
import com.ngsystem.apisprintbootblog.repo.IUserBlog;
import com.ngsystem.apisprintbootblog.service.IUserBlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserBlogServiceImpl extends CRUDImpl<UserBlog,Integer> implements IUserBlogService {
    private final IUserBlog repo;
    @Override
    protected IGenericRepo<UserBlog, Integer> getRepo() {
        return repo;
    }
}
