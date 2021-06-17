package test;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Review_Booking {
	JFrame f;
	JPanel panel1,panel2,panel3;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20;
public void review(String airlineName,String fromAirport,String toAirport,String countryName,String travellerName) throws IOException {
	f=new JFrame("Review_Booking");
	
	l1=new JLabel("Review Booking");
	l1.setBounds(250,10,100,70);
	 
//	File imagepath=new File("./images/long_line.png");
//	BufferedImage image=ImageIO.read(imagepath);
//	l2=new JLabel(new ImageIcon(image));
//	l2.setBounds(30,50,550,10);
	
	l3=new JLabel(airlineName);
	l3.setBounds(100,70,100,30);
	
	l4=new JLabel("|                                  Traveller");
	l4.setBounds(300,70,400,30);
	
	l5=new JLabel("From Airport");
	l5.setBounds(105,100,100,20);
	
	l6=new JLabel("To  Airport");
	l6.setBounds(355,100,100,20);
	
	l7=new JLabel(fromAirport);
	l7.setBounds(100,130,100,30);
	
	l8=new JLabel("--->");
	l8.setBounds(280,130,70,30);
	
	l9=new JLabel(toAirport);
	l9.setBounds(350,130,90,30);
	
	l10=new JLabel("Departure :");
	l10.setBounds(100,170,100,30);
	
	l11=new JLabel("23/september/2020");
	l11.setBounds(190,170,200,30);
	
	File imagepath=new File("./images/thickline.png");
	BufferedImage image=ImageIO.read(imagepath);
	l2=new JLabel(new ImageIcon(image));
	l2.setBounds(30,220,550,10);
	
	l12=new JLabel("Travelling Passengers");
	l12.setBounds(100,250,200,50);
	
	File imagepath1=new File("./images/thickline.png");
	BufferedImage image1=ImageIO.read(imagepath1);
	l13=new JLabel(new ImageIcon(image1));
	l13.setBounds(100,290,200,10);
	
	l14=new JLabel(travellerName);
	l14.setBounds(100,305,100,30);
	
	l15=new JLabel("Nationality :");
	l15.setBounds(100,325,150,30);
	
	l16=new JLabel(countryName);
	l16.setBounds(200,325,150,30);
	
	JButton b1=new JButton("Replan");
	b1.setBounds(200,390,90,30);
	b1.setBackground(Color.blue);
	b1.setForeground(Color.white);
	b1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String name=airlineName+"_confirmation";
			Register_Side rs=new Register_Side();
			rs.register();
			
		}
	});
	
	JButton b2=new JButton("Continue");
	b2.setBounds(300,390,90,30);
	b2.setBackground(Color.blue);
	b2.setForeground(Color.white);
	b2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e1) {
			Confirmed_your_booking bookingconfirmed=new Confirmed_your_booking();
			bookingconfirmed.booking_confirmed(travellerName, fromAirport, toAirport, countryName);
		}
	});
	
	 f.add(l1);f.add(l3);f.add(l4);f.add(l5);f.add(l6);f.add(l7);f.add(l8);f.add(l9);f.add(l10);f.add(l11);f.add(l2);f.add(l12);
	 f.add(l13);f.add(l14);f.add(l15);f.add(l16);f.add(b1);f.add(b2);
	 f.setSize(600,800);
	 f.setLayout(null);
	 f.setVisible(true);
}
}
