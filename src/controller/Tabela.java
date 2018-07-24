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
	private List<Partida> listaPartida = new ArrayList<>();
	private List<EAtletaTorneio> listaEAtletaTorneio = new ArrayList<>();

	public void partidas() {

		EAtletaTorneio gio = new EAtletaTorneio(new EAtleta("Giovanildo"), new Torneio("Meu torneio de bola"),
				new Clube("Ceará"));
		EAtletaTorneio gen = new EAtletaTorneio(new EAtleta("gen"), new Torneio("Meu torneio de bola"),
				new Clube("Ferrin"));
		EAtletaTorneio fab = new EAtletaTorneio(new EAtleta("fab"), new Torneio("Meu torneio de bola"),
				new Clube("Fortaleza"));
		EAtletaTorneio zal = new EAtletaTorneio(new EAtleta("zal"), new Torneio("Meu torneio de bola"),
				new Clube("Tiradentes"));
		EAtletaTorneio outro = new EAtletaTorneio(new EAtleta("outro"), new Torneio("Meu torneio de bola"),
				new Clube("Itapipoca"));

		// adicionarClubes();
		listaEAtletaTorneio.add(gio);
		listaEAtletaTorneio.add(gen);
		listaEAtletaTorneio.add(fab);
		listaEAtletaTorneio.add(zal);

		// listaPartida.add(new Partida(new Anfitriao(listaEAtletaTorneio.get(0),2), new
		// Visitante(listaEAtletaTorneio.get(1),0)));

		qtdClubesImpar();
		gerarTabela();
		int p = 0;
		int r = 0;
		int metadePartidas = listaEAtletaTorneio.size()/2;
		for (Partida partida : listaPartida) {
			p++;
			if(p==metadePartidas-1) {
				r++;
				System.out.print(r  + "a rodada ");
			}			
			String anfitriao = partida.getAnfitriao().geteAtletaTorneio().getClube().getNome();
			int golsa = partida.getAnfitriao().getGols();
			String visitante = partida.getVisitante().geteAtletaTorneio().getClube().getNome();
			int golsv = partida.getVisitante().getGols();
			
			System.out.println(anfitriao + " " + golsa + " x " + visitante + " " + golsv);

			
		}

	}

	/**
	 * Métodos para adicionar clubes a partir de uma entrada scanner
	 */

//	public void adicionarClubes() {
//
//		System.out.println("Entre com o nome dos clubes. Deixe em branco para terminar.");
//		String clube = "";
//		Scanner in = new Scanner(System.in);
//		do {
//			clube = in.nextLine().trim();
//			if (!clube.isEmpty()) {
//				clubes.add(clube);
//
//			}
//		} while (!clube.isEmpty());
//		in.close();
//	}

	/**
	 * em casos de clubes impar adiciona um clube com um texto vazio
	 */
	public void qtdClubesImpar() {
		if (listaEAtletaTorneio.size() % 2 == 1) {
			listaEAtletaTorneio.add(0, null);

		}
	}

	public void gerarTabela() {
		// variaveis que serao base para gerar tabela
		int totalClubes = listaEAtletaTorneio.size();
		int metadeClubes = totalClubes / 2;
		int mando = 0;
//		int m1 = 0;
//		int t1 = 0;
//		int m0 = 0;
		// montando a tabela

		for (int r = 0; r < 2; r++) {
			for (int t = 0; t < (totalClubes - 1); t++) {// for das rodadas
				//System.out.print((t + 1) + "a rodada: ");
				for (int m = 0; m < metadeClubes; m++) {// for dos jogos
					// Clube está de fora nessa rodada?
					if (listaEAtletaTorneio.get(m) == null)
						continue;
					mando = totalClubes - m - 1;
//					m1 = m % 2;
//					t1 = t % 2;
//					m0 = m;
					// Teste para ajustar o mando de campo
					if (m % 2 == 1 || t % 2 == 1 && m == 0) {
						if (r == 0) {
							listaPartida.add(new Partida(new Anfitriao(listaEAtletaTorneio.get(mando), 0),
									new Visitante(listaEAtletaTorneio.get(m), 0)));
						} else {
							listaPartida.add(new Partida(new Anfitriao(listaEAtletaTorneio.get(m), 0),
									new Visitante(listaEAtletaTorneio.get(mando), 0)));
						}

					} else {
						if (r == 1) {
							listaPartida.add(new Partida(new Anfitriao(listaEAtletaTorneio.get(m), 0),
									new Visitante(listaEAtletaTorneio.get(mando), 0)));
						} else {
							listaPartida.add(new Partida(new Anfitriao(listaEAtletaTorneio.get(mando), 0),
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

}
