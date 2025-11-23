package net.javatrining.bankapp.repository;

import net.javatrining.bankapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Long> {
    
}
