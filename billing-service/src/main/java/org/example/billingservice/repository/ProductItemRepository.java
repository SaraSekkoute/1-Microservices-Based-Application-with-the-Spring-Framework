package org.example.billingservice.repository;

import org.example.billingservice.entities.Bill;
import org.example.billingservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
}