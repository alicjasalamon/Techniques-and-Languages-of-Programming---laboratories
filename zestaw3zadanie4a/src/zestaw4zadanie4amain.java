import java.io.*;
import java.util.zip.*;

public class zestaw4zadanie4amain 
{
	//----------------------KOMPRESOWANIE------------------------//
	static void compress(String input, String output) 
	{										
		try 
		{
			GZIPOutputStream out = new GZIPOutputStream(new FileOutputStream(output));	
			FileInputStream in =  new FileInputStream(input);
			byte[] buffer = new byte[1024];
			int length;
			
			while ((length = in.read(buffer)) > 0) 
			{
				out.write(buffer, 0, length);
			}
			out.finish();
			out.close();
		} 
		catch(IOException e) 
		{
			System.out.println(e.getMessage());
		}
	}
	
	//--------------------DEKOMPRESOWANIE------------------------//
	static void uncompress(String input, String output) 
	{
		try 
		{
			GZIPInputStream in = new GZIPInputStream(new FileInputStream(input));
			OutputStream out = new FileOutputStream(output);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = in.read(buffer)) > 0) 
			{
				out.write(buffer, 0, length);
			}
			
			in.close();
			out.close();
		} 
		
		catch(IOException e) 
		{
			System.out.println(e.getMessage());	
		}
	}
	
	public static void main(String args[]) 
	{
		if (args.length == 0) 
		{
			System.out.println("U¿ycie: mainik compress/uncompress input output");
			System.exit(1);
		}
		
		if (args[0].equals("compress")) 
		{
			compress(args[1], args[2]);
		} 
		else if (args[0].equals("uncompress")) 
		{
			uncompress(args[1], args[2]);
		} 
		else 
		{
			System.out.println("Z³y argument wywo³ania.");
		}
	}
}