package br.com.join.jpaController;


import br.com.join.entity.Pessoa;

public interface PessoaJpaControllerRemote {

	public  Pessoa create(Pessoa pessoa);
	
	public Pessoa merge(Pessoa pessoa);

	public Pessoa findById(Integer id) ;
	
	public void delete(Pessoa pessoa);
	
}
