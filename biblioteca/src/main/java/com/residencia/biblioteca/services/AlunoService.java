package com.residencia.biblioteca.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.dto.AlunoResumidoDTO;
import com.residencia.biblioteca.entities.Aluno;
import com.residencia.biblioteca.repositories.AlunoRepository;

@Service // é obrigatóro para os serviços
public class AlunoService {
	// 5 métodos - CRUD
	// recuperar todos alunos
	// recuperar um aluno pela sua chave primária
	// salvar um novo aluno
	// atualizar um determinado aluno
	// deletar um determinado aluno

	@Autowired // essa anotação é para injeção de dependencia, recursos de outro lugar
	AlunoRepository alunoRepo; // instanciando o repositorio do aluno

	// criando o metodo para recuperar todos os alunos
	public List<Aluno> listarAlunos() { // List pq são varios alunos
		return alunoRepo.findAll(); // o findAll irá listar todos
	}

	// metodo de listar todos os alunos DTO - temos que usar list
	public List<AlunoResumidoDTO> listarAlunosResumidos() {

		List<Aluno> alunos = alunoRepo.findAll(); // guardar tudo dentro da list
		List<AlunoResumidoDTO> alunosDTO = new ArrayList<>();

		for (Aluno aluno : alunos) {
			// cada vez que passar pelo laço, aluno irá guardar os atributos de alunos

			AlunoResumidoDTO alunoResDTO = new AlunoResumidoDTO();

			alunoResDTO.setNumeroMatriculaAluno(aluno.getNumeroMatriculaAluno());
			alunoResDTO.setNome(aluno.getNome());
			alunoResDTO.setCpf(aluno.getCpf());

			alunosDTO.add(alunoResDTO);
			// metodo add para adicionar varios objetos na lista alunosDTO
			// senão quando rodar o laço, perderia as informações
		}

		return alunosDTO;
	}

	// criando metodo de recuperar aluno pela chave primária
	public Aluno buscarAlunoPorId(Integer numeroMatriculaAluno) { // integer pq é o tipo da chave primária de aluno

		return alunoRepo.findById(numeroMatriculaAluno).orElse(null); // utilizamos o getbyid optional, depois o .get
																		// para
																		// retornar um aluno.
		// temos que fazer essa alteração no service para depois alterar o controller
		// utilizamos o orElse, caso o numero do ID não exista, seria uma exception -
		// entao o que tivermos dentro do orElse, irá ser passado na pesquisa quando o
		// ID não for encontrado - - Caso o Id é encontrado, retorna o ID como se fosse
		// um .get()
	}

	// metodo para devolver um aluno resumido DTO por id
	public AlunoResumidoDTO buscarAlunoResumidoPorId(Integer numeroMatriculaAluno) {
		// guardando dentro de aluno os dados
		Aluno aluno = alunoRepo.findById(numeroMatriculaAluno).orElse(null);

		// na linha de baixo estamos pegando os dados do aluno, e inserindo no alunoRes
		// estamos utulizando o set no alunoRes para inserir dados atraves do get do
		// aluno

		if (aluno != null) { // utilizamos o if para que não de erro quando o aluno for null
			AlunoResumidoDTO alunoResDTO = new AlunoResumidoDTO( 
					aluno.getNumeroMatriculaAluno(), 
					aluno.getNome(),
					aluno.getCpf());
					//aqui acima estamos utilizando o construtor para agilizar 
					//escolhemos o jeito de cima ou de baixo que esta comentado para utilizar
			
			/*
			 * alunoResDTO.setNumeroMatriculaAluno(aluno.getNumeroMatriculaAluno());
			 * alunoResDTO.setNome(aluno.getNome()); alunoResDTO.setCpf(aluno.getCpf());
			 */
			return alunoResDTO;

		}

		return null;
	}

	// criando metodo para salvar um novo aluno
	public Aluno salvarAluno(Aluno novoAluno) { // salvando um novo aluno na entidade Aluno
		return alunoRepo.save(novoAluno); // o .save ja vai salvar
	}

	// criando metodo para atualizar um aluno existente
	public Aluno atualizarAluno(Aluno atualizaAluno) {
		return alunoRepo.save(atualizaAluno);
	}

	// criando metodo para deletar um determinado aluno
	public Boolean deletarAluno(Aluno deletaAluno) { // boolena pq é mais facil de tratar no controller

		if (deletaAluno == null) {
			return false; // aqui estamos vendo se o aluno inserido para deletar é nulo
		}

		Aluno alunoExistente = buscarAlunoPorId(deletaAluno.getNumeroMatriculaAluno());

		if (alunoExistente == null) {
			return false; // aqui etamos vendo se o aluno existe no banco
		}

		alunoRepo.delete(deletaAluno);

		Aluno alunoContinuaExistindo = buscarAlunoPorId(deletaAluno.getNumeroMatriculaAluno());

		if (alunoContinuaExistindo == null) {
			return true;
		}
		return false;

	}
}
