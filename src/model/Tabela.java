package model;

public class Tabela {
	String clube;
	int pontos;
	int jogos;
	int vitorias;
	int empates;
	int derrotas;
	int golspro;
	int golscontra;
	int saldo;
	int aproveitamento;
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
	@Override
	public String toString() {
		return "Tabela [clube=" + clube + ", pontos=" + pontos + ", jogos=" + jogos + ", vitorias=" + vitorias
				+ ", empates=" + empates + ", derrotas=" + derrotas + ", golspro=" + golspro + ", golscontra="
				+ golscontra + ", saldo=" + saldo + ", aproveitamento=" + aproveitamento + "]";
	}
}