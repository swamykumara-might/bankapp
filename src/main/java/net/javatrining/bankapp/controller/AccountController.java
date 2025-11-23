package net.javatrining.bankapp.controller;

import net.javatrining.bankapp.dto.AccountDto;
import net.javatrining.bankapp.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService =accountService;
    }

    // Add Account using REST API
    @PostMapping
    private ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto) {
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //GET Account Details  using REST API
    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
        AccountDto accountDto =accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    // Deposit Amount REST API
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> depositAmt(@PathVariable Long id, @RequestBody Map<String, Double>request) {

        Double amount = request.get("amount");
        AccountDto accountDto = accountService.depositAmt(id,amount);
        return  ResponseEntity.ok(accountDto);
    }

    // WithDraw Amount REST API
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withDrawAmt(@PathVariable Long id, @RequestBody Map<String, Double>request) {

        Double amount = request.get("amount");
        AccountDto accountDto = accountService.depositAmt(id,amount);
        return  ResponseEntity.ok(accountDto);
    }



    // Delete Account
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable  Long id) {
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted Successfully");
    }

    // Get All Accounts
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        List<AccountDto> accounts =accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }
}
