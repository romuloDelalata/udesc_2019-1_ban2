package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import configuracao.conexao;
import helpers.DateSqlHelper;
import modelo.Animal;

public class AnimalDAO {
	private conexao con;

	public AnimalDAO() {
		this.con = new conexao();
	}

	public boolean inserir_animal(Animal animal) {
		String inserir_animal = "insert into animais (nomeAnimal, codEspecie, codAnimal, codAnimalPai, codAnimalMae, dtNascAnimal)"+
				"values('"+
				animal.getNomeAnimal()+
				"', '"+
				animal.getCodEspecie()+
				"', '"+
				"(select max(\"codAnimal\"+1) from animais)"+
				"', '"+
				animal.getCodAnimalPai()+
				"', '"+
				animal.getCodAnimalMae()+
				"', '"+
				DateSqlHelper.toDateSql(animal.getDtNascAnimal())+
				"')";

		int resultado_inserir_animal = con.executaSQL(inserir_animal);
		if(resultado_inserir_animal > 0) {
			System.out.println("Cadastro de animal feito com sucesso!");
			return true;
		}else {
			System.out.println("Erro no cadastro de animal.");
			return false;
		}
	}

	public List<Animal> busca_animal(){
		String buscar_animais = "select * from animais a inner join especies e on a.\"codEspecie\" = e.codespecie;";
		ResultSet rs_buscar_animais = con.executaBusca(buscar_animais);
		List<Animal> animais = new ArrayList<>();

		try {
			while(rs_buscar_animais.next()) {
				String nomeAnimal = rs_buscar_animais.getString("nomeAnimal");
				int codEspecie = rs_buscar_animais.getInt("codEspecie");
				String especie = rs_buscar_animais.getString("nomeespecie");
				int codAnimal = rs_buscar_animais.getInt("codAnimal");	
				int codAnimalPai = rs_buscar_animais.getInt("codAnimalPai");	
				int codAnimalMae = rs_buscar_animais.getInt("codAnimalMae");	
				Date dtNascAnimal = DateSqlHelper.toDate(rs_buscar_animais.getDate("dtNascAnimal"));

				Animal animal = new Animal(nomeAnimal, codEspecie, especie,codAnimal, codAnimalPai, codAnimalMae, dtNascAnimal);
				animais.add(animal);

				System.out.println(nomeAnimal+" - "+codEspecie+" - "+codAnimal+" - "+codAnimalPai+" - "+codAnimalMae+" - "+DateSqlHelper.toDateSql(dtNascAnimal));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return animais;
	}

	public boolean att_animal(Animal animal) {
		String att_animal = "update animais set"
				+" nomeAnimal = "+animal.getNomeAnimal()+","
				+" codEspecie = "+animal.getCodEspecie()+","
				+" codAnimalPai = "+animal.getCodAnimalPai()+","
				+" AnimalMae = "+animal.getCodAnimalMae()+","
				+" dtNascAnimal = "+DateSqlHelper.toDateSql(animal.getDtNascAnimal())+","
				+" where codAnimal = "+animal.getCodAnimal()+";";

		int resultado_att_animal = con.executaSQL(att_animal);
		if(resultado_att_animal > 0) {
			System.out.println("Atualizacao de animal feito com sucesso!");
			return true;
		}else {
			System.out.println("Erro na atualizacao de animal.");
			return false;
		}
	}
	
	public boolean delete_animal(Animal animal) {
		String delete_animal = "delete from animais where"
				+" \"codAnimal\" = "+animal.getCodAnimal()
				+" ;";

		int resultado_delete_animal = con.executaSQL(delete_animal);
		if(resultado_delete_animal > 0) {
			System.out.println("Exclusao de animal feito com sucesso!");
			return true;
		}else {
			System.out.println("Erro na exclusao de animal.");
			return false;
		}
	}

	public Animal busca_animal_por_id(int idAnimal) {
		String buscar_animais = "select * from animais a inner join especies e on a.\"codEspecie\" = e.codespecie where \"codAnimal\" = "+idAnimal+";";
		ResultSet rs_buscar_animais = con.executaBusca(buscar_animais);
		Animal animal = null;
		try {
			while(rs_buscar_animais.next()) {
				String nomeAnimal = rs_buscar_animais.getString("nomeAnimal");
				int codEspecie = rs_buscar_animais.getInt("codEspecie");
				String especie = rs_buscar_animais.getString("nomeespecie");
				int codAnimal = rs_buscar_animais.getInt("codAnimal");	
				int codAnimalPai = rs_buscar_animais.getInt("codAnimalPai");	
				int codAnimalMae = rs_buscar_animais.getInt("codAnimalMae");	
				Date dtNascAnimal = DateSqlHelper.toDate(rs_buscar_animais.getDate("dtNascAnimal"));

				animal = new Animal(nomeAnimal, codEspecie, especie, codAnimal, codAnimalPai, codAnimalMae, dtNascAnimal);

				System.out.println(nomeAnimal+" - "+codEspecie+" - "+codAnimal+" - "+codAnimalPai+" - "+codAnimalMae+" - "+DateSqlHelper.toDateSql(dtNascAnimal));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return animal;
	}
}