package gui;

import java.awt.*;

import javax.swing.*;

public class ControleLabel extends JFrame{

	public ControleLabel() {
		super("Label");
		Container c = getContentPane();
		JLabel simples = new JLabel("Label Simples");
		simples.setToolTipText("Meu tooltip");
		
		Font fonte = new Font("serif", Font.BOLD | Font.ITALIC, 12);
		JLabel label = new JLabel("Outro Label");
		label.setFont(fonte);
		label.setForeground(Color.BLUE);
		ImageIcon icon = 
				new ImageIcon(getClass().getResource("IMG_20171118_171207447_HDR.jpg"));
		JLabel imagem = new JLabel(icon);
		
		c.setLayout(new FlowLayout());
		c.add(simples);
		c.add(label);
		c.add(imagem);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ControleLabel();
	}

}
