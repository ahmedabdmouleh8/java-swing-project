package projet_java;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;  
public class intro extends JFrame
{
  JProgressBar progress;  
  
  intro()
  {
  	setTitle("TTFU");
 
    progress = new JProgressBar(0,1000);
    progress.setForeground(Color.GREEN);
   
    progress.setBounds(43,200,698,30);
     
    progress.setValue(0);  
   
    progress.setStringPainted(true);  
    
    getContentPane().add(progress);  
    setSize(789,358);  
    getContentPane().setLayout(null);  
    
    JLabel lblNewLabel = new JLabel("bienvenue dans notre centre de formation");
    lblNewLabel.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 21));
    lblNewLabel.setBounds(140, 43, 567, 30);
    getContentPane().add(lblNewLabel);
    setResizable(false);
    JLabel lblNewLabel_1 = new JLabel("TTFU");
    lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 22));
    lblNewLabel_1.setBounds(322, 95, 138, 30);
    getContentPane().add(lblNewLabel_1);
  }  
  
  
  public void loop()
  {
    int i=0; 
    while(i <= 10000)
    {
      
      progress.setValue(i);  
      i = i + 10;  
      try
      {
       
        Thread.sleep(10);
      }
      
      catch(Exception e){}
    }
    identification a = new identification();
	a.setVisible(true);
	setVisible(false);
    
  }
  
  public static void main(String[] args) 
  {  
    intro frame = new intro();  
    frame.setVisible(true);  
    frame.loop(); 
	
    
  }  
}