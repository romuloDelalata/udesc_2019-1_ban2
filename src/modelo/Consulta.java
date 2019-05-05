package modelo;

import java.util.Date;

import com.google.gson.annotations.SerializedName;

public class Consulta {
	@SerializedName("codanimal")
	private int codanimal;
	@SerializedName("matricula")
	private int matricula;
	@SerializedName("data")
	private Date data;
	@SerializedName("diagnosticoconsulta")
	private String diagnosticoconsulta;
	@SerializedName("codconsulta")
	private int codconsulta;

	public Consulta(int codanimal, int matricula, Date data, String diagnosticoconsulta, int codconsulta) {
		this.codanimal = codanimal;
		this.matricula = matricula;
		this.data = data;
		this.diagnosticoconsulta = diagnosticoconsulta;
		this.codconsulta = codconsulta;
	}
	
	public Consulta(int codconsultaa) {
		this.codconsulta = codconsulta;
	}

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
	
	public void setCodconsulta(int codconsulta) {
		this.codconsulta = codconsulta;
	}

}