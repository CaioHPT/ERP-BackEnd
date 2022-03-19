package br.com.brothers.erp.service;

import br.com.brothers.erp.model.Pedido;
import br.com.brothers.erp.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Transactional(readOnly = true)
    public List<Pedido> getAll(){
        try{
            return pedidoRepository.findAll();
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Transactional(readOnly = true)
    public Pedido findById(Long id){
        try{
            Optional<Pedido> pedido = pedidoRepository.findById(id);
            if(pedido.isPresent()){
                return pedido.get();
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
            Optional<Pedido> pedido = pedidoRepository.findById(id);
            if (pedido.isPresent()){
                pedidoRepository.delete(pedido.get());
            }
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void save(Pedido pedido){
        try{
            pedidoRepository.save(pedido);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void update(Long id, Pedido pedido){
        try{
            Optional<Pedido> pedidoOp = pedidoRepository.findById(id);
            if (pedidoOp.isPresent()){
                pedido.setId(id);
                pedidoRepository.save(pedido);
            }
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}
