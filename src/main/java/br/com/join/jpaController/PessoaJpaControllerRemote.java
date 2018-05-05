package br.com.join.jpaController;


import br.com.join.entity.Pessoa;

public interface PessoaJpaControllerRemote {

	public  Pessoa create(Pessoa pessoa);
	
	public void merge(Pessoa pessoa);
		
	
}
