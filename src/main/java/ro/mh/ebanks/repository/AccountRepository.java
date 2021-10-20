package ro.mh.ebanks.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import ro.mh.ebanks.model.Account;

import java.util.List;


public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByUserId(Long userId);

    Account findById(int theId);

    void deleteById(int theId);
}
