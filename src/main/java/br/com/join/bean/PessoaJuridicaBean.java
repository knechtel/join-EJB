package br.com.join.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.join.entity.Pessoa;
import br.com.join.entity.PessoaFisica;
import br.com.join.entity.PessoaJuridica;
import br.com.join.jpaController.PessoaFisicaJpaControllerRemote;
import br.com.join.jpaController.PessoaJpaControllerRemote;
import br.com.join.jpaController.PessoaJuridicaJpaControllerRemote;

@RequestScoped
@Named("pessoaJuridicaBean")
public class PessoaJuridicaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Pessoa pessoa;
	private PessoaJuridica pessoaJuridica;
	private PessoaFisica pessoaFisica;

	@EJB
	private PessoaJpaControllerRemote pessoaJpa;

	@EJB
	private PessoaJuridicaJpaControllerRemote pessoaJpaJuridica;

	@EJB
	private PessoaFisicaJpaControllerRemote pessoaJpaFisica;

	@PostConstruct
	public void init() {
		pessoa = new Pessoa();
		pessoaJuridica = new PessoaJuridica();
		pessoaFisica = new PessoaFisica();
		pessoaFisica.setPessoa(pessoa);
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public PessoaJuridica getPessoaJuridica() {
		return pessoaJuridica;
	}

	public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
		this.pessoaJuridica = pessoaJuridica;
	}

	public PessoaFisica getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(PessoaFisica pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}

	public String create() {

		pessoa = pessoaJpa.create(pessoa);
		pessoaFisica.setPessoa(pessoa);
		
		if (pessoa.getId() == pessoaFisica.getPessoa().getId()) {
			pessoaFisica = pessoaJpaFisica.merge(pessoaFisica);
		}

		List<PessoaJuridica> list = new ArrayList<PessoaJuridica>();

		pessoaJuridica.setPessoa(pessoa);
		list.add(pessoaJuridica);

		pessoa.setListPessoaJuridica(list);
		if (pessoa.getId() == pessoaJuridica.getPessoa().getId()) {
			pessoaJpaJuridica.create(pessoaJuridica);
		}
		return "/success.xhtml";
	}

}
