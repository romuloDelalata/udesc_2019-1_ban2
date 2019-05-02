package modelo;

import com.google.gson.annotations.SerializedName;

public class Funcionario {
	@SerializedName("matricula")
	private int matricula;
	@SerializedName("nome")
	private String nome;
	@SerializedName("endereco")
	private String endereco;
	@SerializedName("email")
	private String email;
	@SerializedName("crmv")
	private int crmv;
	@SerializedName("especialidade")
	private String especialidade;

	public Funcionario(int matricula, String nome, String endereco, String email, int crmv, String especialidade) {
		this.matricula = matricula;
		this.nome = nome;
		this.endereco = endereco;
		this.email = email;
		this.crmv = crmv;
		this.especialidade = especialidade;
	}
	
	public Funcionario(int matricula) {
		this.matricula = matricula;
	}

	public int getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getEmail() {
		return email;
	}

	public int getCrmv() {
		return crmv;
	}

	public String getEspecialidade() {
		return especialidade;
	}
	
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

}