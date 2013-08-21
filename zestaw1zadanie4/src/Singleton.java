public class Singleton
{
	private int i = 0;
    private static Singleton _soleInstance = null;
    private Singleton() {i++;}
       
    public static Singleton getInstance()
    {
    	if(_soleInstance==null)
    	{
    		_soleInstance =new Singleton();
    	}
    	return _soleInstance;
    }

    public void invoke() 
    {
    	System.out.println("ja super singleton! z i=" + i);
    }
    
    ////////////////////////////////////////////////////////////////////////
    
    public static void main(String argv[])
    {
    	for (int i= 0;i<10;i++)
    		Singleton.getInstance().invoke();
    }
}