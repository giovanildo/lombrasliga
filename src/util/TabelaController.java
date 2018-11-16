package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import model.Clube;
import model.EAtleta;
import model.EAtletaTorneio;
import model.EquipeEmCampo;
import model.Partida;
import model.Torneio;
import view.FrameCadastros;
import view.FramePartidas;
import view.FrameTorneios;

/**
 * 
 * @author Francisco Giovanildo Teixeira de Souza 
 * 
 */
public class TabelaController {
	/**
	 * Quantidades de clubes no torneio
	 */
	private int totalClubes;
	/**
	 * metade de clubes do torneio
	 */
	private int metadeClubes;
	/**
	 * verifica se a quantidade de equipes é par ou impar no torneio
	 */
	private boolean impar;
	/**
	 * Array de clubes
	 */
	private List<Partida> listaPartidas;
	/**
	 * Array de times e Jogadores Videogame
	 */
	private List<EAtletaTorneio> listaEAtletaTorneio;
	/**
	 * Entrada de dados na linha de comando
	 */
	private Scanner entrada = new Scanner(System.in);
	/**
	 * view dos cadastros, clubes e jogadores
	 */
	private FrameCadastros frameCadastros;
	/**
	 * view dos torneios
	 */
	private FrameTorneios frameTorneios;
	/**
	 * view das partidas
	 */
	private FramePartidas framePartidas;

	public void partidas() {
		listaPartidas = new ArrayList<>();
		// adicionandoEquipes();
		adicionandoEquipesScanner();
		equipesImpar();
//		geraPartidas();
		removeClubeVazio();
		preenchendoPartidas();
//		gerarClassificacao();
		mostrarPartidas();
	}

	
	
	/**
	 * adiciona as equipes e seus jogadores de videogame
	 */

	
	public void adicionandoEquipes() {
		listaEAtletaTorneio = new ArrayList<>();
		/**
		 * criando os clubes e jogadores de videogame
		 */
		EAtletaTorneio gio = new EAtletaTorneio(new EAtleta("Giovanildo"), new Torneio("Meu torneio de bola", null),
				new Clube("gio"));
		EAtletaTorneio gen = new EAtletaTorneio(new EAtleta("gen"), new Torneio("Meu torneio de bola", null),
				new Clube("gen"));
		EAtletaTorneio fab = new EAtletaTorneio(new EAtleta("fab"), new Torneio("Meu torneio de bola", null),
				new Clube("fab"));
		EAtletaTorneio zal = new EAtletaTorneio(new EAtleta("zal"), new Torneio("Meu torneio de bola", null),
				new Clube("zal"));
		EAtletaTorneio quinto = new EAtletaTorneio(new EAtleta("quinto"), new Torneio("Meu torneio de bola", null),
				new Clube("qui"));
		// adicionando no array list
		listaEAtletaTorneio.add(fab);
		listaEAtletaTorneio.add(gen);
		listaEAtletaTorneio.add(zal);

		listaEAtletaTorneio.add(gio);
		listaEAtletaTorneio.add(quinto);
	}
	/**
	 * 
	 * @return
	 */
	public FrameCadastros getFrameCadastros() {
		return frameCadastros;
	}
	/**
	 * 
	 * @param frameCadastros
	 */
	public void setFrameCadastros(FrameCadastros frameCadastros) {
		this.frameCadastros = frameCadastros;
	}
	/**
	 * 
	 * @return
	 */
	public FrameTorneios getFrameTorneios() {
		return frameTorneios;
	}
	/**
	 * 
	 * @param frameTorneios
	 */
	public void setFrameTorneios(FrameTorneios frameTorneios) {
		this.frameTorneios = frameTorneios;
	}
	/**
	 * 
	 * @return
	 */
	public FramePartidas getFramePartidas() {
		return framePartidas;
	}
	/**
	 * 
	 * @param framePartidas
	 */
	public void setFramePartidas(FramePartidas framePartidas) {
		this.framePartidas = framePartidas;
	}

	/**
	 * 
	 * @return boolean em casos de que a quantidade de equipes é impar adiciona-se
	 *         um clube vazio para gerar a tabela
	 */
	public boolean equipesImpar() {
		// em caso de partidas clubes impares
		impar = false;

		if (listaEAtletaTorneio.size() % 2 == 1) {
			listaEAtletaTorneio.add(0, null);
			impar = true;
		}
		return impar;
	}

	
	public void removeClubeVazio() {
		// desfazando a adição de um clube vazio
		if (impar) {
			listaEAtletaTorneio.remove(0);
			this.totalClubes = listaEAtletaTorneio.size();
			this.metadeClubes = totalClubes / 2;
		}
	}

	public void mostrarPartidas() {
		// mostrando a arraylist das partidas
		int p = 0;
		int r = 0;

		metadeClubes = listaEAtletaTorneio.size() / 2;
		System.out.println(listaPartidas.get(0).getAnfitriao().geteAtletaTorneio().getTorneio().getNome());
		for (Partida partida : listaPartidas) {

			if ((p % metadeClubes) == 0) {
				System.out.println();
				r++;
				System.out.print(r + "a rodada ");
			}

			String anfitriao = partida.getAnfitriao().geteAtletaTorneio().getClube().getNome();
			int golsa = partida.getAnfitriao().getGols();
			String visitante = partida.getVisitante().geteAtletaTorneio().getClube().getNome();
			int golsv = partida.getVisitante().getGols();

			System.out.print(anfitriao + " " + golsa + " x " + visitante + " " + golsv + "  ");
			p++;
		}
	}




	/**
	 * Preenche partidas com os gols
	 */
	public void preenchendoPartidas() {

		System.out.println("preenchendo partidas");
		// preenchendo a arraylist das partidas
		int p = 0;
		int r = 0;
		metadeClubes = listaEAtletaTorneio.size() / 2;
		System.out.println("O nome do Torneio é "
				+ listaPartidas.get(0).getAnfitriao().geteAtletaTorneio().getTorneio().getNome());
		for (Partida partida : listaPartidas) {
			if ((p % metadeClubes) == 0) {
				System.out.println();
				r++;
				System.out.print(r + "a rodada ");
			}
			String anfitriao = partida.getAnfitriao().geteAtletaTorneio().getClube().getNome();
			String visitante = partida.getVisitante().geteAtletaTorneio().getClube().getNome();

			System.out.print(anfitriao + " gols ");
			int golscasa = entrada.nextInt();
			System.out.print(visitante + " gols ");
			int golsfora = entrada.nextInt();
			partida.getAnfitriao().setGols(golscasa);
			partida.getVisitante().setGols(golsfora);
			p++;
		}

	}

	/**
	 * adicionando equipes de forma dinamica através da classe scanner
	 */
	public void adicionandoEquipesScanner() {
		listaEAtletaTorneio = new ArrayList<>();
		entrada = new Scanner(System.in);
		System.out.print(" Torneio ");
		String torneio = entrada.nextLine();
		System.out.println(torneio);

		String eatleta = "jogador";

		while (true) {
			System.out.println();
			System.out.println(" Jogador de Videogame ");
			eatleta = entrada.nextLine();
			if (eatleta.isEmpty())
				return;
			System.out.println(" Clube ");
			String clube = entrada.nextLine();
			listaEAtletaTorneio.add(new EAtletaTorneio(new EAtleta(eatleta), new Torneio(torneio,null), new Clube(clube)));
			// torneio, jogador, clube
			//
		}
	}


}