package main;

import java.util.ArrayList;

public class Liga {

	public static void main(String[] args) {
		liga();
	}

	public static void liga() {

		// cria um array de clubes e preenchendo
		ArrayList<String> clubes = new ArrayList<String>();

		int qtdPovoar = 8; // número de clubes - é usado somente para povoar a array de clubes
		for (int i = 0; i < qtdPovoar; i++) {
			clubes.add("Club_" + Integer.toString(i));
		}

		int qtdClubes = clubes.size();// qtd de clubes

		// verifica se é par ou impar
		// serve gerar as rodadas
		// quando o número é impar sempre vai ter uma rodada que um dos clubes não joga
		// a tecnica aqui é aumentar o clube pra ficar par e depois setar ele como nulo
		boolean impar = (qtdClubes % 2 != 0);
		if (impar) {
			++qtdClubes;
		}

		int totalP = (qtdClubes * (qtdClubes - 1)) / 2; // total de partidas por turno
		String[] casa = new String[totalP]; // criando matrizes com o número de partidas por turno
		String[] fora = new String[totalP];// criando matrizes com o número de partidas por turno
		
		// fazendo a tabela
		int modIF = (qtdClubes / 2);// usado para fazer as combinações
		int indiceInverso = qtdClubes - 2;
		for (int i = 0; i < totalP; i++) {
			String onde = "";	
			if (i % modIF == 0) {// seria el partido inicial de cada data
				if (impar) { // qtd de clubes impar
					casa[i] = null;
					fora[i] = null;
				} else {// qtd de clubes par coloca um em casa e outro fora
					if (i % 2 == 0) {
						casa[i] = clubes.get(i % (qtdClubes - 1));
						fora[i] = clubes.get(qtdClubes - 1);
						onde = "é par";						
					} else {
						casa[i] = clubes.get(qtdClubes - 1);
						fora[i] = clubes.get(i % (qtdClubes - 1));
					}
				}
			} else {
				casa[i] = clubes.get(i % (qtdClubes - 1));
				fora[i] = clubes.get(indiceInverso);
				--indiceInverso;
				if (indiceInverso < 0) {
					indiceInverso = qtdClubes - 2;
				}
			}
			System.out.println(i + " " + onde);
		}

		
		// mostra a tabela percorrendo as duas matrizes de
//		for (int i = 0; i < totalP; i++) {
//			if (casa[i] != null) {// corrige o caso de números impares
//				System.out.println(casa[i] + " vs " + fora[i] + "\n");
//			}
//		}
//
//		System.out.println("\n Segundo Turno \n \n");
//		for (int i = 0; i < totalP; i++) {// corrige o caso de números impares
//			if (casa[i] != null) {
//				System.out.println(fora[i] + " vs " + casa[i] + "\n");
//			}
//		}
	}

}
