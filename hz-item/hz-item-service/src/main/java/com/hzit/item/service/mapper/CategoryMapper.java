package com.hzit.item.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hzit.item.api.bean.Category;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CategoryMapper extends BaseMapper<Category> {

    @Select("select * from tb_category WHERE id in(select category_id from tb_category_brand where brand_id = #{bid})")
    List<Category> findListByBid(Long bid);

}
