package com.dh.fullstack.users.service.controller;

import com.dh.fullstack.users.service.input.CompanyCreateInput;
import com.dh.fullstack.users.service.model.domain.Company;
import com.dh.fullstack.users.service.service.CompanyCreateService;
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
 * @author Julio Daviu
 */
@Api(
        tags = "company",
        description = "Operations over companies"
)
@RestController
@RequestMapping("/public/companies")
@RequestScope
public class CompanyController {
    @Autowired
    private CompanyCreateService companyCreateService;

    @ApiOperation(
            value = "Create a company"
    )
    @ApiResponses({
            @ApiResponse(
                    code = 401,
                    message = "Unauthorized to create account"
            ),
            @ApiResponse(
                    code = 404,
                    message = "Not found test"
            )
    })
    @RequestMapping(method = RequestMethod.POST)
    public Company createCompany(@RequestBody CompanyCreateInput input) {
        companyCreateService.setInput(input);
        companyCreateService.execute();

        return companyCreateService.getCompany();
    }
}
