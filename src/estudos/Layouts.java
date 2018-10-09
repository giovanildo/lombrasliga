package estudos;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.*;

public class Layouts extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Layouts() {
		super("Layouts");
		Container c = getContentPane();
		BorderLayout border = new BorderLayout();
		c.setLayout(new FlowLayout());
		c.add(new JButton("1"));
		c.add(new JButton("2"));
		c.add(new JButton("3"));
		c.add(new JButton("4"));
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(300,300);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Layouts();
	}

}
