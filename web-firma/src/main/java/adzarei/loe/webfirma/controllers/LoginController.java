package adzarei.loe.webfirma.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping({"","/","index","/home"})
    public String getHomePage(){
        return "index";
    }

    @RequestMapping({"/login"})
    public String getLoginPage(){
        return "login";
    }

    @RequestMapping({"access-denied"})
    public String accessDenied(){
        return "error/access-denied";
    }

    @RequestMapping({"/user"})
    public String userIndex(Model model) {

        //model.


        return "user/index";
    }
}
