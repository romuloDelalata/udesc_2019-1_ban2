package configuracao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class conexao {
	private String url;
	private String usuario;
	private String senha;
	private Connection con;
	
	public conexao(){
		url = "jdbc:postgresql://localhost:5432/zoo_normalizado";
		usuario = "postgres";
		senha = "";
		
		try {	
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conexão realizada com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
	
	public int executaSQL(String sql) {
		try {
			Statement stm = con.createStatement();
			int resultado = stm.executeUpdate(sql);
			con.close();
			return resultado;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}
	
	public Statement createStatement() throws SQLException {
		return con.createStatement();
	}
	
	public ResultSet executaBusca(String sql) {
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			con.close();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void close() throws SQLException {
		con.close();
	}
	
}
