package br.com.join.bean;

import java.io.Serializable;
import java.util.List;

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
	private List<PessoaFisica> listPessoaFisica;
	@EJB
	private PessoaJpaControllerRemote pessoaJpa;
	@EJB
	private PessoaFisicaJpaControllerRemote pessoaFisicaJpa;

	@PostConstruct
	public void init() {
		pessoa = new Pessoa();
		pessoaFisica = new PessoaFisica();
		pessoaFisica.setPessoa(pessoa);
		listPessoaFisica = pessoaFisicaJpa.findAll();
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

	public List<PessoaFisica> getListPessoaFisica() {
		return listPessoaFisica;
	}

	public void setListPessoaFisica(List<PessoaFisica> listPessoaFisica) {
		this.listPessoaFisica = listPessoaFisica;
	}

	public String create() {
		pessoaFisica.setPessoa(pessoa);
		pessoaFisicaJpa.create(pessoaFisica);

		listPessoaFisica = pessoaFisicaJpa.findAll();
		return null;
	}

	public String editDadosPessoais(PessoaFisica pessoaFisica) {
		pessoa =pessoaFisica.getPessoa();
		return "/editPessoa.xhtml";
	}

	public String deleteAction(PessoaFisica pessoaFisica) {
		pessoaFisicaJpa.delete(pessoaFisica);
		listPessoaFisica.remove(pessoaFisica);
		pessoaJpa.delete(pessoa);
		return null;
	}

	public String edit() {

		pessoaJpa.merge(pessoa);
		listPessoaFisica = pessoaFisicaJpa.findAll();
		pessoa = new Pessoa();
		pessoaFisica = new PessoaFisica();
		return "/success.xhtml";
	}

}
