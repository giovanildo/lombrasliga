package giovanildo.lombrasliga.controller;

import giovanildo.lombrasliga.view.FrameCadastros;
import giovanildo.lombrasliga.view.FramePartidas;
import giovanildo.lombrasliga.view.FrameTorneios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import giovanildo.lombrasliga.dao.DAO;
import giovanildo.lombrasliga.model.Classificacao;
import giovanildo.lombrasliga.model.Clube;
import giovanildo.lombrasliga.model.EAtleta;
import giovanildo.lombrasliga.model.EAtletaTorneio;
import giovanildo.lombrasliga.model.Partida;
import giovanildo.lombrasliga.model.Torneio;

public class TorneioController {

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
	/**
	 * Lista de torneios
	 */
	private ArrayList<Torneio> listaTorneios;
	/**
	 * Lista Jogadores e Clubes no Torneio
	 * 
	 */
	private ArrayList<EAtletaTorneio> listaEatletasTorneio;
	/**
	 * Lista de Partidas geradas a partir da lista EatletasTorneio
	 */
	private ArrayList<Partida> listaPartidas;

	/**
	 * lista de Clubes
	 */
	private ArrayList<Clube> listaClubes;

	/**
	 * lista de EAtleta
	 */

	private ArrayList<EAtleta> listaEatleta;
	/**
	 * conexão com o banco de dados
	 */
	private DAO dao;

	/**
	 * Inicializador de objetos
	 */

	public TorneioController() {
		super();
		//preencher as arrays com os dados que estão no banco de dados
		
		this.dao = new DAO();
		this.listaClubes = dao.preencherArrayClubes();
		this.listaEatleta = dao.preencherArrayEAtleta();
		this.listaTorneios = dao.preencherArrayTorneios();

		this.listaEatletasTorneio = dao.preencherArrayEAtletasTorneio(listaEatleta, listaTorneios, listaClubes);
		this.listaPartidas = dao.preencherArrayPartidas(listaEatletasTorneio);
		
		this.frameCadastros = new FrameCadastros();
		this.frameTorneios = new FrameTorneios();
		this.framePartidas = new FramePartidas();
	}

	private void preencherJLists() {

		//preechendo JList com a lista de torneios
		for(Torneio t : listaTorneios) {
			System.out.println(t);
			getFrameTorneios().getModelTorneios().addElement(t);
		}
		
		//preechendo JList com a lista de eatletaTorneio
		for(EAtletaTorneio eat : listaEatletasTorneio) {
			System.out.println(eat);
			getFrameTorneios().getModelEatletaTorneio().addElement(eat);
		}
			
		//preechendo JList com a lista de clubes
		for(Clube c : listaClubes) {
			System.out.println(c);
			getFrameCadastros().getModelClubes().addElement(c);
		}
		
		//preechendo JList com a lista de atletas
		for(EAtleta ea : listaEatleta) {
			System.out.println(ea.getNome() + ea.getId());
			getFrameCadastros().getModelEatletas().addElement(ea);
		}		
	}
	

	/**
	 * Preenche a JList Classificação na Frame Partidas
	 */
	public void preencherJListClassificacao() {
		getFramePartidas().getModelClassif().clear();

		// gerar lista eatletaTorneio atual
		ArrayList<EAtletaTorneio> listaTorneioAtual = new ArrayList<EAtletaTorneio>();
		String torneioTxtField = getFrameTorneios().getTxtNomeTorneio().getText();

		for (EAtletaTorneio eat : listaEatletasTorneio) {
			String torneioEat = eat.getTorneio().getNome();
			if (torneioEat.equals(torneioTxtField)) {
				listaTorneioAtual.add(eat);
			}
		}

		// gerar lista partidas atual
		ArrayList<Partida> listaPartidasAtual = new ArrayList<Partida>();
		for (Partida partida : listaPartidas) {
			String torneioPartida = partida.getAnfitriao().getTorneio().getNome();
			if (torneioPartida.equals(torneioTxtField)) {
				listaPartidasAtual.add(partida);
			}
		}

		// preencher a model classificação com os dados da lista de classificacao

		ArrayList<Classificacao> listaClassif = gerarClassificacao(listaTorneioAtual, listaPartidasAtual);

		for (Classificacao classif : listaClassif) {
			getFramePartidas().getModelClassif().addElement(classif);
		}

		getFramePartidas().getJlstPartidas().setModel(getFramePartidas().getModelPartidas());
		getFramePartidas().getJlstClassif().setModel(getFramePartidas().getModelClassif());
	}

