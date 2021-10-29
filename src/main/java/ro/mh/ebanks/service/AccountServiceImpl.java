package ro.mh.ebanks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.mh.ebanks.model.Account;
import ro.mh.ebanks.repository.AccountRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;


    /*@Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }*/

    @Override
    public List<Account> getAccountsByUserId(Long userId) {
        return accountRepository.findByUserId(userId);
    }


    @Override
    @Transactional
    public Optional<Account> getAccount(Long theId) {
        return accountRepository.findById(theId);
    }

    @Override
    @Transactional
    public List<Account> getCustomers() {
        return accountRepository.findAll();
    }

    @Override
    @Transactional
    public void saveAccount(Account theAccount) {
        accountRepository.save(theAccount);
    }

    @Override
    @Transactional
    public Account getAccount(int theId) {
        return accountRepository.findById(theId);
    }

    @Override
    @Transactional
    public void deleteAccount(int theId) {
        accountRepository.deleteById(theId);
    }


}
