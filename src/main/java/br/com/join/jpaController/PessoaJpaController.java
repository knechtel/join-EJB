package br.com.join.jpaController;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.join.entity.Pessoa;

@Stateless
@Remote(PessoaJpaControllerRemote.class)
public class PessoaJpaController implements PessoaJpaControllerRemote {
	@PersistenceContext(unitName = "join-EJBPU")
	private EntityManager em;

	public void create(Pessoa pessoa) {
		em.persist(pessoa);
		em.flush();
	}

}
