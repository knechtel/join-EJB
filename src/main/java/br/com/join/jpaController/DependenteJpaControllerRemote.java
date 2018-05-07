package br.com.join.jpaController;

import java.util.List;

import br.com.join.entity.Dependente;

public interface DependenteJpaControllerRemote {

	public Dependente create(Dependente dependente);

	public Dependente findById(Integer id);
	
	public List<Dependente> findAll();
	
	public Dependente merge(Dependente dependente);
	
	public void delete(Dependente dependente);
}
