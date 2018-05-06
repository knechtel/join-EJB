package br.com.join.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.join.entity.Pessoa;
import br.com.join.jpaController.PessoaJpaControllerRemote;

@SessionScoped
@Named("pessoaBean")
public class PessoaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Pessoa pessoa;
	private String meuTestPessoa;

	@EJB
	private PessoaJpaControllerRemote pessoaJpa;

	@PostConstruct
	public void init() {
		pessoa = new Pessoa();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getMeuTestPessoa() {
		return meuTestPessoa;
	}

	public void setMeuTestPessoa(String meuTestPessoa) {
		this.meuTestPessoa = meuTestPessoa;
	}

	public String cadastra() {
		pessoaJpa.create(pessoa);
		return null;

	}
	
	public String doDependentes() {
		return "/cadDependentes.xhtml";
	}

	public String doCadPfisica() {
		return "/cadpFisica.xhtml";
	}
	public String doCadJuridica() {
		return "/cadPJuridica.xhtml";
	}
	public String doRelatorio() {
		return "/test.xhtml";
	}
}
