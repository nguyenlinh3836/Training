package com.example.demo.dto;

import com.example.demo.model.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring",uses = {ProductMapper.class})
public interface StockMapper extends EntityMapper<StockDto, Stock> {
}
