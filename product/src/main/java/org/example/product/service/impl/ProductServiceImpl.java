package org.example.product.service.impl;

import org.example.common.pojo.Products;
import org.example.product.mapper.ProductMapper;
import org.example.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;
    @Override
    public Products findById(Integer productId) {
        return productMapper.selectById(productId);
    }
}
