package com.codecentric.retailbank.web.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class HomeController extends BaseController {

    //region INDEX
    @GetMapping({"/", "/home", "/index", "/home/index"})
    public String getHome(HttpSession session) {
        setSessionUsernameAttribute(session, getPrincipalClassName(), getPrincipal());

        return "home/index";
    }
    //endregion

}
