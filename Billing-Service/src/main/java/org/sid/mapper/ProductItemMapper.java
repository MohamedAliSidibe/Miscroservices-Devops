package org.sid.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.sid.dto.ProductItemDto;
import org.sid.entities.ProductItem;

@Mapper(componentModel = "spring")
public interface ProductItemMapper {
    ProductItemMapper MAPPER= Mappers.getMapper(ProductItemMapper.class);
    ProductItem ProductItemDtotoProdItem(ProductItemDto productItemDto);
    ProductItemDto ProductItemtoProdItemDto(ProductItem productItem);
}
