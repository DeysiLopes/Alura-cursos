package br.com.alura.leilao.dao;

import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.utils.JPAUtil;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

class UsuarioDaoTest {

    private UsuarioDao usuarioDao;

    @Test
    void deveriaBuscaDeUusuarioCadastrado(){
        EntityManager em = JPAUtil.getEntityManager();
        this.usuarioDao = new UsuarioDao(em);

        Usuario usuario = new Usuario("fulano", "fulano@email.com", "123456");
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();

        Usuario encontrado = this.usuarioDao.buscarPorUsername(usuario.getNome());
        Assert.assertNotNull(encontrado);
    }
    @Test
    void naoDeveriaBuscaDeUusuarioNaoCadastrado(){
        EntityManager em = JPAUtil.getEntityManager();
        this.usuarioDao = new UsuarioDao(em);

        Usuario usuario = new Usuario("fulano", "fulano@email.com", "123456");
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();

        Assert.assertThrows(NoResultException.class, () -> this.usuarioDao.buscarPorUsername("beltrano"));
    }
}