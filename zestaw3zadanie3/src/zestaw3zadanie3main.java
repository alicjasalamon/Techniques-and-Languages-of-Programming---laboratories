import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class zestaw3zadanie3main 
{
	public static void main(String[] args) throws IOException
	{
		FileReader r = new FileReader("plik.csv");
		WczytywanieTabeli wczytywanie = new WczytywanieTabeli(r);
		List<Rekord> stworzonaTabela = wczytywanie.wczytajOsoby();
		System.out.println(stworzonaTabela.get(0).wczytajWartoscDlaKLucza("drugie"));
	}
}
