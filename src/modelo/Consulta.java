package modelo;

import java.util.Date;

public class Consulta {
	private int codanimal;
	private int matricula;
	private Date data;
	private String diagnosticoconsulta;
	private int codconsulta;

	public Consulta(int codanimal, int matricula, Date data, String diagnosticoconsulta, int codconsulta) {
		this.codanimal = codanimal;
		this.matricula = matricula;
		this.data = data;
		this.diagnosticoconsulta = diagnosticoconsulta;
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

}