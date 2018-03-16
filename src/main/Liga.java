package main;

import java.util.ArrayList;

public class Liga {

	public static void main(String[] args) {
		System.out.println(2%1.5);
		liga();
	}

	public static void liga() {

		// cria um array de clubes e preenchendo
		ArrayList<String> clubes = new ArrayList<String>();

		int qtdPovoar = 11; // n�mero de clubes - � usado somente para povoar a array de clubes
		for (int i = 0; i < qtdPovoar ; i++) {
			clubes.add("Club_" + Integer.toString(i));
		}

		int qtdClubes = clubes.size();// qtd de clubes

		// verifica se � par ou impar
		// serve gerar as rodadas
		// quando o n�mero � impar sempre vai ter uma rodada que um dos clubes n�o joga
		// a tecnica aqui � aumentar o clube pra ficar par e depois setar ele como nulo
		boolean impar = (qtdClubes % 2 != 0);
		if (impar) {
			++qtdClubes;
		}

		int totalP = (qtdClubes * (qtdClubes - 1)) / 2; // total de partidas por turno
		String[] casa = new String[totalP]; // criando matrizes com o n�mero de partidas por turno
		String[] fora = new String[totalP];// criando matrizes com o n�mero de partidas por turno

		// fazendo a tabela
		int modIF = (qtdClubes / 2);// para hacer mod cada inicio de data - criado para tirar o resto da divis�o
		int indiceInverso = qtdClubes - 2;
		for (int i = 0; i < totalP; i++) {
			System.out.println(i);
			System.out.println(" i " + i + " modif " + modIF +  " resultado " + i % modIF );
			if (i % modIF == 0) {// seria el partido inicial de cada data				
				System.out.println(fora[i] + " vs " + casa[i] + "\n");
				if (impar) { // qtd de clubes impar

					casa[i] = null;
					fora[i] = null;
					System.out.println("qtd Clubes " + qtdClubes);// aqui aparece o valor impar acrescido de mais um.
																	// Por isso � anulado
					System.out.println(
							" anulando o valor acrescido no caso de ser impar " + fora[i] + " vs " + casa[i] + "\n");
				} else {// qtd de clubes par
					// coloca um em casa e outro fora
					System.out.println("quando a qtd de clubes � par");
					if (i % 2 == 0) {
						casa[i] = clubes.get(i % (qtdClubes - 1));
						fora[i] = clubes.get(qtdClubes - 1);
						System.out.println(" i resto com 2");
						System.out.println(fora[i] + " vs " + casa[i] + "\n");
					} else {
						casa[i] = clubes.get(qtdClubes - 1);
						fora[i] = clubes.get(i % (qtdClubes - 1));
						System.out.println(" sou par mas o resto n�o � 0");
						System.out.println(fora[i] + " vs " + casa[i] + "\n");
					}
				}
			} else {
				casa[i] = clubes.get(i % (qtdClubes - 1));
				fora[i] = clubes.get(indiceInverso);
				System.out.println(" i resto com a metade da qtd de clubes diferente de 0");
				System.out.println(fora[i] + " vs " + casa[i] + "\n");
				--indiceInverso;
				if (indiceInverso < 0) {
					indiceInverso = qtdClubes - 2;
					System.out.println(
							" se o indice inverso for menor que zero atribuindo novo valor que � a qtd de clubes decrescido de 2");
					System.out.println(fora[i] + " vs " + casa[i] + "\n");
				}
			}
		}

		// mostra a tabela percorrendo as duas matrizes de
		System.out.println("\n Primeiro Turno \n \n");
		for (int i = 0; i < totalP; i++) {
			if (casa[i] != null) {// corrige o caso de n�meros impares
				System.out.println(casa[i] + " vs " + fora[i] + "\n");
			}
		}

		System.out.println("\n Segundo Turno \n \n");
		for (int i = 0; i < totalP; i++) {// corrige o caso de n�meros impares
			if (casa[i] != null) {
				System.out.println(fora[i] + " vs " + casa[i] + "\n");
			}
		}
	}

}
