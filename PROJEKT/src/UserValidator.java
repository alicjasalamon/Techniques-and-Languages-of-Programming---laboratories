public class UserValidator 
{  
    private static final String[] name = {"Alicja", "PanJarzab", "misiek"};  
    private static final String[] password = {"qazwsx", "qazwsx", "misiek"}; 
  
    public static boolean authenticate(String n, String p) 
    {  
    	for(int i=0; i<3; i++)
    	{
    		if(UserValidator.name[i].equals(n) & UserValidator.password[i].equals(p))  
            return true; 
    	}
        return false;  
    }  
}