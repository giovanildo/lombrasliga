package giovanildo.lombrasliga.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 
 * @author giovanildo
 * classe que faz a comunicação com o banco de dados
 *
 */

	//método para conectar
	//método para adicionar registro
	//método para apagar registro
	//método para carregar todo o banco de dados dentro das arrayslistes

public class DAO {
	
	public void conectar() 
	{
		String url = "jdbc:postgresql://127.0.0.1/";
		//String clube = "CREATE TABLE clube (id_clube integer CONSTRAINT pk_id_clube PRIMARY KEY, nome_clube varchar(30) NOT NULL, );";
		//String sql = "select * from eatleta";
		String usuario = "postgres";
		String senha = "labti@unilab2012";
	
	}
	
	public void criarBanco() {
//		criar banco de dados lombras
//		String sql = "CREATE DATABASE lombras OWNER postgres ENCODING 'UTF-8';";
//		tabela eatleta
//		id e nome		
		String eatleta = "CREATE TABLE eatleta (id_eatleta integer CONSTRAINT pk_id_eatleta PRIMARY KEY,  nome_eatleta varchar(30) NOT NULL);";
//		tabela clube
//		id e nome
		String clube = "CREATE TABLE clube (id_clube integer CONSTRAINT pk_id_clube PRIMARY KEY, nome_clube varchar(30) NOT NULL, );";
//		tabela torneio
//		id e nome e porquedoNome
		String torneio = "CREATE TABLE torneio (id_torneio integer CONSTRAINT pk_id_torneio PRIMARY KEY, "
				+ " nome_torneio varchar(30) NOT NULL, );";

//		tabela EatletaTorneio
//		id, id eatleta, id clube, id torneio

		String eatletatorneio = "CREATE TABLE eatletatorneio( "
				+ "id_eatletatorneio integer CONSTRAINT pk_id_eatletatorneio PRIMARY KEY, "
				+ "id_eatleta integer NOT NULL, " + "id_clube integer NOT NULL, " + "id_torneio integer NOT NULL, "
				+ "FOREIGN KEY (id_eatleta) REFERENCES eatleta (id_eatleta) ON DELETE CASCADE, "
				+ "FOREIGN KEY (id_clube) REFERENCES clube (id_clube) ON DELETE CASCADE, "
				+ "FOREIGN KEY (id_torneio) REFERENCES torneio (id_torneio) ON DELETE CASCADE);";

//		tabela partida
//		id
//		visitante
//		anfitriao
//		golsVisitante
//		golsAnfitriao
//		encerrada?

		String partida = "CREATE TABLE partida(" + "id_partida integer CONSTRAINT pk_id_partida PRIMARY KEY, "
				+ "visitante integer not null, " + "anfitriao integer not null, " + "golsvisitante integer not null"
				+ "golsanfitriao integer not null" + "encerrada boolean"
				+ "FOREIGN KEY(visitante) REFERENCES eatletatorneio(id_eatletatorneio) ON DELETE CASCADE,"
				+ "FOREIGN KEY(anfitriao) REFERENCES eatletatorneio(id_eatletatorneio) ON DELETE CASCADE);";

	}

}
