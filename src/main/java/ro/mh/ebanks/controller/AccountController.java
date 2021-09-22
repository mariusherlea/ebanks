package ro.mh.ebanks.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ro.mh.ebanks.converter.AccountConverter;
import ro.mh.ebanks.model.Account;
import ro.mh.ebanks.repository.AccountRepository;
import ro.mh.ebanks.repository.UserRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class AccountController {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    private AccountConverter accountConverter;


    @GetMapping("/accounts")
    public String getAllAccount( Model model, String error, String logout, HttpServletRequest request) {

        List<Account> account=accountRepository.findAll();

        HttpSession session = request.getSession();
        session.setAttribute("account", account );

        return "account";
    }

    @GetMapping("/accounts/{postId}")
    public String getAllCommentsByPostId(@PathVariable(value = "postId") Long postId, HttpServletRequest request, Model model) {
        List<Account>accounts = accountRepository.findByUserId(postId);

        HttpSession session = request.getSession();
        session.setAttribute("accounts", accounts );

        return "account2";
    }

}


