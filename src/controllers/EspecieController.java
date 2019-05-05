package controllers;

import java.util.List;

import dao.EspecieDAO;
import modelo.Especie;

public class EspecieController {
	private EspecieDAO dao;
	
	public EspecieController() {
		this.dao = new EspecieDAO();
	}
	public List<Especie> listarTodos() {
		return this.dao.busca_especie();
	}
	
	public boolean deletaEspecie(int codespecie) {
		Especie especie = new Especie(codespecie);
		return this.dao.delete_especie(especie);
	}

	public boolean atualizarEspecie(Especie especieAtualizado) {
		return this.dao.att_especie(especieAtualizado); 
	}


	public boolean inserirEspecie(Especie especie) {
		return this.dao.inserir_especie(especie);
	}

	public Especie buscaPorId(int codespecie) {
		return this.dao.busca_especie_por_id(codespecie);
	}

}
