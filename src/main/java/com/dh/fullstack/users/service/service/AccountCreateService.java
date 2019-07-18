package com.dh.fullstack.users.service.service;

import com.dh.fullstack.users.service.input.AccountInput;
import com.dh.fullstack.users.service.model.domain.Account;
import com.dh.fullstack.users.service.model.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author Santiago Mamani
 */
@Scope("prototype")
@Service
public class AccountCreateService {

    private AccountInput input;

    @Autowired
    private AccountRepository accountRepository;

    public Account save() {
        return accountRepository.save(composeAccountInstance());
    }

    private Account composeAccountInstance() {
        Account instance = new Account();
        instance.setState(input.getState());
        instance.setEmail(input.getEmail());

        return instance;
    }

    public void setInput(AccountInput input) {
        this.input = input;
    }
}
