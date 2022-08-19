package projet_java;

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
import java.awt.Font;

public class recapitulation extends JFrame {

 JPanel contentPane;
 DefaultTableModel model;
 JTable table;
 PreparedStatement pst;
 static Connection con;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					recapitulation frame = new recapitulation();
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
	public recapitulation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 811, 552);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		JButton btnNewButton = new JButton("afficher");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
//------------------------------------
				
				//--------
				
				
				PreparedStatement pst ; 

				JPanel panel = new JPanel();
				panel.setBounds(120, 10, 651, 294);
				contentPane.add(panel);
				panel.setLayout(null);
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 10, 631, 274);
				panel.add(scrollPane);
				
				table = new JTable();
				
				model=new DefaultTableModel();
				Object[]column= {"mail", "proposition"};
				final Object[]row=new Object[8];
				model.setColumnIdentifiers(column);
				table.setModel(model);
				scrollPane.setViewportView(table);
				
	try {
		
	
		            con = DriverManager.getConnection("jdbc:mysql://localhost/centre_de_formation","root","root");
		            Statement st=con.createStatement();
					String sql="SELECT * FROM proposition";
					pst=con.prepareStatement(sql);
					
					ResultSet rs=pst.executeQuery();
					
					while(rs.next())
					{row[0]=rs.getString("mail");
					row[1]=	rs.getString("proposition");
					
					model.addRow(row);			
					}
					
					}
					
					catch(Exception exp)
					{
						System.out.println(exp);
					}
					
					

				}
			});
				
				
		
		btnNewButton.setBounds(519, 439, 137, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("retourner");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				page_other a=new page_other();
				a.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(72, 439, 124, 39);
		contentPane.add(btnNewButton_1);
	}
}
