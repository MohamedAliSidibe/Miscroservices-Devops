package org.sid.mapper;

import org.mapstruct.Mapper;
import org.sid.dto.BillDto;
import org.sid.entities.Bill;

@Mapper(componentModel = "spring")
public interface BillMapper {
    Bill BillDtotoBill(BillDto billDto);
    BillDto BilltoBillDto(Bill bill);
}
