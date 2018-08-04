package model;

public class Torneio {	
	/**
	 * id do torneio
	 */
	private int id;
	/**
	 * nome do torneio
	 */
	private String Nome;
	/**
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @param nome torneio
	 */
	public Torneio(String nome) {
		super();
		Nome = nome;
	}
	/**
	 * 
	 * @return nome do torneio
	 */
	public String getNome() {
		return Nome;
	}
	/**
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		Nome = nome;
	}
}