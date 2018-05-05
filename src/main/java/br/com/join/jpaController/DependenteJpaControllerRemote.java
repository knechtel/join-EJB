package br.com.join.jpaController;

import br.com.join.entity.Dependente;

public interface DependenteJpaControllerRemote {

	public Dependente create(Dependente dependente);

	public Dependente findById(Integer id);
}
