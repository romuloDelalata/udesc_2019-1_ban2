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

}
