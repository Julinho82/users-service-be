package com.dh.fullstack.users.service.controller;

import com.dh.fullstack.users.service.bean.Asus;
import com.dh.fullstack.users.service.input.AccountInput;
import com.dh.fullstack.users.service.model.domain.Account;
import com.dh.fullstack.users.service.model.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Santiago Mamani
 */
@RestController
@RequestMapping("/accounts")
@RequestScope
public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    @RequestMapping(method = RequestMethod.POST)
    public Account createAccount(@RequestBody AccountInput input){
        Account account = new Account();
        account.setEmail(input.getEmail());
        account.setState(input.getState());

        return accountRepository.save(account);
    }
}
