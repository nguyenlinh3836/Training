package com.example.demo.dto;

import com.example.demo.model.OrderDetail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderDetailMapper extends EntityMapper<OrderDetailDto, OrderDetail> {
}
