import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;

class z3 extends JPanel 
{
	JTextField budzettext = new JTextField();
	ArrayList <JSlider> suwaki = new ArrayList<JSlider>();
	DaneMenagera dmen = null;
	JButton przyciskDodawania = new JButton("Zmieñ ustawienia"); 
	JButton nowyMiesiac = new JButton("Nowy miesiac"); 
	Zakladki ojciec=null;
	   
	z3(DaneMenagera dmen, Zakladki o)
	{
		ojciec=o;
		this.dmen = dmen;

		for(int i=0; i<9; i++)
		{
			JSlider suwak = new JSlider(0,40,(int)o.dm.ustawienia[i+1]);
			suwak.setMajorTickSpacing(10);
			suwak.setMinorTickSpacing(1);
			suwak.setPaintTicks(true);
			suwak.setPaintLabels(true);
			Font font = new Font("Arial", Font.BOLD, 8);
			suwak.setFont(font);
			suwaki.add(suwak);
		}
			
		JLabel budzet = new JLabel("Miesiêczny budzet: ");  
		JLabel kategoria = new JLabel(""); 
		String[] kategorie= dmen.kategorie;
	
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(10,2));
    
		inputPanel.add(budzet);  
		inputPanel.add(budzettext); 

		JPanel inputPanel2 = new JPanel();
		inputPanel2.setLayout(new GridLayout(1,2));
		   	
		inputPanel2.add(przyciskDodawania);  
		inputPanel2.add(nowyMiesiac); 
		   	
		for(int i=0; i<9; i++)
		{
			kategoria = new JLabel(kategorie[i]);
			inputPanel.add(kategoria);
			inputPanel.add(suwaki.get(i));
		}
 
		JPanel parentPanel = new JPanel();  
		parentPanel.setLayout(new BorderLayout());  
		parentPanel.add(inputPanel, BorderLayout.CENTER);
		parentPanel.add(inputPanel2, BorderLayout.SOUTH); 
	    this.add(parentPanel);
	}
	
	void aktualizuj()
	{
		Deserializowanie de = new Deserializowanie();
		dmen = de.deserializuj(ojciec.Name);

		ojciec.jtp.invalidate();
        ojciec.jtp.remove(ojciec.z3);
        ojciec.z3 = new z3(dmen, ojciec);
        ojciec.jtp.addTab("USTAWIENIA", ojciec.z3);       
        ojciec.jtp.revalidate();
        ojciec.jtp.repaint(); 
	}
}