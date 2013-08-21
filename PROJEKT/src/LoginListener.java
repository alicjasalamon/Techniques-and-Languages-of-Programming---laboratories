import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
  
import javax.swing.JFrame;  
import javax.swing.JPanel;  
import javax.swing.SwingUtilities;  
  
public class LoginListener implements ActionListener 
{   
    private JFrame frame;  
    private LoginPanel loginPanel;  
  
    public void setPanel(LoginPanel loginPanel) 
    {  
        this.loginPanel = loginPanel;  
    }  
  
    public LoginListener(JFrame frame) 
    {  
        this.frame = frame;  
    }  
  
    @Override  
    public void actionPerformed(ActionEvent event) 
    {  
    	final String name = loginPanel.getName();  
	    String password = loginPanel.getPassword();
	    System.out.println("tu jestem1");
	    if (UserValidator.authenticate(name, password)) 
	    {  
	    	System.out.println("tu jestem");
	        SwingUtilities.invokeLater(new Runnable() 
	        {  
	            @Override  
	            public void run() 
	            {  
	                frame.setVisible(false); 
	                frame = new Zakladki(name); 
	                frame.validate();  
	            }  
	        });   
    	}
    }
}  