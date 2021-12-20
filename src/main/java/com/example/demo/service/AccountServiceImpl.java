package com.example.demo.service;

import com.example.demo.dto.AccountDto;
import com.example.demo.dto.AccountMapper;
import com.example.demo.model.Account;
import com.example.demo.repository.AccountRepo;
import com.example.demo.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepo accountRepo;
    @Autowired
    private AccountMapper accountMapper;
    @Autowired
    private RoleRepo roleRepo;


    @Override
    public AccountDto findByUserName(String username) {
        return accountMapper.toDto(accountRepo.findByUsername(username));
    }

    @Override
    @Transactional
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = accountMapper.toEntity(accountDto);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String passEncode = encoder.encode(account.getPassword());
        account.setPassword(passEncode);
        account.setRoles(Arrays.asList(roleRepo.getById(1)));
        return accountMapper.toDto(accountRepo.save(account));
    }
}
