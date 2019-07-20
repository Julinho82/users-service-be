package com.dh.fullstack.users.service.service;

import com.dh.fullstack.users.service.input.CompanyCreateInput;
import com.dh.fullstack.users.service.model.domain.Account;
import com.dh.fullstack.users.service.model.domain.AccountState;
import com.dh.fullstack.users.service.model.domain.Company;
import com.dh.fullstack.users.service.model.repositories.AccountRepository;
import com.dh.fullstack.users.service.model.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author Julio Daviu
 */

@Scope("prototype")
@Service
public class CompanyCreateService {


    private CompanyCreateInput input;

    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private AccountRepository accountRepository;

    private Company company;

    public  void  execute(){
        Account account = composeAccountInstance();
        account = accountRepository.save(account);

        Company companyInstance = composeCompanyInstance(account);
        company = companyRepository.save(companyInstance);
    }

    private Account composeAccountInstance() {
        Account instance = new Account();
        instance.setState(AccountState.DEACTIVATED);
        instance.setEmail(input.getEmail());

        return instance;
    }

    private Company composeCompanyInstance(Account account) {
        Company instance = new Company();
        instance.setName(input.getName());
        instance.setEmail(input.getEmail());
        instance.setPassword(input.getPassword());
        instance.setActive(Boolean.TRUE);
        instance.setCreatedDate(new Date());
        instance.setAccount(account);

        return instance;
    }

    public void setInput(CompanyCreateInput input) {
        this.input = input;
    }

    public Company getCompany() {
        return company;
    }
}
