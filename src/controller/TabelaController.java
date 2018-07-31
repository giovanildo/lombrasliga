package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import model.Anfitriao;
import model.Clube;
import model.EAtleta;
import model.EAtletaTorneio;
import model.EquipeEmCampo;
import model.Partida;
import model.Tabela;
import model.Torneio;
import model.Visitante;

public class TabelaController {
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
	private Scanner entrada;

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
		// adicionando no array list
		listaEAtletaTorneio.add(fab);
		listaEAtletaTorneio.add(gen);
		listaEAtletaTorneio.add(zal);

		listaEAtletaTorneio.add(gio);
		listaEAtletaTorneio.add(quinto);
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
	public void geraPartidas() {
		// variaveis que serao base para gerar tabela
		totalClubes = listaEAtletaTorneio.size();
		metadeClubes = totalClubes / 2;

		for (int turno = 0; turno <= 1; turno++) {
			for (int t = 0; t < (totalClubes - 1); t++) {// for das rodadas
				for (int m = 0; m < metadeClubes; m++) {// for dos jogos
					// Clube está de fora nessa rodada?
					if (listaEAtletaTorneio.get(m) == null) {
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

	public void mostrarPartidas() {
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
		// adicionandoEquipes();
		adicionandoEquipesScanner();
		equipesImpar();
		geraPartidas();
		removeClubeVazio();
		preenchendoPartidas();
		gerarTabela();
		mostrarPartidas();
	}

	/**
	 * Preenche partidas com os gols
	 */
	public void preenchendoPartidas() {
		System.out.println("preenchendo partidas");
		// preenchendo a arraylist das partidas
		int p = 0;
		int r = 0;
		metadeClubes = listaEAtletaTorneio.size() / 2;
		System.out.println("O nome do Torneio é "
				+ listaPartidas.get(0).getAnfitriao().geteAtletaTorneio().getTorneio().getNome());
		for (Partida partida : listaPartidas) {
			if ((p % metadeClubes) == 0) {
				System.out.println();
				r++;
				System.out.print(r + "a rodada ");
			}
			String anfitriao = partida.getAnfitriao().geteAtletaTorneio().getClube().getNome();
			String visitante = partida.getVisitante().geteAtletaTorneio().getClube().getNome();

			System.out.print(anfitriao + " gols ");
			int golscasa = entrada.nextInt();
			System.out.print(visitante + " gols ");
			int golsfora = entrada.nextInt();
			partida.getAnfitriao().setGols(golscasa);
			partida.getVisitante().setGols(golsfora);
			p++;
		}

	}

	/**
	 * adicionando equipes de forma dinamica através da classe scanner
	 */
	public void adicionandoEquipesScanner() {
		listaEAtletaTorneio = new ArrayList<>();
		entrada = new Scanner(System.in);
		System.out.print(" Torneio ");
		String torneio = entrada.nextLine();
		System.out.println(torneio);

		String eatleta = "jogador";

		while (true) {
			System.out.println();
			System.out.println(" Jogador de Videogame ");
			eatleta = entrada.nextLine();
			if (eatleta.isEmpty())
				return;
			System.out.println(" Clube ");
			String clube = entrada.nextLine();
			listaEAtletaTorneio.add(new EAtletaTorneio(new EAtleta(eatleta), new Torneio(torneio), new Clube(clube)));
		}
	}

	/**
	 * Gera tabela
	 * 
	 */
	public void gerarTabela() {
		int pontos = 0;
		int saldo = 0;
		System.out.println();
		System.out.println("Tabela");
		System.out.println("Time, Pontos, Jogos, Vitórias, Empates, Derrotas, Gols Pro, Gols Contra, Saldo, % Aprov, ");
		int pontospossiveis = (listaEAtletaTorneio.size() - 1) * 3 * 2;
		List<Tabela> listaTabela = new ArrayList<>();
		for (Partida partida : listaPartidas) {
			partida.fimDePartida();
		}
		for (EAtletaTorneio eat : listaEAtletaTorneio) {
			
			int jogos = 0;
			int vitorias = 0;
			int empates = 0;
			int derrotas = 0;
			int golspro = 0;
			int golscontra = 0;
			
			int aproveitamento = 0;
			for (Partida partida : listaPartidas) {
				if (!partida.isEncerrada()) {
					System.out.println("Partida não acabou ainda");
					return;
				}
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
					jogos++;
				}
			}
			aproveitamento = (int) (((float) pontos / pontospossiveis) * 100);
			saldo = golspro - golscontra;
			listaTabela.add(new Tabela(eat.getClube().getNome(), pontos, jogos, vitorias, empates, derrotas, golspro,
					golscontra, saldo, aproveitamento));

			System.out.println(eat.getClube().getNome() + "     " + pontos + "      " + jogos + "      " + vitorias
					+ "         " + empates + "        " + derrotas + "          " + golspro + "           "
					+ golscontra + "        " + saldo + "      " + aproveitamento + "%");
		}
		for(Tabela t : listaTabela) {
			System.out.println(t.toString());
		}
		
	}
}