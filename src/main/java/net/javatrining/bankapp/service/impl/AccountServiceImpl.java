package net.javatrining.bankapp.service.impl;

import net.javatrining.bankapp.dto.AccountDto;
import net.javatrining.bankapp.entity.Account;
import net.javatrining.bankapp.mapper.AccountMapper;
import net.javatrining.bankapp.repository.AccountRepository;
import net.javatrining.bankapp.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount =  accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Account does not exists"));
        return AccountMapper.mapToAccountDto(account);

    }

    @Override
    public AccountDto depositAmt(Long id, double amount){

        Account account = accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Account does not exists"));

            double totalAmt = account.getBalance() + amount;

            account.setBalance(totalAmt);
            Account saveAccount = accountRepository.save(account);
            return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public  AccountDto withDrawAmt(Long id, double amount) {
        Account account = accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Account does not exists"));

        double totalAmt = account.getBalance() - amount;

        account.setBalance(totalAmt);
        Account saveAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(saveAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();

        return accounts.stream().map((account)-> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long id) {
        Account account = accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Account does not exists"));

        accountRepository.deleteById(id);

    }
}
