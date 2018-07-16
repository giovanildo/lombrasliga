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
	public void teste() {
		for (int contador = 1; contador <= 100; contador++) {
			if (contador % 5 != 0)
				continue;
			/*
			 * Se o contador não for múltiplo de 5 Todo o código abaixo será ignorado e o
			 * loop continua com o próximo nr
			 */
			System.out.println("Contador: " + contador);
		}
	}

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
		if (clubes.size() % 2 == 1) {
			clubes.add(0, "");
		}
	}

	public void gerarTabela() {
		// variaveis que serão base para gerar tabela
		int totalClubes = clubes.size();
		int metadeClubes = totalClubes / 2;
		int mando = 0;
		int m1 = 0;
		int t1 = 0;
		int m0 = 0;
		String remove = "";
		// montando a tabela
		for (int t = 0; t < (totalClubes - 1); t++) {// for das rodadas
			System.out.print((t + 1) + "a rodada: ");
			for (int m = 0; m < metadeClubes; m++) {// for dos jogos
				// Clube está de fora nessa rodada?
				if (clubes.get(m).isEmpty())
					continue;
				mando = totalClubes - m - 1;
				m1 = m % 2;
				t1 = t % 2;
				m0 = m;
				// Teste para ajustar o mando de campo
				if (m % 2 == 1 || t % 2 == 1 && m == 0) {
					System.out.print(clubes.get(mando) + " x " + clubes.get(m) + "   ");
				} else {
					System.out.print(clubes.get(m) + " x " + clubes.get(mando) + "   ");
				}
			}
			System.out.println();
			remove = clubes.remove(clubes.size() - 1);
			// Gira os clubes no sentido horário, mantendo o primeiro no lugar
			clubes.add(1, remove);//apaga o clube do final do array e o insere na segunda posição
		}
	}

	public void partidas() {
		// adicionarClubes();
		 clubes.add("0");
		 clubes.add("1");
		 clubes.add("2");
		 clubes.add("3");		 
		 
		 qtdClubesImpar();
		 gerarTabela();
		
	}
}