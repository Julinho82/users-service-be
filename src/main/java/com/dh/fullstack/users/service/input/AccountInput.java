package com.dh.fullstack.users.service.input;

import com.dh.fullstack.users.service.model.domain.AccountState;

/**
 * @author Santiago Mamani
 */
public class AccountInput {

    private String email;

    private AccountState state;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public AccountState getState() {
        return state;
    }

    public void setState(AccountState state) {
        this.state = state;
    }
}
