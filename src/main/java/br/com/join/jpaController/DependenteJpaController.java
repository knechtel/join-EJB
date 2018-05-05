package br.com.join.jpaController;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.join.entity.Dependente;

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
}
