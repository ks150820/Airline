package test;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.*;


public class Booking {
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
	JTextField tf1,tf2,tf3;
	JMenu menu;
	JMenuItem logout;
	public void Booking_Tickets(String FIRSTNAME,String LASTNAME) throws IOException {
		f=new JFrame("Booking");
		String[] classes= {"ECONOMY","BUSINESS"};
		String[] dates= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		String[] month= {"january","Feb","March","April","May","June","July","August","September","October","November","December"};
		String[] year = {"2020","2021","2022"};
		Font myFont2 = new Font(Font.SERIF, Font.BOLD | Font.ITALIC, 14);
		Font myFont3 = new Font(Font.MONOSPACED,Font.BOLD | Font.PLAIN ,12);
		
		JMenuBar bar=new JMenuBar();
		bar.setBackground(Color.blue);
		menu=new JMenu(FIRSTNAME + " " + LASTNAME);
		menu.setForeground(Color.white);
		logout=new JMenuItem("LOGOUT");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				JOptionPane.showConfirmDialog(f, "Sure , You want to Logout");
				LoginPage lp=new LoginPage();
				try {
					lp.loginStyle();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		menu.add(logout);
		bar.add(menu);
		
		l1=new JLabel("AIRLINE RESERVATION BOOKING CENTER");
		l1.setBounds(110,20,300,50);
		l1.setFont(myFont2);
		
		
		l2=new JLabel("From");
		l2.setBounds(80,50,40,70);
		l2.setFont(myFont3);
		tf1=new JTextField();
		tf1.setBounds(60,100,100,40);
		
		String path1="./images/arrow.png";
		File file1=new File(path1);
		BufferedImage image1=ImageIO.read(file1);
		l4=new JLabel(new ImageIcon(image1));
		l4.setBounds(200,100,100,50);
		
		l3=new JLabel("To");
		l3.setBounds(350,50,40,70);
		l3.setFont(myFont3);
		tf2=new JTextField();
		tf2.setBounds(320,100,100,40);
		
		l5=new JLabel("Class");
		l5.setBounds(80,150,40,70);
		l5.setFont(myFont3);
		JComboBox cb1=new JComboBox(classes);
		cb1.setBounds(60,200,100,30);
		
		l6=new JLabel("Date");
		l6.setBounds(350,150,40,70);
		JComboBox cb2=new JComboBox(dates);
		cb2.setBounds(300,200,40,30);
		
		JComboBox cb3=new JComboBox(month);
		cb3.setBounds(340,200,60,30);
		
		JComboBox cb4=new JComboBox(year);
		cb4.setBounds(397,200,60,30);
		 
		JButton b1=new JButton("Go");
		b1.setBounds(210,230,50,30);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String takeText=b1.getText();
				String fromText=tf1.getText();
				String toText=tf2.getText();
				String classText=(String) cb1.getItemAt(cb1.getSelectedIndex());
				
				try {
					Registeration re=new Registeration();
					re.Register(FIRSTNAME,LASTNAME,fromText,toText,classText);
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
			}
		});

		
			String path2="./images/93x56-malaysia.jpg";
			File file2=new File(path2);
			BufferedImage image2=ImageIO.read(file2);
			l7=new JLabel(new ImageIcon(image2));
			l7.setBounds(30,200,96,200);
			
			String path3="./images/bestseller_holiday.gif";
			File file3=new File(path3);
			BufferedImage image3=ImageIO.read(file3);
			l8=new JLabel(new ImageIcon(image3));
			l8.setBounds(150,200,96,200);
			
			String path6="./images/cards_hpcl_silvervisa.jpg";
			File file6=new File(path6);
			BufferedImage image6=ImageIO.read(file6);
			l11=new JLabel(new ImageIcon(image6));
			l11.setBounds(300,200,96,200);
			
			String path4="./images/bluecards.gif";
			File file4=new File(path4);
			BufferedImage image4=ImageIO.read(file4);
			l9=new JLabel(new ImageIcon(image4));
			l9.setBounds(30,300,96,200);
			
			String path5="./images/best_of.jpg";
			File file5=new File(path5);
			BufferedImage image5=ImageIO.read(file5);
			l10=new JLabel(new ImageIcon(image5));
			l10.setBounds(150,300,96,200);
			
			String path7="./images/exclusive_holiday_obt.gif";
			File file7=new File(path7);
			BufferedImage image7=ImageIO.read(file7);
			l12=new JLabel(new ImageIcon(image7));
			l12.setBounds(300,300,96,200);
		
		
		
		f.add(l1);f.add(l2);f.add(l3);f.add(tf1);f.add(tf2);f.add(l4);f.add(cb1);f.add(l5);f.add(l6);f.add(cb2);
		f.add(cb3);f.add(cb4);f.add(l7);f.add(l8);f.add(l9);f.add(l10);f.add(l11);f.add(l12);f.add(b1);f.setJMenuBar(bar); 
		f.setSize(500,550);
		f.setLayout(null);
		f.setVisible(true);
		
	}
}
