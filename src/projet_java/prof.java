package projet_java;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JEditorPane;

public class prof extends JFrame {

	 DefaultTableModel model;
	 JPanel contentPane;
	 static Connection con;
	 JTable table;
	  JTextField cin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prof frame = new prof();
					frame.setVisible(true);
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
	public prof() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 899, 547);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setResizable(false);
		
		
		

		JButton btnNewButton = new JButton("Afficher Formateur");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PreparedStatement pst ;  
				
				try {
					JPanel panel = new JPanel();
					panel.setBounds(189, 10, 651, 294);
					contentPane.add(panel);
					panel.setLayout(null);
					
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(10, 10, 631, 274);
					panel.add(scrollPane);
					
					table = new JTable();
					
					model=new DefaultTableModel();
					Object[]column= {"cin", "nom", "prenom", "addresse_mail", "genre", "num_tel", "addresse"};
					final Object[]row=new Object[8];
					model.setColumnIdentifiers(column);
					table.setModel(model);
					scrollPane.setViewportView(table);
					
					
				
					            con = DriverManager.getConnection("jdbc:mysql://localhost/centre_de_formation","root","root");
					            Statement st=con.createStatement();
								String sql="SELECT * FROM page_identification where type_de_compte='Formateur'";
								pst=con.prepareStatement(sql);
								
								ResultSet rs=pst.executeQuery();
								
								while(rs.next())
								{row[0]=rs.getString("cin");
								row[1]=	rs.getString("nom");
								row[2]=	rs.getString("prenom");
								row[3]=	rs.getString("addresse_mail");
								row[4]=	rs.getString("genre");
								row[5]=	rs.getInt("num_tel");
								row[6]=	rs.getString("addresse");
								
								model.addRow(row);			
								}
							/*	String	sql2="select count(*) from page_identification WHERE type_de_compte=Etudiant";
pst2=con.prepareStatement(sql2);
pst2=con.prepareStatement(sql2);
								ResultSet rs2=pst2.executeQuery();
								System.out.prointln(rs2.getString);*/
								
								}
								
								catch(Exception exp)
								{
									System.out.println(exp);
								}
								
								

							}
						});
		btnNewButton.setBounds(10, 70, 169, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("retourner");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				page_other a = new page_other();
				a.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton_1.setBounds(72, 425, 107, 35);
		contentPane.add(btnNewButton_1);
		
		cin = new JTextField();
		cin.setBounds(518, 375, 118, 19);
		contentPane.add(cin);
		cin.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Supprimer");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
String sql="DELETE FROM page_identification WHERE cin="+cin.getText();
            	
				PreparedStatement pst;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost/centre_de_formation","root","root");
					Statement st=con.createStatement();
					System.out.println("connection reussie");
					pst = con.prepareStatement(sql);
					pst.execute();
				cin.setText("");
					showMessageDialog(null, "formateur supprimée");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					showMessageDialog(null, "formation inexistante");
				} 
			}
		});	
				
			
				
				
				
				
				
				
				
				
				
				
				
		
		btnNewButton_2.setBounds(645, 411, 123, 35);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Saisir le CIN de Formateur \u00E0 supprimer : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(127, 370, 414, 21);
		contentPane.add(lblNewLabel);
		
	}
}
