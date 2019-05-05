package rotas;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

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
	
	@POST
	@Path("especie")
	public String cadastrarEspecie(String dados) {
		Especie especie = new Gson().fromJson(dados, Especie.class);
		
		return String.valueOf(especieController.cadastra(especie));
	}
	
	@PUT
	@Path("especie/{codespecie}")
	public String atualizarEspecie(@PathParam("codespecie") int codespecie, String dados) {
		Especie especie = new Gson().fromJson(dados, Especie.class);
		especie.setCodEspecie(codespecie);
		return String.valueOf(especieController.atualiza(especie));
	}
	
	@DELETE
	@Path("especie/{codespecie}")
	public String removerEspecie(@PathParam("codespecie") int codespecie) {
		Especie especie = new Especie();
		especie.setCodEspecie(codespecie);
		return String.valueOf(especieController.deletar(especie));
	}
}
