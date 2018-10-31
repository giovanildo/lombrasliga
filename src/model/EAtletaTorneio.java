package model;

/**
 * 
 * @author giovanildo classe que guarda as informações do clube/jogador de vídeo game
 *         na partida
 */
public class EAtletaTorneio {
	@Override
	public String toString() {
		return eAtleta + "   " + clube + "   " + torneio;
	}

	private int id;
	/**
	 * Jogador de Video Game
	 */
	private EAtleta eAtleta;

	/**
	 * Torneio da partida
	 */
	private Torneio torneio;
	/**
	 * clube que o jogador de vídeogame vai jogar
	 */
	private Clube clube;

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
	 * 
	 * @return o jogador de videogame
	 */
	public EAtleta geteAtleta() {
		return eAtleta;
	}

	/**
	 * 
	 * @param eAtleta o jogador de videogame
	 * 
	 */
	public void seteAtleta(EAtleta eAtleta) {
		this.eAtleta = eAtleta;
	}

	/**
	 * 
	 * @return o torneio
	 */
	public Torneio getTorneio() {
		return torneio;
	}

	/**
	 * 
	 * @param torneio
	 */
	public void setTorneio(Torneio torneio) {
		this.torneio = torneio;
	}

	/**
	 * 
	 * @return o clube que o jogador de video game está jogando
	 */
	public Clube getClube() {
		return clube;
	}

	/**
	 * 
	 * @param clube
	 */
	public void setClube(Clube clube) {
		this.clube = clube;
	}

	/**
	 * 
	 * @param eAtleta
	 * @param torneio
	 * @param clube
	 * 
	 */
	
	public EAtletaTorneio(EAtleta eAtleta, Torneio torneio, Clube clube) {
		super();
		this.eAtleta = eAtleta;
		this.torneio = torneio;
		this.clube = clube;
	}

}
