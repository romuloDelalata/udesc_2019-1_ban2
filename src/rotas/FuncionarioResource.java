package rotas;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.google.gson.Gson;

import controllers.FuncionarioController;
import modelo.Funcionario;

@Path("funcionarios")
public class FuncionarioResource {
	
	private FuncionarioController funcionariosController = new FuncionarioController();

	@GET
	@Path("")
	public String listarTodos() {
		List<Funcionario> funcionarios = funcionariosController.listarTodos();
		return new Gson().toJson(funcionarios);
	}
}
