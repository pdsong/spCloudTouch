package org.example.page.controller;

import org.example.common.pojo.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/page")
public class PageController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/getData/{id}")
    public Products findDataById(@PathVariable Integer id) {

        List<ServiceInstance> instances = discoveryClient.getInstances("lagou-service-product");
        ServiceInstance instance = instances.get(0);
        String host = instance.getHost();
        int port = instance.getPort();
        String url = "http://" + host + ":" + port + "/product/query/" + id;
        Products products =
                restTemplate.getForObject(url, Products.class);
        System.out.println("从lagou-service-product获得product对象:" + products);
        return products;
    }


}
