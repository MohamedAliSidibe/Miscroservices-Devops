package org.sid.repository;

import org.sid.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductitemRepository extends JpaRepository<ProductItem, Long> {
}
