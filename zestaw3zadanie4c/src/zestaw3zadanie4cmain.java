import java.io.File;
import java.io.RandomAccessFile;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;


public class zestaw3zadanie4cmain
{
	Timer timer;
	public zestaw3zadanie4cmain(int seconds) 
	{
		timer = new Timer();
		timer.schedule(new RemindTask(),1000 , seconds*1000);
	}
	
	class RemindTask extends TimerTask 
	{
		public void run() 
		{
			try 
			{

				RandomAccessFile randomFile = new RandomAccessFile("czytanie.txt", "r");
				long numberOfLines = 5;
				long lineno = 0;
				String str;
				String outstr;
				StringBuilder sb = new StringBuilder();
				Map<Long, String> strmap = new HashMap<Long, String>();
				while ((str = randomFile.readLine()) != null) 
				{
					strmap.put(lineno + 1, str);
					lineno++;
				}
	        
				long startPosition = lineno - numberOfLines;
				
				while (startPosition <= lineno) 
				{
					if (strmap.containsKey(startPosition)) 
					{
						outstr = (String) strmap.get(startPosition);
						sb.append(outstr);
						System.out.println(outstr);
					}
					startPosition++;
				}
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
			
		
		}
	
	public static void main(String args[]) 
	{
		new zestaw3zadanie4cmain(5);
	}
}
