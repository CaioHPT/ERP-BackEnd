package br.com.brothers.erp.repository;

import br.com.brothers.erp.model.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
