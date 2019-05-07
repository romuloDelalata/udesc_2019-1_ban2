package modelo;

public class Prescricao {
	private int codconsulta;
	private String diagnosticoconsulta;
	private String nomemedicamento;

	public Prescricao(int codconsulta, String diagnosticoconsulta, String nomemedicamento) {
		this.codconsulta = codconsulta;
		this.diagnosticoconsulta = diagnosticoconsulta;
		this.nomemedicamento = nomemedicamento;
	}
	
	public int getCodconsulta() {
		return codconsulta;
	}
	
	public String getDiagnosticoconsulta() {
		return diagnosticoconsulta;
	}
	
	public String getNomemedicamento() {
		return nomemedicamento;
	}
}