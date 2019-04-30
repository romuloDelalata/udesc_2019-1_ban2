package rotas;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import controllers.AnimalController;
import modelo.Animal;

@Path("animais")
public class AnimalResource {
	
	private AnimalController animalController = new AnimalController();
	
	@GET
	@Path("")
	public String buscaAnimais() {
	 List<Animal> animais = animalController.buscarTodos();
	 return new Gson().toJson(animais);
	}
	
	@GET
	@Path("animal/{codAnimal}")
	public String buscaPorId(@PathParam("codAnimal") int codAnimal) {
		Animal animal = animalController.buscaPorId(codAnimal);
		return new Gson().toJson(animal);
	}
	
	@DELETE
	@Path("animal/{codAnimal}")
	public String deleteAnimal(@PathParam("codAnimal") int codAnimal) {
		return String.valueOf(animalController.deletaAnimal(codAnimal));
	}
	
	@PUT
	@Path("animal/{codAnimal}")
	public String atualizarAnimal(@PathParam("codAnimal") int codAnimal, String dados) {
		System.out.println("ATUALIZNDO DADOS DO ANIMAL : "+ dados);
		Animal animalAtualizado = new Gson().fromJson(dados, Animal.class);
		animalAtualizado.setCodAnimal(codAnimal);
		return String.valueOf(animalController.atualizarAnimal(animalAtualizado));
	}
	
	@POST
	@Path("animal")
	public String inserirAnimal(String dados) {
		Animal animal = new Gson().fromJson(dados, Animal.class);
		return String.valueOf(animalController.inserirAnimal(animal));
	}
}
