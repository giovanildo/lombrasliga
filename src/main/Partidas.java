package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Partidas {
	private Scanner in;
	List<String> clubes;

	public void partidas() {
		in = new Scanner(System.in);
		clubes = new ArrayList<String>();
		System.out.println("Entre com o nome dos clubes. Deixe em branco para terminar.");
		String clube = "";
		do {
			clube = in.nextLine().trim();
			if (!clube.isEmpty()) {
				clubes.add(clube);
			}
		} while (!clube.isEmpty());
		// no de ser impar
		if (clubes.size() % 2 == 1) {
			clubes.add(0, "");
		}
		// variaveis que serão base para gerar tabela
		int totalClubes = clubes.size();
		int metadeClubes = totalClubes / 2;
		// montando a tabela
		for (int t = 0; t < (totalClubes - 1); t++) {//for de fora
			System.out.print((t + 1) + "a rodada: ");
			for (int m = 0; m < metadeClubes; m++) {//for de dentro
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
}
