package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import configuracao.conexao;
import helpers.DateSqlHelper;
import modelo.Consulta;

public class ConsultaDAO {
	private conexao con;

	public ConsultaDAO() {
		this.con = new conexao();
	}

	public boolean inserir_consulta(Consulta consulta) {
		String inserir_consulta = "insert into consultas (codanimal, matricula, data, diagnosticoconsulta, codconsulta)"+
				"values('"+
				consulta.getCodanimal()+
				"', '"+
				consulta.getMatricula()+
				"', '"+
				DateSqlHelper.toDateSql(consulta.getDataConsulta())+
				"', '"+
				consulta.getDiagnosticoconsulta()+
				"', '"+
				consulta.getCodconsulta()+
				"')";

		int resultado_inserir_consulta = con.executaSQL(inserir_consulta);
		if(resultado_inserir_consulta > 0) {
			System.out.println("Cadastro de consulta feito com sucesso!");
			return true;
		}else {
			System.out.println("Erro no cadastro de consulta.");
			return false;
		}
	}

	public List<Consulta> busca_consulta(){
		String buscar_consultas = "select * from consultas";
		ResultSet rs_buscar_consultas = con.executaBusca(buscar_consultas);
		List<Consulta> consultas = new ArrayList<>();

		try {
			while(rs_buscar_consultas.next()) {
				int codanimal = rs_buscar_consultas.getInt("codanimal");
				int matricula = rs_buscar_consultas.getInt("matricula");
				Date data = DateSqlHelper.toDate(rs_buscar_consultas.getDate("data"));
				String diagnosticoconsulta = rs_buscar_consultas.getString("diagnosticoconsulta");
				int codconsulta = rs_buscar_consultas.getInt("codconsulta");						
				
				Consulta consulta = new Consulta(codanimal, matricula, data, diagnosticoconsulta, codconsulta);
				consultas.add(consulta);

				System.out.println(codanimal+" - "+matricula+" - "+DateSqlHelper.toDateSql(data)+" - "+diagnosticoconsulta+" - "+codconsulta);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return consultas;
	}
	
	public boolean att_consulta(Consulta consulta) {
		String att_consulta = "update consultas set"
				+" codanimal = "+consulta.getCodanimal()+","
				+" matricula = "+consulta.getMatricula()+","
				+" data = "+DateSqlHelper.toDateSql(consulta.getDataConsulta())+","
				+" diagnosticoconsulta = "+consulta.getDiagnosticoconsulta()+","
				+" codconsulta = "+consulta.getCodconsulta()+","
				+" ;";

		int resultado_att_consulta = con.executaSQL(att_consulta);
		if(resultado_att_consulta > 0) {
			System.out.println("Atualizacao de consulta feito com sucesso!");
			return true;
		}else {
			System.out.println("Erro na atualizacao de consulta.");
			return false;
		}
	}
	
	public boolean delete_consulta(Consulta consulta) {
		String delete_consulta = "delete from consultas where"
				+" codconsulta = "+consulta.getCodconsulta()+","
				+" ;";

		int resultado_delete_consulta = con.executaSQL(delete_consulta);
		if(resultado_delete_consulta > 0) {
			System.out.println("Exclusao de consulta feito com sucesso!");
			return true;
		}else {
			System.out.println("Erro na exclusao de consulta.");
			return false;
		}
	}
	
}
