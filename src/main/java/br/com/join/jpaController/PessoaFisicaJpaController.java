package br.com.join.jpaController;

import java.util.List;

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

	public PessoaFisica create(PessoaFisica pessoaFisica) {
		em.persist(pessoaFisica);
		em.flush();
		return pessoaFisica;
	}

	public PessoaFisica merge(PessoaFisica pessoaFisica) {
		em.merge(pessoaFisica);
		em.flush();
		return pessoaFisica;
	}

	public List<PessoaFisica> findAll() {
		List<PessoaFisica> listPaciente = em.createNamedQuery("PessoaFisica.findAll", PessoaFisica.class)
				.getResultList();
		return listPaciente;
	}

	public PessoaFisica findById(Integer id) {

		return em.find(PessoaFisica.class, id);

	}

	public PessoaFisica find(PessoaFisica pessoaFisica) {
		return null;
	}

	@Override
	public void delete(PessoaFisica pessoaFisica) {
		em.createQuery("DELETE FROM PessoaFisica e WHERE id=" + pessoaFisica.getId()).executeUpdate();
		if (em.contains(pessoaFisica)){
		     em.remove(pessoaFisica);
		}
	}

}
