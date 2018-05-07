package br.com.join.jpaController;

import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.join.entity.Dependente;
import br.com.join.entity.PessoaFisica;

@Stateless
@Remote(DependenteJpaControllerRemote.class)
public class DependenteJpaController implements DependenteJpaControllerRemote {
	@PersistenceContext(unitName = "join-EJBPU")
	private EntityManager em;

	public Dependente create(Dependente dependente) {

		em.persist(dependente);
		em.flush();

		return dependente;
	}

	public Dependente findById(Integer id) {

		return em.find(Dependente.class, id);

	}

	@Override
	public List<Dependente> findAll() {
		List<Dependente> listDependente = em.createNamedQuery("Dependente.findAll", Dependente.class).getResultList();
		return listDependente;

	}
	
	public Dependente merge(Dependente dependente) {

		em.merge(dependente);
		em.flush();

		return dependente;
	}

	@Override
	public void  delete(Dependente dependente) {
		// TODO Auto-generated method stub
		em.createQuery("DELETE FROM Dependente e WHERE id=" + dependente.getId()).executeUpdate();
		if (em.contains(dependente)){
		     em.remove(dependente);
		}
	}
}
