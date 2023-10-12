package com.residencia.biblioteca.entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class, // esse será padrão, copia e cola
		property = "codigoLivro", // aqui tem que ser o atributo da chave primária
		scope = Livro.class)
//o entity é utilizado para a informar que essa classe é uma entidade - é obrigatório
@Entity
@Table(name = "livro") // o table é opcional, utilizado para dar o nome a tabela
public class Livro {

	// os atributos abaixo são todas as colunas la no banco de dados

	@Id // o Id é para informar que a entidade é chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // vai ser usado para gerar o valor automático, e p identity diz
														// que o banco vai gerar esse valor
	@Column(name = "codigolivro") // é também opcional
	private Integer codigoLivro;

	@Column(name = "nomelivro")
	private String nomeLivro;

	@ManyToOne
	@JoinColumn(name = "codigoautor", referencedColumnName = "codigoautor")
	private Autor autor;

	@Column(name = "datalancamento")
	private Date dataLancamento;

	@Column(name = "codigoisbn")
	private Integer codigoIsbn;

	//@JsonBackReference(value = "editora-livro-ref")
	@ManyToOne // muitos livros para 1 editora
	@JoinColumn(name = "codigoeditora", referencedColumnName = "codigoeditora")
	private Editora editora;

	//@JsonManagedReference(value = "livro-emprestimo-ref") // utilizando managed pq é o principal, onde temos o List
	@OneToMany(mappedBy = "livro") // 1 livro para muitos emprestimos
	private List<Emprestimo> emprestimos;

	public Integer getCodigoLivro() {
		return codigoLivro;
	}

	public void setCodigoLivro(Integer codigoLivro) {
		this.codigoLivro = codigoLivro;
	}

	public String getNomeLivro() {
		return nomeLivro;
	}

	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}


	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Integer getCodigoIsbn() {
		return codigoIsbn;
	}

	public void setCodigoIsbn(Integer codigoIsbn) {
		this.codigoIsbn = codigoIsbn;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public void setEmprestimos(List<Emprestimo> emprestimos) {
		this.emprestimos = emprestimos;
	}
	
	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

}
