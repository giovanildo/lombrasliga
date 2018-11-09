package model;

public abstract class EquipeEmCampo {
	EAtletaTorneio eAtletaTorneio;
	int gols;
	int golscontra;
	int resultado;
	int pontos;

	public int getGolscontra() {
		return golscontra;
	}

	public void setGolscontra(int golscontra) {
		this.golscontra = golscontra;
	}

	@Override
	public String toString() {
		return eAtletaTorneio + "  " + gols + " Resultado " + resultadoString() + " Pontos " + pontos;
	}

	public String resultadoString() {
		String resultadoString = "ERRO";
		if(resultado==1) {
			resultadoString="VITÓRIA";
		} else if (resultado==2){
			resultadoString="EMPATE";
		} else if(resultado==3) {
			resultadoString="DERROTA";
		}
		return resultadoString;
	}

	public int getPontos() {
		return pontos;
	}

	public void ganhou() {
		pontos += 3;
		resultado = VITORIA;
	}

	public int getResultado() {
		return resultado;
	}
	
	public void empatou() {
		pontos++;
		resultado = EMPATE;
	}

	public void perdeu() {
		resultado = DERROTA;
	}

	public EAtletaTorneio geteAtletaTorneio() {
		return eAtletaTorneio;
	}

	public void seteAtletaTorneio(EAtletaTorneio eAtletaTorneio) {
		this.eAtletaTorneio = eAtletaTorneio;
	}

	public EquipeEmCampo(EAtletaTorneio eAtletaTorneio) {
		super();
		this.eAtletaTorneio = eAtletaTorneio;
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
