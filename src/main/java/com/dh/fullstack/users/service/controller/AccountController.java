package com.dh.fullstack.users.service.controller;

import com.dh.fullstack.users.service.input.AccountInput;
import com.dh.fullstack.users.service.model.domain.Account;
import com.dh.fullstack.users.service.service.AccountCreateService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

/**
 * @author Santiago Mamani
 */
@Api(
        tags = "account rest",
        description = "Operations over accounts"
)
@RestController
@RequestMapping("/accounts")
@RequestScope
public class AccountController {

    @Autowired
    private AccountCreateService accountCreateService;

    @ApiOperation(
            value = "Endpoint to create account"
    )
    @ApiResponses({
            @ApiResponse(
                    code = 401,
                    message = "Unauthorized to create account"
            ),
            @ApiResponse(
                    code = 404,
                    message = "Not fount test"
            )
    })
    @RequestMapping(method = RequestMethod.POST)
    public Account createAccount(@RequestBody AccountInput input) {
        accountCreateService.setInput(input);
        return accountCreateService.save();
    }
}
