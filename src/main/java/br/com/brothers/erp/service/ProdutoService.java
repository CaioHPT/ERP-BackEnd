package br.com.brothers.erp.service;

import br.com.brothers.erp.model.Produto;
import br.com.brothers.erp.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional(readOnly = true)
    public List<Produto> getAll(){
        try{
            return produtoRepository.findAll();
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Transactional(readOnly = true)
    public Produto findById(Long id){
        try{
            Optional<Produto> produto = produtoRepository.findById(id);
            if(produto.isPresent()){
                return produto.get();
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
            Optional<Produto> produto = produtoRepository.findById(id);
            if (produto.isPresent()){
                produtoRepository.delete(produto.get());
            }
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void save(Produto produto){
        try{
            produtoRepository.save(produto);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void update(Long id, Produto produto){
        try{
            Optional<Produto> produtoOp = produtoRepository.findById(id);
            if (produtoOp.isPresent()){
                produto.setId(id);
                produtoRepository.save(produto);
            }
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }
}

