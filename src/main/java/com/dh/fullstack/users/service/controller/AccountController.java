package com.dh.fullstack.users.service.controller;

import com.dh.fullstack.users.service.bean.Asus;
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

    private Asus asus;

    public AccountController(Asus asus) {
        this.asus = asus;
    }

    //    public AccountController() {
//        this.asus = new Asus(); NO usar jamas
//    }
    @RequestMapping(value = "/asus", method = RequestMethod.GET)
    public Asus readAsus(){
        asus.setName(asus.getName() + ": GET");
        return asus;
    }
}
