package controllers;

import java.sql.SQLException;
import java.util.List;

import dao.ConsultaDAO;
import modelo.Consulta;

public class ConsultaController {

	private ConsultaDAO dao;
	
	public ConsultaController() {
		this.dao = new ConsultaDAO();
	}
	
	public List<Consulta> listar() {
		return this.dao.busca_consulta();
	}

	public int cadastrar(Consulta consulta) throws SQLException {
		return this.dao.inserir_consulta(consulta);
	}

	public boolean atualizar(Consulta consulta) {
		return this.dao.att_consulta(consulta);
	}

	public boolean deletar(Consulta consulta) {
		return this.dao.delete_consulta(consulta);
	}
}
