package ro.mh.ebanks.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.mh.ebanks.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}