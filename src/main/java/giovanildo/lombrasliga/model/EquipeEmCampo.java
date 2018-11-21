package giovanildo.lombrasliga.model;
/**
 * 
 * @author giovanildo
 * Super Classe de Anfitrião e Visitante
 */

public class EquipeEmCampo {
	/**
	 * EAtleta da Equipe em Campo
	 */
	private EAtletaTorneio eAtletaTorneio;
	/**
	 * qtd gols a favor
	 */
	private int gols;
	/**
	 * qtd gols contra
	 */
	private int golscontra;
	/**
	 * resultado da partida
	 */
	private int resultado;
	/**
	 * qtd de pontos da equipe em campo
	 */
	private int pontos;
	/**
	 * 
	 * @return gols contra
	 */
	public int getGolscontra() {
		return golscontra;
	}
	/**
	 * 
	 * @param golscontra
	 */
	public void setGolscontra(int golscontra) {
		this.golscontra = golscontra;
	}

	@Override
	public String toString() {
		return eAtletaTorneio + "  " + gols + " Resultado " + resultadoString() + " Pontos " + pontos;
	}
	/**
	 * 
	 * @return String Resultado da Partida
	 */
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
	/**
	 * 
	 * @return qtd pontos
	 */
	public int getPontos() {
		return pontos;
	}
	/**
	 * em caso da equipe ganhar
	 */
	public void ganhou() {
		pontos += 3;
		resultado = VITORIA;
	}
	/**
	 * 
	 * @return int resultado da equipe na partida
	 */
	public int getResultado() {
		return resultado;
	}
	/**
	 * Em caso de empate
	 */
	public void empatou() {
		pontos++;
		resultado = EMPATE;
	}
	/**
	 * Em caso de derrota
	 */
	public void perdeu() {
		resultado = DERROTA;
	}
	/**
	 * 
	 * @return EAtletaTorneio
	 */
	public EAtletaTorneio geteAtletaTorneio() {
		return eAtletaTorneio;
	}
	/**
	 * 
	 * @param eAtletaTorneio
	 */
	public void seteAtletaTorneio(EAtletaTorneio eAtletaTorneio) {
		this.eAtletaTorneio = eAtletaTorneio;
	}
	/**
	 * 
	 * @param eAtletaTorneio
	 * @param gols
	 */
	public EquipeEmCampo(EAtletaTorneio eAtletaTorneio, int gols) {
		super();
		this.eAtletaTorneio = eAtletaTorneio;
		this.gols = gols;
	}
	/**
	 * 
	 * @return gols a favor
	 */
	public int getGols() {
		return gols;
	}
	/**
	 * 
	 * @param gols
	 */
	public void setGols(int gols) {
		this.gols = gols;
	}
	/**
	 * Constante em caso de vitória
	 */
	public static final int VITORIA = 1;
	/**
	 * Constante em caso de empate
	 */
	public static final int EMPATE = 2;
	/**
	 * Constante em caso de derrota
	 */
	public static final int DERROTA = 3;
}
