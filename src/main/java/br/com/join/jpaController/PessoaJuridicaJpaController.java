package br.com.join.jpaController;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.join.entity.PessoaJuridica;
@Stateless
@Remote(PessoaJuridicaJpaControllerRemote.class)
public class PessoaJuridicaJpaController implements PessoaJuridicaJpaControllerRemote{

	@PersistenceContext(unitName = "join-EJBPU")
	private EntityManager em;
	
	public PessoaJuridica create(PessoaJuridica pessoaJuridica) {
		em.persist(pessoaJuridica);
		return pessoaJuridica;
	}
}
