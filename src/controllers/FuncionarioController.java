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

}
