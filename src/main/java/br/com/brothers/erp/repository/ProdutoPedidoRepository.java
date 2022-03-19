package br.com.brothers.erp.repository;

import br.com.brothers.erp.model.Produto_Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoPedidoRepository extends JpaRepository<Produto_Pedido, Long> {
}
