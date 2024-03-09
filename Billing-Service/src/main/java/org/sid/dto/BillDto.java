package org.sid.dto;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.*;
import org.sid.entities.Customer;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString @Builder
public class BillDto {
    private Long id;
    private long customerId ;
    private Customer customer;
}
