package controllers;

import java.util.List;

import dao.ConsultaDAO;
import modelo.Consulta;

public class ConsultaController {
	private ConsultaDAO dao;
	
	public ConsultaController() {
		this.dao = new ConsultaDAO();
	}
	public List<Consulta> listarTodos() {
		return this.dao.busca_consulta();
	}
	
	public boolean deletaConsulta(int codconsulta) {
		Consulta consulta = new Consulta(codconsulta);
		return this.dao.delete_consulta(codconsulta);
	}

	public boolean atualizarConsulta(Consulta consultaAtualizada) {
		return this.dao.att_consulta(consultaAtualizada); 
	}


	public boolean inserirConsulta(Consulta consulta) {
		return this.dao.inserir_consulta(consulta);
	}

	public Consulta buscaPorId(int codconsulta) {
		return this.dao.busca_consulta_por_id(codconsulta);
	}

}
