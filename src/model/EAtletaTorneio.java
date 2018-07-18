package model;

public class EAtletaTorneio {
	private EAtleta eAtleta;
	private Torneio torneio;
	private Clube clube;
	private int gols;
	public EAtleta geteAtleta() {
		return eAtleta;
	}
	public void seteAtleta(EAtleta eAtleta) {
		this.eAtleta = eAtleta;
	}
	public Torneio getTorneio() {
		return torneio;
	}
	public void setTorneio(Torneio torneio) {
		this.torneio = torneio;
	}
	public Clube getClube() {
		return clube;
	}
	public void setClube(Clube clube) {
		this.clube = clube;
	}
	public int getGols() {
		return gols;
	}
	public void setGols(int gols) {
		this.gols = gols;
	}
	public EAtletaTorneio() {
		super();
		this.eAtleta = new EAtleta();
		this.torneio = new Torneio();
		this.clube = new Clube();
		this.gols = 0;
	}
}
