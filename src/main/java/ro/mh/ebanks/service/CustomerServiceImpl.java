package ro.mh.ebanks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.mh.ebanks.model.Customer;
import ro.mh.ebanks.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {
        customerRepository.save(theCustomer);
    }

    @Override
    @Transactional
    public Customer getCustomer(Long theId) {
        return customerRepository.getById(theId);
    }

    @Override
    public void deleteCustomer(Long theId) {
customerRepository.deleteById(theId);
    }

}
