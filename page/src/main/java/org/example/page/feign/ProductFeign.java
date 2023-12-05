package org.example.page.feign;

import org.example.common.pojo.Products;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name="lagou-service-product")
public interface ProductFeign {

    @RequestMapping("/product/query/{id}")
    public Products query(@PathVariable Integer id);

//    @RequestMapping("/server/query")
//    public String findServerPort();

}
