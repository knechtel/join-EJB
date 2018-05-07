
package br.com.join.jpaController;

import java.util.List;

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

	@Override
	public List<PessoaJuridica> findAll() {
		List<PessoaJuridica> listDependente = em.createNamedQuery("PessoaJuridica.findAll", PessoaJuridica.class).getResultList();
		return listDependente;
	}

	@Override
	public PessoaJuridica merge(PessoaJuridica pessoaJuridica) {
		em.merge(pessoaJuridica);
		return pessoaJuridica;
	}

	@Override
	public void delete(PessoaJuridica pessoaJuridica) {
		em.createQuery("DELETE FROM PessoaJuridica e WHERE id=" + pessoaJuridica.getId()).executeUpdate();
		if (em.contains(pessoaJuridica)){
		     em.remove(pessoaJuridica);
		}
		
	}
	
	
}
