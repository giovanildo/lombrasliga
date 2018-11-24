package giovanildo.lombrasliga.dao;

public class DAO {
	
	
	public void criarBanco() {
//		criar banco de dados lombras
		String sql = "CREATE DATABASE lombras OWNER postgres ENCODING 'UTF-8';"
				+ "CREATE TABLE [IF NOT EXISTS] EAtleta (\r\n" + 
				"  id int [COLLATE colação] constraint,\r\n" + 
				"  nome_coluna tipo_dados constraint,\r\n" + 
				"  nome_coluna tipo_dados constraint,\r\n" + 
				"  ...,\r\n" + 
				"[FOREIGN KEY chave_estrangeira REFERENCES coluna]\r\n" + 
				"[ON DELETE ação ] [ ON UPDATE ação ]\r\n" + 
				");"
				+ ""
				+ "";
//		tabela eatleta
		
//		id e nome
//		tabela clube
//		id e nome
//		tabela torneio
//		id e nome e porquedoNome
//		tabela EatletaTorneio
//		id, id eatleta, id clube, id torneio
//
//		tabela partida
//		id
//		visitante
//		anfitriao
//		golsVisitante
//		golsAnfitriao
//		encerrada?
		
		
	}

}
