package org.example.billingservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.example.billingservice.model.Product;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class ProductItem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)//quand je consulte bill il va ppas etre serialisé en json
    private Bill bill;
    private int quantity;
    private double unitPrice;


    @Transient // il exist en la classe mais il n'est pas représenté dans la base de données
    private Product product;
}