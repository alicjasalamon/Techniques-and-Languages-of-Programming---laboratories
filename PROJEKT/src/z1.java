import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class z1 extends JPanel 
{
	Zakladki ojciec = null;
	//BufferedImage image1;
	JTextField nazwaWydatku = new JTextField();  
	JTextField kwotaPole = new JTextField(); 
	DaneMenagera dmen = null;
    JButton przyciskDodawania = new JButton("Dodaj wydatek"); 
	JComboBox kateg = new JComboBox();
        
	public z1(DaneMenagera dmen, Zakladki o) 
	{
		ojciec = o;
		kateg = new JComboBox(dmen.kategorie);

		this.dmen = dmen;
		JLabel nazwa = new JLabel("Nazwa wydatku: ");  
		JLabel kategoria = new JLabel("Nazwa kategorii: "); 
		JLabel kwota = new JLabel("Kwota: "); 
	    JPanel inputPanel = new JPanel();  
	    inputPanel.setLayout(new GridLayout(3, 2));  
	        
	    inputPanel.add(nazwa);  
	    inputPanel.add(nazwaWydatku);  
	    inputPanel.add(kwota);
	    inputPanel.add(kwotaPole);
	    inputPanel.add(kategoria);  
	    inputPanel.add(kateg);  
	  
	    JPanel parentPanel = new JPanel();  
	    parentPanel.setLayout(new BorderLayout());  
	    parentPanel.add(inputPanel, BorderLayout.CENTER);  
	    parentPanel.add(przyciskDodawania, BorderLayout.SOUTH);  
	      
	    this.add(parentPanel);
	}
}