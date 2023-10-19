package com.residencia.biblioteca.dto;

//no DTO NÃO temos as anotações da entidade
//o DTO é feito para fazer as pesquisas personalizadas, abaixo selecionamos apenas os atributos mais relevantes
public class AlunoResumidoDTO {

	private Integer numeroMatriculaAluno;
	private String nome;
	private String cpf;

	// construtores
	public AlunoResumidoDTO(Integer numeroMatriculaAluno, String nome, String cpf) {
		this.numeroMatriculaAluno = numeroMatriculaAluno;
		this.nome = nome;
		this.cpf = cpf;
	}

	public AlunoResumidoDTO() {
	}

	// get e set
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
