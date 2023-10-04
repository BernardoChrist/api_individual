package com.residencia.biblioteca.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//o entity é utilizado para a informar que essa classe é uma entidade - é obrigatório
@Entity
@Table(name = "aluno") // o table é opcional, utilizado para dar o nome a tabela

public class Aluno {

	// os atributos abaixo são todas as colunas la no banco de dados

	@Id // o Id é para informar que a entidade é chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // vai ser usado para gerar o valor automático, e p identity diz
														// que o banco vai gerar esse valor
	@Column(name = "numeromatriculaaluno") // é também opcional
	private Integer numeroMatriculaAluno;

	@Column(name = "nome")
	private String nome;

	@Column(name = "datanascimento")
	private Date dataNascimento;

	@Column(name = "cpf")
	private String cpf;

	@Column(name = "logradouro")
	private String logradouro;

	@Column(name = "numerologradouro")
	private String numeroLogradouro;

	@Column(name = "complemento")
	private String complemento;

	@Column(name = "bairro")
	private String bairro;

	@Column(name = "cidade")
	private String cidade;

	@OneToMany(mappedBy = "aluno")
	// onetomany é para dizer que é 1 para muitos
	// o mappedBy é para colocar o nome da instancia de aluno dentro de Emprestimo -
	// é "aluno"
	private List<Emprestimo> esmprestimos;// criando a lista para chave estrangeira (n)

	// daqui para baixo é a geração do GET e SET

	public List<Emprestimo> getEsmprestimos() {
		return esmprestimos;
	}

	public void setEsmprestimos(List<Emprestimo> esmprestimos) {
		this.esmprestimos = esmprestimos;
	}

	public Integer getNumeroMatriculaAluno() {
		return numeroMatriculaAluno;
	}

	public void setNumeroMatriculaAluno(Integer numeroMatriculaAluno) {
		this.numeroMatriculaAluno = numeroMatriculaAluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumeroLogradouro() {
		return numeroLogradouro;
	}

	public void setNumeroLogradouro(String numeroLogradouro) {
		this.numeroLogradouro = numeroLogradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

}
