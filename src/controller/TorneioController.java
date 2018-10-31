package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import model.Clube;
import model.EAtleta;
import view.FrameCadastros;
import view.FramePartidas;
import view.FrameTorneios;

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

	public TorneioController() {
		super();
		this.frameCadastros = new FrameCadastros();
		this.frameTorneios = new FrameTorneios();
		this.framePartidas = new FramePartidas();
	}

	public FrameCadastros getFrameCadastros() {
		return frameCadastros;
	}

	public void setFrameCadastros(FrameCadastros frameCadastros) {
		this.frameCadastros = frameCadastros;
	}

	public FrameTorneios getFrameTorneios() {
		return frameTorneios;
	}

	public void setFrameTorneios(FrameTorneios frameTorneios) {
		this.frameTorneios = frameTorneios;
	}

	public FramePartidas getFramePartidas() {
		return framePartidas;
	}

	public void setFramePartidas(FramePartidas framePartidas) {
		this.framePartidas = framePartidas;
	}

	public void iniciarFrameTorneios() {
		getFrameTorneios().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrameTorneios().setSize(800, 600);
		getFrameTorneios().setVisible(true);
	}

	public void iniciarFramePartidas() {
		getFramePartidas().setVisible(true);
		getFramePartidas().setSize(800, 600);
		getFramePartidas().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void preencherComboBox() {
		getFrameTorneios().getTxtClube().addItem(new Clube("barcelona"));
		getFrameTorneios().getTxtClube().addItem(new Clube("real"));
		getFrameTorneios().getTxtEatleta().addItem(new EAtleta("fabiano"));
		getFrameTorneios().getTxtEatleta().addItem(new EAtleta("giovanildo"));
	}

	public void iniciar() {

		iniciarFrameTorneios();
		preencherComboBox();

		getFrameTorneios().getBtnEditarPartidas().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarFramePartidas();
			}
		});

		getFrameTorneios().getBtnNovoTorneio().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				getFrameTorneios().getTxtNometorneio().setText("");
//				getFrameTorneios().getTxtPorqueDoNome().setText("");

			}
		});

	}
}
