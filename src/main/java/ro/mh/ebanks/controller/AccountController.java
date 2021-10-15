package ro.mh.ebanks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import ro.mh.ebanks.model.Account1;
import ro.mh.ebanks.repository.Account1Repository;
import ro.mh.ebanks.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class AccountController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Account1Repository account1Repository;


    @GetMapping("/accounts")
    public String getAllAccount( HttpServletRequest request) {

        List<Account1> account1 = account1Repository.findAll();

        HttpSession session = request.getSession();
        session.setAttribute("account", account1);

        return "account";
    }

    @GetMapping("/accounts/{userId}")
    public String getAllAccountsByUserId(@PathVariable(value = "userId") Long userId, HttpServletRequest request) {
        List<Account1> account1s = account1Repository.findByUserId(userId);

        HttpSession session = request.getSession();
        session.setAttribute("accounts", account1s);

        return "accountByUserId";
    }




    @GetMapping("/addForm")
    public static String maScarpin(){
        return "addAccount";
    }



}


