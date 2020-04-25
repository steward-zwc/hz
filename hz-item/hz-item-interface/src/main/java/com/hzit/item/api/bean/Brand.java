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
@TableName("tb_brand")
public class Brand {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;//品牌id
    private String name;//品牌名称
    private String image;//品牌图片地址
    private Character letter;//品牌的首字母
}
