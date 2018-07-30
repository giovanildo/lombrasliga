package controller;

import java.util.ArrayList;
import java.util.List;

import model.Anfitriao;
import model.Clube;
import model.EAtleta;
import model.EAtletaTorneio;
import model.EquipeEmCampo;
import model.Partida;
import model.Torneio;
import model.Visitante;

public class Tabela {
	/**
	 * Quantidades de clubes no torneio
	 */
	private int totalClubes;
	/**
	 * metade de clubes do torneio
	 */
	private int metadeClubes;
	/**
	 * verifica se a quantidade de equipes é par ou impar no torneio
	 */
	private boolean impar;
	/**
	 * Array de clubes
	 */
	private List<Partida> listaPartidas;
	/**
	 * Array de times e Jogadores Videogame
	 */
	private List<EAtletaTorneio> listaEAtletaTorneio;

	/**
	 * adiciona as equipes e seus jogadores de videogame
	 */
	public void adicionandoEquipes() {
		listaEAtletaTorneio = new ArrayList<>();
		/**
		 * criando os clubes e jogadores de videogame
		 */
		EAtletaTorneio gio = new EAtletaTorneio(new EAtleta("Giovanildo"), new Torneio("Meu torneio de bola"),
				new Clube("gio"));
		EAtletaTorneio gen = new EAtletaTorneio(new EAtleta("gen"), new Torneio("Meu torneio de bola"),
				new Clube("gen"));
		EAtletaTorneio fab = new EAtletaTorneio(new EAtleta("fab"), new Torneio("Meu torneio de bola"),
				new Clube("fab"));
		EAtletaTorneio zal = new EAtletaTorneio(new EAtleta("zal"), new Torneio("Meu torneio de bola"),
				new Clube("zal"));
		EAtletaTorneio quinto = new EAtletaTorneio(new EAtleta("quinto"), new Torneio("Meu torneio de bola"),
				new Clube("qui"));
		EAtletaTorneio sexto = new EAtletaTorneio(new EAtleta("sexto"), new Torneio("Meu torneio de bola"),
				new Clube("sex"));
		// adicionando no array list
		listaEAtletaTorneio.add(fab);
		listaEAtletaTorneio.add(gen);
		listaEAtletaTorneio.add(zal);

		listaEAtletaTorneio.add(gio);
		listaEAtletaTorneio.add(quinto);
		listaEAtletaTorneio.add(sexto);
	}

	/**
	 * 
	 * @return boolean em casos de que a quantidade de equipes é impar adiciona-se
	 *         um clube vazio para gerar a tabela
	 */
	public boolean equipesImpar() {
		// em caso de partidas clubes impares
		impar = false;
		if (listaEAtletaTorneio.size() % 2 == 1) {
			listaEAtletaTorneio.add(0, null);
			impar = true;
		}
		return impar;
	}

	/**
	 * gera array de partidas
	 */
	public void arrayPartidas() {
		// variaveis que serao base para gerar tabela
		totalClubes = listaEAtletaTorneio.size();
		metadeClubes = totalClubes / 2;

		for (int turno = 0; turno <= 1; turno++) {
			for (int t = 0; t < (totalClubes - 1); t++) {// for das rodadas
				for (int m = 0; m < metadeClubes; m++) {// for dos jogos
					// Clube está de fora nessa rodada?
					if (listaEAtletaTorneio.get(m).equals(null)) {
						continue;
					}
					// Teste para ajustar o mando de campo
					if (m % 2 == 1 || t % 2 == 1 && m == 0) {
						if (turno == 0) {
							listaPartidas
									.add(new Partida(new Anfitriao(listaEAtletaTorneio.get(totalClubes - m - 1), 0),
											new Visitante(listaEAtletaTorneio.get(m), 0)));
						} else {
							listaPartidas.add(new Partida(new Anfitriao(listaEAtletaTorneio.get(m), 0),
									new Visitante(listaEAtletaTorneio.get(totalClubes - m - 1), 0)));
						}
					} else {
						if (turno == 1) {
							listaPartidas.add(new Partida(new Anfitriao(listaEAtletaTorneio.get(m), 0),
									new Visitante(listaEAtletaTorneio.get(totalClubes - m - 1), 0)));

						} else {
							listaPartidas
									.add(new Partida(new Anfitriao(listaEAtletaTorneio.get(totalClubes - m - 1), 0),
											new Visitante(listaEAtletaTorneio.get(m), 0)));
						}
					}
				}
				// Gira os clubes no sentido horário, mantendo o primeiro no lugar
				EAtletaTorneio remove = listaEAtletaTorneio.remove(listaEAtletaTorneio.size() - 1);
				listaEAtletaTorneio.add(1, remove);
			}
		}

	}

