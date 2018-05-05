package br.com.join.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.join.entity.Dependente;
import br.com.join.entity.PessoaFisica;
import br.com.join.jpaController.DependenteJpaControllerRemote;
import br.com.join.jpaController.PessoaFisicaJpaControllerRemote;

@SessionScoped
@Named("dependenteBean")
public class DependenteBean implements Serializable {

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
	private List<Dependente> listDependente;

	private Integer idPessoaFisica;
	
	private Dependente selectDependente;

	@PostConstruct
	public void init() {
		dependente = new Dependente();
		listPessoaFisica = pessoaFisicaJpa.findAll();
		listDependente = dependenteJpa.findAll();
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

	public List<Dependente> getListDependente() {
		return listDependente;
	}

	public void setListDependente(List<Dependente> listDependente) {
		this.listDependente = listDependente;
	}

	public Integer getIdPessoaFisica() {
		return idPessoaFisica;
	}

	public void setIdPessoaFisica(Integer idPessoaFisica) {
		this.idPessoaFisica = idPessoaFisica;
	}
	
	public String update() {
		return null;
	}

	public String create() {
		PessoaFisica pessoaFisica = pessoaFisicaJpa.findById(idPessoaFisica);
		dependente.setPessoaFisica(pessoaFisica);
		dependenteJpa.create(dependente);
		listDependente.add(dependente);
		dependente = new Dependente();
		return null;
	}
	public String edit() {
		return null;
	}

	public Dependente getSelectDependente() {
		return selectDependente;
	}

	public void setSelectDependente(Dependente selectDependente) {
		System.out.println("dependente "+selectDependente.getNomeDependente());
		this.selectDependente = selectDependente;
	}
	
	

}
