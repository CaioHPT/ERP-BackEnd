package br.com.brothers.erp.repository;

import br.com.brothers.erp.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
