package org.sid.dto;
import lombok.*;
import org.sid.entities.Bill;
import org.sid.entities.Product;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProductItemDto {
    private Long Id;
    private long productId;
    private double price;
    private double quantity;
    private Bill bill;
    private Product product;
}
