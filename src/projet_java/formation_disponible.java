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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class formation_disponible extends JFrame {

	 JPanel contentPane;
	 JTextField mail;
	 JTextField date;
	 JTextField hd;
	 JTextField nff;
	 static Connection con;
		PreparedStatement pst;
		DefaultTableModel model;
		  JTable table;
		   JButton btnNewButton;
		  JButton btnNewButton_1;
		  JLabel lblNomFormation;
		  JLabel lblDate;
		 JLabel lblHeureDebut;
		  JLabel lblMailForamteur;
		 JTextField mf;
		  JButton btnNewButton_2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					formation_disponible frame = new formation_disponible();
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
	public formation_disponible() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mail = new JTextField();
		mail.setBounds(44, 403, -1, 19);
		contentPane.add(mail);
		mail.setColumns(10);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(289, 403, 96, 19);
		contentPane.add(date);
		
		hd = new JTextField();
		hd.setColumns(10);
		hd.setBounds(478, 403, 96, 19);
		contentPane.add(hd);
		setResizable(false);
		nff = new JTextField();
		nff.setColumns(10);
		nff.setBounds(79, 403, 96, 19);
		contentPane.add(nff);
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(105, 10, 735, 294);
		contentPane.add(panel);
		panel.setLayout(null);
		
		mf = new JTextField();
		mf.setColumns(10);
		mf.setBounds(675, 403, 96, 19);
		contentPane.add(mf);
		
	/*	*/
		
		btnNewButton = new JButton("inscrire");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				try {
					String sql="INSERT INTO `inscrire`(`mail`, `nom_formation`, `date`, `hd`, `mail_formateur`) VALUES ('"+mail.getText()+"','"+nff.getText()+"','"+date.getText()+"','"+hd.getText()+"','"+mf.getText()+"')";
					
					pst = con.prepareStatement(sql);
							pst.execute();
							showMessageDialog(null, "inscription reussie");
				}catch(Exception g)
				{
					showMessageDialog(null, g.getMessage());
				}
			//	nomm.setText(cmn.getText());
			}
		});
		//---------------		
		mail.setEnabled(false);
				//---------
				
				
				
				
				
		
		btnNewButton.setBounds(478, 441, 96, 21);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("afficher");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 10, 715, 274);
				panel.add(scrollPane);
				
				table = new JTable();
				
				model=new DefaultTableModel();
				Object[]column= {"mail", "date", "heure_deb", "heure_fin", "salle", "prix", "nom_formation", "description"};
				final Object[]row=new Object[8];
				model.setColumnIdentifiers(column);
				table.setModel(model);
				scrollPane.setViewportView(table);
				
				PreparedStatement pst ;  
				
				try {
					
				
					            con = DriverManager.getConnection("jdbc:mysql://localhost/centre_de_formation","root","root");
					            Statement st=con.createStatement();
								String sql="SELECT * FROM formation";
								pst=con.prepareStatement(sql);
								
								ResultSet rs=pst.executeQuery();
								
								while(rs.next())
								{
									int x=rs.getInt(5);
								if (x!=0) {	
								row[0]=rs.getString("mail");
								row[1]=	rs.getString("date");
								row[2]=	rs.getInt("heure_deb");
								row[3]=	rs.getInt("heure_fin");
								row[4]=	rs.getInt("salle");
								row[5]=	rs.getInt("prix");
								row[6]=	rs.getString("nom_formation");
								row[7]=	rs.getString("description");
								model.addRow(row);				
								}}
								
								}
								
								catch(Exception exp)
								{
									System.out.println(exp);
								}
								
								

							}
						});
				
				
				
		
		btnNewButton_1.setBounds(10, 244, 85, 21);
		contentPane.add(btnNewButton_1);
		
		lblNomFormation = new JLabel("nom formation");
		lblNomFormation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNomFormation.setBounds(64, 368, 141, 19);
		contentPane.add(lblNomFormation);
		
		lblDate = new JLabel("date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDate.setBounds(300, 368, 85, 16);
		contentPane.add(lblDate);
		
		lblHeureDebut = new JLabel("heure debut");
		lblHeureDebut.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHeureDebut.setBounds(478, 368, 113, 20);
		contentPane.add(lblHeureDebut);
		
		lblMailForamteur = new JLabel("mail foramteur");
		lblMailForamteur.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMailForamteur.setBounds(665, 368, 141, 20);
		contentPane.add(lblMailForamteur);
		
		btnNewButton_2 = new JButton("retourner");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				page_etudiant a=new page_etudiant();
				a.setVisible(true);
				setVisible(false);
				
				a.rec.setText(mail.getText());
				
				
			}
		});
		btnNewButton_2.setBounds(227, 441, 106, 21);
		contentPane.add(btnNewButton_2);
	
		
	}}