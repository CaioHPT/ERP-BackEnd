package br.com.brothers.erp.service;

import br.com.brothers.erp.model.Cliente;
import br.com.brothers.erp.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional(readOnly = true)
    public List<Cliente> getAll(){
        try{
            return clienteRepository.findAll();
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Transactional(readOnly = true)
    public Cliente findById(Long id){
        try{
            Optional<Cliente> cliente = clienteRepository.findById(id);
            if(cliente.isPresent()){
                return cliente.get();
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
            Optional<Cliente> cliente = clienteRepository.findById(id);
            if (cliente.isPresent()){
                clienteRepository.delete(cliente.get());
            }
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void save(Cliente cliente){
        try{
            clienteRepository.save(cliente);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void update(Long id, Cliente cliente){
        try{
            Optional<Cliente> clienteOp = clienteRepository.findById(id);
            if (clienteOp.isPresent()){
                cliente.setId(id);
                clienteRepository.save(cliente);
            }
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}

