package com.example.demo.dto;

public class BaseResponse<T> {
    public int status = 1;
    public String message = "success";
    public T data;
}
