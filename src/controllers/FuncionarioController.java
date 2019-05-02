package controllers;

import java.util.List;

import dao.FuncionarioDAO;
import modelo.Funcionario;

public class FuncionarioController {
	private FuncionarioDAO dao;
	
	public FuncionarioController() {
		this.dao = new FuncionarioDAO();
	}
	public List<Funcionario> listarTodos() {
		return this.dao.busca_funcionario();
	}
	
	public boolean deletaFuncionario(int matricula) {
		Funcionario funcionario = new Funcionario(matricula);
		return this.dao.delete_funcionario(funcionario);
	}

	public boolean atualizarFuncionario(Funcionario funcionarioAtualizado) {
		return this.dao.att_funcionario(funcionarioAtualizado); 
	}


	public boolean inserirFuncionario(Funcionario funcionario) {
		return this.dao.inserir_funcionario(funcionario);
	}

	public Funcionario buscaPorId(int matricula) {
		return this.dao.busca_funcionario_por_id(matricula);
	}

}
