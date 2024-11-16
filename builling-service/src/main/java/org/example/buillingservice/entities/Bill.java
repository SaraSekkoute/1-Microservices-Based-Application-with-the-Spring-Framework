package org.example.buillingservice.entities;

import jakarta.persistence.*;
import lombok.*;
import org.example.buillingservice.model.Customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter @Builder
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date billingDate;
    private long customerId;

    @OneToMany(mappedBy = "bill")//bidirectionnelle
    private List<ProductItem> productItems = new ArrayList<>();

    @Transient private Customer customer;
}