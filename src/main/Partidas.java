package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Partidas {
	/**
	 * Array de clubes
	 */
	private List<String> clubes = new ArrayList<String>();

	/**
	 * Métodos para adicionar clubes a partir de uma entrada scanner
	 */
	public void adicionarClubes() {
		System.out.println("Entre com o nome dos clubes. Deixe em branco para terminar.");
		String clube = "";
		Scanner in = new Scanner(System.in);
		do {
			clube = in.nextLine().trim();
			if (!clube.isEmpty()) {
				clubes.add(clube);
			}
		} while (!clube.isEmpty());
		in.close();
	}

	/**
	 * em casos de clubes impar adiciona um clube com um texto vazio
	 */
	public void qtdClubesImpar() {
		// no caso de ser impar
		if (clubes.size() % 2 == 1) {
			clubes.add(0, "");
		}
	}

	public void gerarTabela() {
		// variaveis que serão base para gerar tabela
		int totalClubes = clubes.size();
		int metadeClubes = totalClubes / 2;
		// montando a tabela
		for (int t = 0; t < (totalClubes - 1); t++) {// for de fora
			System.out.print((t + 1) + "a rodada: ");
			for (int m = 0; m < metadeClubes; m++) {// for de dentro
				// Clube está de fora nessa rodada?
				if (clubes.get(m).isEmpty())
					continue;

				// Teste para ajustar o mando de campo
				if (m % 2 == 1 || t % 2 == 1 && m == 0) {
					System.out.print(clubes.get(totalClubes - m - 1) + " x " + clubes.get(m) + "   ");

				} else {
					System.out.print(clubes.get(m) + " x " + clubes.get(totalClubes - m - 1) + "   ");
				}
			}
			System.out.println();
			// Gira os clubes no sentido horário, mantendo o primeiro no lugar
			clubes.add(1, clubes.remove(clubes.size() - 1));
		}
	}

	public void partidas() {
		// adicionarClubes();
		clubes.add("Gigolô");
		clubes.add("Cunhado");
		clubes.add("Mister Coca");
		clubes.add("Gio");

		qtdClubesImpar();
		gerarTabela();
	}
}