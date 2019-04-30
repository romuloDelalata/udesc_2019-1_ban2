package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import configuracao.conexao;
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
}