package com.example.demo.service;

import com.example.demo.dto.RoleDto;

import java.util.List;

public interface RoleService {
    List<RoleDto> listAllRole();
    RoleDto createRole(RoleDto roleDto);
    RoleDto updateRole(RoleDto roleDto,int id);
    void deleteRole(int id);
}
