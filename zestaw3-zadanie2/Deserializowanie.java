import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Deserializowanie 
{
	public static void main(String[] args)
	{
		ListaDoSerializacji lista2 = new ListaDoSerializacji();
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		try
		{
			fis=new FileInputStream("test.ser");
			ois=new ObjectInputStream(fis);
			lista2=(ListaDoSerializacji)ois.readObject();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) 
		{
		   e.printStackTrace();
		}
		finally
		{
			try
			{
				if(ois!=null)ois.close();
				
			}
			catch(IOException e){};
			try
			{
				if(fis!=null)fis.close();
				
			}
			catch(IOException e){};
			
		}
		lista2.wyswietlaj();
	}
}