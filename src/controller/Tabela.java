package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Anfitriao;
import model.Clube;
import model.EAtleta;
import model.EAtletaTorneio;
import model.Partida;
import model.Torneio;
import model.Visitante;

public class Tabela {
	/**
	 * Array de clubes
	 */
	private List<Partida> listaPartidas;
	/**
	 * Array de times e Jogadores Videogame
	 */
	private List<EAtletaTorneio> listaEAtletaTorneio;

	/**
	 * Gerando as partidas
	 */

	public void partidas() {
		boolean impar = false;
		listaPartidas = new ArrayList<>();
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
		EAtletaTorneio outro = new EAtletaTorneio(new EAtleta("outro"), new Torneio("Meu torneio de bola"),
				new Clube("outro"));
		EAtletaTorneio quinto = new EAtletaTorneio(new EAtleta("outro"), new Torneio("Meu torneio de bola"),
				new Clube("quinto"));
		EAtletaTorneio sexto = new EAtletaTorneio(new EAtleta("outro"), new Torneio("Meu torneio de bola"),
				new Clube("sexto"));
		// adicionando no array list
		listaEAtletaTorneio.add(fab);

		listaEAtletaTorneio.add(gen);
		listaEAtletaTorneio.add(zal);

//		 listaEAtletaTorneio.add(gio);
//		 listaEAtletaTorneio.add(quinto);
//		 listaEAtletaTorneio.add(sexto);

		// em caso de partidas clubes impares
		if (listaEAtletaTorneio.size() % 2 == 1) {
			listaEAtletaTorneio.add(0, outro);
			impar = true;
		}

		// variaveis que serao base para gerar tabela
		int totalClubes = listaEAtletaTorneio.size();
		int metadeClubes = totalClubes / 2;
		// int m1 = 0;
		// int t1 = 0;
		// int m0 = 0;
		for (int t = 0; t < (totalClubes - 1); t++) {// for das rodadas
			for (int m = 0; m < metadeClubes; m++) {// for dos jogos
				// Clube está de fora nessa rodada?
				if (listaEAtletaTorneio.get(m).getClube().getNome().equals("outro")) {
					continue;
				}
				// Teste para ajustar o mando de campo
				if (m % 2 == 1 || t % 2 == 1 && m == 0) {
					listaPartidas.add(new Partida(new Anfitriao(listaEAtletaTorneio.get(totalClubes - m - 1), 0),
							new Visitante(listaEAtletaTorneio.get(m), 0)));

				} else {
					listaPartidas.add(new Partida(new Anfitriao(listaEAtletaTorneio.get(m), 0),
							new Visitante(listaEAtletaTorneio.get(totalClubes - m - 1), 0)));
				}
			}
			// Gira os clubes no sentido horário, mantendo o primeiro no lugar
			EAtletaTorneio remove = listaEAtletaTorneio.remove(listaEAtletaTorneio.size() - 1);
			listaEAtletaTorneio.add(1, remove);
			System.out.println(remove.getClube().getNome());
		}
		
		//desfazando a adição de um clube vazio
		if (impar) {
			listaEAtletaTorneio.remove(0);
			totalClubes = listaEAtletaTorneio.size();
			System.out.println(" total  de clube é impar " + totalClubes);
			metadeClubes = totalClubes/2;
		}

		
		// mostrando a arraylist das partidas
		int p = 0;
		int r = 0;
		
		
		for (Partida partida : listaPartidas) {
			if ((p % metadeClubes) ==  0) {
				r++;
				System.out.println(r + "a rodada " + (p%metadeClubes) + " metade dos clubes " + metadeClubes);
			}
			
			System.out.print("teste " + p%metadeClubes + " metade " + metadeClubes + "  ");
			String anfitriao = partida.getAnfitriao().geteAtletaTorneio().getClube().getNome();
			int golsa = partida.getAnfitriao().getGols();
			String visitante = partida.getVisitante().geteAtletaTorneio().getClube().getNome();
			int golsv = partida.getVisitante().getGols();
			System.out.println(p + " " + anfitriao + " " + golsa + " x " + visitante + " " + golsv);
			p++;
		}
	}

	/**
	 * Métodos para adicionar clubes a partir de uma entrada scanner
	 */

	// public void adicionarClubes() {
	//
	// System.out.println("Entre com o nome dos clubes. Deixe em branco para
	// terminar.");
	// String clube = "";
	// Scanner in = new Scanner(System.in);
	// do {
	// clube = in.nextLine().trim();
	// if (!clube.isEmpty()) {
	// clubes.add(clube);
	//
	// }
	// } while (!clube.isEmpty());
	// in.close();
	// }

	/**
	 * em casos de clubes impar adiciona um clube com um texto vazio
	 */

}
