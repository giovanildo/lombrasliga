package giovanildo.lombrasliga.model;

/**
 * 
 * @author giovanildo classe que configura as partidas
 */
public class Partida {

	/**
	 * id único
	 */
	private int id;
	/**
	 * clube que joga em casa
	 */
	private EAtletaTorneio anfitriao;
	/**
	 * clube que joga fora
	 */
	private EAtletaTorneio visitante;
	/**
	 * saber se a partida foi encerrada ou não
	 */

	private boolean encerrada;
	/**
	 * Gols do Visitante
	 */
	private int golsVisitante;
	/**
	 * Gols do Anfitriao
	 */
	private int golsAnfitriao;

	/**
	 * 
	 * @param anfitriao
	 * @param visitante
	 */
	public Partida(EAtletaTorneio anfitriao, int golsAnfitriao, EAtletaTorneio visitante, int golsVisitante) {
		this.anfitriao = anfitriao;
		this.visitante = visitante;
		this.golsAnfitriao = golsAnfitriao;
		this.golsVisitante = golsVisitante;
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

	public EAtletaTorneio getAnfitriao() {
		return anfitriao;

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
	 * @param anfitriao
	 */
	public void setAnfitriao(EAtletaTorneio anfitriao) {
		this.anfitriao = anfitriao;
	}

	/**
	 * 
	 * @param visitante
	 */

	public void setVisitante(EAtletaTorneio visitante) {
		this.visitante = visitante;
	}

	/**
	 * 
	 * @param golsVisitante
	 */
	public void setGolsVisitante(int golsVisitante) {
		this.golsVisitante = golsVisitante;
	}

	/**
	 * 
	 * @param golsAnfitriao
	 */

	public void setGolsAnfitriao(int golsAnfitriao) {
		this.golsAnfitriao = golsAnfitriao;
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

	/**
	 * 
	 * @return qtd gols do visitante
	 */
	public int getGolsVisitante() {
		return golsVisitante;
	}

	/**
	 * 
	 * @return qtd gols do anfitriao
	 */
	public int getGolsAnfitriao() {
		return golsAnfitriao;
	}

	@Override
	public String toString() {
		String clubeMandante = anfitriao.getClube().getNome();
		String clubeVisitante = visitante.getClube().getNome();
		String eAtletaMandante = anfitriao.geteAtleta().getNome().toUpperCase();
		String eAtletaVisitante = visitante.geteAtleta().getNome().toUpperCase();

		int golsMandante = this.golsAnfitriao;
		int golsVisitante = this.golsVisitante;

		return eAtletaMandante + " - " + clubeMandante + " " + golsMandante + " x " + golsVisitante + " "
				+ clubeVisitante + " - " + eAtletaVisitante;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partida other = (Partida) obj;
		if (anfitriao == null) {
			if (other.anfitriao != null)
				return false;
		} else if (!anfitriao.equals(other.anfitriao))
			return false;
		if (id != other.id)
			return false;
		if (visitante == null) {
			if (other.visitante != null)
				return false;
		} else if (!visitante.equals(other.visitante))
			return false;
		return true;
	}

}