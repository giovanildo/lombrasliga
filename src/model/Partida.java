package model;
/**
 * 
 * @author giovanildo
 *classe que configura as partidas
 */
public class Partida {
	public Partida(Anfitriao anfitriao, Visitante visitante) {
		super();
		this.anfitriao = anfitriao;
		this.visitante = visitante;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	private int id;
	/**
	 * clube que joga em casa
	 */
	private Anfitriao anfitriao;
	/**
	 * clube que joga fora
	 */
	private Visitante visitante;	
	 /**
	  * @return o anfitrião da partida
	 */
	
	public Anfitriao getAnfitriao() {
		return anfitriao;
		
	}
	/**
	 * 
	 * @param anfitriao
	 */
	public void setAnfitriao(Anfitriao anfitriao) {
		this.anfitriao = anfitriao;
	}
	/**
	 * 
	 * @return a equipe que joga fora de casa
	 */
	public Visitante getVisitante() {
		return visitante;
	}
	/**
	 * 
	 * @param visitante
	 */
	public void setVisitante(Visitante visitante) {
		this.visitante = visitante;
	}	
	
}