package com.residencia.biblioteca.entities;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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

		@Column(name = "nomeautor")
		private String nomeAutor;

		@Column(name = "datalancamento")
		private Date dataLancamento;

		@Column(name = "codigoisbn")
		private Integer codigoIsbn ;

		@Column(name = "codigoeditora")
		private Integer codigoEditora;
		
		@ManyToOne //muitos livros para 1 editora
		@JoinColumn(name = "codigoeditora", referencedColumnName = "codigoeditora")
		private Editora editora;

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

		public String getNomeAutor() {
			return nomeAutor;
		}

		public void setNomeAutor(String nomeAutor) {
			this.nomeAutor = nomeAutor;
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

		public Integer getCodigoEditora() {
			return codigoEditora;
		}

		public void setCodigoEditora(Integer codigoEditora) {
			this.codigoEditora = codigoEditora;
		}

		public Editora getEditora() {
			return editora;
		}

		public void setEditora(Editora editora) {
			this.editora = editora;
		}

}