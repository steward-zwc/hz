package com.hzit.item.service.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hzit.common.PageResult;
import com.hzit.item.api.bean.Brand;
import com.hzit.item.service.mapper.BrandMapper;
import com.hzit.item.service.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public PageResult<Brand> queryBrandByPageAndSort(String key, Long page, Long rows, String sortBy, Boolean desc) {
        //1.封装查询条件
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<>();
        //1.1设置关键字，根据关键字来查询
        queryWrapper.like("name",key);
        //1.2根据字段进行排序
        queryWrapper.orderByDesc(desc,sortBy);
        //1.3设置分页参数
        IPage<Brand> ipage = new Page<>();
        ipage.setCurrent(page);
        ipage.setSize(rows);
        //2.调用brandMapper的方法，从数据库查出结果
        IPage<Brand> rs = brandMapper.selectPage(ipage, queryWrapper);
        //3.封装分页信息，作为结果返回
        PageResult<Brand> pageResult = new PageResult<>();
        pageResult.setTotal(rs.getTotal());
        pageResult.setTotalPages(rs.getPages());
        pageResult.setItems(rs.getRecords());
        return pageResult;
    }

    @Override
    public int saveBrand(Brand brand, List<Integer> cids) {
        //1.在品牌表中插入一条数据
        int row =  brandMapper.insert(brand);
        //2.根据回显的id，在品牌分类表中插入对应的关系
        if (row > 0){
            for (Integer cid : cids) {
                long cidlong = cid;
                //在插入之后直接调用getId()就会获得回显的id
                brandMapper.saveBrandCategory(brand.getId(), cidlong);
            }
        }
        return row;
    }
}
