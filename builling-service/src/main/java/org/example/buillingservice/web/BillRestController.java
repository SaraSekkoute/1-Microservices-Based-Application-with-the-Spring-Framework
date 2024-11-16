package org.example.buillingservice.web;

import org.example.buillingservice.entities.Bill;
import org.example.buillingservice.feign.CustomerRestClient;
import org.example.buillingservice.feign.ProductRestClient;
import org.example.buillingservice.model.Product;
import org.example.buillingservice.repository.BillRepository;
import org.example.buillingservice.repository.ProductItemRepository;
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
