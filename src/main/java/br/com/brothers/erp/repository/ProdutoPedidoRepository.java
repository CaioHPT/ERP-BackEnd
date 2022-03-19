package br.com.brothers.erp.repository;

import br.com.brothers.erp.model.Produto_Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoPedidoRepository extends JpaRepository<Produto_Pedido, Long> {
}
