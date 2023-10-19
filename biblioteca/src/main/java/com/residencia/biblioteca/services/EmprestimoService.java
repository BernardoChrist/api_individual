package com.residencia.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.entities.Emprestimo;
import com.residencia.biblioteca.repositories.EmprestimoRepository;

@Service
public class EmprestimoService {

	// 5 métodos - CRUD
	// recuperar todos emprestimos
	// recuperar um emprestimo pela sua chave primária
	// salvar um novo Emprestimo
	// atualizar um determinado Emprestimo
	// deletar um determinado Emprestimo

	@Autowired
	EmprestimoRepository emprestimoRepo;

	public List<Emprestimo> listarEmprestimos() { // List pq são varios Emprestimos
		return emprestimoRepo.findAll();
	}

	public Emprestimo buscarEmprestimoPorId(Integer codigoEmprestimo) { // integer pq é o tipo da chave primária de
																		// Emprestimo
		return emprestimoRepo.findById(codigoEmprestimo).orElse(null);
		// utilizamos o orElse, caso o numero do ID não exista, seria uma exception -
				// entao o que tivermos dentro do orElse, irá ser passado na pesquisa quando o
				// ID não for encontrado - - Caso o Id é encontrado, retorna o ID como se fosse
				// um .get()
	}

	public Emprestimo salvarEmprestimo(Emprestimo novoEmprestimo) { // salvando um novo emprestimo na entidade Emprestimo
		return emprestimoRepo.save(novoEmprestimo); // o .save ja vai salvar
	}

	public Emprestimo atualizarEmprestimo(Emprestimo atualizaEmprestimo) {
		return emprestimoRepo.save(atualizaEmprestimo);
	}

	public Boolean deletarEmprestimo(Emprestimo deletaEmprestimo) { // boolena pq é mais facil de tratar no controller

		if (deletaEmprestimo == null) {
			return false; // aqui estamos vendo se o emprestimo inserido para deletar é nulo
		}

		Emprestimo emprestimoExistente = buscarEmprestimoPorId(deletaEmprestimo.getCodigoEmprestimo());

		if (emprestimoExistente == null) {
			return false; // aqui etamos vendo se o emprestimo existe no banco
		}

		emprestimoRepo.delete(deletaEmprestimo);

		Emprestimo emprestimoContinuaExistindo = buscarEmprestimoPorId(deletaEmprestimo.getCodigoEmprestimo());

		if (emprestimoContinuaExistindo == null) {
			return true;
		}
		return false;

	}
}
