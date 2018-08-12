package model;

/**
 * 
 * @author giovanildo classe que configura as partidas
 */
public class Partida {

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
	 * saber se a partida foi encerrada ou não
	 */
	private boolean encerrada;
	/**
	 * 
	 * @param anfitriao
	 * @param visitante
	 */
	public Partida(Anfitriao anfitriao, Visitante visitante) {
		super();
		this.anfitriao = anfitriao;
		this.visitante = visitante;
	}

	/**
	 * encerra a partida e efetiva o placar da partida
	 */
	public void fimDePartida() {
		this.setEncerrada(true);

		int golsfora = this.getVisitante().getGols();
		int golscasa = this.getAnfitriao().getGols();

		// preencher gols contra
		this.getAnfitriao().setGolscontra(golsfora);
		this.getVisitante().setGolscontra(golscasa);

		// preenchendo resultado da partida
		if (golscasa == golsfora) {
			this.getAnfitriao().empatou();
			this.getVisitante().empatou();
			return;
		}

		if (golscasa > golsfora) {
			this.getVisitante().perdeu();
			this.getAnfitriao().ganhou();
		} else {
			this.getVisitante().ganhou();
			this.getAnfitriao().perdeu();
		}
	}

	/**
	 * 
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

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

	/**
	 * @return the encerrada verifica se a partida está encerrada
	 */
	public boolean isEncerrada() {
		
		return encerrada;
	}

	/**
	 * @param encerrada
	 *            the encerrada to set
	 */
	public void setEncerrada(boolean encerrada) {
		this.encerrada = encerrada;
	}

}