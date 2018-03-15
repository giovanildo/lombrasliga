package main;

import java.util.ArrayList;

// pergunta o nome do torneio
// pergunta o nome do e-atleta e o time que ele vai jogar or sorteia o
// time
// adiciona em um array
// monta as rodadas e a tabela de pontos

public class Partidas {

	public static void main(String[] args) {
		// geraTabela();
		
	}

	
	public static void geraTabela() {
		// fazer rodadas do torneio
		// guarda em uma matriz as combinações, uma rodada tem que todos os times
		// jogarem
		// uma rodada sempre será a metade do número de participantes
		

		// 1 x 7 - 2 x

		// char contar = 'a';

		// for (int a = 0; a < lista.size(); a++) {
		// for (int b = 0; b < lista.size(); b++) {
		// if (a != b) {
		// System.out.println(" " + contar + " anfitrião " + a + " x " + b + " visitante
		// ");
		// contar++;
		// }
		//
		//
		// }
		// }
	}

	public static ArrayList<EAtletaTorneio> preencherListaAtletaTorneio() {
		ArrayList<EAtletaTorneio> lista = new ArrayList<>();
		lista.add(new EAtletaTorneio(new Torneio("La decima"), new EAtleta("gio"), new Clube("Bayer")));
		lista.add(new EAtletaTorneio(new Torneio("La decima"), new EAtleta("gen"), new Clube("chelsea")));
		lista.add(new EAtletaTorneio(new Torneio("La decima"), new EAtleta("zal"), new Clube("liverpool")));
		lista.add(new EAtletaTorneio(new Torneio("La decima"), new EAtleta("fab"), new Clube("real")));
		lista.add(new EAtletaTorneio(new Torneio("La decima"), new EAtleta("assis"), new Clube("roma")));
		lista.add(new EAtletaTorneio(new Torneio("La decima"), new EAtleta("nen"), new Clube("barça")));

		lista.add(new EAtletaTorneio(new Torneio("La decima"), new EAtleta("nana"), new Clube("milan")));
		lista.add(new EAtletaTorneio(new Torneio("La decima"), new EAtleta("natan"), new Clube("inter")));
		lista.add(new EAtletaTorneio(new Torneio("La decima"), new EAtleta("mario 20"), new Clube("toteran")));
		lista.add(new EAtletaTorneio(new Torneio("La decima"), new EAtleta("barbosa"), new Clube("manchester united")));
		lista.add(new EAtletaTorneio(new Torneio("La decima"), new EAtleta("crocodilo"), new Clube("manchester city")));
		lista.add(new EAtletaTorneio(new Torneio("La decima"), new EAtleta("pedro henrique"),
				new Clube("atletico de madrid")));
		return lista;

	}

}
