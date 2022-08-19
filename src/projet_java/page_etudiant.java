package projet_java;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class page_etudiant extends JFrame {

	 JPanel contentPane;
	 JTextField rec;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					page_etudiant frame = new page_etudiant();
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
	public page_etudiant() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 965, 765);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(50, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(78, 43, 738, 57);
		contentPane.add(panel);
		setResizable(false);
		JLabel lblNewLabel = new JLabel("Menu Etudiant");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 36));
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Formations Disponibles");
		btnNewButton_1.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				formation_disponible a=new formation_disponible();
				a.setVisible(true);
				setVisible(false);
				a.mail.setText(rec.getText());
			}
		});
		btnNewButton_1.setBounds(90, 291, 241, 57);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("D\u00E9connexion");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				identification a = new identification();
				a.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton_2.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_2.setBounds(330, 427, 261, 62);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("votre propositions");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				proposition t =new proposition();
				t.mail.setText(rec.getText());
				t.setVisible(true);
				setVisible(false);
				
				
	
		}
		}	);
		btnNewButton_3.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_3.setBounds(330, 163, 249, 57);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Formations inscrit");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formation_inscrit a=new formation_inscrit();
				a.setVisible(true);
				setVisible(false);
				a.recc.setText(rec.getText());
				
				
			}
		});
		btnNewButton_4.setFont(new Font("Sylfaen", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_4.setBounds(592, 291, 249, 57);
		contentPane.add(btnNewButton_4);
		
		rec = new JTextField();
		rec.setBounds(74, 442, -1, 19);
		contentPane.add(rec);
		rec.setColumns(10);
	}
	
	

}
