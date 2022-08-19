package projet_java;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JEditorPane;


public class formation_inscrit extends JFrame {
	
	 static Connection con;
	  JTextField date;
	
	  DefaultTableModel model;
	  JTable table;

	 JPanel contentPane;
	  JTextField rec;
	  JButton btnNewButton_1;
	   JTextField recc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formation_inscrit frame = new formation_inscrit();
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
	public formation_inscrit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 541);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBounds(154, 10, 651, 294);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JButton btnNewButton = new JButton("afficher");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PreparedStatement pst ;  
				
				try {
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(10, 10, 631, 274);
					panel.add(scrollPane);
					
					table = new JTable();
					
					model=new DefaultTableModel();
					Object[]column= {"nom formation", "date", "heure debut","mail formateur"};
					final Object[]row=new Object[8];
					model.setColumnIdentifiers(column);
					table.setModel(model);
					scrollPane.setViewportView(table);
					rec = new JTextField();
					rec.setBounds(94, 386, 0, 19);
					contentPane.add(rec);
					rec.setColumns(10);
					
					
					
				
					            con = DriverManager.getConnection("jdbc:mysql://localhost/centre_de_formation","root","root");
					            Statement st=con.createStatement();
								String sql="SELECT * FROM inscrire";
								pst=con.prepareStatement(sql);
								
								ResultSet rs=pst.executeQuery();
								String x=recc.getText();
								
								while(rs.next())
								{
									if(x.equals(rs.getString("mail"))){
									
								row[0]=	rs.getString("nom_formation");
								row[1]=	rs.getString("date");
								row[2]=	rs.getInt("hd");
								row[3]=	rs.getString("mail_formateur");
								
								model.addRow(row);				
								}}
								
								}
								
								catch(Exception exp)
								{
									System.out.println(exp);
								}
								
								

							}
						});
		btnNewButton.setBounds(25, 185, 85, 21);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("retourner");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				page_etudiant a=new page_etudiant();
				a.setVisible(true);
				setVisible(false);
				a.rec.setText(recc.getText());
				
			}
		});
		btnNewButton_1.setBounds(273, 426, 110, 21);
		contentPane.add(btnNewButton_1);
		
		recc = new JTextField();
		recc.setEnabled(false);
		recc.setColumns(10);
		recc.setBounds(38, 403, -1, 19);
		contentPane.add(recc);
		
		
	}
}
