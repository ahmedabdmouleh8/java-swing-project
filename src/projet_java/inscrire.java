package projet_java;
import java.sql.*;
import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class inscrire extends JFrame {

	 JPanel contentPane;
	 JPasswordField mdp;
	 JPasswordField mdp2;
	 JFrame frame;
	static Connection con;
	 JTable table;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

			//	System.out.println("donner le nom de votre base de données");
			//	Scanner scanner = new Scanner(System.in);
			//	String  base = scanner.next();
			
				//intro a=new intro();
			//	System.out.println(a.getnom());
				
				try {
					inscrire frame = new inscrire();
					frame.setVisible(true);

				//	con = DriverManager.getConnection("jdbc:mysql://localhost/"+a.getnom(),"root","root");
					con = DriverManager.getConnection("jdbc:mysql://localhost/centre_de_formation","root","root");
					Statement st=con.createStatement();
					System.out.println("connection reussie");
					
				} catch (Exception e) {
					e.printStackTrace();
					showMessageDialog(null, "ce nom de base de donne n'existe pas");
					System.exit(0);
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public inscrire() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 913, 796);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 240));
		panel.setBounds(10, 10, 889, 87);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("cr\u00E9er un nouveau compte");
		lblNewLabel.setFont(new Font("Sylfaen", Font.ITALIC, 34));
		panel.add(lblNewLabel);
		
		JEditorPane cin = new JEditorPane();
		cin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cin.setBounds(150, 169, 197, 31);
		contentPane.add(cin);
		
		JLabel lblNewLabel_1 = new JLabel("CIN");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(42, 169, 70, 26);
		contentPane.add(lblNewLabel_1);
		
		JComboBox box1 = new JComboBox();
		box1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		box1.setModel(new DefaultComboBoxModel(new String[] {"", "Etudiant", "Formateur", "autre"}));
		box1.setBounds(283, 119, 128, 31);
		contentPane.add(box1);
		
		JLabel lblNewLabel_1_1 = new JLabel("NOM");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_1.setBounds(42, 250, 70, 26);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("PRENOM");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_2.setBounds(42, 327, 98, 26);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("ADDRESSE MAIL");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_3.setBounds(42, 414, 197, 26);
		contentPane.add(lblNewLabel_1_3);
		
		JEditorPane nom = new JEditorPane();
		nom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nom.setBounds(150, 250, 197, 31);
		contentPane.add(nom);
		
		JEditorPane prenom = new JEditorPane();
		prenom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		prenom.setBounds(150, 327, 197, 31);
		contentPane.add(prenom);
		
		JEditorPane mail = new JEditorPane();
		mail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mail.setBounds(283, 409, 296, 31);
		contentPane.add(mail);
		
		JLabel lblNewLabel_1_4 = new JLabel("NUM TEL");
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_4.setBounds(453, 169, 137, 26);
		contentPane.add(lblNewLabel_1_4);
		
		JEditorPane num_tel = new JEditorPane();
		num_tel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		num_tel.setBounds(641, 169, 197, 31);
		contentPane.add(num_tel);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Genre");
		lblNewLabel_1_4_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_4_1.setBounds(596, 124, 70, 26);
		contentPane.add(lblNewLabel_1_4_1);
		
		JComboBox box2 = new JComboBox();
		box2.setModel(new DefaultComboBoxModel(new String[] {"", "homme", "femme"}));
		box2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		box2.setBounds(695, 124, 128, 31);
		contentPane.add(box2);
		
		JLabel lblNewLabel_1_5 = new JLabel("TYPE DE COMPTE");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_5.setBounds(42, 119, 219, 26);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_4_2 = new JLabel("ADDRESSE");
		lblNewLabel_1_4_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_4_2.setBounds(453, 250, 137, 26);
		contentPane.add(lblNewLabel_1_4_2);
		
		JTextPane addresse = new JTextPane();
		addresse.setBounds(641, 250, 197, 67);
		contentPane.add(addresse);
		
		JButton btnNewButton = new JButton("INSCRIRE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

		
				//if(box1.getSelectedItem().toString()=="")
			//	{
				//	System.out.println("true");
			//	}
				String nomm =nom.getText();
				String cinn = cin.getText();
				int resultat = Integer.parseInt(cinn);
				//

				

				if (resultat<1000000)
				{
					showMessageDialog(null, "priere de donner votre cin");
				}
				if(resultat>1000000 && nom.getText().length()==0)
				{
					showMessageDialog(null, "priere de donner votre nom");
				}
					if(resultat>1000000 && nom.getText().length()>1&& prenom.getText().length()==0)
				{
					showMessageDialog(null, "priere de donner votre prenom");
				}
				if(resultat>1000000 && nom.getText().length()>1&& prenom.getText().length()>1 && mail.getText().contains("@")==false )
				{
					showMessageDialog(null, "priere de donner votre mail exact");
				}
				if(resultat>1000000 && nom.getText().length()>1&& prenom.getText().length()>1 && mail.getText().contains("@")&&mail.getText().contains(".")==false )
				{
					showMessageDialog(null, "priere de donner votre mail exact");
				}
				if(resultat>1000000 && nom.getText().length()>1&& prenom.getText().length()>1 && mail.getText().contains("@")&&mail.getText().contains(".")&& mdp.getText().length()<8 )
				{
					showMessageDialog(null, "priere de donner une mot de passe superieur a 8 caractere");
				}
				if(resultat>1000000 && nom.getText().length()>1&& prenom.getText().length()>1 && mail.getText().contains("@")&&mail.getText().contains(".")&& mdp.getText().length()>8 && mdp.getText().equals(mdp2.getText())==false )
				{
					showMessageDialog(null, "priere de verifier votre mot de passe");
					mdp.setText("");
					mdp2.setText("");
				}
				if(resultat>1000000 && nom.getText().length()>1&& prenom.getText().length()>1 && mail.getText().contains("@")&&mail.getText().contains(".")&& mdp.getText().length()>8 && mdp.getText().equals(mdp2.getText())&& num_tel.getText().length()<8)
				{
					showMessageDialog(null, "priere de donner votre numero");
				}
				if(resultat>1000000 && nom.getText().length()>1&& prenom.getText().length()>1 && mail.getText().contains("@")&&mail.getText().contains(".")&& mdp.getText().length()>8 && mdp.getText().equals(mdp2.getText())&& num_tel.getText().length()>=8 && addresse.getText().length()<7 )
				{
					showMessageDialog(null, "priere de donner votre addresse");
				}
				if(resultat>1000000 && nom.getText().length()>1&& prenom.getText().length()>1 && mail.getText().contains("@")&&mail.getText().contains(".")&& mdp.getText().length()>8 && mdp.getText().equals(mdp2.getText())&& num_tel.getText().length()>=8 && addresse.getText().length()>7 && box1.getSelectedItem().toString()=="")
				{
					showMessageDialog(null, "priere de donner votre type de compte");
				}
				if(resultat>1000000 && nom.getText().length()>1&& prenom.getText().length()>1 && mail.getText().contains("@")&&mail.getText().contains(".")&& mdp.getText().length()>8 && mdp.getText().equals(mdp2.getText())&& num_tel.getText().length()>=8 && addresse.getText().length()>7 && box1.getSelectedItem().toString()!=""&& box2.getSelectedItem().toString()=="")
				{
					showMessageDialog(null, "priere de donner votre genre");
				}
				if(resultat>1000000 && nom.getText().length()>1&& prenom.getText().length()>1 && mail.getText().contains("@")&&mail.getText().contains(".")&& mdp.getText().length()>8 && mdp.getText().equals(mdp2.getText())&& num_tel.getText().length()>=8 && addresse.getText().length()>7 && box1.getSelectedItem().toString()!=""&& box2.getSelectedItem().toString()!="")
				{
					System.out.println("hani lina "); 
					
					String sql="INSERT INTO page_identification VALUES ('"+Integer.parseInt(cin.getText())+"','"+nom.getText()+"','"+prenom.getText()+"','"+mail.getText()+"','"+box1.getSelectedItem().toString()+"','"+box2.getSelectedItem().toString()+"','"+Integer.parseInt(num_tel.getText())+"','"+addresse.getText()+"','"+mdp.getText()+"')";
				                                                                                	
					PreparedStatement pst;
					try {
						con = DriverManager.getConnection("jdbc:mysql://localhost/centre_de_formation","root","root");
						Statement st=con.createStatement();
						System.out.println("connection reussie");
						pst = con.prepareStatement(sql);
						pst.execute();
						showMessageDialog(null, "inscription réussie");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						showMessageDialog(null, e1.getMessage());
					} 
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		
			
		btnNewButton.setBounds(301, 663, 157, 31);
		contentPane.add(btnNewButton);
		
		JButton btnRetourPageDacceuil = new JButton("se connecter");
		btnRetourPageDacceuil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				identification a=new identification();
				a.setVisible(true);
				setVisible(false);
			}
		});
	
			
		btnRetourPageDacceuil.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRetourPageDacceuil.setBounds(530, 663, 304, 31);
		contentPane.add(btnRetourPageDacceuil);
		
		JLabel lblNewLabel_1_4_2_1 = new JLabel("mot de passe");
		lblNewLabel_1_4_2_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_4_2_1.setBounds(42, 486, 162, 26);
		contentPane.add(lblNewLabel_1_4_2_1);
		
		mdp = new JPasswordField();
		mdp.setBounds(283, 486, 296, 29);
		contentPane.add(mdp);
		
		JLabel lblNewLabel_1_4_2_1_1 = new JLabel("confirmer mot de passe");
		lblNewLabel_1_4_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1_4_2_1_1.setBounds(42, 572, 272, 26);
		contentPane.add(lblNewLabel_1_4_2_1_1);
		
		mdp2 = new JPasswordField();
		mdp2.setBounds(324, 569, 296, 29);
		contentPane.add(mdp2);
		
		JButton btnActualiser = new JButton("actualiser");
		btnActualiser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cin.setText("");
				nom.setText("");
				prenom.setText("");
				mail.setText("");
				addresse.setText("");
				num_tel.setText("");
				mdp.setText("");
				mdp2.setText("");
				
			}
		});
		btnActualiser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnActualiser.setBounds(42, 663, 157, 31);
		contentPane.add(btnActualiser);
	}	
}
