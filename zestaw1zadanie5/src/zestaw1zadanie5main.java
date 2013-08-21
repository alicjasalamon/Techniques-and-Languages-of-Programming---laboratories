
public class zestaw1zadanie5main 
{
	public static void main(String[] args)
    {
        Composite Katalog = new Composite("Katalog G³ówny");
  
        Composite PKatalog1 = new Composite("Podkatalog1");
        PKatalog1.dodaj(new Leaf("Plik4"));
        PKatalog1.dodaj(new Leaf("Plik5"));

        Composite PKatalog2 = new Composite("Podkatalog2");
        PKatalog2.dodaj(new Leaf("Plik6"));
        
        PKatalog1.dodaj(PKatalog2);
        Katalog.dodaj(PKatalog1);
        

        Katalog.dodaj(new Leaf("Plik1"));
        Katalog.dodaj(new Leaf("Plik2"));
        Katalog.dodaj(new Leaf("Plik3"));
    
        Katalog.rysuj(1);
    }
	
}
