package com.residencia.biblioteca.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "editora") // o table é opcional, utilizado para dar o nome a tabela
public class Editora {

	// os atributos abaixo são todas as colunas la no banco de dados

	@Id // o Id é para informar que a entidade é chave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) // vai ser usado para gerar o valor automático, e p identity diz
														// que o banco vai gerar esse valor
	@Column(name = "codigoeditora") // é também opcional
	private Integer codigoEditora;

	@Column(name = "nome")
	private String nome;

	@Column(name = "imagem_nome")
	private String imagemNome;

	@Column(name = "imagem_filename")
	private String imagemFileName;

	@Column(name = "imagem_url")
	private String imagemUrl;

	@JsonManagedReference(value = "editora-livro-ref") 
	@OneToMany(mappedBy = "editora") // 1 editora para muitos livros
	private List<Livro> livros;

	public Integer getCodigoEditora() {
		return codigoEditora;
	}

	public void setCodigoEditora(Integer codigoEditora) {
		this.codigoEditora = codigoEditora;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getImagemNome() {
		return imagemNome;
	}

	public void setImagemNome(String imagemNome) {
		this.imagemNome = imagemNome;
	}

	public String getImagemFileName() {
		return imagemFileName;
	}

	public void setImagemFileName(String imagemFileName) {
		this.imagemFileName = imagemFileName;
	}

	public String getImagemUrl() {
		return imagemUrl;
	}

	public void setImagemUrl(String imagemUrl) {
		this.imagemUrl = imagemUrl;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

}
