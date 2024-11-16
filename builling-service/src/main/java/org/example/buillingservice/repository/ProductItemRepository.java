package org.example.buillingservice.repository;

import org.example.buillingservice.entities.Bill;
import org.example.buillingservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductItemRepository extends JpaRepository<ProductItem, Long> {
}