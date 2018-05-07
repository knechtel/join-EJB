package br.com.join.jpaController;

import java.util.List;

import br.com.join.entity.PessoaFisica;

public interface PessoaFisicaJpaControllerRemote {
	public PessoaFisica create(PessoaFisica pessoaFisica);

	public PessoaFisica merge(PessoaFisica pessoaFisica);

	public List<PessoaFisica> findAll();
	
	public PessoaFisica findById(Integer id);
	
	public PessoaFisica find(PessoaFisica pessoaFisica);
	
	public void delete(PessoaFisica pessoaFisica);
}
