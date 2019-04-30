package modelo;

public class Medicamento {
	private int codmedicamento;
	private String nomemedicamento;

	public Medicamento(int codmedicamento, String nomemedicamento) {
		this.codmedicamento = codmedicamento;
		this.nomemedicamento = nomemedicamento;
	}

	public int getCodmedicamento() {
		return this.codmedicamento;
	}

	public String getNomemedicamento() {
		return this.nomemedicamento;
	}
}
