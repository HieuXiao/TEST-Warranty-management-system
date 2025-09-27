package com.mega.warrantymanagementsystem.service.service;

import com.mega.warrantymanagementsystem.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    Account findByUsername(String username);
    Account findByEmail(String email);
    Account findByAccountId(String accountId);

    Account createAccount(Account account);
    Account updateAccount(Account account);
    void deleteAccount(String accountId);

    public List<Account> getAccounts();
}
