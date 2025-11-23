package net.javatrining.bankapp.mapper;

import net.javatrining.bankapp.dto.AccountDto;
import net.javatrining.bankapp.entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto){
        Account acc =new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance()
        );
        return acc;
    }

    public static AccountDto mapToAccountDto(Account account){
        AccountDto accDto =new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance()
        );
        return accDto;
    }

}
