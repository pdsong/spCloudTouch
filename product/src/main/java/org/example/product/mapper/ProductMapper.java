package org.example.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.common.pojo.Products;
import org.springframework.stereotype.Repository;



@Repository
public interface ProductMapper extends BaseMapper<Products> {
}
