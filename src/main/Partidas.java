package main;

import java.util.ArrayList;

public class Partidas {

	public static void main(String[] args) {
		geraTabela();
	}

	public static void geraTabela() {
		ArrayList<EAtletaTorneio> lista = preencherListaAtletaTorneio();
		int contar = 0;
		for (int a = 0; a < lista.size(); a++) {
			for (int b = 0; b < lista.size(); b++) {
				if (a != b) {
					System.out.println(" " + contar + " anfitrião " + a + " x " + b + " visitante ");
					contar++;
				}
				

			}
		}

		/*
		 * 0 x 1 0 x 2 0 x 3 1 x 0 1 x 2 1 x 3 2 x 0 2 x 1 2 x 3 3 x 0 3 x 1 3 x
		 * 2
		 */

		// pergunta o nome do torneio

		// pergunta o nome do e-atleta e o time que ele vai jogar or sorteia o
		// time

		// adiciona em um array

		// monta as rodadas e a tabela de pontos
	}

	public static ArrayList<EAtletaTorneio> preencherListaAtletaTorneio() {
		ArrayList<EAtletaTorneio> lista = new ArrayList<>();
		lista.add(new EAtletaTorneio(new Torneio("La decima"), new EAtleta("gio"), new Clube("Bayer")));
		lista.add(new EAtletaTorneio(new Torneio("La decima"), new EAtleta("gen"), new Clube("chelsea")));
		lista.add(new EAtletaTorneio(new Torneio("La decima"), new EAtleta("zal"), new Clube("liverpool")));
		lista.add(new EAtletaTorneio(new Torneio("La decima"), new EAtleta("fab"), new Clube("real")));
		return lista;

	}

}
