package org.example.billingservice.feign;

import org.example.billingservice.model.Customer;
import org.example.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
//pour creation des methodes qui permet de communiquer avec product
public interface ProductRestClient {

    @GetMapping("/api/products/{id}")
    Product getProductById(@PathVariable String id);

    @GetMapping("/api/products")
    PagedModel<Product> getAllProducts();
}