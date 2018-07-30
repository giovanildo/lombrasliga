package model;
/**
 * 
 * @author giovanildo
 *classe grava informações do jogador de videogame
 */
public class EAtleta {
	private int id;
	/**
	 * Nome do Jogador de Vídeo Game
	 */
	private String nome;
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
/**
 * 
 * @return nome do tipo String
 */
	public String getNome() {
		return nome;
	}
public EAtleta(String nome) {
	super();
	this.nome = nome;
}
/**
 * 
 * @param nome
 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
