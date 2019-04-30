package modelo;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Animal {
	
	@SerializedName("nomeAnimal")
	private String nomeAnimal;
	@SerializedName("codEspecie")
	private int codEspecie;
	@SerializedName("especie")
	private String especie;
	@SerializedName("codAnimal")
	private int codAnimal;
	@SerializedName("codAnimalPai")
	private int codAnimalPai;
	@SerializedName("codAnimalMae")
	private int codAnimalMae;
	@SerializedName("dtNascAnimal")
	private Date dtNascAnimal;

	public Animal(String nomeAnimal, int codEspecie, String especie,int codAnimal, int codAnimalPai, int codAnimalMae, Date dtNascAnimal) {
		this.nomeAnimal = nomeAnimal;
		this.codEspecie = codEspecie;
		this.especie = especie;
		this.codAnimal = codAnimal;
		this.codAnimalPai = codAnimalPai;
		this.codAnimalMae = codAnimalMae;
		this.dtNascAnimal = dtNascAnimal;
	}

	public Animal(int codAnimal) {
		this.codAnimal = codAnimal;
	}

	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public int getCodEspecie() {
		return codEspecie;
	}

	public int getCodAnimal() {
		return codAnimal;
	}

	public int getCodAnimalPai() {
		return codAnimalPai;
	}

	public int getCodAnimalMae() {
		return codAnimalMae;
	}

	public Date getDtNascAnimal() {
		return dtNascAnimal;
	}

	public void setCodAnimal(int codAnimal) {
		this.codAnimal = codAnimal;
	}

}