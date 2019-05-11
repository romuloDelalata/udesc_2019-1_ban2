package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import configuracao.conexao;
import modelo.Consulta;
import modelo.Medicamento;
import modelo.Prescricao;

public class PrescricaoDAO {
	private conexao con;

	public PrescricaoDAO() {
		this.con = new conexao();
	}

	public List<Prescricao> busca_prescricao(){
		String buscar_prescricoes = "select c.codconsulta, c.diagnosticoconsulta, m.nomemedicamento from prescricao p inner join consultas c on p.codconsulta = c.codconsulta inner join medicamentos m on p.codmedicamento = m.codmedicamento order by c.codconsulta asc";
		ResultSet rs_buscar_prescricoes = con.executaBusca(buscar_prescricoes);
		List<Prescricao> prescricoes = new ArrayList<>();

		try {
			while(rs_buscar_prescricoes.next()) {
				int codconsulta = rs_buscar_prescricoes.getInt("codconsulta");
				String diagnosticoconsulta = rs_buscar_prescricoes.getString("diagnosticoconsulta");
				String nomemedicamento = rs_buscar_prescricoes.getString("nomemedicamento");


				Prescricao prescricao = new Prescricao(codconsulta, diagnosticoconsulta, nomemedicamento);
				prescricoes.add(prescricao);

				System.out.println(codconsulta+" - "+diagnosticoconsulta+" - "+nomemedicamento);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prescricoes;
	}

	public boolean deletar_prescricoes(Integer codconsulta) {
		String delete_prescricao = "delete from prescricao where codconsulta = "+codconsulta+";";
		System.out.println(delete_prescricao);
		int resultado_delete_funcionario = con.executaSQL(delete_prescricao);
		if(resultado_delete_funcionario > 0) {
			System.out.println("Exclusao de prescricao feito com sucesso!");
			return true;
		}else {
			System.out.println("Erro na exclusao de prescricoes.");
			return false;
		}
	}
	
	@SuppressWarnings("finally")
	public boolean inserir_prescricao(int codconsulta, List<Medicamento> medicamentos) {
		boolean retorno = false;
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			for (Medicamento medicamento : medicamentos) {
				String inserir_prescricao = "insert into prescricao (codconsulta, codmedicamento)"+
						"values("+
						codconsulta+
						", "+
						medicamento.getCodmedicamento()+
						")";
				stmt.addBatch(inserir_prescricao);
				System.out.println(inserir_prescricao);
			}
			int[] registrosCriados = stmt.executeBatch();

			if(registrosCriados.length == medicamentos.size()) {
				System.out.println("Prescricoes inseridas com sucesso!");
				retorno = true;
			}else {
				System.out.println("Erro no cadastro de prescricoes.");
				retorno = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if ( stmt != null ) {				
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if ( con != null ) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return retorno;
		}
	}
}