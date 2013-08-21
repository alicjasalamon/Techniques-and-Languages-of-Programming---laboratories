import javax.swing.JFrame;  
import javax.swing.JPanel;  
  
public class LoginFrame extends JFrame 
{  

    public LoginFrame() 
    {  
    	super( "PANEL LOGOWANIA" );
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,200);
		setLocation(500,200);
		setResizable(false);

		LoginListener listener = new LoginListener(this);  
        JPanel loginPanel = new LoginPanel(listener);  

	    add(loginPanel);
		setVisible(true);
	    
    }  
}  