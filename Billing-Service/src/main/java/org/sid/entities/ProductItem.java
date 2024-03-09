package org.sid.entities;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
@Entity
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private long productId;
    private double price;
    private double quantity;
    @ManyToOne
    private Bill bill;
    @Transient
    private Product product;
}
