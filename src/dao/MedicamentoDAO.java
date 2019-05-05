package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import configuracao.conexao;
import modelo.Funcionario;
import modelo.Medicamento;

public class MedicamentoDAO {

	private conexao con;

	public MedicamentoDAO() {
		this.con = new conexao();
	}

	public boolean inserir_medicamento(Medicamento medicamento) {

		String inserir_medicamento = "insert into medicamentos (codmedicamento, nomemedicamento)"+
				"values('"+
				medicamento.getCodmedicamento()+
				"', '"+
				medicamento.getNomemedicamento()+
				"')";

		int resultado_inserir_medicamento = con.executaSQL(inserir_medicamento);
		if(resultado_inserir_medicamento > 0) {
			System.out.println("Cadastro de medicamento feito com sucesso!");
			return true;
		}else {
			System.out.println("Erro no cadastro de medicamento.");
			return false;
		}

	}

	public List<Medicamento> busca_medicamento(){
		String buscar_medicamentos = "select * from medicamentos";
		ResultSet rs_buscar_medicamentos = con.executaBusca(buscar_medicamentos);
		List<Medicamento> medicamentos = new ArrayList<>();
		try {
			while(rs_buscar_medicamentos.next()) {
				int codmedicamento = rs_buscar_medicamentos.getInt("codmedicamento");
				String nomemedicamento = rs_buscar_medicamentos.getString("nomemedicamento");	

				Medicamento medicamento = new Medicamento(codmedicamento, nomemedicamento);
				medicamentos.add(medicamento);

				System.out.println(codmedicamento+" - "+nomemedicamento);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return medicamentos;
	}

	public boolean att_medicamento(Medicamento medicamento) {
		String att_medicamento = "update medicamentos set"
				+" codmedicamento = "+medicamento.getCodmedicamento()+","
				+" nomemedicamento = "+medicamento.getNomemedicamento()+","
				+" ;";

		int resultado_att_medicamento = con.executaSQL(att_medicamento);
		if(resultado_att_medicamento > 0) {
			System.out.println("Atualizacao de medicamento feito com sucesso!");
			return true;
		}else {
			System.out.println("Erro na atualizacao de medicamento.");
			return false;
		}
	}

	public boolean delete_medicamento(Medicamento medicamento) {
		String delete_medicamento = "delete from medicamentos where"
				+" codmedicamento = "+medicamento.getCodmedicamento()+","
				+" ;";

		int resultado_delete_medicamento = con.executaSQL(delete_medicamento);
		if(resultado_delete_medicamento > 0) {
			System.out.println("Exclusao de medicamento feito com sucesso!");
			return true;
		}else {
			System.out.println("Erro na exclusao de medicamento.");
			return false;
		}
	}
	
	public Medicamento busca_medicamento_por_id(int idMedicamento) {
		String buscar_medicamentos = "select * from medicamentos where \"codmedicamento\" = "+idMedicamento+";";
		ResultSet rs_buscar_medicamentos = con.executaBusca(buscar_medicamentos);
		Medicamento medicamento = null;
		try {
			while(rs_buscar_medicamentos.next()) {
				int codmedicamento = rs_buscar_medicamentos.getInt("codmedicamento");
				String nomemedicamento = rs_buscar_medicamentos.getString("nomemedicamento");	

				medicamento = new Medicamento(codmedicamento, nomemedicamento);

				System.out.println(codmedicamento+" - "+nomemedicamento);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return medicamento;
	}


}
