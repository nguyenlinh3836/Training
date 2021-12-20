package com.example.demo.dto;

import javax.persistence.Id;

public class RoleDto {
    @Id
    private int id;
    private String rolename;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }
}
