package br.com.brothers.erp.repository;

import br.com.brothers.erp.model.UserErp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserErpRepository extends JpaRepository<UserErp, Long> {

    UserErp findByUsername(String username);

}