	/**
	 * Encerra as partidas contabilizar o placar Atualiza a tabela de classificação
	 */
	public void confirmarPlacar() {
		getFramePartidas().getModelClassif().clear();

		int index = getFramePartidas().getJlstPartidas().getSelectedIndex();
		Partida partidaModel = getFramePartidas().getModelPartidas().getElementAt(index);

		int golsAnfitriao = Integer.parseInt(getFramePartidas().getTxtGolsAnfitriao().getText());
		int golsVisitante = Integer.parseInt(getFramePartidas().getTxtGolsVisitante().getText());

		partidaModel.setGolsAnfitriao(golsAnfitriao);
		partidaModel.setGolsVisitante(golsVisitante);

		for (Partida partidaArray : listaPartidas) {
			if (partidaArray.equals(partidaModel)) {
				partidaArray.setEncerrada(true);
			}
		}

		preencherJListClassificacao();

	}

	/**
	 * Gera a tabela de classificação
	 * 
	 */
	public ArrayList<Classificacao> gerarClassificacao(ArrayList<EAtletaTorneio> listaEAtletaTorneioAtual,
			ArrayList<Partida> listaPartidasAtual) {

		ArrayList<Classificacao> listaClassificacao = new ArrayList<Classificacao>();

		int pontospossiveis = (listaEAtletaTorneioAtual.size() - 1) * 3 * 2;

		for (EAtletaTorneio eat : listaEAtletaTorneioAtual) {
			int jogos = 0;
			int vitorias = 0;
			int empates = 0;
			int derrotas = 0;
			int golspro = 0;
			int golscontra = 0;
			int pontos = 0;
			int saldo = 0;
			int aproveitamento = 0;

			for (Partida partida : listaPartidasAtual) {
				if (!partida.isEncerrada()) {
					System.out.println("Partida não acabou ainda");
					continue;
				}

				if (partida.getAnfitriao().getClube().getNome().equals(eat.getClube().getNome())) {
					if (partida.getGolsAnfitriao() > partida.getGolsVisitante()) {
						vitorias++;
						pontos += 3;
					}
						
					if (partida.getGolsAnfitriao() == partida.getGolsVisitante()) {
						empates++;
						pontos++;
					}
					if (partida.getGolsAnfitriao() < partida.getGolsVisitante()) {
						derrotas++;
					}

					golspro += partida.getGolsAnfitriao();
					golscontra += partida.getGolsVisitante();
					jogos++;
				} else if (partida.getVisitante().getClube().getNome().equals(eat.getClube().getNome())) {
					if (partida.getGolsVisitante() > partida.getGolsAnfitriao()) {
						vitorias++;
						pontos += 3;
					}
					if (partida.getGolsVisitante() == partida.getGolsAnfitriao()) {
						empates++;
						pontos++;
					}
					if (partida.getGolsVisitante() < partida.getGolsAnfitriao()) {
						derrotas++;
					}

					golspro += partida.getGolsAnfitriao();
					golscontra += partida.getGolsVisitante();
					jogos++;

				}
			}
			aproveitamento = (int) (((float) pontos / pontospossiveis) * 100);
			saldo = golspro - golscontra;
			listaClassificacao.add(new Classificacao(eat.getClube().getNome(), pontos, jogos, vitorias, empates,
					derrotas, golspro, golscontra, saldo, aproveitamento));
		}
		Collections.sort(listaClassificacao);
		return listaClassificacao;
	}

