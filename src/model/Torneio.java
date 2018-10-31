package model;

public class Torneio {
	/**
	 * id do torneio
	 */
	private int id;
	/**
	 * nome do torneio
	 */
	private String nome;
	/**
	 * Explicação do nome
	 */
	private String porqueDoNome;
	/**
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	public String getPorqueDoNome() {
		return porqueDoNome;
	}

	public void setPorqueDoNome(String porqueDoNome) {
		this.porqueDoNome = porqueDoNome;
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
	public Torneio(String nome, String porqueDoNome) {
		super();
		this.nome = nome;
		this.porqueDoNome = porqueDoNome;
	}

	@Override
	public String toString() {
		return nome;
	}

	/**
	 * 
	 * @return nome do torneio
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * @param nome
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
}