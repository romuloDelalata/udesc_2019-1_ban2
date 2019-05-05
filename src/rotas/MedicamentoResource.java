package rotas;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import com.google.gson.Gson;

import controllers.MedicamentoController;
import modelo.Medicamento;

@Path("medicamentos")
public class MedicamentoResource {
	
	private MedicamentoController medicamentomontroller = new MedicamentoController();
	
	@GET
	@Path("")
	public String listar() {
		List<Medicamento> medicamentos = medicamentomontroller.listar();
		return new Gson().toJson(medicamentos);
	}
	
	@POST
	@Path("medicamento")
	public String cadastrarEspecie(String dados) {
		Medicamento medicamento = new Gson().fromJson(dados, Medicamento.class);
		return String.valueOf(medicamentomontroller.cadastra(medicamento));
	}
	
	@PUT
	@Path("medicamento/{codmedicamento}")
	public String atualizarEspecie(@PathParam("codmedicamento") int codmedicamento, String dados) {
		Medicamento medicamento = new Gson().fromJson(dados, Medicamento.class);
		medicamento.setCodMedicamento(codmedicamento);
		return String.valueOf(medicamentomontroller.atualiza(medicamento));
	}
	
	@DELETE
	@Path("medicamento/{codmedicamento}")
	public String removerEspecie(@PathParam("codmedicamento") int codmedicamento) {
		Medicamento medicamento = new Medicamento();
		medicamento.setCodMedicamento(codmedicamento);
		return String.valueOf(medicamentomontroller.deletar(medicamento));
	}
}

