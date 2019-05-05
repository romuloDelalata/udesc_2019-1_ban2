package controllers;

import java.util.List;

import dao.EspecieDAO;
import modelo.Especie;

public class EspecieController {

	private EspecieDAO dao;
	
	public EspecieController() {
		this.dao = new EspecieDAO();
	}
	
	public List<Especie> listar() {
		return this.dao.busca_especie();
	}

	public boolean cadastra(Especie especie) {
		return this.dao.inserir_especie(especie);
	}

	public boolean atualiza(Especie especie) {
		return this.dao.att_especie(especie);
	}

	public boolean deletar(Especie especie) {
		return this.dao.delete_especie(especie);
	}

}
