package main;

public class Clube {
	private String nome;
	//private int qtdCampeonatos;
	@Override
	public String toString() {
		return "Clube [nome=" + nome + "]";
	}
	public Clube(String nome) {
		super();
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

}
