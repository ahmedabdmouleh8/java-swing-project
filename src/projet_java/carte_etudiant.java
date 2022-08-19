package projet_java;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class carte_etudiant extends JFrame {

	private JPanel contentPane;
	 JTextField addresse;
	 JTextField nom;
	 static Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		identification id=new identification();
		String email =id.getaddresse();
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					carte_etudiant frame = new carte_etudiant();
					frame.setVisible(true);
					con = DriverManager.getConnection("jdbc:mysql://localhost/centre_de_formation","root","root");
					Statement st=con.createStatement();
					System.out.println("connection reussie");
				} catch (Exception e) {
					e.printStackTrace();
					showMessageDialog(null, "ce nom de base de donne n'existe pas");
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public carte_etudiant() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 923, 714);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		addresse = new JTextField();
		addresse.setBounds(41, 72, 203, 25);
		contentPane.add(addresse);
		addresse.setColumns(10);
		addresse.setEnabled(false);
		
		JLabel lblNewLabel = new JLabel("addresse");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 22));
		lblNewLabel.setBounds(55, 37, 97, 25);
		contentPane.add(lblNewLabel);

		
		JLabel lblPrenom = new JLabel("nom");
		lblPrenom.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 22));
		lblPrenom.setBounds(29, 135, 69, 25);
		contentPane.add(lblPrenom);
		
		nom = new JTextField();
		nom.setBounds(108, 138, 149, 25);
		contentPane.add(nom);
		nom.setColumns(10);
		
		/*
		*/
		JLabel lblNewLabel_1 = new JLabel("prenom");
		lblNewLabel_1.setBounds(41, 208, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JTextPane prenom = new JTextPane();
		prenom.setBounds(108, 208, 149, 19);
		contentPane.add(prenom);
		
		JLabel lblNewLabel_2 = new JLabel("genre");
		lblNewLabel_2.setBounds(41, 257, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("num_tel");
		lblNewLabel_2_1.setBounds(41, 351, 45, 13);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("type");
		lblNewLabel_2_2.setBounds(41, 418, 45, 13);
		contentPane.add(lblNewLabel_2_2);
		
		JTextPane cin = new JTextPane();
		cin.setBounds(108, 286, 149, 19);
		contentPane.add(cin);
		
		JTextPane num_tel = new JTextPane();
		num_tel.setBounds(108, 351, 149, 19);
		contentPane.add(num_tel);
		JTextPane genre = new JTextPane();
		genre.setBounds(108, 257, 149, 19);
		contentPane.add(genre);
		
		JTextPane type = new JTextPane();
		type.setBounds(108, 418, 149, 19);
		contentPane.add(type);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x=addresse.getText();
				
				PreparedStatement pst;
				try{
		          	
			        
			        con = DriverManager.getConnection("jdbc:mysql://localhost/centre_de_formation","root","root");
			            String sql = "Select * from page_identification where addresse_mail ='"+x+"'";
			            pst=con.prepareStatement(sql);  
			            ResultSet rs = pst.executeQuery();
			            if(rs.next()) {
			            	nom.setText(rs.getString(2));
			            	prenom.setText(rs.getString(3));
			            	genre.setText(rs.getString(6));
			            	cin.setText(rs.getString(1));
			            	num_tel.setText(rs.getString(7));
			            	type.setText(rs.getString(5));
			            	
			                
							
			}
		}catch(Exception g)
				{
			
				}
			}}	);
		btnNewButton.setBounds(41, 104, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2_3 = new JLabel("cin");
		lblNewLabel_2_3.setBounds(41, 286, 45, 13);
		contentPane.add(lblNewLabel_2_3);
		
		JButton btnNewButton_1 = new JButton("retourne");
		btnNewButton_1.setBounds(236, 485, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("enregistrer");
		btnNewButton_2.setBounds(506, 485, 85, 21);
		contentPane.add(btnNewButton_2);
		

		
	}
}
