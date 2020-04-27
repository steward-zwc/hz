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
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public int deleteBrand(Long brandId) {
        //1.先从品牌分类的关系表中把对应的关系删除
        int row = brandMapper.deleteBrandCategory(brandId);
        //2.再从品牌表中把该品牌删除
        if(row != 0){
            brandMapper.deleteById(brandId);
        }
        return row;
    }

    @Override
    @Transactional
    public int updateBrand(Brand brand, List<Integer> cids) {
        //1.先把品牌分类关系表中的对应关系删除
        brandMapper.deleteBrandCategory(brand.getId());
        //2.修改品牌表中的信息
        int row = brandMapper.updateById(brand);
        //3.再在品牌分类关系表中添加对应关系
        for (Integer cid : cids) {
            long cidlong = cid;
            brandMapper.saveBrandCategory(brand.getId(), cidlong);
        }
        return row;
    }
}
