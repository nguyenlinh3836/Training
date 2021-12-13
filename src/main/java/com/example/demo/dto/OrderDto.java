package com.example.demo.dto;


import com.example.demo.model.OrderDetail;
import com.example.demo.model.Product;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Id;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OrderDto {
    @Id
    private int id;
    private String customerName;
    private String customerPhone;
    private String address;
    private Date orderDate;
    private List<OrderDetailDto> orderDetailDtos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<OrderDetailDto> getOrderDetailDtos() {
        return orderDetailDtos;
    }

    public void setOrderDetailDtos(List<OrderDetailDto> orderDetailDtos) {
        this.orderDetailDtos = orderDetailDtos;
    }
}
