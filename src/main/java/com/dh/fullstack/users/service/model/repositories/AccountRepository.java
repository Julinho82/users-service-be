package com.dh.fullstack.users.service.model.repositories;

import com.dh.fullstack.users.service.model.domain.Account;
import com.dh.fullstack.users.service.model.domain.AccountState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Santiago Mamani
 */
public interface AccountRepository extends JpaRepository<Account,Long> {

    Optional<Account> findByEmailAndAndStateOrderBy(String email, AccountState state);
}
