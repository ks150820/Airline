package test;
import java.sql.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.awt.Color;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
public class LoginPage {
	JTextField tf1;
	public void loginStyle() throws IOException {
		JFrame f= new JFrame("Login Detail");  
	    JLabel l1,l2,l3,l4,l5,l6,labelimage,checkpnr;
	    
	    l4=new JLabel("WELCOME TO ONLINE RESERVATION SYSTEM");
	    l4.setBounds(70,10,300,30);
	    
	    l3=new JLabel("Registered Users");
	    l3.setBounds(150,30,200,30);
	    
	    checkpnr=new JLabel("Check PNR");
	    checkpnr.setBounds(380,30,100,30);
	    checkpnr.setForeground(Color.blue);
	    checkpnr.addMouseListener(new MouseAdapter() {
	    	public void mouseClicked(MouseEvent me) {
	    		PNRSTAT pnr=new PNRSTAT();
	    		try {
					pnr.pnrstatus();
				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}
	    	}
	    });
	    
	    l1=new JLabel("UserName :");  
	    l1.setBounds(50,60, 100,30);
	    
	    tf1=new JTextField();
	    tf1.setBounds(120,60,200,30);
	    
	    l2=new JLabel("Password :");  
	    l2.setBounds(50,130, 100,30);
	    
	    JPasswordField pass=new JPasswordField();
	    pass.setBounds(120,130,200,30);
	    
	    l5=new JLabel();
	    l5.setBounds(130,90,300,30);
	    l5.setForeground(Color.red);
	    
	    l6=new JLabel("or");
	    l6.setBounds(180,210,50,30);
	    
	    
	    
	    JButton b=new JButton("Submit");
	    b.setBounds(150,180,100,30);
	    b.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		try {
	    			String getUserName=tf1.getText();
	    			String getPassword=new String(pass.getPassword());
	    			
	    			Class.forName("oracle.jdbc.driver.OracleDriver");
	    			
	    			Connection Con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","kapil");
	    			
	    			PreparedStatement stmt=Con.prepareStatement("select * from AirlineReservation where UserName=? AND Password=?");
	    			stmt.setString(1, getUserName);
	    			stmt.setString(2, getPassword);
	    			 ResultSet rs=stmt.executeQuery();
	    			 
	    			 String extractedUserName="";
	    			 String extractedPassword="";
	    			 String LASTNAME="";
	    			 String FIRSTNAME="";
	    			while(rs.next()) {
	    				FIRSTNAME=rs.getString(1);
	    				LASTNAME=rs.getString(2);
	    				extractedUserName=rs.getString(3); 
	    				extractedPassword=rs.getString(4);
	    				
	    			}
	    			if(getUserName.equals(extractedUserName)) {
    					JOptionPane.showMessageDialog(f, "Login Successfully");
    					Booking b=new Booking();
	    				b.Booking_Tickets(FIRSTNAME,LASTNAME);
	    				tf1.setText("");
	    				pass.setText("");
	    			}else{
	    				//JOptionPane.showMessageDialog(f, "Invalid Username and Password");
	    				l5.setText("Invalid Username and Password");
	    				tf1.setText("");
	    				pass.setText("");
	    			}
    				
	    		}catch(Exception ex) { 
	    			System.out.println(ex);
	    		}
	    	}

	    });
	    
	    JButton registerButton=new JButton("Register");
	    registerButton.setBounds(150,240,100,30);
	    registerButton.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent ex) {
	    		Register_Side reg=new Register_Side();
	    		reg.register();
	    	}
	    });
	    
	    String path="./images/466x246-Pilotimage-Best-of-india.jpg";
	    File file=new File(path);
	    BufferedImage image=ImageIO.read(file);
	    labelimage=new JLabel(new ImageIcon(image));
	    labelimage.setBounds(10,280,460,200);
	    
	    f.add(l1); f.add(l2);f.add(tf1);f.add(pass);f.add(b);f.add(l3);f.add(l4);f.add(l5);f.add(l6);f.add(registerButton);f.add(checkpnr);
	    f.add(labelimage);
	    f.setSize(500,600);  
	    f.setLayout(null);  
	    f.setVisible(true);  
	}
}
