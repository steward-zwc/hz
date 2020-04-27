package com.hzit.item.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hzit.item.api.bean.Category;
import com.hzit.item.service.mapper.CategoryMapper;
import com.hzit.item.service.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findCategoryListByPid(Long pid) {
        //mybatis-plus的条件构造器
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", pid);
        List<Category> categoryList = categoryMapper.selectList(queryWrapper);
        return categoryList;
    }

    @Override
    public List<Category> findListByBid(Long bid) {
        List<Category> list = categoryMapper.findListByBid(bid);
        return list;
    }
}
