package ro.mh.ebanks.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ro.mh.ebanks.model.Account1;

import java.util.List;


public interface Account1Repository extends JpaRepository<Account1, Long> {
    List<Account1> findByUserId(Long userId);

}