	/**
	 * gera array de partidas
	 */
	public void geraPartidas(ArrayList<EAtletaTorneio> listaEAtletaTorneioAtual) {
		// em caso de partidas clubes impares
		if (listaEAtletaTorneioAtual.size() % 2 == 1) {
			listaEAtletaTorneioAtual.add(0, null);
		}

		// variaveis que serao base para gerar partidas
		int totalClubes = listaEAtletaTorneioAtual.size();
		int metadeClubes = totalClubes / 2;
		Partida partida = null;
		for (int turno = 0; turno <= 1; turno++) {
			for (int t = 0; t < (totalClubes - 1); t++) {// for das rodadas
				for (int m = 0; m < metadeClubes; m++) {// for dos jogos
					// Clube está de fora nessa rodada?
					if (listaEAtletaTorneioAtual.get(m) == null) {
						continue;
					}
					// Teste para ajustar o mando de campo
					if (m % 2 == 1 || t % 2 == 1 && m == 0) {
						if (turno == 0) {
							partida = new Partida(listaEAtletaTorneioAtual.get(totalClubes - m - 1), 0,
									listaEAtletaTorneioAtual.get(m), 0);
						} else {
							partida = new Partida(listaEAtletaTorneioAtual.get(m), 0,
									listaEAtletaTorneioAtual.get(totalClubes - m - 1), 0);
						}
					} else {
						if (turno == 1) {
							partida = new Partida(listaEAtletaTorneioAtual.get(m), 0,
									listaEAtletaTorneioAtual.get(totalClubes - m - 1), 0);

						} else {
							partida = new Partida(listaEAtletaTorneioAtual.get(totalClubes - m - 1), 0,
									listaEAtletaTorneioAtual.get(m), 0);
						}
					}
				}
				listaPartidas.add(partida);
				// Gira os clubes no sentido horário, mantendo o primeiro no lugar
				EAtletaTorneio remove = listaEAtletaTorneioAtual.remove(listaEAtletaTorneioAtual.size() - 1);
				listaEAtletaTorneioAtual.add(1, remove);
			}
		}

	}

	public void iniciar() {				
		iniciarFrameTorneios();
		preencherComboBox();
		preencherJLists();
		getFrameTorneios().getBtnNovoJogadorClube().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarFrameCadastros();
			}
		});

		// Editar EAtleta
		getFrameCadastros().getBtnEditarEatleta().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String eatleta = getFrameCadastros().getTxtEatleta().getText();
				//altera no JList
				EAtleta eaJlist = getFrameCadastros().getJlstEatleta().getSelectedValue(); 
				getFrameCadastros().getJlstEatleta().getSelectedValue().setNome(eatleta);
				getFrameCadastros().getJlstEatleta().setModel(getFrameCadastros().getModelEatletas());
				
				//alterar no array
				
				for(EAtleta eaArray : listaEatleta) {
					if(eaJlist.getId()==eaArray.getId()) {
						eaArray.setNome(eatleta);
					}
				}
				
				//alterar no banco de dados
				dao.alterar("eatleta", "id_eatleta", Integer.toString(eaJlist.getId()), "nome_eatleta", eatleta);
			}
		});

		getFrameCadastros().getJlstEatleta().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				getFrameCadastros().getTxtEatleta().requestFocus();
			}
		});

		// editar Clube
		getFrameCadastros().getBtnEditarClube().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String clubeTxt = getFrameCadastros().getTxtClube().getText();
				Clube clubeJlist = getFrameCadastros().getJlstClubes().getSelectedValue();

				//alterar no jlist
				getFrameCadastros().getJlstClubes().getSelectedValue().setNome(clubeTxt);				
				getFrameCadastros().getJlstClubes().setModel(getFrameCadastros().getModelClubes());
				//alterar no array
				for(Clube clubeArray : listaClubes) {
					if(clubeArray.getId()==clubeJlist.getId()) {
						clubeArray.setNome(clubeTxt);
					}
				}
				//alterar banco de dados
				dao.alterar("clube", "id_clube", Integer.toString(clubeJlist.getId()), "nome_clube", clubeTxt);
				
				
			}
		});

		getFrameCadastros().getJlstClubes().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				getFrameCadastros().getTxtClube().requestFocus();
			}
		});

		getFrameTorneios().getBtnNovoTorneio().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getFrameTorneios().getModelEatletaTorneio().clear();
				
				String torneioTxt = getFrameTorneios().getTxtNomeTorneio().getText();
				
				for (Torneio torneio : listaTorneios) {
					if (torneio.getNome().equals(torneioTxt)) {
						System.out.println("repetido");
						return;
					}
				}
				
				//incluindo id para não termos inconsistencia de dados entre
				// jlist, model, combobox
				dao.inserir("torneio", "nome_torneio", "porque_nome_torneio", getFrameTorneios().getTxtNomeTorneio().getText(), getFrameTorneios().getTxtPorqueDoNome().getText());
				int id = dao.ultimoID("torneio", "id_torneio");			
				Torneio torneio = new Torneio(getFrameTorneios().getTxtNomeTorneio().getText(), getFrameTorneios().getTxtPorqueDoNome().getText());
				torneio.setId(id);
				// inclue na lista
				listaTorneios.add(torneio);
				
				getFrameTorneios().getModelTorneios().addElement(torneio);
				//incluindo na tabela
				
				
			}
			
		});
		// remove EAtelta Torneio
		getFrameTorneios().getBtnRemoverJogador().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = getFrameTorneios().getJlstEatletaClube().getSelectedIndex();
				EAtletaTorneio eatDoModel = getFrameTorneios().getModelEatletaTorneio().getElementAt(index);
				// removendo do array
				for (int i = 0; i < listaEatletasTorneio.size(); i++) {
					EAtletaTorneio eatDoArray = listaEatletasTorneio.get(i);
					if (eatDoModel.equals(eatDoArray)) {
						listaEatletasTorneio.remove(i);
					}
				}
				getFrameTorneios().getModelEatletaTorneio().remove(index);
			}
		});

		// adiciona EAtletaTorneio
		getFrameTorneios().getBtnAdicionarJogador().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// se for repetido EAtleta Torneio encerra o método
				for (int i = 0; i < getFrameTorneios().getJlstEatletaClube().getModel().getSize(); i++) {
					EAtletaTorneio eat = getFrameTorneios().getJlstEatletaClube().getModel().getElementAt(i);
					String itemClube = getFrameTorneios().getTxtClube().getSelectedItem().toString();
					String itemEatleta = getFrameTorneios().getTxtEatleta().getSelectedItem().toString();
					// se não for repetido adiciona tanto a JList como a lista EAtleta Torneio
					if (eat.getClube().getNome().equals(itemClube) && eat.geteAtleta().getNome().equals(itemEatleta)
							&& eat.getTorneio().getNome().equals(getFrameTorneios().getTxtNomeTorneio().getText())) {
						System.out.println("repetido");
						return;
					}
				}

				EAtletaTorneio eat = new EAtletaTorneio((EAtleta) getFrameTorneios().getTxtEatleta().getSelectedItem(),
						new Torneio(getFrameTorneios().getJlstTorneios().getSelectedValue().getNome(),
								getFrameTorneios().getTxtPorqueDoNome().getText()),
						(Clube) getFrameTorneios().getTxtClube().getSelectedItem());
				getFrameTorneios().getModelEatletaTorneio().addElement(eat);
				listaEatletasTorneio.add(eat);
			}
		});
