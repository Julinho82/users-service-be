package com.dh.fullstack.users.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Santiago Mamani
 */
@Configuration
public class UsersProperties {

    @Value("${users.permit.age:15}")
    private Integer permitAge;

    public Integer getPermitAge() {
        return permitAge;
    }
}
