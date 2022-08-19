package projet_java;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class page_formateur extends JFrame {

	 JPanel contentPane;
	 JTextField cmn;
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					page_formateur frame = new page_formateur();
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
	public page_formateur() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		JButton btnNewButton = new JButton("Ajouter Formation");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouter_formation p=new ajouter_formation();
				p.mail.setText(cmn.getText());
				p.setVisible(true);
				setVisible(false);
				lister a=new lister();
			
				
				
			}
		});
		
		btnNewButton.setBounds(50, 180, 169, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Lister");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lister a=new lister();
					a.mail.setText(cmn.getText());
					lister b=new lister();
					a.setVisible(true);
					setVisible(false);
					
				
				
				
			}
		});
		btnNewButton_2.setBounds(345, 180, 95, 21);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("D\u00E9connexion");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				identification a = new identification();
				a.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_3.setBounds(213, 251, 130, 21);
		contentPane.add(btnNewButton_3);
		
		cmn = new JTextField();
		cmn.setBounds(26, 284, -3, 19);
		contentPane.add(cmn);
		cmn.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(80, 10, 424, 57);
		contentPane.add(panel);
		
		JLabel lblMenuFormateur = new JLabel("Menu Formateur");
		panel.add(lblMenuFormateur);
		lblMenuFormateur.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 36));
		
		JButton btnNewButton_1 = new JButton("Demande");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				proposition1 a=new proposition1 ();
				a.setVisible(true );
				setVisible(false);
				a.mail.setText(cmn.getText());
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(213, 117, 130, 21);
		contentPane.add(btnNewButton_1);
	}
}
