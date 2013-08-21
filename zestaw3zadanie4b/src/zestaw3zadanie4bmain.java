import java.io.*;

public class zestaw3zadanie4bmain
{
	public static void main(String[] args) 
	{
		try 
		{
		FileInputStream czytaj = new FileInputStream("test.txt");
		int tmp = 0;
			while ((tmp = czytaj.read()) != -1)
			{
				System.out.print((char)tmp);
			}
		}
		catch (IOException e) 
		{
			System.out.println(e.getMessage());
		}
	}
}
