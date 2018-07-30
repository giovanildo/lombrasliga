package model;

public class Torneio {	

	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String Nome;

	public Torneio(String nome) {
		super();
		Nome = nome;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}
	

}
