package main;

import java.util.Date;

import com.google.gson.Gson;

import modelo.Consulta;
import modelo.Medicamento;

/*
import dao.PrescricaoDAO;
import modelo.Prescricao;
*/

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("Olá! Bem-vindo ser humano! \n");
		System.out.println("Esta é uma aplicação para gerenciamento de um zoológico. \n\n\n");
		System.out.println("O que você deseja fazer? \n");
		
		Consulta consulta = null;
				//new Consulta(10,15,new Date(),"diagnostico",5);
		
		Medicamento medicamento = new Medicamento();
		medicamento.setCodMedicamento(12);
		
		consulta.addMedicamento(medicamento);
		
		String string = new Gson().toJson(consulta);
		
		System.out.println(string);
		
		
		String json = "{\"codanimal\":10,\"matricula\":15,\"data\":\"May 6, 2019 1:25:58 AM\",\"diagnosticoconsulta\":\"diagnostico\",\"medicamentos\":[{\"codmedicamento\":12}],\"codconsulta\":5}\r\n";
		
		Consulta consulta2 = new Gson().fromJson(json, Consulta.class);
		System.out.println(new Gson().toJson(consulta2));
		
		/*
		buscar prescrição
		PrescricaoDAO dao = new PrescricaoDAO();
		List<Prescricao> busca_prescricao = dao.busca_prescricao();
		*/
		
	}

}
