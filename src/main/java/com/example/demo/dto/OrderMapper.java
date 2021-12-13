package com.example.demo.dto;

import com.example.demo.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper extends EntityMapper<OrderDto, Order>{
}
