/**
 * 
 */
package estudos;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Francisco Giovanildo Teixeira de Souza
 *
 */
public class ControleTextArea extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextArea texto;

	/**
	 * exercicio sobre text area
	 */
	public ControleTextArea() {	
		super("Controle Text �rea");
		
		texto = new JTextArea();
		JScrollPane rolar = new JScrollPane(texto);
		
		texto.setFont(new Font("Serif", Font.PLAIN, 26));
		
		JButton botao = new JButton("Abrir Arquivo");
		botao.setFont(new Font("Serif", Font.PLAIN, 26));
		botao.addActionListener(this);
		
		Container c = getContentPane();
		
		c.add(BorderLayout.SOUTH, botao);
		c.add(BorderLayout.CENTER, rolar);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500,300);
		setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ControleTextArea();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser c = new JFileChooser();
		c.showOpenDialog(this);
		File file = c.getSelectedFile();
		try {
			Path path = Paths.get(file.getAbsolutePath());
			Files.readAllBytes(path);
			String retorno = new String(Files.readAllBytes(path));
			texto.setText(retorno);
		} catch (Exception erro){
			JOptionPane.showMessageDialog(this, "Erro");
		}
	}

}
