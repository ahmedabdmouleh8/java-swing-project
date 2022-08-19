package projet_java;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JLabel;

public class proposition extends JFrame {

	 JPanel contentPane;
	 JTextField mail;
	 static Connection con;
	 PreparedStatement pst;
	  JTextArea proposition;
	  private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					proposition frame = new proposition();
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
	public proposition() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		mail = new JTextField();
		mail.setBounds(72, 34, 0, 19);
		contentPane.add(mail);
		mail.setColumns(10);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost/centre_de_formation","root","root");
					Statement st=con.createStatement();
					System.out.println("connection reussie");
					
					String sql="INSERT INTO proposition(mail, proposition) VALUES ('"+mail.getText()+"','"+proposition.getText()+"')";
					
					pst = con.prepareStatement(sql);
							pst.execute();
							showMessageDialog(null, "proposition ajoutée");
				}catch(Exception g)
				{
					showMessageDialog(null, g.getMessage());
				}
				
				
			}
		});
		btnNewButton.setBounds(388, 270, 96, 29);
		contentPane.add(btnNewButton);
		
		proposition = new JTextArea();
		proposition.setBounds(72, 82, 453, 125);
		contentPane.add(proposition);
		mail.setEnabled(false);
		
		btnNewButton_1 = new JButton("Retourner");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				page_etudiant a=new page_etudiant();
				a.setVisible(true);
				setVisible(false);
				a.rec.setText(mail.getText());
			}
		});
		btnNewButton_1.setBounds(83, 266, 117, 34);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Proposition / Demande");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(170, 25, 314, 29);
		contentPane.add(lblNewLabel);
	}
}
