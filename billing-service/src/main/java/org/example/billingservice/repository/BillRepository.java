package org.example.billingservice.repository;

import org.example.billingservice.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
//the BillRepository interface can execute data retrieval operations without the @RepositoryRestResource annotation.
public interface BillRepository  extends JpaRepository<Bill, Long> {
}