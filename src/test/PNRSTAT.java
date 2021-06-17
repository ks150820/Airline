package test;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class PNRSTAT {
public void pnrstatus() throws SQLException, ClassNotFoundException {
	JFrame f=new JFrame("PNR");
	JLabel pnrLabel=new JLabel("Enter PNR No. :");
	pnrLabel.setBounds(30,80,200,30);
	
	JTextField pnrfield=new JTextField();
	pnrfield.setBounds(120,80,100,30);
	
	JLabel l1=new JLabel();
	l1.setBounds(30,100,200,30);
	
	JLabel l2=new JLabel();
	l2.setBounds(150,100,70,30);
	
	JLabel l3=new JLabel();
	l3.setBounds(30,130,200,30);
	
	JLabel l4=new JLabel();
	l4.setBounds(150,130,150,30);
	
	JButton pnrbutton=new JButton("Go");
	pnrbutton.setBounds(230,80,50,30);
	pnrbutton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection Con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","kapil");
			
			PreparedStatement stmt=Con.prepareStatement("select * from PNR where pnr=?");
			stmt.setString(1, pnrfield.getText());
			
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				String PnrNumber=rs.getString(1);
				String name=rs.getString(2);
				String fromcity=rs.getString(3);
				String pnrstatus=rs.getString(4);
				String toCity=rs.getString(5);
				
				l1.setText(name);
				l2.setText(fromcity);
				l3.setText(pnrstatus);
				l4.setText("Ticket Confirmed !");
				
			}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	});
	
	
	
	f.add(pnrLabel);f.add(pnrfield);f.add(pnrbutton);f.add(l1);f.add(l2);f.add(l3);f.add(l4);
	f.setSize(300,300);
	f.setLayout(null);
	f.setVisible(true);
}
}
