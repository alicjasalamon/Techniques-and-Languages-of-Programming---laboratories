
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class Singleton
{
    private static int i = 0;
    private static int number;
    private static Singleton _soleInstances[] = null;


    private static int idx = 0; 

	private int instance_number = 0;

    static
    {
	try 
	{
	    Properties props = new Properties() ;
	    props.load( new FileInputStream("konfig.properties") );
	    String s = props.getProperty("singleton_count");

	    number = Integer.parseInt(s);

	    _soleInstances = new Singleton[number];

	    for ( int i=0; i<number;i++) 
		_soleInstances[i] = new Singleton();
	}
	catch (Exception iox) 
	{
	     iox.printStackTrace();
	}
    }

    private Singleton() {
	instance_number = i++;
   }
       
    public static Singleton getInstance()
    {
	System.out.println("idx=" + idx);
	return _soleInstances[idx++% number];
    }

    public void invoke() 
    {
    	System.out.println("ja super singleton! z i=" + instance_number);
    }
    
    ////////////////////////////////////////////////////////////////////////
    
    public static void main(String argv[])
    {
    	for (int i= 0;i<10;i++)
    		Singleton.getInstance().invoke();
	   
 }
}
