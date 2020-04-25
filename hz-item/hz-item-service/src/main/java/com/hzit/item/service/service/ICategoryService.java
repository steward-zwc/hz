package com.hzit.item.service.service;

import com.hzit.item.api.bean.Category;

import java.util.List;

public interface ICategoryService {
    /**
     * 通过pid查找分类列表
     * @param pid
     * @return
     */
    List<Category> findCategoryListByPid(Long pid);
}
