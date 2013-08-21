import java.io.ObjectOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Serializowanie 
{
	void serializuj(DaneMenagera dm)
	{
        
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		try
		{
			fos=new FileOutputStream(dm.nazwa);
			oos=new ObjectOutputStream(fos);
			oos.writeObject(dm);
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
