package giovanildo.lombrasliga.dao;

public class DAO {

	public void criarBanco() {
//		criar banco de dados lombras
		String sql = "CREATE DATABASE lombras OWNER postgres ENCODING 'UTF-8';";
//		tabela eatleta
//		id e nome		
		String eatleta = "CREATE TABLE eatleta (id_eatleta integer CONSTRAINT pk_id_eatleta PRIMARY KEY, "
				+ " nome_eatleta varchar(30) NOT NULL, );";
//		tabela clube
//		id e nome
		String clube = "CREATE TABLE clube (id_clube integer CONSTRAINT pk_id_clube PRIMARY KEY, "
				+ " nome_clube varchar(30) NOT NULL, );";
//		tabela torneio
//		id e nome e porquedoNome
		String torneio = "CREATE TABLE torneio (id_torneio integer CONSTRAINT pk_id_torneio PRIMARY KEY, "
				+ " nome_torneio varchar(30) NOT NULL, );";
		
//		tabela EatletaTorneio
//		id, id eatleta, id clube, id torneio
		
		String eatletatorneio = "CREATE TABLE eatletaTorneio (id_clube integer CONSTRAINT pk_id_clube PRIMARY KEY, "
				+ " nome_clube varchar(30) NOT NULL, );";
		
		
//		tabela partida
//		id
//		visitante
//		anfitriao
//		golsVisitante
//		golsAnfitriao
//		encerrada?

	}

}
