package test;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Indigo_confirmation {
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22,l23,l24,l25,l26;
	JTextField tf1,tf2,tf3,tf4,tf5;
	JMenu menu;
	JMenuItem logout;
	public void confirmation(String FIRSTNAME,String LASTNAME,String fromText,String toText,String airlinename) throws IOException {
		f=new JFrame("Indigo Airline - Make your trip easy");
		String[] ages= {"5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20"};
		String[] genders= {"Male","Female","Transgender"};
		String[] countries= {"America","Argentina","Africa","Australia","Canada","Coatia","China","Denmark","France","Germeny","India"};
		
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
		
		String path="./images/indigoairplane2.png";
		File file=new File(path);
		BufferedImage image=ImageIO.read(file);
		l1=new JLabel(new ImageIcon(image));
		l1.setBounds(5,10,556,150);
		
		l2=new JLabel("Passenger Detail");
		l2.setBounds(40,170,130,50);
		
		String line_path = "./images/long_line.png";
		File line_file=new File(line_path);
		BufferedImage line_image=ImageIO.read(line_file);
		l3=new JLabel(new ImageIcon(line_image));
		l3.setBounds(40,205,545,10);
		
		
		l4=new JLabel("Name : ");
		l4.setBounds(50,220,70,30);
		tf1 =new JTextField();
		tf1.setBounds(100,220,90,30);
	
		l5=new JLabel("Age : ");
		l5.setBounds(220,220,50,30);
		JComboBox ageBox=new JComboBox(ages);
		ageBox.setBounds(250,220,50,30);
		
		l6=new JLabel("Gender : ");
		l6.setBounds(330,220,70,30);
		JComboBox genderBox=new JComboBox(genders);
		genderBox.setBounds(380,220,90,30);
		
		l7=new JLabel("Country : ");
		l7.setBounds(50, 280,70,30);
		JComboBox countriesBox=new JComboBox(countries);
		countriesBox.setBounds(110,275,90,30);
		
		countriesBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getCountriesName=(String) countriesBox.getItemAt(countriesBox.getSelectedIndex());
				if(getCountriesName!="India") {
					JOptionPane.showMessageDialog(f,"for the other countries travel insurance shall not permitted");
				}
			}
		});
		
		
		File thicklinefile=new File("./images/thickline.png");
		BufferedImage thicklineimage=ImageIO.read(thicklinefile);
		l8=new JLabel(new ImageIcon(thicklineimage));
		l8.setBounds(60,330,400,10);
		
		l9=new JLabel("Travelling with a child below 5 years of age ? ");
		l9.setBounds(50,350,400,30);
		l10=new JLabel("click here");
		l10.setBounds(307,350,70,30);
		l10.setForeground(Color.blue);
		l10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		l10.addMouseListener( new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				JFrame f1=new JFrame();
				
				JLabel childName=new JLabel("Name :");
				childName.setBounds(20,30,50,30);
				JTextField childNameField=new JTextField();
				childNameField.setBounds(90,30,50,30);
				
				JLabel childAgeLabel=new JLabel("Age :");
				childAgeLabel.setBounds(160,30,60,30);
				JComboBox childages=new JComboBox(ages);
				childages.setBounds(200,30,50,30);
				
				JLabel childGender=new JLabel("Gender :");
				childGender.setBounds(265,30,50,30);
				JComboBox childgenderbox=new JComboBox(genders);
				childgenderbox.setBounds(330,30,70,30);
				
				f1.add(childName);f1.add(childNameField);f1.add(childAgeLabel);f1.add(childages);f1.add(childGender);f1.add(childgenderbox);
				f1.setSize(500,180);
				f1.setLayout(null);
				f1.setVisible(true);
			}
		});
		
		l11=new JLabel("to outer details .");
		l11.setBounds(370,350,110,30);
		
		File thicklinefile1=new File("./images/thickline.png");
		BufferedImage thicklineimage1=ImageIO.read(thicklinefile);
		l12=new JLabel(new ImageIcon(thicklineimage1));
		l12.setBounds(60,385,400,10);
		
		l13=new JLabel("Travel Insurance "); // add font size after
		l13.setBounds(50 ,395,100,50);
		
		l14=new JLabel("Do you want to take Travel Insurance ( Rs.0.49/person) :");
		l14.setBounds(50,430,400,30);
		
		JRadioButton button1=new JRadioButton();
		button1.setBounds(80,450,20,30);
		l15=new JLabel("YES and I accept the Terms & Conditions");
		l15.setBounds(110,450,300,30);
		
		JRadioButton button2=new JRadioButton("No");
		button2.setBounds(80,480,20,30);
		l16=new JLabel("No");
		l16.setBounds(110,480,50,30);
		
		File thicklinefile2=new File("./images/thickline.png");
		BufferedImage thicklineimage2=ImageIO.read(thicklinefile2);
		l17=new JLabel(new ImageIcon(thicklineimage2));
		l17.setBounds(60,510,400,10);
		
		l18=new JLabel("Email :");
		l18.setBounds(80,530,50,30);
		l20=new JLabel("( Ticket details will be sent to this email )");
		l20.setBounds(60,565,250,10);
		tf2=new JTextField();
		tf2.setBounds(130,530,150,30);
		
		l19=new JLabel("Mobile No. :");
		l19.setBounds(320,530,70,30);
		l21=new JLabel("( SMS will be sent to this number )");
		l21.setBounds(340,565,250,10);
		tf3=new JTextField();
		tf3.setBounds(390,530,150,30);
		
		File thicklinefile3=new File("./images/thickline.png");
		BufferedImage thicklineimage3=ImageIO.read(thicklinefile3);
		l22=new JLabel(new ImageIcon(thicklineimage3));
		l22.setBounds(60,580,400,10);
		
		l23=new JLabel("Payment Mode ");//change font size and weight
		l23.setBounds(40,590,90,50);
		
		JRadioButton radiobutton3=new JRadioButton();
		radiobutton3.setBounds(60,620,20,30);
		l24=new JLabel("Payment through Credit & Debit card / Net Banking / Wallets");
		l24.setBounds(90,620,350,30);
		l25=new JLabel(" ( Convenience Fee : Rs. 15 /- + GST)");
		l25.setBounds(100,645,300,10);
		
		JButton b1=new JButton(" Replan");
		b1.setBounds(150,690,90,30);
		b1.setBackground(Color.blue);
		b1.setForeground(Color.white);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registeration rs=new Registeration();
				try {
					rs.Register(FIRSTNAME,LASTNAME," "," "," ");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		JButton b2=new JButton("Continue");
		b2.setBounds(260,690,90,30);
		b2.setBackground(Color.blue);
		b2.setForeground(Color.white);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fromAirport=fromText;
				String toAirport=toText;
				String countryName=(String) countriesBox.getItemAt(countriesBox.getSelectedIndex());
				String travellerName=tf1.getText();
				Review_Booking reviewbooking = new Review_Booking();
				try {
					reviewbooking.review(airlinename,fromAirport,toAirport,countryName,travellerName);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(tf1);f.add(l5);f.add(ageBox);f.add(l6);f.add(genderBox);f.add(countriesBox);f.add(l7);
		f.add(l8);f.add(l9);f.add(l10);f.add(l11);f.add(l12);f.add(l13);f.add(l14);f.add(button1);f.add(button2);f.add(l15);f.add(l16);
		f.add(l17);f.add(l18);f.add(tf2);f.add(l19);f.add(tf3);f.add(l20);f.add(l21);f.add(l22);f.add(l23);f.add(radiobutton3);
		f.add(l24);f.add(l25);f.add(b1);f.add(b2);f.setJMenuBar(bar);
		f.setSize(580,800);
		f.setLayout(null);
		f.setVisible(true);
	}
	
}
