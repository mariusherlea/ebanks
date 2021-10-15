package ro.mh.ebanks.service;

import ro.mh.ebanks.model.Customer;

import java.util.List;

public interface CustomerService {

    public  List<Customer> getCustomer();

    public void saveCustomer(Customer theCustomer);

    public Customer getCustomer(Long theId);

    public void deleteCustomer(Long theId);
}