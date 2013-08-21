import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class z4 extends JPanel
{
	public JTable table;
	DaneMenagera dmen = null;
	Zakladki ojciec =null;	
	Object [][] dane = new Object[10][4];
	String kateg[] ={"Ogólem","Artyku³y spo¿ywcze", "Kosmetyki", "Ubrania/Buty",
            "RTV/AGD", "Komunikacja miejska", "Zajecia dodatkowe", 
            "Artykuly papiernicze/ druk", "Rozrywka", "inne" };
	String[] naglowki = {"kategoria", "Procent zuzycia", "wydane", "pozostalo"};
	
	public z4(DaneMenagera dmen, Zakladki o) 
	{
		ojciec = o;
		this.dmen = dmen;

			
		JProgressBar[] slupki = new JProgressBar[10];
		
		 for(int i=0; i<10; i++)
	     {
			 JProgressBar prog = new JProgressBar(0,100);
	 	     prog.setValue(dmen.stat[i].zuzycieStat);
	 	     slupki[i]=prog;
	     }
	
		for(int i=0;i<10;i++)
		{
			dane[i][0]=kateg[i];
			dane[i][1]=createBar(dmen.stat[i].zuzycieStat, dmen.stat[i].zuzycieStat.toString());
			dane[i][2]=dmen.stat[i].wydaneStat;
			dane[i][3]=dmen.stat[i].pozostaloStat;
		}
		

		table = new JTable(dane, naglowki);
		table.getColumn("Procent zuzycia").setCellRenderer(new ProgRenderer());
		table.setEnabled(false);
		table.setAutoCreateRowSorter(true);

		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);

		this.add(scrollPane);
		
		for(int i=0; i<naglowki.length; i++)
            table.getColumnModel().getColumn(i).setCellRenderer(new CenterRenderer());
	}
	
	void aktualizuj()
	{
		Deserializowanie de = new Deserializowanie();
		dmen = de.deserializuj(ojciec.Name);

		ojciec.jtp.invalidate();
        ojciec.jtp.remove(ojciec.z4);
        ojciec.z4 = new z4(dmen, ojciec);
        
		table = new JTable(dane, naglowki);
        ojciec.jtp.addTab("STATYSTYKA", ojciec.z4);       
        ojciec.jtp.revalidate();
        ojciec.jtp.repaint(); 
	}
	
	void wyzeruj()
	{
		
		for(int i=0;i<10;i++)
		{
			dane[i][0]=kateg[i];
			dane[i][1]=createBar(dmen.stat[i].zuzycieStat, dmen.stat[i].zuzycieStat.toString());
			dane[i][2]=dmen.stat[i].wydaneStat;
			dane[i][3]=dmen.stat[i].pozostaloStat;
		}
		
	}
	
	  public JProgressBar createBar(int percentDone, String text)
	  {
	        JProgressBar progressBar = new JProgressBar(0, 100);
	                
	        progressBar.setStringPainted(true);
	        progressBar.setValue(percentDone);
	        progressBar.setString(text);
	        
	        return progressBar;
	    }
	}

class ProgRenderer implements TableCellRenderer
{
    public Component getTableCellRendererComponent(JTable table, Object value, 
    		boolean isSelected, boolean hasFocus, int row, int column)
    {
        return (JProgressBar)value;
    }
}

class CenterRenderer implements TableCellRenderer 
{
	 public Component getTableCellRendererComponent(JTable table, Object value,
			 boolean isSelected, boolean hasFocus, int row, int column) 
	 {
		 if(value instanceof JLabel) 
		 {
			 JLabel lab = (JLabel)value;
             lab.setHorizontalAlignment(JLabel.CENTER);
              return lab;
         } else if(value instanceof Component) 
         {
        	 return (Component)value;
         }
         return new JLabel(String.valueOf(value),JLabel.CENTER);
    }
}