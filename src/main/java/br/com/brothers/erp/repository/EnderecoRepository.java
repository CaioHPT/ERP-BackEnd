package br.com.brothers.erp.repository;

import br.com.brothers.erp.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
