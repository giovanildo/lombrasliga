package giovanildo.lombrasliga.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import giovanildo.lombrasliga.model.EAtleta;

/**
 * 
 * @author giovanildo classe que faz a comunicação com o banco de dados
 *
 */

// método para conectar
// método para adicionar registro
// método para apagar registro
// método para carregar todo o banco de dados dentro das arrayslistes

public class DAO {

	private String usuario;
	private String senha;
	private String url;

	public DAO() {
		super();
		this.usuario = "postgres";
		;
		this.senha = "labti@unilab2012";
		this.url = "jdbc:postgresql://127.0.0.1/lombras";
	}

	public boolean criarBaseDeDados(String database) {

		String url = "jdbc:postgresql://127.0.0.1/";
		String criaDatabase = "CREATE DATABASE " + database + " OWNER postgres ENCODING 'UTF-8';";

		try (Connection con = DriverManager.getConnection(url, usuario, senha)) {
			System.out.println("Tentando conexão");
			Statement stm = con.createStatement();
			System.out.println("Criando statement");
			stm.executeUpdate(criaDatabase);
			System.out.println("Base de dados criada com sucesso");
			con.close();
			stm.close();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("deu merda");

			return false;
		}

	}

	public boolean apagarBaseDeDados(String database) {

		String url = "jdbc:postgresql://127.0.0.1/";
		String criaDatabase = "DROP DATABASE " + database + ";";

		try (Connection con = DriverManager.getConnection(url, usuario, senha)) {
			System.out.println("Tentando conexão");
			Statement stm = con.createStatement();
			System.out.println("Criando statement");
			stm.executeUpdate(criaDatabase);
			System.out.println("Base de dados apagada com sucesso");
			con.close();
			stm.close();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("deu merda");

			return false;
		}

	}

	public void criarBanco() {

		String eatleta = "CREATE TABLE eatleta (id_eatleta SERIAL CONSTRAINT pk_id_eatleta PRIMARY KEY,  nome_eatleta varchar(30) UNIQUE NOT NULL);";
		String clube = "CREATE TABLE clube (id_clube SERIAL CONSTRAINT pk_id_clube PRIMARY KEY, nome_clube varchar(30) UNIQUE NOT NULL);";
		String torneio = "CREATE TABLE torneio (id_torneio SERIAL CONSTRAINT pk_id_torneio PRIMARY KEY, "
				+ " nome_torneio varchar(30) UNIQUE NOT NULL);";

		String eatletatorneio = "CREATE TABLE eatletatorneio( "
				+ "id_eatletatorneio SERIAL CONSTRAINT pk_id_eatletatorneio PRIMARY KEY, "
				+ "id_eatleta integer NOT NULL, " + "id_clube integer NOT NULL, " + "id_torneio integer NOT NULL, "
				+ "FOREIGN KEY (id_eatleta) REFERENCES eatleta (id_eatleta) ON DELETE CASCADE, "
				+ "FOREIGN KEY (id_clube) REFERENCES clube (id_clube) ON DELETE CASCADE, "
				+ "FOREIGN KEY (id_torneio) REFERENCES torneio (id_torneio) ON DELETE CASCADE);";

		String partida = "CREATE TABLE partida(" + "id_partida SERIAL CONSTRAINT pk_id_partida PRIMARY KEY, "
				+ "visitante integer not null, " + "anfitriao integer not null, " + "golsvisitante integer not null, "
				+ "golsanfitriao integer not null, " + "encerrada boolean, "
				+ "FOREIGN KEY(visitante) REFERENCES eatletatorneio(id_eatletatorneio) ON DELETE CASCADE,"
				+ "FOREIGN KEY(anfitriao) REFERENCES eatletatorneio(id_eatletatorneio) ON DELETE CASCADE);";

		String baseDeDados = "lombras";

		criarBaseDeDados(baseDeDados);

		String url = "jdbc:postgresql://127.0.0.1/" + baseDeDados;

		try (Connection con = DriverManager.getConnection(url, usuario, senha)) {
			System.out.println("Tentando conexão");
			Statement stm = con.createStatement();
			System.out.println("Criando statement");
			stm.executeUpdate(eatleta);
			stm.executeUpdate(clube);
			stm.executeUpdate(torneio);
			stm.executeUpdate(eatletatorneio);
			stm.executeUpdate(partida);
			System.out.println("tabelas criadas com sucesso");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("deu merda");
		}

	}

	/**
	 * 
	 * @param tabela
	 * @param campo
	 * @param valor
	 * @return sucesso ou fracasso
	 */
	public boolean inserir(String tabela, String campo, String valor) {
		try (Connection con = DriverManager.getConnection(url, usuario, senha)) {
			Statement stm = con.createStatement();
			String sql = "INSERT INTO " + tabela + "(" + campo + ")" + "values ('" + valor + "')";
			System.out.println(sql);
			stm.executeUpdate(sql);
			System.out.println("deu certo");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 
	 * @param tabela
	 * @param campo
	 * @param valor
	 * @return
	 */
	public boolean excluir(String tabela, String campoId, int id) {
		try (Connection con = DriverManager.getConnection(url, usuario, senha)) {
			Statement stm = con.createStatement();
			String sql = "DELETE FROM " + tabela + "WHERE " + campoId + "=" + id;
			System.out.println(sql);
			stm.executeUpdate(sql);
			System.out.println("deu certo");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<EAtleta> preencherArrays() {
		ArrayList<EAtleta> lista = new ArrayList<EAtleta>();
		String sql = "select * from eatleta";
		try (Connection con = DriverManager.getConnection(url, usuario, senha);
				PreparedStatement stm = con.prepareStatement(sql);
				ResultSet rs = stm.executeQuery()) {
			while (rs.next()) {
				EAtleta eatleta = new EAtleta(rs.getString("nome_eatleta"));
				eatleta.setId(Integer.parseInt(rs.getString("id_eatleta")));
				lista.add(eatleta);								
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}

}
