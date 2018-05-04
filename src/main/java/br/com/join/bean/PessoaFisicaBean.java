package br.com.join.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.join.entity.Pessoa;
import br.com.join.entity.PessoaFisica;
import br.com.join.jpaController.PessoaFisicaJpaControllerRemote;
import br.com.join.jpaController.PessoaJpaControllerRemote;

@SessionScoped
@Named("pessoaFisicaBean")
public class PessoaFisicaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Pessoa pessoa;
	private PessoaFisica pessoaFisica;

	@EJB
	private PessoaJpaControllerRemote pessoaJpa;
	@EJB
	private PessoaFisicaJpaControllerRemote pessoaFisicaJpa;
	
	@PostConstruct
	public void init() {
		pessoa = new Pessoa();
		pessoaFisica = new PessoaFisica();
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}
	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}
	
	
	public String create() {
		pessoaJpa.create(pessoa);
		pessoaFisica.setPessoa(pessoa);
		
		pessoaFisicaJpa.create(pessoaFisica);
		return null;
	}
	
	

}
