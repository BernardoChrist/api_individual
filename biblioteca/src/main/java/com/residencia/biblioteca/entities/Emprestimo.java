package com.residencia.biblioteca.entities;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class, // esse será padrão, copia e cola
		property = "codigoEmprestimo", // aqui tem que ser o atributo da chave primária
		scope = Emprestimo.class)

//o entity é utilizado para a informar que essa classe é uma entidade - é obrigatório
@Entity
@Table(name = "emprestimo") // o table é opcional, utilizado para dar o nome a tabela
public class Emprestimo {
	// os atributos abaixo são todas as colunas la no banco de dados

	@Id // o Id é para informar que a entidade é chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // vai ser usado para gerar o valor automático, e p identity diz
														// que o banco vai gerar esse valor
	@Column(name = "codigoemprestimo") // é também opcional
	private Integer codigoEmprestimo;

	/*@JsonBackReference(value = "aluno-mng-ref") // ao contrario do aluno, essa é a parte de tras do gerenciamento, por
												// isso utilizamos essa outra anotação - o value é identico nas duas
												// partes*/
	@ManyToOne // muitos para um
	@JoinColumn(name = "numeromatriculaaluno", referencedColumnName = "numeromatriculaaluno")
	// o name é o nome da coluna na tabela emprestimo que vai ser a chave
	// estrangeira, E o reference no banco, vai ser o referencedname
	private Aluno aluno; // temos que instanciar aluno da sua classe, isso irá puxar todos os dados dos
							// alunos

	//@JsonBackReference(value = "livro-emprestimo-ref") // back pq é ManyToOne 
	@ManyToOne // muitos emprestimos para 1 livro
	@JoinColumn(name = "codigolivro", referencedColumnName = "codigolivro")
	private Livro livro;

	@Column(name = "dataemprestimo")
	private Date dataEmprestimo;

	@Column(name = "dataentrega")
	private Date dataEntrega;

	@Column(name = "valoremprestimo")
	private BigDecimal valorEmprestimo;

	public Integer getCodigoEmprestimo() {
		return codigoEmprestimo;
	}

	public void setCodigoEmprestimo(Integer codigoEmprestimo) {
		this.codigoEmprestimo = codigoEmprestimo;
	}

	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public BigDecimal getValorEmprestimo() {
		return valorEmprestimo;
	}

	public void setValorEmprestimo(BigDecimal valorEmprestimo) {
		this.valorEmprestimo = valorEmprestimo;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

}
