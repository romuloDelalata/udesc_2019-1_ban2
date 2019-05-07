package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import configuracao.conexao;
import helpers.DateSqlHelper;
import modelo.Consulta;
import modelo.Medicamento;

public class ConsultaDAO {
	private conexao con;

	public ConsultaDAO() {
		this.con = new conexao();
	}

	public int inserir_consulta(Consulta consulta) throws SQLException {
		int codConsulta = 0;
		
		ResultSet rs = con.executaBusca("select max(codconsulta)+1 as novaconsulta from consultas");
		
		con = new conexao();
		
		while (rs.next()) {
			codConsulta = rs.getInt("novaconsulta");
		}
		
		String inserir_consulta = "insert into consultas (codanimal, matricula, data, diagnosticoconsulta, codconsulta)"+
				"values('"+
				consulta.getCodanimal()+
				"', '"+
				consulta.getMatricula()+
				"', '"+
				DateSqlHelper.toDateSql(consulta.getDataConsulta())+
				"', '"+
				consulta.getDiagnosticoconsulta()+
				"', "+codConsulta+" )";

		System.out.println(inserir_consulta);
		int resultado_inserir_consulta = con.executaSQL(inserir_consulta);
		if(resultado_inserir_consulta > 0) {
			System.out.println("Cadastro de consulta feito com sucesso!");
			return codConsulta;
		}else {
			System.out.println("Erro no cadastro de consulta.");
			return 0;
		}
	}

	public List<Consulta> busca_consulta(){
		String buscar_consultas = "select" + 
				"		c.codconsulta," +
				"		c.codanimal," + 
				"		a.\"nomeAnimal\"," + 
				"		c.matricula," + 
				"		f.nome," + 
				"		c.data," + 
				"		c.diagnosticoconsulta," + 
				"		m.codmedicamento," + 
				"		m.nomemedicamento," +
				"		c.diagnosticoconsulta" +
				"	from consultas c" + 
				"	inner join animais a" + 
				"		on a.\"codAnimal\" = c.codanimal" + 
				"	inner join funcionarios f\r\n" + 
				"		on f.matricula = c.matricula" + 
				"	inner join prescricao p" + 
				"		on p.codconsulta = c.codconsulta" + 
				"	inner join medicamentos m" + 
				"		on m.codmedicamento = p.codmedicamento";
		
		System.out.println(buscar_consultas);
		ResultSet rs_buscar_consultas = con.executaBusca(buscar_consultas);
		List<Consulta> consultas = new ArrayList<>();
		Consulta consulta = null;
		try {
			while(rs_buscar_consultas.next()) {
				int codconsulta = rs_buscar_consultas.getInt("codconsulta");						

				if( consulta == null || consulta.getCodconsulta() != codconsulta ) {
					
					int codanimal = rs_buscar_consultas.getInt("codanimal");
					String nomeanimal = rs_buscar_consultas.getString("nomeanimal");
					int matricula = rs_buscar_consultas.getInt("matricula");
					String nomefuncionario = rs_buscar_consultas.getString("nome");
					Date data = DateSqlHelper.toDate(rs_buscar_consultas.getDate("data"));
					String diagnosticoconsulta = rs_buscar_consultas.getString("diagnosticoconsulta");
					
					consulta = new Consulta(codanimal, nomeanimal, matricula, nomefuncionario, data, diagnosticoconsulta, codconsulta);
					consultas.add(consulta);
					System.out.println(codanimal+" - "+matricula+" - "+DateSqlHelper.toDateSql(data)+" - "+diagnosticoconsulta+" - "+codconsulta);
					
				}
				int codmedicamento = rs_buscar_consultas.getInt("codmedicamento");
				String nomemedicamento = rs_buscar_consultas.getString("nomemedicamento");
				Medicamento medicamento = new Medicamento(codmedicamento, nomemedicamento);
				consulta.addMedicamento(medicamento);
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
				+" diagnosticoconsulta = "+consulta.getDiagnosticoconsulta()
				+" where codconsulta = "+consulta.getCodconsulta()
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
				+" codconsulta = "+consulta.getCodconsulta()
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
