package com.dh.fullstack.users.service.model.domain;

import javax.persistence.*;

/**
 * @author Santiago Mamani
 */
@Entity
@Table(name = "account_table",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})}
)
public class Account {

    //CTRL+ALT+L
    @Id
    @Column(name = "accountid", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "state", length = 20, nullable = false)
    private AccountState state;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
