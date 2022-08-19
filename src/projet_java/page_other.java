package projet_java;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class page_other extends JFrame {

	private JPanel contentPane;
	static Connection con;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					page_other frame = new page_other();
					frame.setVisible(true);
					con = DriverManager.getConnection("jdbc:mysql://localhost/centre_de_formation","root","root");
					Statement st=con.createStatement();
					System.out.println("connection reussie");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public page_other() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		JButton btnNewButton = new JButton("Afficher Formateur");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				prof a = new prof();
				a.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(93, 189, 175, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Afficher \u00E9tudiant");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				etudiant c = new etudiant ();
				c.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_1.setBounds(445, 189, 164, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Confirmation de foramtion");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				confirmation a=new confirmation();
				a.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton_2.setBounds(63, 297, 235, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("D\u00E9connexion");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				identification a = new identification();
				a.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_3.setBounds(471, 299, 138, 25);
		contentPane.add(btnNewButton_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(26, 25, 589, 57);
		contentPane.add(panel);
		
		JLabel lblMenuAutre = new JLabel("Menu Autre");
		lblMenuAutre.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 36));
		panel.add(lblMenuAutre);
		
		JButton btnNewButton_4 = new JButton("R\u00E9capitulation");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				recapitulation a=new recapitulation();
				a.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_4.setBounds(306, 239, 148, 29);
		contentPane.add(btnNewButton_4);
	}

}
