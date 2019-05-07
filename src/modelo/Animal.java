package modelo;

import java.util.Date;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Animal {
	
	@SerializedName("nomeAnimal")
	private String nomeAnimal;
	@SerializedName("codEspecie")
	private Integer codEspecie;
	@SerializedName("especie")
	private String especie;
	@SerializedName("codAnimal")
	private Integer codAnimal;
	@SerializedName("codAnimalPai")
	private Integer codAnimalPai;
	@SerializedName("codAnimalMae")
	private Integer codAnimalMae;
	@SerializedName("dtNascAnimal")
	private Date dtNascAnimal;

	public Animal(String nomeAnimal, Integer codEspecie, String especie,Integer codAnimal, Integer codAnimalPai, Integer codAnimalMae, Date dtNascAnimal) {
		this.nomeAnimal = nomeAnimal;
		this.codEspecie = codEspecie;
		this.especie = especie;
		this.codAnimal = codAnimal;
		this.codAnimalPai = codAnimalPai;
		this.codAnimalMae = codAnimalMae;
		this.dtNascAnimal = dtNascAnimal;
	}

	public Animal(Integer codAnimal) {
		this.codAnimal = codAnimal;
	}

	public String getNomeAnimal() {
		return nomeAnimal;
	}

	public Integer getCodEspecie() {
		return codEspecie;
	}

	public Integer getCodAnimal() {
		return codAnimal;
	}

	public Integer getCodAnimalPai() {
		return codAnimalPai;
	}

	public Integer getCodAnimalMae() {
		return codAnimalMae;
	}

	public Date getDtNascAnimal() {
		return dtNascAnimal;
	}

	public void setCodAnimal(Integer codAnimal) {
		this.codAnimal = codAnimal;
	}

}