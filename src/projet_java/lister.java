package projet_java;

import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class lister extends JFrame {

	 JPanel contentPane;
	 JTextField mail;
	 
	 static Connection con;
	  JTextField date;
	
	  DefaultTableModel model;
	  JTable table;
	   JTextField hd1;
	  
	  


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lister frame = new lister();
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
	public lister() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 864, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		mail = new JTextField();
		mail.setBounds(62, 402, -3, 19);
		contentPane.add(mail);
		mail.setColumns(10);
		
		JButton btnNewButton = new JButton("supprimer");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
            	
				PreparedStatement pst;
				try {
					con = DriverManager.getConnection("jdbc:mysql://localhost/centre_de_formation","root","root");
					Statement st=con.createStatement();
					System.out.println("connection reussie");
					String sql="DELETE FROM formation WHERE mail='"+mail.getText()+"'and  date='"+date.getText()+"'and heure_deb="+hd1.getText();
					
					//String sql="DELETE FROM formation WHERE mail='"+mail.getText()+"'and nom_formation='"+nom.getText()+"'and date='"+date.getText()+"'and heure_deb="+hd1.getText();
					pst = con.prepareStatement(sql);
					System.out.println("hello");
					pst.execute();
				/*	mail.setText("");
					nom.setText("");
					date.setText("");
					hd1.setText("");*/
					showMessageDialog(null, "formation supprimée");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					showMessageDialog(null, "formation inexistante");
				} 
			}
		});
		btnNewButton.setBounds(683, 355, 116, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("retourner");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page_formateur a=new page_formateur ();
				a.setVisible(true);
				setVisible(false);
				
				a.cmn.setText(mail.getText());
			}
		});
		btnNewButton_2.setBounds(325, 421, 144, 21);
		contentPane.add(btnNewButton_2);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(295, 356, 96, 19);
		contentPane.add(date);
		
		
		
		
		
		
		
		JButton btnNewButton_1 = new JButton("afficher");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//------------------------------------
				
				//--------
				
				
				PreparedStatement pst ; 

				JPanel panel = new JPanel();
				panel.setBounds(189, 10, 651, 294);
				contentPane.add(panel);
				panel.setLayout(null);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 10, 631, 274);
				panel.add(scrollPane);
				
				table = new JTable();
				
				model=new DefaultTableModel();
				Object[]column= {"mail", "date", "heure_deb", "heure_fin", "salle", "prix", "nom_formation", "description"};
				final Object[]row=new Object[8];
				model.setColumnIdentifiers(column);
				table.setModel(model);
				scrollPane.setViewportView(table);
				
	try {
		
	
		            con = DriverManager.getConnection("jdbc:mysql://localhost/centre_de_formation","root","root");
		            Statement st=con.createStatement();
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
		btnNewButton_1.setBounds(57, 75, 85, 21);
		contentPane.add(btnNewButton_1);
		
		hd1 = new JTextField();
		hd1.setColumns(10);
		hd1.setBounds(474, 356, 96, 19);
		contentPane.add(hd1);
		
		JLabel lblDate = new JLabel("date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDate.setBounds(285, 325, 88, 13);
		contentPane.add(lblDate);
		
		JLabel lblHeuredeb = new JLabel("heure d\u00E9but");
		lblHeuredeb.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHeuredeb.setBounds(464, 325, 88, 13);
		contentPane.add(lblHeuredeb);
		
		
		
		
		
		
	}
}
