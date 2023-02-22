package com.ngsystem.apisprintbootblog.service.impl;

import com.ngsystem.apisprintbootblog.model.Category;
import com.ngsystem.apisprintbootblog.repo.ICategoryRepo;
import com.ngsystem.apisprintbootblog.repo.IGenericRepo;
import com.ngsystem.apisprintbootblog.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl extends CRUDImpl<Category,Integer> implements ICategoryService {
    private final ICategoryRepo repo;// = new CategoryRepo();
    @Override
    protected IGenericRepo<Category, Integer> getRepo() {
        return repo;
    }
}
