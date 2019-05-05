package controllers;

import java.util.List;

import dao.MedicamentoDAO;
import modelo.Medicamento;

public class MedicamentoController {
	private MedicamentoDAO dao;
	
	public MedicamentoController() {
		this.dao = new MedicamentoDAO();
	}
	public List<Medicamento> listarTodos() {
		return this.dao.busca_medicamento();
	}
	
	public boolean deletaMedicamento(int codmedicamento) {
		Medicamento medicamento = new Medicamento(codmedicamento);
		return this.dao.delete_medicamento(medicamento);
	}

	public boolean atualizarMedicamento(Medicamento medicamentoAtualizado) {
		return this.dao.att_medicamento(medicamentoAtualizado); 
	}


	public boolean inserirMedicamento(Medicamento medicamento) {
		return this.dao.inserir_medicamento(medicamento);
	}

	public Medicamento buscaPorId(int codmedicamento) {
		return this.dao.busca_medicamento_por_id(codmedicamento);
	}

}
