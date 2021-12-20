package com.example.demo.service;

import com.example.demo.dto.RoleDto;
import com.example.demo.dto.RoleMapper;
import com.example.demo.model.Role;
import com.example.demo.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RoleRepo roleRepo;
    @Override
    public List<RoleDto> listAllRole() {
        return roleMapper.toDtoList(roleRepo.findAll());
    }

    @Override
    public RoleDto createRole(RoleDto roleDto) {
        Role role = roleMapper.toEntity(roleDto);
        return roleMapper.toDto(roleRepo.save(role));
    }

    @Override
    public RoleDto updateRole(RoleDto roleDto, int id) {
        Role role = roleMapper.toEntity(roleDto);
        role.setId(id);
        return roleMapper.toDto(roleRepo.save(role));
    }

    @Override
    public void deleteRole(int id) {
        Role role = roleRepo.getById(id);
        roleRepo.delete(role);
    }
}
