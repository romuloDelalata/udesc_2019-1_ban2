package controllers;

import java.util.List;

import dao.AnimalDAO;
import modelo.Animal;

public class AnimalController {
	private AnimalDAO dao;
	
	public AnimalController() {
		this.dao = new AnimalDAO();
	}

	public List<Animal> buscarTodos() {
		return this.dao.busca_animal();
	}

	public boolean deletaAnimal(int codAnimal) {
		Animal animal = new Animal(codAnimal);
		return this.dao.delete_animal(animal);
	}

	public boolean atualizarAnimal(Animal animalAtualizado) {
		return this.dao.att_animal(animalAtualizado);
	}


	public boolean inserirAnimal(Animal animal) {
		return this.dao.inserir_animal(animal);
	}

	public Animal buscaPorId(int codAnimal) {
		return this.dao.busca_animal_por_id(codAnimal);
	}
	
	
}
