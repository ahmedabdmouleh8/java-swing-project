package projet_java;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class ajouter_formation extends JFrame {

	 JPanel contentPane;
	 Object nomm;
	  JTextField mail;
		static Connection con;
		PreparedStatement pst;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ajouter_formation frame = new ajouter_formation();
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
	public ajouter_formation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 673);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JTextArea nf = new JTextArea();
		nf.setBounds(254, 54, 269, 108);
		contentPane.add(nf);
		
		JTextArea hd = new JTextArea();
		hd.setBounds(146, 401, 123, 22);
		contentPane.add(hd);
		
		JTextArea date = new JTextArea();
		date.setBounds(146, 303, 137, 22);
		contentPane.add(date);
		
		JTextArea hf = new JTextArea();
		hf.setBounds(478, 401, 123, 22);
		contentPane.add(hf);
		
		JTextArea desc = new JTextArea();
		desc.setBounds(254, 172, 269, 108);
		contentPane.add(desc);
		
		JLabel lblNewLabel_2 = new JLabel("nom de formation\r\n:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 67, 178, 22);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("description :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(21, 198, 115, 22);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("date :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(10, 303, 70, 16);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_6 = new JLabel("heure fin :\r\n");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(343, 404, 119, 19);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("heure debut :");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(10, 394, 126, 30);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("prix :");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(274, 461, 70, 30);
		contentPane.add(lblNewLabel_9);
		JTextArea prix = new JTextArea();
		prix.setBounds(366, 468, 123, 22);
		contentPane.add(prix);
		
		JButton btnNewButton = new JButton("retourne");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				page_formateur a=new page_formateur();
				a.setVisible(true);
				setVisible(false);
				a.cmn.setText(mail.getText());
			}
		});
		btnNewButton.setBounds(185, 567, 110, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("confirmer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost/centre_de_formation","root","root");
					Statement st=con.createStatement();
					System.out.println("connection reussie");
					
					String sql="INSERT INTO formation(mail, date, heure_deb, heure_fin, prix, nom_formation, description) VALUES ('"+mail.getText()+"','"+date.getText()+"','"+hd.getText()+"','"+hf.getText()+"','"+prix.getText()+"','"+nf.getText()+"','"+desc.getText()+"')";
					
					pst = con.prepareStatement(sql);
							pst.execute();
							showMessageDialog(null, "formation ajoutée");
				}catch(Exception g)
				{
					showMessageDialog(null, g.getMessage());
				}
			//	nomm.setText(cmn.getText());
			}
		});
		btnNewButton_1.setBounds(585, 567, 137, 30);
		contentPane.add(btnNewButton_1);
		
		mail = new JTextField();
		mail.setBounds(173, 28, -1, 19);
		contentPane.add(mail);
		mail.setColumns(10);
		//mail.setEnabled(false);
		

		
		JButton btnRefraichir = new JButton("refraichir");
		btnRefraichir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				nf.setText("");
				desc.setText("");
				prix.setText("");
				hd.setText("");
				hf.setText("");
				date.setText("");
				
			}
		});
		btnRefraichir.setBounds(387, 567, 102, 30);
		contentPane.add(btnRefraichir);
	}
}
