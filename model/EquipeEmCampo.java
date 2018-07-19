package model;

public abstract class EquipeEmCampo {
	EAtletaTorneio eAtletaTorneio;
	int gols;
	public EAtletaTorneio geteAtletaTorneio() {
		return eAtletaTorneio;
	}
	public void seteAtletaTorneio(EAtletaTorneio eAtletaTorneio) {
		this.eAtletaTorneio = eAtletaTorneio;
	}
	public int getGols() {
		return gols;
	}
	public void setGols(int gols) {
		this.gols = gols;
	}
}
