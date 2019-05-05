package controllers;

import java.util.List;

import dao.MedicamentoDAO;
import modelo.Medicamento;

public class MedicamentoController {

	private MedicamentoDAO dao;
	
	public MedicamentoController() {
		this.dao = new MedicamentoDAO();
	}
	public List<Medicamento> listar() {
		return this.dao.busca_medicamento();
	}
	public boolean cadastra(Medicamento medicamento) {
		return this.dao.inserir_medicamento(medicamento);
	}
	public boolean atualiza(Medicamento medicamento) {
		return this.dao.att_medicamento(medicamento);
	}
	public boolean deletar(Medicamento medicamento) {
		return this.dao.delete_medicamento(medicamento);
	}

}
