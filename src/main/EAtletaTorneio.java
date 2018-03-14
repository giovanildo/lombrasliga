package main;

public class EAtletaTorneio {
	private EAtleta eatleta;
	private Torneio torneio;
	private Clube clube;
	private int pontos;
	private int jogos;
	private int vitorias;
	private int derrotas;
	private int empates;
	private int golsPro;
	private int golsContra;
	@Override
	public String toString() {
		return "EAtletaTorneio [eatleta=" + eatleta + ", torneio=" + torneio + ", clube=" + clube + ", pontos=" + pontos
				+ ", jogos=" + jogos + ", vitorias=" + vitorias + ", derrotas=" + derrotas + ", empates=" + empates
				+ ", golsPro=" + golsPro + ", golsContra=" + golsContra + "]";
	}
	public EAtleta getEatleta() {
		return eatleta;
	}
	public void setEatleta(EAtleta eatleta) {
		this.eatleta = eatleta;
	}
	public Clube getClube() {
		return clube;
	}
	public void setClube(Clube clube) {
		this.clube = clube;
	}
	public EAtletaTorneio(Torneio torneio, EAtleta eatleta, Clube clube) {
		super();
		this.torneio = torneio;
		this.eatleta = eatleta;
		this.clube = clube;
	}
}
