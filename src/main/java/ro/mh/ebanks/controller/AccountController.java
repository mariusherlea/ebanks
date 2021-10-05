package ro.mh.ebanks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.mh.ebanks.converter.AccountConverter;
import ro.mh.ebanks.exeption.ResourceNotFoundException;
import ro.mh.ebanks.model.Account;
import ro.mh.ebanks.repository.AccountRepository;
import ro.mh.ebanks.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;


@Controller
public class AccountController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;


    @GetMapping("/accounts")
    public String getAllAccount( HttpServletRequest request) {

        List<Account> account=accountRepository.findAll();

        HttpSession session = request.getSession();
        session.setAttribute("account", account );

        return "account";
    }

    @GetMapping("/accounts/{userId}")
    public String getAllAccountsByUserId(@PathVariable(value = "userId") Long userId, HttpServletRequest request) {
        List<Account>accounts = accountRepository.findByUserId(userId);

        HttpSession session = request.getSession();
        session.setAttribute("accounts", accounts );

        return "accountByUserId";
    }

    @PostMapping("/accounts/{userId}/")
    public Account createAccount(@PathVariable (value = "userId") Long userId,
                                 @Valid @RequestBody Account account) {
        return userRepository.findById(userId).map(user -> {
            account.setUser(user);
            return accountRepository.save(account);
        }).orElseThrow(() -> new ResourceNotFoundException( userId ));
    }


    @GetMapping("/addForm")
    public static String maScarpin(){
        return "addAccount";
    }

    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Account account, Model model) {
        model.addAttribute("greeting", account);
        return "FormResponse";
    }

}


