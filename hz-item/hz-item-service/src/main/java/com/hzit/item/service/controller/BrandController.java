package com.hzit.item.service.controller;

import com.hzit.common.PageResult;
import com.hzit.item.api.bean.Brand;
import com.hzit.item.service.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private IBrandService brandService;

    @RequestMapping("/page")
    public PageResult<Brand> page(@RequestParam("key") String key,
                                  @RequestParam("page") Long page,
                                  @RequestParam("rows") Long rows,
                                  @RequestParam("sortBy") String sortBy,
                                  @RequestParam("desc") Boolean desc) {
        PageResult<Brand> pageResult = this.brandService.queryBrandByPageAndSort(key, page, rows, sortBy, desc);
        return pageResult;
    }

    @PostMapping("/add")
    public int addBrand(Brand brand, @RequestParam("cids") List<Integer> cids) {
        int row = brandService.saveBrand(brand, cids);
        return row;
    }
}
