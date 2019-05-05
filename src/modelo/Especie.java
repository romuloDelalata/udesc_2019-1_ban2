package modelo;

import com.google.gson.annotations.SerializedName;

public class Especie {
	
	@SerializedName("codespecie")
	private int codespecie;
	@SerializedName("nomeespecie")
	private String nomeespecie;
	@SerializedName("expectativaespecie")
	private String expectativaespecie;


	public Especie(int codespecie, String nomeespecie, String expectativaespecie) {
		this.codespecie = codespecie;
		this.nomeespecie = nomeespecie;
		this.expectativaespecie = expectativaespecie;
	}

	public Especie() {	}

	public int getCodespecie() {
		return codespecie;
	}

	public String getNomeespecie() {
		return nomeespecie;
	}

	public String getExpectativaespecie() {
		return expectativaespecie;
	}

	public void setCodEspecie(int codespecie) {
		this.codespecie = codespecie;
	}

}

