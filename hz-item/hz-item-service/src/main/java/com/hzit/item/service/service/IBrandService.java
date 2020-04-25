package com.hzit.item.service.service;

import com.hzit.common.PageResult;
import com.hzit.item.api.bean.Brand;

import java.util.List;

public interface IBrandService {

    PageResult<Brand> queryBrandByPageAndSort(String key, Long page, Long rows, String sortBy, Boolean desc);

    int saveBrand(Brand brand, List<Integer> cids);
}
