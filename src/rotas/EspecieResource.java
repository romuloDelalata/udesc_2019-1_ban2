package rotas;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.google.gson.Gson;

import controllers.EspecieController;
import modelo.Especie;

@Path("especies")
public class EspecieResource {
	
	private EspecieController especieController = new EspecieController();
	
	@GET
	@Path("")
	public String listar() {
		List<Especie> especies = especieController.listar();
		return new Gson().toJson(especies);
	}
}
