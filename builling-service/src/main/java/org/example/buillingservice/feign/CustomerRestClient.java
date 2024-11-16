package org.example.buillingservice.feign;

import jakarta.ws.rs.PathParam;
import org.example.buillingservice.model.Customer;
import org.example.buillingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
//pour creation des methodes qui permet de communiquer avec customer
public interface CustomerRestClient {

    @GetMapping("/api/customers/{id}")
    Customer findCustomerById(@PathVariable Long id);


    @GetMapping("/api/customers")
    PagedModel<Customer> getAllCustomers();
}
