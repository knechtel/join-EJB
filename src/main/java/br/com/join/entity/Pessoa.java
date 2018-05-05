package br.com.join.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "pessoa")
public class Pessoa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String municipio;
	private String uf;
	private Date dataNascimento;
	@JoinTable(name = "pessoa_has_juridica", joinColumns = {
			@JoinColumn(name = "pessoa_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "pessoaJuridica_id", referencedColumnName = "id") })
	@OneToMany(fetch = FetchType.LAZY)
	private List<PessoaJuridica> listPessoaJuridica;

	@Version
	private Integer versao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMunicipio() {
		return municipio;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<PessoaJuridica> getListPessoaJuridica() {
		return listPessoaJuridica;
	}

	public void setListPessoaJuridica(List<PessoaJuridica> listPessoaJuridica) {
		this.listPessoaJuridica = listPessoaJuridica;
	}

	public Integer getVersao() {
		return versao;
	}

	public void setVersao(Integer versao) {
		this.versao = versao;
	}

}
