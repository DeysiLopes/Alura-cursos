package br.com.alura.leilao.dao;

import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.utils.JPAUtil;
import br.com.alura.leilao.utils.builder.UsuarioBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

class UsuarioDaoTest {

    private UsuarioDao usuarioDao;
    private EntityManager em;

    @BeforeEach
    public void beforeEach(){
        this.em = JPAUtil.getEntityManager();
        this.usuarioDao = new UsuarioDao(em);
        em.getTransaction().begin();
    }
    @AfterEach
    public void afterEach(){
        em.getTransaction().rollback();
    }

    @Test
    void deveriaBuscaDeUusuarioCadastrado(){
        Usuario usuario = new UsuarioBuilder()
                .comNome("fulano")
                .comEmail("fulano@email.com")
                .comSenha("123456")
                .criar();
        em.persist(usuario);

        Usuario encontrado = this.usuarioDao.buscarPorUsername(usuario.getNome());
        Assert.assertNotNull(encontrado);
    }
    @Test
    void naoDeveriaBuscaDeUusuarioNaoCadastrado(){
        Usuario usuario = new UsuarioBuilder()
                .comNome("fulano")
                .comEmail("fulano@email.com")
                .comSenha("123456")
                .criar();
        em.persist(usuario);
        Assert.assertThrows(NoResultException.class, () -> this.usuarioDao.buscarPorUsername("beltrano"));
    }

    @Test
    void deveriaRemoverUmUsuario(){
        Usuario usuario = new UsuarioBuilder()
                .comNome("fulano")
                .comEmail("fulano@email.com")
                .comSenha("123456")
                .criar();
        em.persist(usuario);
       usuarioDao.deletar(usuario);

        Assert.assertThrows(NoResultException.class, () -> this.usuarioDao.buscarPorUsername(usuario.getNome()));
    }

}