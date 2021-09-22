package ro.mh.ebanks.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.mh.ebanks.model.Account;

import java.util.List;


public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByUserId(Long userId);

}