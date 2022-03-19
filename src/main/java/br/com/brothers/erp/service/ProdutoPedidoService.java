package br.com.brothers.erp.service;

import br.com.brothers.erp.model.Produto_Pedido;
import br.com.brothers.erp.repository.ProdutoPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoPedidoService {

    @Autowired
    private ProdutoPedidoRepository produtoPedidoRepository;

    @Transactional(readOnly = true)
    public List<Produto_Pedido> getAll(){
        try{
            return produtoPedidoRepository.findAll();
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Transactional(readOnly = true)
    public Produto_Pedido findById(Long id){
        try{
            Optional<Produto_Pedido> produtoPedido = produtoPedidoRepository.findById(id);
            if(produtoPedido.isPresent()){
                return produtoPedido.get();
            }else{
                return null;
            }
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void delete(Long id){
        try{
            Optional<Produto_Pedido> produtoPedido = produtoPedidoRepository.findById(id);
            if (produtoPedido.isPresent()){
                produtoPedidoRepository.delete(produtoPedido.get());
            }
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void save(Produto_Pedido produtoPedido){
        try{
            produtoPedidoRepository.save(produtoPedido);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void update(Long id, Produto_Pedido produtoPedido){
        try{
            Optional<Produto_Pedido> produtoPedidoOp = produtoPedidoRepository.findById(id);
            if (produtoPedidoOp.isPresent()){
                produtoPedido.setId(id);
                produtoPedidoRepository.save(produtoPedido);
            }
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}