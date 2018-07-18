package model;
public class Partida {
	private EAtletaTorneio anfitriao;
	private EAtletaTorneio visitante;
	public Partida() {
		super();
		this.setAnfitriao(new EAtletaTorneio());
		this.setVisitante(new EAtletaTorneio());
	}
	public EAtletaTorneio getAnfitriao() {
		return anfitriao;
	}
	public void setAnfitriao(EAtletaTorneio anfitriao) {
		this.anfitriao = anfitriao;
	}
	public EAtletaTorneio getVisitante() {
		return visitante;
	}
	public void setVisitante(EAtletaTorneio visitante) {
		this.visitante = visitante;
	}	
	
}