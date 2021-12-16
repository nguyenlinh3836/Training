package com.example.demo.service;

import com.example.demo.dto.ProductDto;
import com.example.demo.dto.SupplierDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SupplierService {
    List<SupplierDto> listAllSupplier();

    SupplierDto getById(int id);

    SupplierDto createSupplier(SupplierDto supplierDto);

    SupplierDto updateSupplier(SupplierDto supplierDto, int id);

    void deleteSupllier(int id);

}
