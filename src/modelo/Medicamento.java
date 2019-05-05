package modelo;

import com.google.gson.annotations.SerializedName;

public class Medicamento {
	@SerializedName("codmedicamento")
	private int codmedicamento;
	@SerializedName("nomemedicamento")
	private String nomemedicamento;

	public Medicamento(int codmedicamento, String nomemedicamento) {
		this.codmedicamento = codmedicamento;
		this.nomemedicamento = nomemedicamento;
	}
	
	public Medicamento(int codmedicamento) {
		this.codmedicamento = codmedicamento;
	}

	public int getCodmedicamento() {
		return this.codmedicamento;
	}

	public String getNomemedicamento() {
		return this.nomemedicamento;
	}
	
	public void setCodmedicamento(int codmedicamento) {
		this.codmedicamento = codmedicamento;
	}
}