//		// Salva Torneio
//		getFrameTorneios().getBtnSalvarTorneio().addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				// evita que adicione torneios com o mesmo nome
//				// salva edições do torneio
//				for (int i = 0; i < getFrameTorneios().getJlstTorneios().getModel().getSize(); i++) {
//					Torneio torneioDaVez = getFrameTorneios().getJlstTorneios().getModel().getElementAt(i);
//					// verifica se o nome já existe o registro no JList
//					if (torneioDaVez.getNome().equals(getFrameTorneios().getTxtNomeTorneio().getText())) {
//						// salva na JList dos torneios
//						torneioDaVez.setPorqueDoNome(getFrameTorneios().getTxtPorqueDoNome().getText());
//						System.out.println("Esse registro existe, salvando os dados do objeto Torneio");
//						// salva no lista Torneios
//						for (Torneio torneioArray : listaTorneios) {
//							if (torneioArray.getNome().equals(getFrameTorneios().getTxtNomeTorneio().getText())) {
//								torneioArray.setPorqueDoNome(getFrameTorneios().getTxtPorqueDoNome().getText());
//							}
//						}
//						return;
//					}
//				}
//				System.out.println("novo torneio");
//				// no caso de um novo torneio...
//				Torneio torneio = new Torneio(getFrameTorneios().getTxtNomeTorneio().getText(),
//						getFrameTorneios().getTxtPorqueDoNome().getText());
//				// adiciona tanto na lista temporaria(jlist) como na lista permanente(arraylist)
//				System.out.println("adicionando ao lista Torneios");
//				listaTorneios.add(torneio);
//				getFrameTorneios().getModelTorneios().addElement(torneio);
//				System.out.println("adicionando ao Jist Torneio");
//			}
//		});
		// Gera Partidas e Edita Partidas

		getFrameTorneios().getBtnEditarPartidas().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				getFramePartidas().getModelPartidas().clear();

				// saber se já existe o torneio já foi disputado ou não - comparar a lista das
				// partidas com a lista dos eats

				ArrayList<EAtletaTorneio> listaTorneioAtual = new ArrayList<EAtletaTorneio>();
				String torneioTxtField = getFrameTorneios().getTxtNomeTorneio().getText();

				for (EAtletaTorneio eat : listaEatletasTorneio) {
					String torneioEat = eat.getTorneio().getNome();
					if (torneioEat.equals(torneioTxtField)) {
						listaTorneioAtual.add(eat);
					}
				}
				// caso não exista gera normalmente - código já montado
				if (!seTorneioFoiDisputado()) {
					geraPartidas(listaTorneioAtual);
				}

				// caso exista seleciona as partidas existentes e joga para o model list - fazer
				// um for selecionando

				for (Partida partida : listaPartidas) {
					String torneioPartida = partida.getAnfitriao().getTorneio().getNome();
					if (torneioPartida.equals(torneioTxtField)) {
						getFramePartidas().getModelPartidas().addElement(partida);
					}
				}

				preencherJListClassificacao();

				iniciarFramePartidas();
			}
		});
		// deleta Torneio
		getFrameTorneios().getBtnDeletarTorneio().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int index = getFrameTorneios().getJlstTorneios().getSelectedIndex();
				Torneio torneioNoModel = getFrameTorneios().getJlstTorneios().getModel().getElementAt(index);

				getFrameTorneios().getModelEatletaTorneio().clear();
				
				//removendo do JList e da Lista Torneios
				getFrameTorneios().getModelTorneios().remove(index);
				listaTorneios.remove(index);

				// apagar todas as referencias do torneio na lista EAtletaTorneio

				for (int i = 0; i < listaEatletasTorneio.size(); i++) {
					String torneioEAtleta = listaEatletasTorneio.get(i).getTorneio().getNome();
					if (torneioEAtleta.equals(torneioNoModel.getNome())) {
						System.out.println("apagando linha " + torneioEAtleta);
						dao.excluir("eatletatorneio", "id_eatletatorneio", torneioNoModel.getId());
						listaEatletasTorneio.remove(i);
						
					}
				}
				// apagar as referencias da lista de partidas
				for (int i = 0; i < listaPartidas.size(); i++) {
					String torneioNaListaPartidas = listaPartidas.get(i).getAnfitriao().getTorneio()
							.getNome();
					if (torneioNaListaPartidas.equals(torneioNoModel.getNome())) {
						listaPartidas.remove(i);
					}

				}
				// apagar no banco de dados
				//apagando na tabela torneio
				dao.excluir("torneio", "id_torneio", torneioNoModel.getId());
				
				
				System.out.println("deletado com sucesso " + torneioNoModel.getNome());
			}
		});

		getFramePartidas().getJlstPartidas().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				getFramePartidas().getTxtGolsAnfitriao().requestFocus();
				getFramePartidas().getTxtGolsAnfitriao().setText("0");
				getFramePartidas().getTxtGolsVisitante().setText("0");
			}
		});

		getFramePartidas().getTxtGolsVisitante().addKeyListener(new KeyAdapter() {
			public void keyPressed(java.awt.event.KeyEvent e) {
				if (e.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
					confirmarPlacar();
				}
			}
		});

		getFramePartidas().getBtnConfirmar().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmarPlacar();
			}
		});

		getFrameTorneios().getBtnEditarTorneio().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Torneio torneio = getFrameTorneios().getJlstTorneios().getModel()
						.getElementAt(getFrameTorneios().getJlstTorneios().getSelectedIndex());

				getFrameTorneios().getTxtNomeTorneio().setText(torneio.getNome());
				getFrameTorneios().getTxtPorqueDoNome().setText(torneio.getPorqueDoNome());
				// limpa JList EAtleta Torneio
				getFrameTorneios().getModelEatletaTorneio().clear();
				// recuperar do arraylist e jogar no JList do EAtletaTorneio
				for (EAtletaTorneio eat : listaEatletasTorneio) {
					if (eat.getTorneio().getNome().equals(torneio.getNome())) {
						getFrameTorneios().getModelEatletaTorneio().addElement(eat);
					}
				}
			}
		});

		// cadastrar clube
		getFrameCadastros().getBtnAdicionarClube().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String clubeTextField = getFrameCadastros().getTxtClube().getText();
				for (Clube clube : listaClubes) {
					if (clube.getNome().equals(clubeTextField)) {
						System.out.println("repetido");
						return;
					}
				}
				//incluindo id para não termos inconsistencia de dados entre
				// jlist, model, combobox
				dao.inserir("clube", "nome_clube", getFrameCadastros().getTxtClube().getText());
				Clube clube = new Clube(getFrameCadastros().getTxtClube().getText());
				int id = dao.ultimoID("clube", "id_clube");
				clube.setId(id);
				// inclue na lista, no modelClubes e no combobox da frame torneios
				listaClubes.add(clube);
				getFrameTorneios().getTxtClube().addItem(clube);
				getFrameCadastros().getModelClubes().addElement(clube);
				//incluindo na tabela
				getFrameCadastros().getTxtClube().setText("");
			}
		});
		// cadastrar EAtleta
		getFrameCadastros().getBtnAdicionarEatleta().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String eAtletaTextField = getFrameCadastros().getTxtEatleta().getText();
				
				for (EAtleta ea : listaEatleta) {
					if (ea.getNome().equals(eAtletaTextField)) {
						System.out.println("repetido");
						return;
					}
				}
				
				dao.inserir("eatleta", "nome_eatleta", eAtletaTextField);
				int id = dao.ultimoID("eatleta", "id_eatleta");				

				EAtleta eAtleta = new EAtleta(getFrameCadastros().getTxtEatleta().getText());
				//adicionando id para evitar inconsistencias de dados
				eAtleta.setId(id);

				// adicionar na lista, no model e no combobox do frame torneios e banco de dados
				listaEatleta.add(eAtleta);
				getFrameTorneios().getTxtEatleta().addItem(eAtleta);
				getFrameCadastros().getModelEatletas().addElement(eAtleta);
				getFrameCadastros().getTxtEatleta().setText("");

			}
		});
		// descadastrar clube
		getFrameCadastros().getBtnApagarClube().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Clube clube = getFrameCadastros().getJlstClubes().getSelectedValue();
				int id = clube.getId();
				String clubeNoJlist = clube.getNome();

				// remove da lista, jlist e combobox da frame torneios

				getFrameCadastros().getModelClubes().removeElement(clube);
				getFrameTorneios().getTxtClube().removeItem(clube);
				for (int i = 0; i < listaClubes.size(); i++) {
					String clubeNaLista = listaClubes.get(i).getNome();
					if (clubeNaLista.equals(clubeNoJlist)) {
						listaClubes.remove(i);
					}
				}
				//remove do banco de dados
				dao.excluir("clube", "id_clube", id);

			}
		});
		// descadastrar EAtleta
		getFrameCadastros().getBtnApagarEatleta().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = getFrameCadastros().getJlstEatleta().getSelectedIndex();
				String eAtletaNoJlist = getFrameCadastros().getModelEatletas().get(index).getNome();
				getFrameCadastros().getModelEatletas().remove(index);
				getFrameTorneios().getTxtEatleta().removeItemAt(index);
				
				for (int i = 0; i < listaEatleta.size(); i++) {
					String eAtletaNaLista = listaEatleta.get(i).getNome();
					if (eAtletaNoJlist.equals(eAtletaNaLista)) {
						dao.excluir("eatleta", "id_eatleta", listaEatleta.get(i).getId());
						listaEatleta.remove(i);
						
					}
				}
				
			}
		});

		getFrameCadastros().getBtnTelaPrincipal().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarFrameTorneios();
			}
		});

	}

	private boolean seTorneioFoiDisputado() {
		boolean foiDisputado = false;
		for (Partida partida : listaPartidas) {
			String torneioTxtField = getFrameTorneios().getTxtNomeTorneio().getText();
			String torneioPartida = partida.getAnfitriao().getTorneio().getNome();
			if (torneioPartida.equals(torneioTxtField)) {
				foiDisputado = true;
				break;
			}
		}
		return foiDisputado;
	}

	public FrameCadastros getFrameCadastros() {
		return frameCadastros;
	}

	public FrameTorneios getFrameTorneios() {
		return frameTorneios;
	}

	public FramePartidas getFramePartidas() {
		return framePartidas;
	}

	public void iniciarFrameTorneios() {
		getFrameTorneios().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrameTorneios().setSize(800, 600);
		getFrameTorneios().setVisible(true);
	}

	public void iniciarFrameCadastros() {
		getFrameCadastros().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrameCadastros().setSize(800, 600);
		getFrameCadastros().setVisible(true);
	}

	public void iniciarFramePartidas() {
		getFramePartidas().setVisible(true);
		getFramePartidas().setSize(800, 600);
		getFramePartidas().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void preencherComboBox() {
		
		for(Clube c: listaClubes) {
			getFrameTorneios().getTxtClube().addItem(c);
		}
		
		for(EAtleta eat : listaEatleta) {
			getFrameTorneios().getTxtEatleta().addItem(eat);
		}
		
	}


}
