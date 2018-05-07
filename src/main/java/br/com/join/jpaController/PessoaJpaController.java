package br.com.join.jpaController;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.join.entity.Pessoa;
import br.com.join.entity.PessoaFisica;

@Stateless
@Remote(PessoaJpaControllerRemote.class)
public class PessoaJpaController implements PessoaJpaControllerRemote {
	@PersistenceContext(unitName = "join-EJBPU")
	private EntityManager em;

	public Pessoa create(Pessoa pessoa) {
//		if (pessoa.getId() == null) {
//			em.persist(pessoa);
//			em.flush();
//		}
		em.persist(pessoa);
		return pessoa;
	}

	public Pessoa merge(Pessoa pessoa) {
		em.merge(pessoa);
		em.flush();
		return pessoa;
	}
	
	public Pessoa findById(Integer id) {

		return em.find(Pessoa.class, id);

	}
	
	
	public Pessoa findByIdPessoaFisica(Integer id) {
		return em.createQuery("from Pessoa p where p.id = :id", Pessoa.class)
				.setParameter("id", id).getSingleResult();

	}

	@Override
	public void delete(Pessoa pessoa) {
		em.createQuery("DELETE FROM Pessoa e WHERE id=" + pessoa.getId()).executeUpdate();
		if (em.contains(pessoa)){
		     em.remove(pessoa);
		}
		
	}

}
