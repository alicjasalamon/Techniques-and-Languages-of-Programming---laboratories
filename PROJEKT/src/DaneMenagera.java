import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class DaneMenagera implements Serializable
{
	public String nazwa = "nazwa";
	public double kwota = 1500;
	public String[] kategorie= { "Artyku³y spo¿ywcze", "Kosmetyki", "Ubrania/Buty",
            "RTV/AGD", "Komunikacja miejska", "Zajecia dodatkowe", 
            "Artykuly papiernicze/ druk", "Rozrywka", "inne" };
	public List<Wydatek> historiaWydatkow = new ArrayList<Wydatek>();
	public Integer[] ustawienia = {100, 30, 10, 10, 5, 5, 10, 10, 10, 10};
	public Statystyki[] stat = new Statystyki[10];
	public double suma = 0;
	
	public DaneMenagera(String n) 
	{
		nazwa=n;
		stat[0]= new Statystyki("Ogó³em",0,0.0,kwota);
		for(int i=1; i<10; i++)
		{
			stat[i]= new Statystyki(kategorie[i-1], 0, 0.0, kwota*ustawienia[i]/100);
		}
	}	
}

class Wydatek implements Serializable
{
	String nazwaWydatku;
	String kategoriaWydatku;
	Date dataWydatku;
	double kwotaWydatku;
	
	Wydatek(String w, String k, Date d, double kw)
	{
		nazwaWydatku=w;
		kategoriaWydatku=k;
		dataWydatku=d;
		kwotaWydatku=kw;
	}
}

class Statystyki implements Serializable
{
	String kategoriaStat;
	Integer zuzycieStat;
	Double wydaneStat;
	Double pozostaloStat;
	
	Statystyki(String k, Integer z, Double w, Double p)
	{
		kategoriaStat=k;
		zuzycieStat=z;
		wydaneStat=w;
		pozostaloStat=p;
	}
}