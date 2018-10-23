package controller;

import javax.swing.JFrame;

import model.Clube;
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


	public void iniciar() {	
		
		
		
		getFrameTorneios().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrameTorneios().setSize(800, 600);
		getFrameTorneios().setVisible(true);		
		getFrameTorneios().getTxtClube().addItem(new Clube("barcelona"));
		
		
		
		
	}
}
