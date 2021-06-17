package test;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.*;
public class Register_Side {
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	JTextField tf1,tf2,tf3,tf4,tf5;
	JTextArea ta1;
	JButton b1;
	public void register() {
		f=new JFrame("Register Page");
		
		l1=new JLabel("PLEASE REGISTER FIRST");
		l1.setBounds(150,10,200,30);
		
		l2=new JLabel("First Name :");
		l2.setBounds(30,30,80,30);
		tf1=new JTextField();
		tf1.setBounds(100,30,80,30);
		
		l3=new JLabel("Last Name :");
		l3.setBounds(200,30,80,30);
		tf2=new JTextField();
		tf2.setBounds(300,30,80,30);
		
		l4=new JLabel("UserName :");
		l4.setBounds(30,70,90,30);
		tf3=new JTextField();
		tf3.setBounds(100,70,200,30);
		
		l5=new JLabel("Password :");
		l5.setBounds(30,100,90,30);
		tf4=new JTextField();
		tf4.setBounds(100,100,200,30);
		

		l6=new JLabel("Address :");
		l6.setBounds(30,130,80,30);
		ta1=new JTextArea();
		ta1.setBounds(100,133,200,150);
		
		l7=new JLabel("Email :");
		l7.setBounds(30,300,80,30);
		tf5=new JTextField();
		tf5.setBounds(100,300,200,30);
		
		b1=new JButton("Submit");
		b1.setBounds(120,350,80,30);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstName=tf1.getText();
				String lastName=tf2.getText();
				String userName=tf3.getText();
				String password=tf4.getText();
				String textArea=ta1.getText();
				String getEmail = tf5.getText();
				
				//getting username from the database
				try {
	    			Class.forName("oracle.jdbc.driver.OracleDriver");
	    			
	    			Connection Conf = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","kapil");
	    			
	    			PreparedStatement stmt=Conf.prepareStatement("select * from AirlineReservation where UserName=?");
	    			stmt.setString(1, userName);
	    			 ResultSet rs=stmt.executeQuery();
	    			 
	    			 String extractedUserName="";
	    			while(rs.next()) {
	    				extractedUserName=rs.getString(3);
	    				
	    					
	    			}
	    			if(userName.equals(extractedUserName)) {
    						JOptionPane.showMessageDialog(f, "Username already exist");
    					
    				}else if(password.length()<8) {
						JOptionPane.showMessageDialog(f, "Password length atleast of 8 character or more");
					}
    				else {
    					canRegister(firstName,lastName,userName,password,textArea,getEmail);
    				}
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				//end
				tf1.setText(" ");
				tf2.setText(" ");
				tf3.setText(" ");
				tf4.setText(" ");
				ta1.setText(" ");
				tf5.setText(" ");
			}
			}
		);
		
		l9=new JLabel("If already Registered ");
		l9.setBounds(100,400,200,30);
		
		l10=new JLabel("Click here ");
		l10.setBounds(225,400,100,30);
		l10.setForeground(Color.blue);
		l10.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				LoginPage lp=new LoginPage();
				try {
					lp.loginStyle();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		l11=new JLabel("to Login");
		l11.setBounds(290,400,100,30);
		
		
		f.add(l1);f.add(l2);f.add(l3);f.add(tf1);f.add(tf2);f.add(l4);f.add(l5);f.add(tf3);f.add(tf4);
		f.add(l6);f.add(ta1);f.add(l7);f.add(tf5);f.add(b1);f.add(l9);f.add(l10);f.add(l11);
		
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		f.setSize(500,500);
		f.setLayout(null);
		f.setVisible(true);
	}
	
	public void canRegister(String firstName,String lastName,String UserName,String Password,String Address,String Email) {
			//System.out.println("Hello");
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection Con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","kapil");
				
				PreparedStatement pstmt=Con.prepareStatement("insert into AirlineReservation values(?,?,?,?,?,?)");
				pstmt.setString(1,firstName);
				pstmt.setString(2,lastName);
				pstmt.setString(3, UserName);
				pstmt.setString(4, Password);
				pstmt.setString(5, Address);
				pstmt.setString(6, Email);
				
				int i=pstmt.executeUpdate();
				System.out.println(i);
			} catch (SQLException | ClassNotFoundException e2) {
				e2.printStackTrace();
			}
			JOptionPane.showMessageDialog(f, "Successfully Registered");
			Booking b=new Booking();
			try {
				b.Booking_Tickets(tf3.getText(),tf4.getText());
			} catch (IOException e) {
				e.printStackTrace();
			}
			tf1.setText(" ");
			tf2.setText(" ");
			tf3.setText(" ");
			tf4.setText(" ");
			ta1.setText(" ");
			tf5.setText(" ");
		}
	
}
