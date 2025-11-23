package net.javatrining.bankapp.service;

import net.javatrining.bankapp.dto.AccountDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AccountService {

    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long id);

    AccountDto depositAmt(Long id, double amount);

    AccountDto withDrawAmt(Long id, double amount);

    List<AccountDto> getAllAccounts();

    void deleteAccount(Long id);

}
