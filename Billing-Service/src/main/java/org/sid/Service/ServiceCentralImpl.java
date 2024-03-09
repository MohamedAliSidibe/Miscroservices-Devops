package org.sid.Service;

import jakarta.persistence.EntityNotFoundException;
import org.sid.dto.BillDto;
import org.sid.dto.ProductItemDto;
import org.sid.feign.CustomerServiceClient;
import org.sid.feign.ProductServiceClient;
import org.sid.mapper.BillMapper;
import org.sid.mapper.ProductItemMapper;
import org.sid.repository.BillRepository;
import org.sid.repository.ProductitemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ServiceCentralImpl implements ServiceCentral{
    @Autowired
    BillMapper billMapper;
    @Autowired
    ProductItemMapper productItemMapper;
    @Autowired
    BillRepository billRepository;
    @Autowired
    ProductitemRepository productitemRepository;
    @Autowired
    CustomerServiceClient customerServiceClient;
    @Autowired
    ProductServiceClient productServiceClient;

    @Override
    public BillDto addBillDto(BillDto billDto) {
        if(Objects.isNull(billDto.getCustomerId())
        && Objects.isNull(billDto.getCustomer())
        ){
                throw new EntityNotFoundException("L'entite bill n'existe pas");
        }
        return billMapper.BilltoBillDto(
                billRepository.save(billMapper.BillDtotoBill(billDto)));
    }

    @Override
    public List<BillDto> listBillDto() {
        return billRepository.findAll().stream()
                .map(data-> {
                    data.setCustomer(customerServiceClient.findCustomerById(data.getId()));
                   return billMapper.BilltoBillDto(data);
                })
                .collect(Collectors.toList());
    }

    @Override
    public ProductItemDto addProductItemDto(ProductItemDto productItemDto) {
        if (Objects.isNull(productItemDto.getBill()) &&
        Objects.isNull(productItemDto.getProductId())
        && Objects.isNull(productItemDto.getProduct())){
            throw new EntityNotFoundException("Product is not found");
        }
        return productItemMapper.ProductItemtoProdItemDto(
                productitemRepository.save(
                productItemMapper.ProductItemDtotoProdItem(productItemDto)));
    }

    @Override
    public List<ProductItemDto> listProductItemDto() {
        return productitemRepository.findAll()
                .stream()
                .map(data->
                        {
                            data.setProduct(productServiceClient.productId(data.getId()));
                            return  productItemMapper.ProductItemtoProdItemDto(data);
                        }
                )
                .collect(Collectors.toList());
    }
}
