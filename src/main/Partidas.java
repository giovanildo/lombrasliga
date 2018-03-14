package main;

import java.util.ArrayList;

public class Partidas {

	public static void main(String[] args) {
		geraTabela();
	}
	public static void geraTabela(){
		ArrayList<EAtletaTorneio> lista = preencherListaAtletaTorneio();
		System.out.println(lista.size());
		for(int i=0; i<=lista.size()-1;i++){
			System.out.println(lista.get(i).getClube().getNome() + " 1 x 0 " + lista.get(i+1).getClube().getNome());
		}
		
		//pergunta o nome do torneio
		 
		//pergunta o nome do e-atleta e o time que ele vai jogar or sorteia o time
				
		//adiciona em um array 
		
		//monta as rodadas e a tabela de pontos
	}
 	public static ArrayList<EAtletaTorneio> preencherListaAtletaTorneio(){
 		ArrayList<EAtletaTorneio> lista = new ArrayList<>(); 		
 		lista.add(new EAtletaTorneio(new Torneio("La decima"), new EAtleta("gio"), new Clube("Bayer")));
 		lista.add(new EAtletaTorneio(new Torneio("La decima"), new EAtleta("gen"), new Clube("chelsea")));
 		lista.add(new EAtletaTorneio(new Torneio("La decima"), new EAtleta("zal"), new Clube("liverpool")));
 		lista.add(new EAtletaTorneio(new Torneio("La decima"), new EAtleta("fab"), new Clube("real")));
 		return lista;
 		
 	}

}
