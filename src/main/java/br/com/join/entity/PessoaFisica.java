package br.com.join.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

@Entity
@NamedQueries({ @NamedQuery(name = "PessoaFisica.findAll", query = "SELECT p FROM PessoaFisica p") })
@Table(name = "pessoaFisica")
public class PessoaFisica implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne 
	@MapsId
	private Pessoa pessoa;
	private String cpf;
	

	@OneToMany(fetch = FetchType.LAZY)
	private List<Dependente> listDependente;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public List<Dependente> getListDependente() {
		return listDependente;
	}
	public void setListDependente(List<Dependente> listDependente) {
		this.listDependente = listDependente;
	}


}
