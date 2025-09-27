package com.mega.warrantymanagementsystem.service.impl;


import com.mega.warrantymanagementsystem.entity.Account;
import com.mega.warrantymanagementsystem.repository.AccountRepository;
import com.mega.warrantymanagementsystem.service.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService, UserDetailsService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account findByUsername(String username) {

        return accountRepository.findByUsername(username);
    }

    @Override
    public Account findByEmail(String email) {

        return accountRepository.findByEmail(email);
    }

    @Override
    public Account findByAccountId(String accountId) {

        return accountRepository.findByAccountId(accountId);
    }

    @Override
    public Account createAccount(Account account) {

        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Account account) {
        Account existingAccount = accountRepository.findById(account.getAccountId()).orElse(null);
        if (existingAccount != null) {
            existingAccount.setUsername(account.getUsername());
            existingAccount.setEmail(account.getEmail());
            existingAccount.setGender(account.isGender());
            existingAccount.setFullName(account.getFullName());
            existingAccount.setPhone(account.getPhone());
            return accountRepository.save(existingAccount);
        }
        return existingAccount;
    }

    @Override
    public void deleteAccount(String accountId) {

        accountRepository.deleteById(accountId);
    }

    @Override
    public List<Account> getAccounts() {
        List<Account> accounts = accountRepository.findAll();
        return accounts;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return accountRepository.findByUsername(username);
    }
}
