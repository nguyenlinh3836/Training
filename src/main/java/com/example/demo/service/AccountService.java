package com.example.demo.service;

import com.example.demo.dto.AccountDto;
import com.example.demo.model.Account;

public interface AccountService {
    AccountDto findByUserName(String username);
    AccountDto createAccount(AccountDto accountDto);

}
