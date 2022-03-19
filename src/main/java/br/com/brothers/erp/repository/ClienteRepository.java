package br.com.brothers.erp.repository;

import br.com.brothers.erp.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
