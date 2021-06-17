package test;

import java.awt.Frame;
import java.sql.SQLException;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Confirmed_your_booking {
public void booking_confirmed(String passengerName,String from,String to,String country) {
	String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
    String Small_chars = "abcdefghijklmnopqrstuvwxyz"; 
    String numbers = "0123456789"; 
	
    String values = Capital_chars + Small_chars + numbers; 
    
    Random rndm_method = new Random(); 

    char[] PNR = new char[10]; 

    for (int i = 0; i < 10; i++) 
    { 
        PNR[i] = values.charAt(rndm_method.nextInt(values.length())); 

    } 
    
    char[] pnr=PNR;
    String stringPNR=String.valueOf(pnr);
	
	JFrame f=new JFrame("Confirmed_your_booking");
	
	JLabel bookingConfirmed=new JLabel("Booking Confirmed !!");
	bookingConfirmed.setBounds(200,30,200,50);
	
	JLabel Name=new JLabel("Name :");
	Name.setBounds(100,100,100,30);
	
	JLabel passName=new JLabel(passengerName);
	passName.setBounds(160,100,100,30);
	
	JLabel From = new JLabel("From :");
	From.setBounds(100,130,60,30);
	
	JLabel fromName=new JLabel(from);
	fromName.setBounds(150,130,90,30);
	
	JLabel To=new JLabel("To :");
	To.setBounds(260,130,60,30);
	
	JLabel toName=new JLabel(to);
	toName.setBounds(290,130,60,30);
	
	JLabel Departure=new JLabel("Departure :");
	Departure.setBounds(100,160,90,30);
	
	JLabel departureTime=new JLabel("13:15 A.M");
	departureTime.setBounds(200,160,90,30);
	
	JLabel pnrStatus=new JLabel("PNR :");
	pnrStatus.setBounds(100,190,60,30);
	
	JLabel getPnr=new JLabel(stringPNR);
	getPnr.setBounds(180,190,100,30);
	
	pnr p=new pnr();
	try {
		p.checkPNR(stringPNR,passName.getText(),fromName.getText(),bookingConfirmed.getText(),toName.getText());
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}
	
	f.add(Name);f.add(passName);f.add(From);f.add(fromName);f.add(To);f.add(toName);f.add(Departure);f.add(departureTime);f.add(pnrStatus);
	f.add(getPnr);f.add(bookingConfirmed);
	f.setSize(500,300);
	f.setLayout(null);
	f.setVisible(true);
	
}
}
