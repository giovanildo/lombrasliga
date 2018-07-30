package model;

public abstract class EquipeEmCampo {
	EAtletaTorneio eAtletaTorneio;
	int gols;
	int resultado;
	int pontos;
	int golscontra;
	
	public int getGolscontra() {
		return golscontra;
	}
	public void setGolscontra(int golscontra) {
		this.golscontra = golscontra;
	}
	public int getResultado() {
		return resultado;
	}
	public int getPontos() {
		return pontos;
	}
	public void ganhou() {
		pontos+=3;
		resultado=VITORIA;		
	}
	public void empatou() {
		pontos++;
		resultado=EMPATE;
	}
	public void perdeu() {
		pontos-=3;
		resultado=DERROTA;
	}

	public EAtletaTorneio geteAtletaTorneio() {
		return eAtletaTorneio;
	}
	public void seteAtletaTorneio(EAtletaTorneio eAtletaTorneio) {
		this.eAtletaTorneio = eAtletaTorneio;
	}
	public EquipeEmCampo(EAtletaTorneio eAtletaTorneio, int gols) {
		super();
		this.eAtletaTorneio = eAtletaTorneio;
		this.gols = gols;
	}
	public int getGols() {
		return gols;
	}
	public void setGols(int gols) {
		this.gols = gols;
	}
	
	public static final int VITORIA = 1;
	public static final int EMPATE = 2;
	public static final int DERROTA = 3;
}
