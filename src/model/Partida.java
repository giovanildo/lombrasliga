package model;
/**
 * 
 * @author giovanildo
 *classe que configura as partidas
 */
public class Partida {
	/**
	 * clube que joga em casa
	 */
	private EAtletaTorneio anfitriao;
	/**
	 * clube que joga fora
	 */
	private EAtletaTorneio visitante;	
	 /**
	  * @return o anfitrião da partida
	 */
	public EAtletaTorneio getAnfitriao() {
		return anfitriao;
	}
	/**
	 * 
	 * @param anfitriao
	 */
	public void setAnfitriao(EAtletaTorneio anfitriao) {
		this.anfitriao = anfitriao;
	}
	/**
	 * 
	 * @return a equipe que joga fora de casa
	 */
	public EAtletaTorneio getVisitante() {
		return visitante;
	}
	/**
	 * 
	 * @param visitante
	 */
	public void setVisitante(EAtletaTorneio visitante) {
		this.visitante = visitante;
	}	
	
}