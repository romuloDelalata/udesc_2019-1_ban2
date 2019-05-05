package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import configuracao.conexao;
import modelo.Especie;

public class EspecieDAO {
	private conexao con;

	public EspecieDAO() {
		this.con = new conexao();
	}

	public boolean inserir_especie(Especie especie) {
		String inserir_especie = "insert into especies (codEspecie, nomeespecie, expectativaespecie)"+
				"values("+
				"(select max(codEspecie)+1 from especies)"+
				", '"+
				especie.getNomeespecie()+
				"', '"+
				especie.getExpectativaespecie()+
				"')";

		System.out.println(inserir_especie);
		int resultado_inserir_especie = con.executaSQL(inserir_especie);
		if(resultado_inserir_especie > 0) {
			System.out.println("Cadastro de especie feito com sucesso!");
			return true;
		}else {
			System.out.println("Erro no cadastro de especie.");
			return false;
		}
	}

	public List<Especie> busca_especie(){
		String buscar_especies = "select * from especies";
		ResultSet rs_buscar_especies = con.executaBusca(buscar_especies);
		List<Especie> especies = new ArrayList<>();

		try {
			while(rs_buscar_especies.next()) {
				int codEspecie = rs_buscar_especies.getInt("codEspecie");
				String nomeespecie = rs_buscar_especies.getString("nomeespecie");
				String expectativaespecie = rs_buscar_especies.getString("expectativaespecie");

				Especie especie = new Especie(codEspecie, nomeespecie, expectativaespecie);
				especies.add(especie);

				System.out.println(codEspecie+" - "+nomeespecie+" - "+expectativaespecie);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return especies;
	}

	public boolean att_especie(Especie especie) {
		String att_especie = "update especies set"
				+" nomeespecie = '"+especie.getNomeespecie()+"',"
				+" expectativaespecie = "+especie.getExpectativaespecie()
				+" where codespecie = "+especie.getCodespecie()+";";
		System.out.println(att_especie);
		int resultado_att_especie = con.executaSQL(att_especie);
		if(resultado_att_especie > 0) {
			System.out.println("Atualizacao de especie feito com sucesso!");
			return true;
		}else {
			System.out.println("Erro na atualizacao de especie.");
			return false;
		}
	}

	public boolean delete_especie(Especie especie) {
		String delete_especie = "delete from especies where"
				+" codEspecie = "+especie.getCodespecie()
				+" ;";

		int resultado_delete_especie = con.executaSQL(delete_especie);
		if(resultado_delete_especie > 0) {
			System.out.println("Exclusao de especie feito com sucesso!");
			return true;
		}else {
			System.out.println("Erro na exclusao de especie.");
			return false;
		}
	}

}