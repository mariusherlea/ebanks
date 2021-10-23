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
    public String listCustomers(Model theModel) {
        List < Account > theCustomers = accountService.getCustomers();
        theModel.addAttribute("customers", theCustomers);
        return "list-customers";
    }

    @GetMapping("/showForm")
    public String showFormForAdd(Model theModel) {
        Account theCustomer = new Account();
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Account theCustomer) {
        accountService.saveAccount(theCustomer);
        return "redirect:/welcome";
    }

    @GetMapping("/updateForm")
    public String showFormForUpdate(@RequestParam("customerId") int theId,
                                    Model theModel) {
        Account theCustomer = accountService.getCustomer(theId);
        theModel.addAttribute("customer", theCustomer);
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") int theId) {
        accountService.deleteCustomer(theId);
        return "redirect:/welcome";
    }


}


