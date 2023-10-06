package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Editora;
import com.residencia.biblioteca.repositories.EditoraRepository;

@Service
public class EditoraService {

	// 5 métodos - CRUD
	// recuperar todas Editoras
	// recuperar uma Editora pela sua chave primária
	// salvar uma nova Editora
	// atualizar um determinado editora
	// deletar um determinado editora

	@Autowired
	EditoraRepository editoraRepo; // instanciando o repositorio do Editora

	public List<Editora> listarEditoras() { // List pq são varias editoras
		return editoraRepo.findAll();
	}

	// criando metodo de recuperar editora pela chave primária
	public Editora buscarEditoraPorId(Integer codigoEditora) { // integer pq é o tipo da chave primária de Editora
		return editoraRepo.findById(codigoEditora).get(); // utilizamos o getbyid optional, depois o .get para
																// retornar uma editora.
	}

	// criando metodo para salvar uma nova editora
	public Editora salvarEditora(Editora novaEditora) { // salvando uma nova editora na entidade Editora
		return editoraRepo.save(novaEditora); // o .save ja vai salvar
	}

	// criando metodo para atualizar uma editora existente
	public Editora atualizarEditora(Editora atualizaEditora) {
		return editoraRepo.save(atualizaEditora);
	}

	// criando metodo para deletar um determinada editora
	public void deletarEditora(Editora deletaEditora) { // será void pq não irá devolver nd,
		editoraRepo.delete(deletaEditora); // por isso também não tem o return
		/*
		 * Aluno confereAlunoDeletado =
		 * buscarAlunoPorId(aluno.getNumeroMatriculaAluno())
		 */
	}
}
