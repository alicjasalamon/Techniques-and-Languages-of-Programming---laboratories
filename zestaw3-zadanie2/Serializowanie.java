import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Serializowanie 
{
	public static void main(String[] args)
	{
		ListaDoSerializacji lista1 = new ListaDoSerializacji();
		
		lista1.dodaj(new KlasaDoSerializacji("a"));
		lista1.dodaj(new KlasaDoSerializacji("b"));
		lista1.dodaj(new KlasaDoSerializacji("c"));
        
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try
		{
			fos=new FileOutputStream("test.ser");
			oos=new ObjectOutputStream(fos);
			oos.writeObject(lista1);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(oos!=null)oos.close();
				
			}
			catch(IOException e){};
			try
			{
				if(fos!=null)fos.close();
				
			}
			catch(IOException e){};
			
		}
		
	}
	
}
