package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Editora;
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
		return editoraRepo.findById(codigoEditora).orElse(null); // utilizamos o getbyid optional, depois o .get para
																// retornar uma editora.
		// utilizamos o orElse, caso o numero do ID não exista, seria uma exception -
		// entao o que tivermos dentro do orElse, irá ser passado na pesquisa quando o
		// ID não for encontrado - - Caso o Id é encontrado, retorna o ID como se fosse
		// um .get()
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
	public Boolean deletarEditora(Editora deletaEditora) { // boolena pq é mais facil de tratar no controller

		if (deletaEditora == null) {
			return false; // aqui estamos vendo se o editora inserido para deletar é nulo
		}

		Editora editoraExistente = buscarEditoraPorId(deletaEditora.getCodigoEditora());

		if (editoraExistente == null) {
			return false; // aqui etamos vendo se o editora existe no banco
		}

		editoraRepo.delete(deletaEditora);

		Editora editoraContinuaExistindo = buscarEditoraPorId(deletaEditora.getCodigoEditora());

		if (editoraContinuaExistindo == null) {
			return true;
		}
		return false;

	}
}
