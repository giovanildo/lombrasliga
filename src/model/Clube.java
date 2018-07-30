package model;
/**
 * 
 * @author giovanildo
 *
 *Essa classe grava informações referente ao Clube de Futebol
 */
public class Clube {
	private int id;
	/**
	 * nome do clube
	 */
	private String nome;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Clube(String nome) {
		super();
		this.nome = nome;
	}
	/**
	 * 
	 * @return String nome
	 */
	public String getNome() {
		return nome;
	}
/**
 * 
 * @param nome
 * permite colocar o nome do clube
 */
	public void setNome(String nome) {
		this.nome = nome;
	}	
}
