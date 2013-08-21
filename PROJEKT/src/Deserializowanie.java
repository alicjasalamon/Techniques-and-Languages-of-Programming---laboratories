import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Deserializowanie 
{
	DaneMenagera deserializuj(String naz)
	{
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		DaneMenagera dm = null;
		try
		{
			fis=new FileInputStream(naz);
			ois=new ObjectInputStream(fis);
			dm=(DaneMenagera)ois.readObject();
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
	return dm;
	}
}