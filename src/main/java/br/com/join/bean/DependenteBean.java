package br.com.join.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.join.entity.Dependente;
import br.com.join.entity.Pessoa;
import br.com.join.entity.PessoaFisica;
import br.com.join.jpaController.DependenteJpaControllerRemote;
import br.com.join.jpaController.PessoaFisicaJpaControllerRemote;
@RequestScoped
@Named("dependenteBean")
public class DependenteBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private PessoaFisicaJpaControllerRemote pessoaFisicaJpa;
	private List<PessoaFisica> listPessoaFisica;
	private Dependente dependente;
	@EJB
	private DependenteJpaControllerRemote dependenteJpa;
	
	
	private Integer idPessoaFisica;

	@PostConstruct
	public void init() {
		dependente = new Dependente();
		listPessoaFisica = pessoaFisicaJpa.findAll();

	}
	public Dependente getDependente() {
		return dependente;
	}

	public void setDependente(Dependente dependente) {
		this.dependente = dependente;
	}

	public List<PessoaFisica> getListPessoaFisica() {
		return listPessoaFisica;
	}

	public void setListPessoaFisica(List<PessoaFisica> listPessoaFisica) {
		this.listPessoaFisica = listPessoaFisica;
	}
	
	

	public Integer getIdPessoaFisica() {
		return idPessoaFisica;
	}
	public void setIdPessoaFisica(Integer idPessoaFisica) {
		this.idPessoaFisica = idPessoaFisica;
	}
	public String create() {
		System.out.println("verifica = "+ idPessoaFisica);
		PessoaFisica pessoaFisica = pessoaFisicaJpa.findById(idPessoaFisica);
		dependente.setPessoaFisica(pessoaFisica);
		dependenteJpa.create(dependente);
		
		return "/success.xhtml";
	}

}
