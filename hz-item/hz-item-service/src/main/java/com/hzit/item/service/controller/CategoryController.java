package com.hzit.item.service.controller;

import com.hzit.item.api.bean.Category;
import com.hzit.item.service.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/bid/{bid}")
    public List<Category> findListByBId(@PathVariable("bid")Long bid){
        List<Category> list = categoryService.findListByBid(bid);
        return list;
    }
}
