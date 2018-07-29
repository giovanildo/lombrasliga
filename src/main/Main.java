package main;

import java.util.ArrayList;
import java.util.List;

import controller.Tabela;

public class Main {

	public static void main(String[] args) {
		new Tabela().partidas();
	}

	public static void partidas() {
		// Scanner in;
		List<String> clubes;

		// in = new Scanner(System.in);
		clubes = new ArrayList<String>();
		// System.out.println("Entre com o nome dos clubes. Deixe em branco para
		// terminar.");
		// String clube = "";
		// do {
		// clube = in.nextLine().trim();
		// if (!clube.isEmpty()) {
		// clubes.add(clube);
		// }
		// } while (!clube.isEmpty());

		// variaveis que sera a base para gerar tabela
		clubes.add("gio");
		clubes.add("gen");
		clubes.add("fab");
		clubes.add("zal");
		// clubes.add("outro");
		//clubes.add("zal");

		// no caso de ser impar

		if (clubes.size() % 2 == 1) {
			clubes.add(0, "");
		}
	
		int totalClubes = clubes.size();
		int metadeClubes = totalClubes / 2;
		int mando = 0;
		System.out.println("ESCRIPITE BAIXADO");
		// montando a tabela
		for (int t = 0; t < (totalClubes - 1); t++) {// for de fora
			System.out.println((t + 1) + "a rodada: ");
			for (int m = 0; m < metadeClubes; m++) {// for de dentro
				mando = totalClubes - m - 1;
				// Clube est� de fora nessa rodada?
				if (clubes.get(m).isEmpty())
					continue;

				// Teste para ajustar o mando de campo
				if (m % 2 == 1 || t % 2 == 1 && m == 0) {
					System.out.print(clubes.get(mando) + " x " + clubes.get(m) + "   ");

				} else {
					System.out.print(clubes.get(m) + " x " + clubes.get(mando) + "   ");
				}
			}
			System.out.println();
			// Gira os clubes no sentido hor�rio, mantendo o primeiro no lugar
			String teste = clubes.remove(clubes.size() - 1);
			clubes.add(1, teste);
			System.out.println(teste);
		}
	}

}
