import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Zakladki extends JFrame implements ActionListener
{
	DaneMenagera dm = null;
	JTabbedPane jtp = new JTabbedPane();
	z1 z1 = null;
	z2 z2 = null;
	z3 z3 = null;
	z4 z4 = null;
	String Name = null;
	
	public Zakladki(String name) 
	{
		super( "MANAGER WYDATKOW" );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setLocation(500,200);
		setResizable(false);
		Name=name;
		
		/*dm = new DaneMenagera(Name);
		Serializowanie se = new Serializowanie();
		se.serializuj(dm);*/
		
		Deserializowanie de = new Deserializowanie();
		dm = de.deserializuj(Name);
		
		z1=new z1(dm,this);
		z2=new z2(dm,this);
		z3=new z3(dm,this);
		z4=new z4(dm,this);

		z1.przyciskDodawania.addActionListener(this);
		z3.przyciskDodawania.addActionListener(this);
		z3.nowyMiesiac.addActionListener(this);
		
		jtp.addTab("DODAWNIE WYDATKÓW", z1);
        jtp.addTab("USTAWIENIA", z3);
		jtp.addTab("STATYSTYKA", z4);
		jtp.addTab("HISTORIA", z2);
		
	    add(jtp);
		setVisible(true);
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		if(e.getSource()==z1.przyciskDodawania)
		{
			String st = z1.kwotaPole.getText();
			if(!st.equals(""))
			{
				Wydatek w = new Wydatek(z1.nazwaWydatku.getText(), z1.kateg.getSelectedItem().toString(), new Date(), Double.parseDouble(z1.kwotaPole.getText()));
				boolean b = true;
				Statystyki s = null;
				int i=0;
				while(dm.kategorie[i]!= w.kategoriaWydatku)i++;
				
				s = dm.stat[i+1];
				if((s.pozostaloStat - w.kwotaWydatku)<0) 
				{
					JOptionPane.showMessageDialog(new JFrame("uwaga"), "Nie mo¿esz tyle wydaæ");
					b= false;
				}
				
				if(b==true)
				{
					dm.historiaWydatkow.add(w);
					
					while(dm.kategorie[i]!= w.kategoriaWydatku)i++;
					
					s = dm.stat[0];
					s.wydaneStat=(s.wydaneStat)+(Double.parseDouble(z1.kwotaPole.getText()));
					s.pozostaloStat=(s.pozostaloStat)-(Double.parseDouble(z1.kwotaPole.getText()));
					s.zuzycieStat=(int) ((s.wydaneStat)/((s.wydaneStat)+(s.pozostaloStat))*100);
					
					s = dm.stat[i+1];
					s.wydaneStat=(s.wydaneStat)+(Double.parseDouble(z1.kwotaPole.getText()));
					s.pozostaloStat=(s.pozostaloStat)-(Double.parseDouble(z1.kwotaPole.getText()));
					s.zuzycieStat=(int) ((s.wydaneStat)/((s.wydaneStat)+(s.pozostaloStat))*100);
	
					Serializowanie se = new Serializowanie();
					se.serializuj(dm);
					z4.aktualizuj();
					z2.aktualizuj();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(new JFrame("uwaga"), "Nie podales kwoty");
			}
			
		}
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		else if(e.getSource()==z3.nowyMiesiac)
		{
			int suma = 0;
			String st = z3.budzettext.getText();
			if(!st.equals(""))
			{
				for(int i=0; i<9; i++)
				{
					suma+=z3.suwaki.get(i).getValue();
				}
				if(suma>100)
				{
					JOptionPane.showMessageDialog(new JFrame("uwaga"), "Nie mozna wydac wiecej niz 100%");
				}
				else
				{
					Statystyki s = null;
					dm.kwota=(Double.parseDouble(z3.budzettext.getText()));
					dm.historiaWydatkow = new ArrayList<Wydatek>();
					dm.stat[0]= new Statystyki("Ogó³em",0,0.0,dm.kwota);
					
					for(int i=1;i<9;i++) dm.ustawienia[i]=z3.suwaki.get(i-1).getValue();
					
					for(int i=0; i<10; i++)
					{
						s = dm.stat[i];
						s.wydaneStat=0.0;
						s.pozostaloStat=(dm.kwota*dm.ustawienia[i]/100);
						s.zuzycieStat=0;
					}
		
					Serializowanie se = new Serializowanie();
					se.serializuj(dm);	
					z4.aktualizuj();
					z2.aktualizuj();
				}
			}
			else
			{
				JOptionPane.showMessageDialog(new JFrame("uwaga"), "Nie podales kwoty");
			}
		}
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		else if(e.getSource()==z3.przyciskDodawania)
		{
			String st = z3.budzettext.getText();
			if(!st.equals(""))
			{
				int suma = 0;
				for(int i=0; i<9; i++)
				{
					suma+=z3.suwaki.get(i).getValue();
				}
				if(suma>100)
				{
					JOptionPane.showMessageDialog(new JFrame("uwaga"), "Nie mozna wydac wiecej niz 100%");
				}
				else
				{
					Statystyki s = null;
					dm.kwota=(Double.parseDouble(z3.budzettext.getText()));
					boolean b=true;
					for(int i =0; i<10;i++)
					{
						s = dm.stat[i];
						if((dm.kwota*dm.ustawienia[i]/100)-s.wydaneStat<0) b=false;
					}
					if(b=true)
					{
						JOptionPane.showMessageDialog(new JFrame("uwaga"), "Nie miescisz sie w ramach wydatkow");
					}
					else
					{
						for(int i=1;i<10;i++) dm.ustawienia[i]=z3.suwaki.get(i-1).getValue();
		
						for(int i=0; i<10; i++)
						{
							s = dm.stat[i];
							s.pozostaloStat=(dm.kwota*dm.ustawienia[i]/100)-s.wydaneStat;
							s.zuzycieStat=(int) ((s.wydaneStat)/(s.wydaneStat+s.pozostaloStat)*100);
						}
			
						Serializowanie se = new Serializowanie();
						se.serializuj(dm);	
						z4.aktualizuj();
						z2.aktualizuj();
					}
				}
			}
			else
			{
				JOptionPane.showMessageDialog(new JFrame("uwaga"), "nie podales kwoty");
			}
		}
	}	
}	