package org.example.billingservice.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import jakarta.ws.rs.PathParam;
import org.example.billingservice.model.Customer;
import org.example.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
//pour creation des methodes qui permet de communiquer avec customer
public interface CustomerRestClient {

    @GetMapping("/api/customers/{id}")
    @CircuitBreaker(name="customerServiceCB",fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);


    @GetMapping("/api/customers")
    @CircuitBreaker(name="customerServiceCB",fallbackMethod = "getDefaultCustomers")
     PagedModel<Customer> getAllCustomers();

    //implementation par defaut
    default Customer getDefaultCustomer(Long id,Exception exception)
    {
        return Customer.builder()
                .id(id)
                .name("Default Name")
                .email("Default Email")
                .build();
    }
    default PagedModel<Customer> getDefaultCustomer(Exception exception)
    {
        return PagedModel.empty();
    }




}
