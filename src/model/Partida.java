package model;

/**
 * 
 * @author giovanildo 
 * classe que configura as partidas
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
	
	@Override
	public String toString() {
		String clubeMandante = anfitriao.geteAtletaTorneio().getClube().getNome();
		String clubeVisitante = visitante.geteAtletaTorneio().getClube().getNome();
		String eAtletaMandante = anfitriao.geteAtletaTorneio().geteAtleta().getNome().toUpperCase();
		String eAtletaVisitante = visitante.geteAtletaTorneio().geteAtleta().getNome().toUpperCase();
		
		int golsMandante = anfitriao.getGols();
		int golsVisitante = visitante.getGols();		
		
		return  eAtletaMandante + " - " + clubeMandante + " " + golsMandante + " x " + golsVisitante + " " + clubeVisitante + " - " + eAtletaVisitante;
	}

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
	 * @return a equipe que joga fora de casa
	 */
	public Visitante getVisitante() {
		return visitante;
	}

	/**
	 * @return the encerrada verifica se a partida está encerrada
	 */
	public boolean isEncerrada() {

		return encerrada;
	}

	/**
	 * @param encerrada the encerrada to set
	 */
	public void setEncerrada(boolean encerrada) {
		this.encerrada = encerrada;
	}

}