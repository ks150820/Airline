package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextField;

public class Registeration {
	JFrame f;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
	JTextField tf1,tf2,tf3,tf4;
	JButton b1,b2,b3,b4;
	JMenu menu;
	JMenuItem logout;
public void Register(String FIRSTNAME,String LASTNAME,String fromText,String toText ,String classText) throws IOException {
	
	f=new JFrame("Registeration");
	
	String[] classes= {classText};
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
	tf1.setText(fromText);
	
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
	tf2.setText(toText);
	
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
	 
	l7 = new JLabel("Best departing flights");
	l7.setBounds(60,240,200,30);
	
	//air india
	String path2="./images/airindia.png";
	File file2=new File(path2);
	BufferedImage image2=ImageIO.read(file2);
	l8=new JLabel(new ImageIcon(image2));
	l8.setBounds(60,270,96,30);
	
	
	l9=new JLabel("Air India          13:45 - 15:25       1 h 15 m      Rs.5,662");
	l9.setBounds(200,270,300,30);
	b1=new JButton("Book Now");
	b1.setBounds(520,270,100,30);
	b1.setBackground(Color.green);
	b1.setOpaque(true);
	b1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String setAirlineName="Air India";
			String getFromText=tf1.getText();
			String gettoText=tf2.getText();

			ImageIcon icon = new ImageIcon("images/flashing_line.gif");
            JOptionPane.showMessageDialog(
                    null,
                     "",
                    "Hello", JOptionPane.PLAIN_MESSAGE,
                    icon);
			
			AirIndia_confirmation con=new AirIndia_confirmation();
			try {
				con.confirmation(FIRSTNAME,LASTNAME,getFromText,gettoText,setAirlineName);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
		}
	});
	
	//Air Asia
	String path3="./images/airasia.png";
	File file3=new File(path3);
	BufferedImage image3=ImageIO.read(file3);
	l10=new JLabel(new ImageIcon(image3));
	l10.setBounds(60,320,96,30);
	
	l11=new JLabel("AirAsia          13:45 - 15:25       1 h 15 m      Rs.5,662");
	l11.setBounds(200,320,300,30);
	b2=new JButton("Book Now");
	b2.setBounds(520,320,100,30);
	b2.setBackground(Color.green);
	b2.setOpaque(true);
	b2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String setAirlineName="AirAsia";
			String getFromText=tf1.getText();
			String gettoText=tf2.getText();
			AirAsia_confirmation airasia=new AirAsia_confirmation();
			try {
				airasia.confirmation(FIRSTNAME,LASTNAME,getFromText,gettoText,setAirlineName);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	});
	
	//vistara
	String path4="./images/vistara.png";
	File file4=new File(path4);
	BufferedImage image4=ImageIO.read(file4);
	l12=new JLabel(new ImageIcon(image4));
	l12.setBounds(60,360,96,30);
	
	l13=new JLabel("Vistara          13:45 - 15:25       1 h 15 m      Rs.5,662");
	l13.setBounds(200,360,300,30);
	b3=new JButton("Book Now");
	b3.setBounds(520,360,100,30);
	b3.setBackground(Color.green);
	b3.setOpaque(true);
	b3.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String setAirlineName="Vistara";
			String getFromText=tf1.getText();
			String gettoText=tf2.getText();
			Vistara_confirmation vistara=new Vistara_confirmation();
			try {
				vistara.confirmation(FIRSTNAME,LASTNAME,getFromText,gettoText,setAirlineName);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	});
	
	//indigo
	String path5="./images/indigo.png";
	File file5=new File(path5);
	BufferedImage image5=ImageIO.read(file5);
	l14=new JLabel(new ImageIcon(image5));
	l14.setBounds(60,400,96,30);
	
	l15=new JLabel("Indigo          13:45 - 15:25       1 h 15 m      Rs.5,662");
	l15.setBounds(200,400,300,30);
	b4=new JButton("Book Now");
	b4.setBounds(520,400,100,30);
	b4.setBackground(Color.green);
	b4.setOpaque(true);
	b4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String setAirlineName="indigo";
			String getFromText=tf1.getText();
			String gettoText=tf2.getText();
			Indigo_confirmation indigo=new Indigo_confirmation();
			try {
				indigo.confirmation(FIRSTNAME,LASTNAME,getFromText,gettoText,setAirlineName);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	});
	
	
	
	f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(l5);f.add(l6);f.add(l7);f.add(cb1);f.add(cb2);f.add(cb3);f.add(cb4);f.add(tf1);
	f.add(tf2);f.add(l8);f.add(l9);f.add(b1);f.add(l10);f.add(l11);f.add(b2);f.add(l12);f.add(l13);f.add(b3);f.add(l14);f.add(l15);
	f.add(b4);f.setJMenuBar(bar);
	f.setSize(700,500);
	f.setLayout(null);
	f.setVisible(true);
	
}


}
