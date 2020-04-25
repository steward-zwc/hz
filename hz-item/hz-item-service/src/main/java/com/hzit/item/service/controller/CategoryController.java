package com.hzit.item.service.controller;

import com.hzit.item.api.bean.Category;
import com.hzit.item.service.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list")
    public List<Category> list(@RequestParam(defaultValue = "0")Long pid){
        List<Category> categoryList = categoryService.findCategoryListByPid(pid);
        return categoryList;
    }
}
