package giovanildo.lombrasliga.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AIncluirBD {

	public static void main(String[] args) {
		String url = "jdbc:postgresql://127.0.0.1/xti";
		String sql = "insert into pessoa values(?, ?,?,?)";
		String usuario = "postgres";
		String senha = "labti@unilab2012";
		String[] pessoas = { "Giovanildo", "David", "Jefferson", "Aragão", "Lenilson" };
		try (Connection con = DriverManager.getConnection(url, usuario, senha);) {
			try (PreparedStatement stm = con.prepareStatement(sql);) {
				for (int i = 0; i < pessoas.length; i++) {
					stm.setInt(1, i);
					stm.setString(2, pessoas[i]);
					stm.setString(3, "M");
					stm.setString(4, pessoas[i].toLowerCase() + "@email.com");
					stm.addBatch();
				}

				stm.executeBatch();
				System.out.println("deu certo");
			} catch (SQLException e) {
				sql = "select nome, email from pessoa";

				try (PreparedStatement stm2 = con.prepareStatement(sql); ResultSet rs = stm2.executeQuery();) {
					while (rs.next()) {
						System.out.println(rs.getString("nome") + "  " + rs.getString("email"));
					}

				} catch (Exception e2) {
					// TODO: handle exception
				}

			}

		} catch (Exception e) {
			System.out.println("deu certo n�o");

			// TODO: handle exception
		}

	}

}
