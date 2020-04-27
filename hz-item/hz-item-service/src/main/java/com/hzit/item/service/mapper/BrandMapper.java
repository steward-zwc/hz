package com.hzit.item.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzit.item.api.bean.Brand;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

public interface BrandMapper extends BaseMapper<Brand> {

    @Insert("INSERT INTO tb_category_brand(category_id, brand_id) VALUES(#{cid}, #{bid})")
    int saveBrandCategory(@Param("bid") Long bid, @Param("cid") Long cid);

    @Delete("DELETE FROM tb_category_brand WHERE brand_id = #{brandId}")
    int deleteBrandCategory(@Param("brandId")Long brandId);
}
