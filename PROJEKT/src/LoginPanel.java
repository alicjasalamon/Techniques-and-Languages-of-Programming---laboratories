import java.awt.BorderLayout;  
import java.awt.GridBagConstraints;  
import java.awt.GridBagLayout;  
import java.awt.GridLayout;  
  
import javax.swing.JButton;  
import javax.swing.JLabel;  
import javax.swing.JPanel;  
import javax.swing.JPasswordField;  
import javax.swing.JTextField;  
  
public class LoginPanel extends JPanel 
{  
    private JTextField nameField;  
    public JPasswordField passField;  
    public JButton loginButton; 
    private LoginListener listener;  
  
    public String getName() 
    {  
        return nameField.getText();  
    }  
  
    public String getPassword() 
    {  
        String password = "";  
        char[] pass = passField.getPassword();  
        for(int i=0; i<pass.length; i++) 
        {  
            password += pass[i];  
        }  
        return password;  
    }  
  
    public LoginPanel(LoginListener listener) 
    {  
        super();  
        GridBagLayout gridBag = new GridBagLayout();  
        GridBagConstraints constraints = new GridBagConstraints();  
        constraints.fill = GridBagConstraints.CENTER;  
        gridBag.setConstraints(this, constraints);  
        setLayout(gridBag);  
        this.listener = listener;  
        this.listener.setPanel(this);
        
        JLabel name = new JLabel("Login: ");  
        JLabel password = new JLabel("Haslo: ");  
        nameField = new JTextField();  
        passField = new JPasswordField();   
      
        JPanel inputPanel = new JPanel();  
        inputPanel.setLayout(new GridLayout(2, 2));  
        inputPanel.add(name);  
        inputPanel.add(nameField);  
        inputPanel.add(password);  
        inputPanel.add(passField);  
        
        loginButton = new JButton("          Zaloguj         ");  
        loginButton.addActionListener(this.listener);
        JPanel parentPanel = new JPanel();  
        parentPanel.setLayout(new BorderLayout());  
        parentPanel.add(inputPanel, BorderLayout.CENTER);  
        parentPanel.add(loginButton, BorderLayout.SOUTH);
      
        this.add(parentPanel);  
    }  
   
}  