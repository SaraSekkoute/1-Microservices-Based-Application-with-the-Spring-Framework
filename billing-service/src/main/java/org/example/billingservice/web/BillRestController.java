package org.example.billingservice.web;

import org.example.billingservice.entities.Bill;
import org.example.billingservice.feign.CustomerRestClient;
import org.example.billingservice.feign.ProductRestClient;
import org.example.billingservice.model.Product;
import org.example.billingservice.repository.BillRepository;
import org.example.billingservice.repository.ProductItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class BillRestController {
    private BillRepository billRepository;
    private ProductItemRepository productItemRepository;
    private CustomerRestClient customerRestClient;
    private ProductRestClient productRestClient;

    public BillRestController(BillRepository billRepository, ProductItemRepository productItemRepository, CustomerRestClient customerRestClient, ProductRestClient productRestClient) {
        this.billRepository = billRepository;
        this.productItemRepository = productItemRepository;
        this.customerRestClient = customerRestClient;
        this.productRestClient = productRestClient;
    }



    @GetMapping(path="/bills/{id}")
    public Bill getBill(@PathVariable  Long id)
    {
        Bill bill =billRepository.findById(id).get();
        //pour consulter customers
        bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(productItem ->
                productItem.setProduct(productRestClient.getProductById(productItem.getProductId())));

        return bill;


    }
}
