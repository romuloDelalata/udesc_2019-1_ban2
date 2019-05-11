package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Consulta {
	@SerializedName("codanimal")
	private int codanimal;
	@SerializedName("nomeanimal")
	private String nomeanimal;
	@SerializedName("matricula")
	private int matricula;
	@SerializedName("nomefuncionario")
	private String nomefuncionario;
	@SerializedName("data")
	private Date data;
	@SerializedName("diagnosticoconsulta")
	private String diagnosticoconsulta;
	@SerializedName("medicamentos")
	private List<Medicamento> medicamentos;
	@SerializedName("codconsulta")
	private int codconsulta;

	public Consulta(int codanimal, String nomeanimal, int matricula, String nomefuncionario, Date data, String diagnosticoconsulta, int codconsulta) {
		this.codanimal = codanimal;
		this.nomeanimal = nomeanimal;
		this.matricula = matricula;
		this.nomefuncionario = nomefuncionario;
		this.data = data;
		this.diagnosticoconsulta = diagnosticoconsulta;
		this.codconsulta = codconsulta;
		this.medicamentos = new ArrayList<>();
	}

	public Consulta() {}

	public int getCodanimal() {
		return codanimal;
	}

	public int getMatricula() {
		return matricula;
	}
	
	public Date getDataConsulta() {
		return this.data;
	}

	public String getDiagnosticoconsulta() {
		return diagnosticoconsulta;
	}

	public int getCodconsulta() {
		return codconsulta;
	}
	
	public void addMedicamento(Medicamento medicamento) {
		this.medicamentos.add(medicamento);
	}

	public void setCodConsulta(Integer codconsulta) {
		this.codconsulta = codconsulta;
	}

	public List<Medicamento> getMedicamentos() {
		return this.medicamentos;
	}
}