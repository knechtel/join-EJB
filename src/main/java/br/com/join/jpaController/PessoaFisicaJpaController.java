package br.com.join.jpaController;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.join.entity.PessoaFisica;

@Stateless
@Remote(PessoaFisicaJpaControllerRemote.class)
public class PessoaFisicaJpaController implements PessoaFisicaJpaControllerRemote {
	
	
	@PersistenceContext(unitName = "join-EJBPU")
	private EntityManager em;
	
	public void create(PessoaFisica pessoaFisica) {
		em.persist(pessoaFisica);
	}

}
