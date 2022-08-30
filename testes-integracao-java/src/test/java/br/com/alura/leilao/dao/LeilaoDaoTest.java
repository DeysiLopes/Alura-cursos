package br.com.alura.leilao.dao;

import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.utils.JPAUtil;
import br.com.alura.leilao.utils.builder.LeilaoBuilder;
import br.com.alura.leilao.utils.builder.UsuarioBuilder;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;

class LeilaoDaoTest {

    private LeilaoDao leilaoDao;
    private EntityManager em;

    @BeforeEach
    public void beforeEach(){
        this.em = JPAUtil.getEntityManager();
        this.leilaoDao = new LeilaoDao(em);
        em.getTransaction().begin();
    }
    @AfterEach
    public void afterEach(){
        em.getTransaction().rollback();
    }

    @Test
   void deveriaCadastrarUmLeilao(){
        Usuario usuario = new UsuarioBuilder()
                .comNome("fulano")
                .comEmail("fulano@email.com")
                .comSenha("123456")
                .criar();
        em.persist(usuario);
        Leilao leilao = new LeilaoBuilder()
                .comNome("Mochila")
                .comValorInicial("400")
                .comData(LocalDate.now())
                .comUsuario(usuario)
                .criar();

        leilao = leilaoDao.salvar(leilao);
        Leilao salvo = leilaoDao.buscarPorId(leilao.getId());
        Assert.assertNotNull(salvo);
    }

    @Test
    void deveriaAtualizarUmLeilao(){
        Usuario usuario = new UsuarioBuilder()
                .comNome("fulano")
                .comEmail("fulano@email.com")
                .comSenha("123456")
                .criar();
        em.persist(usuario);
        Leilao leilao = new LeilaoBuilder()
                .comNome("Mochila")
                .comValorInicial("400")
                .comData(LocalDate.now())
                .comUsuario(usuario)
                .criar();

        leilao = leilaoDao.salvar(leilao);
        leilao.setNome("Celular");
        leilao.setValorInicial(new BigDecimal("400"));

        leilao = leilaoDao.salvar(leilao);
        Leilao salvo = leilaoDao.buscarPorId(leilao.getId());
        Assert.assertEquals("Celular", salvo.getNome());
        Assert.assertEquals(new BigDecimal("400"), salvo.getValorInicial());
    }
    private Usuario criarUsuario(){
        Usuario usuario = new Usuario("fulano", "fulano@email.com", "123456");
        em.persist(usuario);
         return usuario;
    }
}