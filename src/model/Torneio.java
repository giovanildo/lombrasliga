package main;

public class Torneio {
	public Torneio(String nomeTorneio) {
		super();
		NomeTorneio = nomeTorneio;
	}
	private String NomeTorneio;
	public String getNomeTorneio() {
		return NomeTorneio;
	}
	public void setNomeTorneio(String nomeTorneio) {
		NomeTorneio = nomeTorneio;
	}
	@Override
	public String toString() {
		return "Torneio [NomeTorneio=" + NomeTorneio + "]";
	}

}
