package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import configuracao.conexao;
import modelo.Funcionario;

public class FuncionarioDAO {
	private conexao con;

	public FuncionarioDAO() {
		this.con = new conexao();
	}

	public boolean inserir_funcionario(Funcionario funcionario) {
		String inserir_funcionario = "insert into funcionarios (matricula, nome, endereco, email, crmv, especialidade)"+
				"values('"+
				funcionario.getMatricula()+
				"', '"+
				funcionario.getNome()+
				"', '"+
				funcionario.getEndereco()+
				"', '"+
				funcionario.getEmail()+
				"', '"+
				funcionario.getCrmv()+
				"', '"+
				funcionario.getEspecialidade()+
				"')";

		int resultado_inserir_funcionario = con.executaSQL(inserir_funcionario);
		if(resultado_inserir_funcionario > 0) {
			System.out.println("Cadastro de funcionario feito com sucesso!");
			return true;
		}else {
			System.out.println("Erro no cadastro de funcionario.");
			return false;
		}
	}

	public List<Funcionario> busca_funcionario(){
		String buscar_funcionarios = "select * from funcionarios;";
		ResultSet rs_buscar_funcionarios = con.executaBusca(buscar_funcionarios);
		List<Funcionario> funcionarios = new ArrayList<>();

		try {
			while(rs_buscar_funcionarios.next()) {
				int matricula = rs_buscar_funcionarios.getInt("matricula");
				String nome = rs_buscar_funcionarios.getString("nome");
				String endereco = rs_buscar_funcionarios.getString("endereco");
				String email = rs_buscar_funcionarios.getString("email");
				int crmv = rs_buscar_funcionarios.getInt("crmv");
				String especialidade = rs_buscar_funcionarios.getString("especialidade");		

				Funcionario funcionario = new Funcionario(matricula, nome, endereco, email, crmv, especialidade);
				funcionarios.add(funcionario);

				System.out.println(matricula+" - "+nome+" - "+endereco+" - "+email+" - "+crmv+" - "+especialidade);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return funcionarios;
	}

	public boolean att_funcionario(Funcionario funcionario) {
		String att_funcionario = "update funcionarios set"
				+" matricula = "+funcionario.getMatricula()+","
				+" nome = "+funcionario.getNome()+","
				+" endereco = "+funcionario.getEndereco()+","
				+" email = "+funcionario.getEmail()+","
				+" crmv = "+funcionario.getCrmv()+","
				+" especialidade = "+funcionario.getEspecialidade()+","
				+" ;";

		int resultado_att_funcionario = con.executaSQL(att_funcionario);
		if(resultado_att_funcionario > 0) {
			System.out.println("Atualizacao de funcionario feito com sucesso!");
			return true;
		}else {
			System.out.println("Erro na atualizacao de funcionario.");
			return false;
		}
	}

	public boolean delete_funcionario(Funcionario funcionario) {
		String delete_funcionario = "delete from funcionarios where"
				+" matricula = "+funcionario.getMatricula()+","
				+" ;";

		int resultado_delete_funcionario = con.executaSQL(delete_funcionario);
		if(resultado_delete_funcionario > 0) {
			System.out.println("Exclusao de funcionario feito com sucesso!");
			return true;
		}else {
			System.out.println("Erro na exclusao de funcionario.");
			return false;
		}
	}

}
