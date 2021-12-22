package com.example.demo.dto;

import com.example.demo.model.Order;
import com.example.demo.model.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring",uses = {OrderDetailMapper.class})
public interface OrderMapper extends EntityMapper<OrderDto, Order>{

}
