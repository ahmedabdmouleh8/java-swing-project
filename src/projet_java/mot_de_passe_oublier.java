package projet_java;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JScrollPane;

public class mot_de_passe_oublier extends JFrame {

	 JPanel contentPane;
	 JTextField recap;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mot_de_passe_oublier frame = new mot_de_passe_oublier();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mot_de_passe_oublier() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 577);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 255));
		panel.setBounds(10, 28, 891, 120);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("CIN");
		lblNewLabel_2.setFont(new Font("Sylfaen", Font.ITALIC, 25));
		lblNewLabel_2.setBounds(42, 228, 101, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("NOM");
		lblNewLabel_2_1.setFont(new Font("Sylfaen", Font.ITALIC, 25));
		lblNewLabel_2_1.setBounds(42, 300, 101, 34);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("PRENOM");
		lblNewLabel_2_2.setFont(new Font("Sylfaen", Font.ITALIC, 25));
		lblNewLabel_2_2.setBounds(42, 375, 144, 34);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("adresse mail");
		lblNewLabel_2_3.setFont(new Font("Sylfaen", Font.ITALIC, 25));
		lblNewLabel_2_3.setBounds(438, 228, 155, 34);
		contentPane.add(lblNewLabel_2_3);
		
		JTextArea cin = new JTextArea();
		cin.setFont(new Font("Monospaced", Font.PLAIN, 20));

		cin.setBounds(153, 228, 184, 33);
		contentPane.add(cin);
		
		JTextArea nom = new JTextArea();
		nom.setFont(new Font("Monospaced", Font.PLAIN, 20));
		nom.setBounds(153, 303, 184, 31);
		contentPane.add(nom);
		
		JTextArea prenom = new JTextArea();
		prenom.setFont(new Font("Monospaced", Font.PLAIN, 20));
		prenom.setBounds(167, 370, 184, 30);
		contentPane.add(prenom);
		
		JTextArea mail = new JTextArea();
		mail.setFont(new Font("Monospaced", Font.PLAIN, 20));
		mail.setBounds(628, 224, 256, 34);
		contentPane.add(mail);
		
		JButton btnNewButton_1 = new JButton("retour page d'accueil");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				identification a=new identification();
				a.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(100, 469, 280, 30);
		contentPane.add(btnNewButton_1);
		
		recap = new JTextField();
		recap.setBounds(628, 358, 165, 42);
		contentPane.add(recap);
		recap.setColumns(10);
		JLabel lblNewLabel = new JLabel("mot de passe oubli\u00E9 ??");
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 41));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("r\u00E9tablir votre mot de passe");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(260, 165, 379, 30);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("r\u00E9cuperer mot de passe");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement pst ;  
				try{
		          	Connection con;
		        
		        con = DriverManager.getConnection("jdbc:mysql://localhost/centre_de_formation","root","root");
		        String sql = "Select * from page_identification where cin = ? and nom= ? and prenom=? and addresse_mail =?";
		        pst=con.prepareStatement(sql);
	            pst.setString(1,cin.getText());
	            pst.setString(2,nom.getText());
	            pst.setString(3,prenom.getText());
	            pst.setString(4,mail.getText());
	            ResultSet rs = pst.executeQuery();
	      
	           if(rs.next()) {
	            	
	                recap.setText(rs.getString(9));
				}
	           else {
	        	   showMessageDialog(null, "ce compte n'existe pas");
	           }
	        	   }catch(Exception r)
				{
					showMessageDialog(null, r.getMessage());
				}
				

			}
		});
		
		recap.setEditable(false);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(453, 469, 280, 30);
		contentPane.add(btnNewButton);
	}
}
