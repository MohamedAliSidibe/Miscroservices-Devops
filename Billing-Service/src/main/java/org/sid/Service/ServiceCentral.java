package org.sid.Service;

import org.sid.dto.BillDto;
import org.sid.dto.ProductItemDto;
import org.sid.entities.Bill;

import java.util.List;

public interface ServiceCentral {
     BillDto addBillDto(BillDto billDto);
     List<BillDto> listBillDto();
     ProductItemDto addProductItemDto(ProductItemDto productItemDto);
     List<ProductItemDto> listProductItemDto();

}
