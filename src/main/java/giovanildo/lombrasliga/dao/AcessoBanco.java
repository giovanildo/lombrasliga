package giovanildo.lombrasliga.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AcessoBanco {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://127.0.0.1/xti";
		String sql = "select * from pessoa";
		String usuario = "postgres";
		String senha = "labti@unilab2012";
		try (Connection con = DriverManager.getConnection(url, usuario, senha);
				PreparedStatement stm = con.prepareStatement(sql);
				ResultSet rs = stm.executeQuery()) {
			while (rs.next()) {
				System.out.println(rs.getString("nome") + " " + rs.getString("email"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
