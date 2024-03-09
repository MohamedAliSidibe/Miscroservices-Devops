package org.sid.repository;

import org.sid.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BillRepository extends JpaRepository<Bill,Long> {
}
