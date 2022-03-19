package br.com.brothers.erp.repository;

import br.com.brothers.erp.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
