package projet_java;
import java.util.*;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.Panel;
import java.awt.Label;
import java.awt.TextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class identification extends JFrame {

	 JPanel contentPane;
	 JPasswordField mdp;
	 JTextField addresse;
	 static Connection con;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					identification frame = new identification();
					frame.setVisible(true);
					inscrire i = new inscrire ();
					con = DriverManager.getConnection("jdbc:mysql://localhost/centre_de_formation","root","root");
					Statement st=con.createStatement();
				} catch (Exception e) {
					e.printStackTrace();
					e.printStackTrace();
					showMessageDialog(null, "ce nom de base de donne n'existe pas");
				}
			}
		});
	}
	public String getaddresse() {
		return addresse.getText();
	}
	public String getmdp() {
		return mdp.getText();
	}

	/**
	 * Create the frame.
	 */
	public identification() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 816, 596);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		Panel panel_1 = new Panel();
		panel_1.setBounds(459, 205, -256, 84);
		contentPane.add(panel_1);
		
		Label label_1 = new Label("Mot De Passe :");
		label_1.setFont(new Font("Ebrima", Font.PLAIN, 30));
		label_1.setBounds(67, 226, 265, 43);
		contentPane.add(label_1);
		
		JButton btnAnnul = new JButton("annuler");
		btnAnnul.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnAnnul.setIcon(null);
		btnAnnul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);;
				

			}
		});
		btnAnnul.setBounds(67, 381, 123, 34);
		contentPane.add(btnAnnul);
		
		JButton btnSeConnecter = new JButton("se connecter");
	
		btnSeConnecter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement pst;
				try{
					con = DriverManager.getConnection("jdbc:mysql://localhost/centre_de_formation?serverTimezone=UTC","root","");
					Statement st=con.createStatement();
		          	
		            String sql = "Select * from page_identification where addresse_mail =? and mdp=?";
		            pst=con.prepareStatement(sql);
		            pst.setString(1,addresse.getText());
		            pst.setString(2,mdp.getText());
		            ResultSet rs = pst.executeQuery();
		            
		            if(rs.next()) {
		            	
		            	System.out.println(rs.getString(5));
		            	String x=rs.getString(5);
		            	if (x.equals("Etudiant")) {
		                JOptionPane.showMessageDialog (null, "bienvenue notre chére etudiant ");
						page_etudiant p=new page_etudiant();
						p.setVisible(true);
						setVisible(false);
						String add = addresse.getText();
						String mot= mdp.getText();
						p.rec.setText(add);
						System.out.println("2");
		            	}
		            	if (x.equals("Formateur")) {
		            		 JOptionPane.showMessageDialog (null, "bienvenue notre chére formateur");
		            		 page_formateur pf=new page_formateur();
		            		 pf.setVisible(true);
		            		 setVisible(false);
		            
		            		 String add = addresse.getText();
								String mot= mdp.getText();
								pf.cmn.setText(add);
		            	}
		            	if (x.equals("autre")) {
		            		JOptionPane.showMessageDialog (null, "email et mot de passe correct");
		            		 page_other pf=new page_other();
		            		 pf.setVisible(true);
		            		 setVisible(false);
		            		
		            	}
		            	
		                
		            }
		            else {
		            	JOptionPane.showMessageDialog(null, "email or mdp ne sont pas correct");
		            	addresse.setText ("");
		            	mdp.setText ("");
		            }
		            
		    
				}catch(Exception f)
				{
					JOptionPane.showMessageDialog(null, f.getMessage());
					}}});
				
		btnSeConnecter.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnSeConnecter.setBounds(532, 381, 199, 34);
		contentPane.add(btnSeConnecter);
		
		mdp = new JPasswordField();
		mdp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mdp.setBounds(392, 239, 227, 28);
		contentPane.add(mdp);
		
		addresse = new JTextField();
		addresse.setFont(new Font("Tahoma", Font.PLAIN, 20));
		addresse.setBounds(392, 142, 227, 28);
		contentPane.add(addresse);
		addresse.setColumns(10);
		
		JButton btnMotDePasse = new JButton("mot de passe oubli\u00E9");
		btnMotDePasse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mot_de_passe_oublier m=new mot_de_passe_oublier();
				m.setVisible(true);
				setVisible(false);
			}
		});
		btnMotDePasse.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnMotDePasse.setBounds(266, 381, 227, 34);
		contentPane.add(btnMotDePasse);
		
		JButton btnCrerUnCompte = new JButton("cr\u00E9er un compte");
		btnCrerUnCompte.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inscrire a =new inscrire ();
				a.setVisible(true);
				setVisible(false);
			}
		});
		btnCrerUnCompte.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnCrerUnCompte.setBounds(266, 461, 227, 34);
		contentPane.add(btnCrerUnCompte);
		
		JLabel lblNewLabel = new JLabel("Bienvenue Dans Notre Centre De Formation");
		lblNewLabel.setBounds(36, 38, 732, 52);
		contentPane.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 0, 255));
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 48));
		
		Label label_1_1 = new Label("Adresse :");
		label_1_1.setFont(new Font("Ebrima", Font.PLAIN, 30));
		label_1_1.setBounds(67, 129, 253, 43);
		contentPane.add(label_1_1);
	}
}
