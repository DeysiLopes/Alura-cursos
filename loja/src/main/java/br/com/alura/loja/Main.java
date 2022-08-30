package br.com.alura.loja;

import br.com.alura.loja.dao.CategoriaDao;
import br.com.alura.loja.dao.ProdutoDao;
import br.com.alura.loja.modelo.Categoria;
import br.com.alura.loja.modelo.Produto;
import br.com.alura.loja.utils.JPAUtil;
import org.hibernate.engine.spi.SessionDelegatorBaseImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args){
        Categoria celulares = new Categoria("CELULARES");

        Produto produto = new Produto("Sansumg", "novo",celulares ,new BigDecimal("600"));


        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();
        produtoDao.cadastrar(produto);
        categoriaDao.cadastrar(celulares);

        em.getTransaction().commit();
        em.close();

    }
}