	public void removeClubeVazio() {
		// desfazando a adição de um clube vazio
		if (impar) {
			listaEAtletaTorneio.remove(0);
			this.totalClubes = listaEAtletaTorneio.size();
			this.metadeClubes = totalClubes / 2;
		}
	}

	public void mostrarArrayPartidas() {
		// mostrando a arraylist das partidas
		int p = 0;
		int r = 0;

		metadeClubes = listaEAtletaTorneio.size() / 2;
		System.out.println(listaPartidas.get(0).getAnfitriao().geteAtletaTorneio().getTorneio().getNome());
		for (Partida partida : listaPartidas) {

			if ((p % metadeClubes) == 0) {
				System.out.println();
				r++;
				System.out.print(r + "a rodada ");
			}

			String anfitriao = partida.getAnfitriao().geteAtletaTorneio().getClube().getNome();
			int golsa = partida.getAnfitriao().getGols();
			String visitante = partida.getVisitante().geteAtletaTorneio().getClube().getNome();
			int golsv = partida.getVisitante().getGols();

			System.out.print(anfitriao + " " + golsa + " x " + visitante + " " + golsv + "  ");
			p++;
		}
	}

	public void partidas() {

		listaPartidas = new ArrayList<>();
		adicionandoEquipes();
		equipesImpar();
		arrayPartidas();
		removeClubeVazio();
		for (Partida partida : listaPartidas) {
			if (partida.getAnfitriao().geteAtletaTorneio().getClube().getNome().equals("gio")) {
				partida.getAnfitriao().setGols(1);
				partida.getVisitante().setGols(0);
			}
		}

		gerarTabela();
		mostrarArrayPartidas();
	}

	public void gerarTabela() {
		System.out.println();
		System.out.println("Tabela");
		System.out.println("Time, Pontos, Jogos, Vitórias, Empates, Derrotas, Gols Pro, Gols Contra, Saldo, % Aprov, ");
		int pontospossiveis = (listaEAtletaTorneio.size() - 1) * 3 * 2;

		for (Partida partida : listaPartidas) {
			partida.fimDePartida();

		}
		for (EAtletaTorneio eat : listaEAtletaTorneio) {
			int pontos = 0;
			int jogos = 0;
			int vitorias = 0;
			int empates = 0;
			int derrotas = 0;
			int golspro = 0;
			int golscontra = 0;
			int saldo = 0;
			int aproveitamento = 0;
			for (Partida partida : listaPartidas) {
				if (partida.getAnfitriao().geteAtletaTorneio().getClube().getNome().equals(eat.getClube().getNome())) {
					pontos += partida.getAnfitriao().getPontos();
					if (partida.getAnfitriao().getResultado() == EquipeEmCampo.VITORIA)
						vitorias++;
					if (partida.getAnfitriao().getResultado() == EquipeEmCampo.EMPATE)
						empates++;
					if (partida.getAnfitriao().getResultado() == EquipeEmCampo.DERROTA)
						derrotas++;
					golspro += partida.getAnfitriao().getGols();
					golscontra += partida.getAnfitriao().getGolscontra();
					saldo += golspro - golscontra;
					jogos++;
				} else if (partida.getVisitante().geteAtletaTorneio().getClube().getNome()
						.equals(eat.getClube().getNome())) {
					pontos += partida.getVisitante().getPontos();
					if (partida.getVisitante().getResultado() == EquipeEmCampo.VITORIA)
						vitorias++;
					if (partida.getVisitante().getResultado() == EquipeEmCampo.EMPATE)
						empates++;
					if (partida.getVisitante().getResultado() == EquipeEmCampo.DERROTA)
						derrotas++;
					golspro += partida.getVisitante().getGols();
					golscontra += partida.getVisitante().getGolscontra();
					saldo += golspro - golscontra;
					jogos++;
				}
			}
			aproveitamento = (int) (((float) pontos / pontospossiveis) * 100);
			System.out.println(eat.getClube().getNome() + "     " + pontos + "      " + jogos + "      " + vitorias
					+ "         " + empates + "        " + derrotas + "          " + golspro + "           "
					+ golscontra + "        " + saldo + "      " + aproveitamento + "%");
		}
	}
}