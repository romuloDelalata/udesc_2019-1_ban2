package rotas;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import controllers.ConsultaController;
import modelo.Consulta;

@Path("consultas")
public class ConsultaResource {
	
	ConsultaController controller = new ConsultaController();
	@Path("")
	@GET
	public String listar() {
		List<Consulta> consultas = controller.listar();
		return new Gson().toJson(consultas);
	}
	
	@Path("consulta")
	@POST
	public String cadastra(String dados) throws SQLException {
		Consulta consulta = new Gson().fromJson(dados, Consulta.class);
		return String.valueOf(controller.cadastrar(consulta));
	}
	
	@Path("consulta/{codconsulta}")
	@PUT
	public String atualiza(@PathParam("codconsulta") Integer codconsulta,String dados) throws SQLException {
		Consulta consulta = new Gson().fromJson(dados, Consulta.class);
		consulta.setCodConsulta(codconsulta);
		return String.valueOf(controller.atualizar(consulta));
	}
	
	@Path("consulta/{codconsulta}")
	@DELETE
	public String deletar(@PathParam("codconsulta") Integer codconsulta) {
		Consulta consulta = new Consulta();
		consulta.setCodConsulta(codconsulta);
		return String.valueOf(controller.deletar(consulta));
	}
}
