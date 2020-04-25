package com.hzit.item.api.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "tb_category")
public class Category {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;//类目id
    private String name;//类目名称
    private Long parentId;//父类目id，顶级类目填0
    private Integer isParent;//是否为父节点，0为否，1为是
    private Integer sort;//排序指数，越小越靠前
}
