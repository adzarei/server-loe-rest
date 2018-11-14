package adzarei.loe.webfirma.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping({"","/","index","/home"})
    public String getHomePage(){
        return "index";
    }

    @RequestMapping({"/login"})
    public String getLoginPage(){
        return "login2";
    }

    @RequestMapping({"access-denied"})
    public String accessDenied(){
        return "error/access-denied";
    }

    @RequestMapping({"/user"})
    public String userIndex() {
        return "user/index";
    }
}
