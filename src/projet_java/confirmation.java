package projet_java;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class confirmation extends JFrame {

	 JPanel contentPane;
	 JTextField mail;
	 JTextField date;
	 JTextField hd;
	 JTextField salle;
		static Connection con;
		PreparedStatement pst;
		 JButton btnNewButton;
		 JButton btnNewButton_1;
		 JButton btnNewButton_2;
		 JLabel lblNewLabel;
		 JLabel lblNewLabel_2;
		 JLabel lblNewLabel_3;
		 JLabel lblNewLabel_4;
		 DefaultTableModel model;
		 JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					confirmation frame = new confirmation();
					frame.setVisible(true);
					con = DriverManager.getConnection("jdbc:mysql://localhost/centre_de_formation","root","root");
					Statement st=con.createStatement();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public confirmation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 747, 539);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mail = new JTextField();
		mail.setBounds(57, 325, 96, 19);
		contentPane.add(mail);
		mail.setColumns(10);
		setResizable(false);
		
		
		lblNewLabel = new JLabel("mail");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(61, 298, 62, 17);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_2 = new JLabel("date");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(285, 298, 96, 17);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("heure debut");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(57, 354, 113, 28);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("salle");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(285, 354, 62, 25);
		contentPane.add(lblNewLabel_4);
		
		date = new JTextField();
		date.setBounds(285, 325, 96, 19);
		contentPane.add(date);
		date.setColumns(10);
		
		hd = new JTextField();
		hd.setBounds(57, 392, 96, 19);
		contentPane.add(hd);
		hd.setColumns(10);
		
		salle = new JTextField();
		salle.setBounds(285, 392, 96, 19);
		contentPane.add(salle);
		salle.setColumns(10);
		
		btnNewButton = new JButton("retourner");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				page_other a=new page_other();
				a.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setBounds(298, 456, 117, 21);
		contentPane.add(btnNewButton);
		
	btnNewButton_1 = new JButton("enregistrer");
	btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PreparedStatement pst;
				try {
					
					
					con = DriverManager.getConnection("jdbc:mysql://localhost/centre_de_formation","root","root");
					Statement st=con.createStatement();
					System.out.println("connection reussie");
				
						//String sql="UPDATE formation SEt salle="+Integer.parseInt(salle.getText())+" WHERE mail='"+mail.getText()+"'and nom_formation='"+nom.getText()+"'and date='"+date.getText()+"'and heure_deb="+Integer.parseInt(hd.getText());
				//	String sql="UPDATE formation SET salle="+Integer.parseInt(salle.getText())+ "where nom_formation=\"python\" and mail=\"admin\"  and date=\"08-12-2021\" and heure_deb=14";
				
						String sql="UPDATE formation SEt salle="+Integer.parseInt(salle.getText())+" WHERE mail='"+mail.getText()+"'and date='"+date.getText()+"'and heure_deb="+Integer.parseInt(hd.getText());
					pst = con.prepareStatement(sql);
					pst.execute();
				
					showMessageDialog(null, "confirmation reussie");
			}catch(Exception g)
			{
				showMessageDialog(null, g.getMessage());
			}
			
			
		}
	});
		btnNewButton_1.setBounds(551, 456, 107, 21);
		contentPane.add(btnNewButton_1);
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(172, 10, 561, 282);
		contentPane.add(panel);
		panel.setLayout(null);
		
		

		
		
		
		
		
		btnNewButton_2 = new JButton("afficher formation");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement pst ;  
				
				try {
			
				
					            con = DriverManager.getConnection("jdbc:mysql://localhost/centre_de_formation","root","root");
					            Statement st=con.createStatement();

					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(10, 10, 545, 274);
					panel.add(scrollPane);
					
					table = new JTable();
					
					model=new DefaultTableModel();
					Object[]column= {"mail", "date", "heure_deb", "heure_fin", "salle", "prix", "nom_formation", "description"};
					final Object[]row=new Object[8];
					model.setColumnIdentifiers(column);
					table.setModel(model);
					scrollPane.setViewportView(table);
					
								String sql="SELECT * FROM formation";
								pst=con.prepareStatement(sql);
								
								ResultSet rs=pst.executeQuery();
								
								while(rs.next())
								{row[0]=rs.getString("mail");
								row[1]=	rs.getString("date");
								row[2]=	rs.getInt("heure_deb");
								row[3]=	rs.getInt("heure_fin");
								row[4]=	rs.getInt("salle");
								row[5]=	rs.getInt("prix");
								row[6]=	rs.getString("nom_formation");
								row[7]=	rs.getString("description");
								model.addRow(row);			
								}
								
								}
								
								catch(Exception exp)
								{
									System.out.println(exp);
								}
								
								

							}
						});
				
		btnNewButton_2.setBounds(10, 88, 160, 38);
		contentPane.add(btnNewButton_2);
				
				
				
				
				
				
				
		
	}

}
