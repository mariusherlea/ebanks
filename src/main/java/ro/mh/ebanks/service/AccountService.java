package ro.mh.ebanks.service;

import ro.mh.ebanks.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    public List<Account> getAccounts();

    public List<Account> getAccountsByUserId(Long userId);



    public Optional<Account> getAccount(Long theId);


    List<Account> getCustomers();

    void saveAccount(Account theCustomer);

    Account getCustomer(int theId);

    void deleteCustomer(int theId);
}
