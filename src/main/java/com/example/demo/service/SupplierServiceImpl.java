package com.example.demo.service;

import com.example.demo.dto.SupplierDto;
import com.example.demo.dto.SupplierMapper;
import com.example.demo.model.Supplier;
import com.example.demo.repository.SupplierRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepo supplierRepo;
    @Autowired
    private SupplierMapper supplierMapper;

    @Override
    @Transactional
    public List<SupplierDto> listAllSupplier() {
        return supplierMapper.toDtoList(supplierRepo.findAll());
    }

    @Override
    @Transactional
    public SupplierDto getById(int id) {
        return supplierMapper.toDto(supplierRepo.getById(id));
    }

    @Override
    @Transactional
    public SupplierDto createSupplier(SupplierDto supplierDto) {
        Supplier supplier = supplierMapper.toEntity(supplierDto);
        return supplierMapper.toDto(supplierRepo.save(supplier));
    }

    @Override
    @Transactional
    public SupplierDto updateSupplier(SupplierDto supplierDto, int id) {
        Supplier supplier = supplierMapper.toEntity(supplierDto);
        supplier.setId(id);
        return supplierMapper.toDto(supplierRepo.save(supplier));
    }

    @Override
    @Transactional
    public void deleteSupllier(int id) {
        Supplier supplier = supplierRepo.getById(id);
        supplierRepo.delete(supplier);
    }
}
