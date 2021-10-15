package ro.mh.ebanks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.mh.ebanks.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
