package controllers;

import java.sql.SQLException;
import java.util.List;

import dao.ConsultaDAO;
import dao.PrescricaoDAO;
import modelo.Consulta;

public class ConsultaController {

	private ConsultaDAO dao;
	
	public ConsultaController() {
		this.dao = new ConsultaDAO();
	}
	
	public List<Consulta> listar() {
		return this.dao.busca_consulta();
	}

	public boolean cadastrar(Consulta consulta) throws SQLException {
		int codconsulta = this.dao.inserir_consulta(consulta);
		PrescricaoDAO prescricaoDao = new PrescricaoDAO();
		return prescricaoDao.inserir_prescricao(codconsulta,consulta.getMedicamentos());
	}

	public boolean atualizar(Consulta consulta) {
		PrescricaoDAO prescricaoDao = new PrescricaoDAO();
		prescricaoDao.deletar_prescricoes(consulta.getCodconsulta());
		this.dao.att_consulta(consulta);
		PrescricaoDAO prescricaoDao2 = new PrescricaoDAO();
		return prescricaoDao2.inserir_prescricao(consulta.getCodconsulta(), consulta.getMedicamentos());
	}

	public boolean deletar(Consulta consulta) {
		PrescricaoDAO prescricaoDao = new PrescricaoDAO();
		prescricaoDao.deletar_prescricoes(consulta.getCodconsulta());
		return this.dao.delete_consulta(consulta);
	}
}
