package br.com.join.jpaController;

import java.util.List;


import br.com.join.entity.PessoaJuridica;

public interface PessoaJuridicaJpaControllerRemote {

	public PessoaJuridica create(PessoaJuridica pessoaJuridica);
	
	public List<PessoaJuridica> findAll();
	
	public PessoaJuridica merge(PessoaJuridica pessoaJuridica) ;
	
	public void delete(PessoaJuridica pessoaJuridica);
}
