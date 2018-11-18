package estudos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Incluir {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://127.0.0.1/xti";
		String sql = "insert into pessoa values(3, 'Caio','M','caio@xti.com.br')";
		String usuario = "postgres";
		String senha = "labti@unilab2012";
		try (Connection con = DriverManager.getConnection(url, usuario, senha);
				PreparedStatement stm = con.prepareStatement(sql);)
				{
					stm.executeUpdate();
					System.out.println("deu certo");
			
		} catch (Exception e) {
			System.out.println("deu certo n�o");
			
			// TODO: handle exception
		}
		
		
	}

}
