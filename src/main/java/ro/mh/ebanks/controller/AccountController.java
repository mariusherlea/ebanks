package ro.mh.ebanks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ro.mh.ebanks.model.Account;
import ro.mh.ebanks.repository.AccountRepository;
import ro.mh.ebanks.repository.UserRepository;
import ro.mh.ebanks.service.AccountService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/account")
public class AccountController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @GetMapping
    public String getAllAccount(HttpServletRequest request) {

        List<Account> account = accountRepository.findAll();

        HttpSession session = request.getSession();
        session.setAttribute("account", account);

        return "account";
    }

    @GetMapping("/{userId}")
    public String getAllAccountsByUserId(@PathVariable(value = "userId") Long userId, HttpServletRequest request) {
        List<Account> accounts = accountRepository.findByUserId(userId);

        HttpSession session = request.getSession();
        session.setAttribute("accounts", accounts);

        return "accountByUserId";
    }

    @GetMapping("/list")
    public String listAccount(Model theModel) {
        List < Account > theAccount = accountService.getCustomers();
        theModel.addAttribute("account", theAccount);
        return "list-accounts";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        Account theAccount = new Account();
        theModel.addAttribute("account", theAccount);
        return "account-form";
    }

    @PostMapping("/saveAccount")
    public String saveAccount(@ModelAttribute("account") Account theAccount) {
        accountService.saveAccount(theAccount);
        return "redirect:/welcome";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("accountId") int theId,
                                    Model theModel) {
        Account theAccount = accountService.getAccount(theId);
        theModel.addAttribute("account", theAccount);
        return "account-form";
    }

    @GetMapping("/delete")
    public String deleteAccount(@RequestParam("accountId") int theId) {
        accountService.deleteAccount(theId);
        return "redirect:/welcome";
    }


}


