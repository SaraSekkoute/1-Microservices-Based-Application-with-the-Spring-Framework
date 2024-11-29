package org.example.inventoryservice.repository;

import org.example.inventoryservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product,String> {
    @Query("SELECT p FROM Product p WHERE p.name LIKE %:name%")
    List<Product> findByNameLike(@Param("name") String name);
}
