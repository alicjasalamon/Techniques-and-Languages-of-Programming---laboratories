import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

class z2 extends JPanel 
{
	JTable table;
	DaneMenagera dmen = null;
	Zakladki ojciec = null;
	Object [][] dane = null;
			
	public z2( DaneMenagera dmen, Zakladki o) 
	{
		this.dmen = dmen;
		ojciec=o;
		Object [][] dane = new Object[dmen.historiaWydatkow.size()][4];
		for(int i=0; i<dmen.historiaWydatkow.size(); i++ )
		{
			dane[i][0]=dmen.historiaWydatkow.get(i).nazwaWydatku;
			dane[i][1]=dmen.historiaWydatkow.get(i).kategoriaWydatku;
			dane[i][2]=dmen.historiaWydatkow.get(i).kwotaWydatku;
			dane[i][3]=dmen.historiaWydatkow.get(i).dataWydatku;
		}
		String[] naglowki = {"nazwa",  "kategoria", "kwota ","data",};
		
		table = new JTable(dane, naglowki);
		table.setEnabled(false);
		table.setAutoCreateRowSorter(true);
		
		JScrollPane scrollPane = new JScrollPane(table);
		table.setFillsViewportHeight(true);
		this.add(scrollPane);
	}

	void aktualizuj()
	{
		Deserializowanie de = new Deserializowanie();
		dmen = de.deserializuj(ojciec.Name);

		ojciec.jtp.invalidate();
        ojciec.jtp.remove(ojciec.z2);
        ojciec.z2 = new z2(dmen, ojciec);
        ojciec.jtp.addTab("HISTORIA", ojciec.z2);       
        ojciec.jtp.revalidate();
        ojciec.jtp.repaint(); 
	}
} 


