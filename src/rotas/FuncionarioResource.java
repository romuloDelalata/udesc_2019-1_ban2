package rotas;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

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
	
	@POST
	@Path("funcionario")
	public String cadastrarUsuario(String dados) {
		Funcionario funcionario = new Gson().fromJson(dados, Funcionario.class);
		return String.valueOf(funcionariosController.inserirFuncionario(funcionario));
	}
	
	@PUT
	@Path("funcionario/{matricula}")
	public String atualizaFuncionario(@PathParam("matricula") int matricula, String dados) {
		Funcionario funcionario = new Gson().fromJson(dados, Funcionario.class);
		funcionario.setMatricula(matricula);
		return String.valueOf(funcionariosController.atualizarFuncionario(funcionario));
	}
	
	@DELETE
	@Path("funcionario/{matricula}")
	public String deletarFuncionario(@PathParam("matricula") int matricula) {
		return String.valueOf(funcionariosController.deletaFuncionario(matricula));
	}
}