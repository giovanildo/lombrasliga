package model;

public class Tabela implements Comparable<Tabela>{
	private String clube;
	public String getClube() {
		return clube;
	}
	public void setClube(String clube) {
		this.clube = clube;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	public int getJogos() {
		return jogos;
	}
	public void setJogos(int jogos) {
		this.jogos = jogos;
	}
	public int getVitorias() {
		return vitorias;
	}
	public void setVitorias(int vitorias) {
		this.vitorias = vitorias;
	}
	public int getEmpates() {
		return empates;
	}
	public void setEmpates(int empates) {
		this.empates = empates;
	}
	public int getDerrotas() {
		return derrotas;
	}
	public void setDerrotas(int derrotas) {
		this.derrotas = derrotas;
	}
	public int getGolspro() {
		return golspro;
	}
	public void setGolspro(int golspro) {
		this.golspro = golspro;
	}
	public int getGolscontra() {
		return golscontra;
	}
	public void setGolscontra(int golscontra) {
		this.golscontra = golscontra;
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	public int getAproveitamento() {
		return aproveitamento;
	}
	public void setAproveitamento(int aproveitamento) {
		this.aproveitamento = aproveitamento;
	}
	@Override
	public String toString() {
		return "Tabela [clube=" + clube + ", pontos=" + pontos + ", jogos=" + jogos + ", vitorias=" + vitorias
				+ ", empates=" + empates + ", derrotas=" + derrotas + ", golspro=" + golspro + ", golscontra="
				+ golscontra + ", saldo=" + saldo + ", aproveitamento=" + aproveitamento + "]";
	}
	public Tabela(String clube, int pontos, int jogos, int vitorias, int empates, int derrotas, int golspro,
			int golscontra, int saldo, int aproveitamento) {
		super();
		this.clube = clube;
		this.pontos = pontos;
		this.jogos = jogos;
		this.vitorias = vitorias;
		this.empates = empates;
		this.derrotas = derrotas;
		this.golspro = golspro;
		this.golscontra = golscontra;
		this.saldo = saldo;
		this.aproveitamento = aproveitamento;
	}
	private String serialNumber;
	private Integer pontos;
	private int jogos;
	private int vitorias;
	private int empates;
	private int derrotas;
	private int golspro;
	private int golscontra;
	private int saldo;
	private int aproveitamento;
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Tabela o) {
		// TODO Auto-generated method stub
		Integer p = pontos;
		return p.compareTo(o.getPontos());
	}

}
