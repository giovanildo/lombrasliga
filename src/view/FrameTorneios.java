package view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JList;

import model.EAtleta;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class FrameTorneios extends JFrame{
	public FrameTorneios() {
		getContentPane().setLayout(null);
		
		JLabel lblTorneiosAnteriores = new JLabel("Torneios Anteriores ");
		lblTorneiosAnteriores.setBounds(65, 11, 154, 14);
		getContentPane().add(lblTorneiosAnteriores);
		
		JList list = new JList<EAtleta>();
		list.setBounds(78, 89, 1, 1);
		getContentPane().add(list);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(21, 42, 97, 21);
		getContentPane().add(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		mnNewMenu.setBounds(21, 41, 107, 22);
		getContentPane().add(mnNewMenu);
		
		JMenu mnTeste = new JMenu("teste");
		mnTeste.setBounds(21, 117, 107, 22);
		getContentPane().add(mnTeste);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
