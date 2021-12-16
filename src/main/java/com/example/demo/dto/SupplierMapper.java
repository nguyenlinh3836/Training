package com.example.demo.dto;

import com.example.demo.model.Supplier;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierMapper extends EntityMapper<SupplierDto, Supplier> {
}
