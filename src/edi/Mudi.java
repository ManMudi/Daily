package edi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.Border;
import javax.swing.text.NumberFormatter;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.lowagie.text.Element;
import com.toedter.calendar.JDateChooser;

import net.proteanit.sql.DbUtils;

public class Mudi extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel p,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18,p19,p20,p21,p22,p23,p24,p25,p26,p27,p28,p29,p30,p31,p32,p33,p34,p35,p36,p37,p38,p39,p40,p41,p42,p43,p44;
	private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,la1,la2,la3,la4,la5,la6,la7,la8,la9,la10,la11,la12,la13,la14,la15,la16,la17,la18,la19,la20,la0,ll4;
	private JTextField t2,ta1,ta2,ta3,ta5,ta7,ta8,ta9,ta10;
	private JTextField t1,ta0;
	private JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label44,labe1,labe2,labe3,labe4;
	private JTextField tx1,tx2,tx3,tx4,tx7,tx8,tx9,tx10,tx44,tex3;
	private String[]name3={"FORM I","FORM II","FORM III","FORM IV","FORM V","FORM VI"};
	private String[]name2={"MALE","FEMALE"};
	private JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22,b23;
	private JComboBox<String> t3,t4,ta4,box,box1,box2,box3,box4,box5,box6,box7,box8,box9,box10,t5,tx5,tx6,tx11,tx12,tex1,tex2;
	private JTextArea text1,text2,ta6,text4,tex4;
	private Double n1,n2,ans;
	private JScrollPane pane1,pane2,pane3,pane4,pane5,pane6;
	private JTabbedPane tab;
	private  Calendar timer;
	private SimpleDateFormat dt,df,dtt;
	private SimpleDateFormat mm;
	private SimpleDateFormat yy;
	private JDateChooser dc,dd;
	private String operation;
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private JTable table,table1,table2;

	

	public Mudi() {
		
		
		super("Daily Transaction");
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {

		}
		
		 try {
				
				Class.forName("org.sqlite.JDBC");
				con=DriverManager.getConnection("jdbc:sqlite:Fund.sqlite");
				//JOptionPane.showMessageDialog(null, "OK");
			
		} catch (Exception e) {
		JOptionPane.showMessageDialog(null, e.getStackTrace());
		}
		 finally{
         try{
             rs.close();
             ps.close();
         }catch(Exception ex){
             ex.getMessage();
         }}

		 timer=Calendar.getInstance();
		 timer.getTime();
		 dt=new SimpleDateFormat("MMM dd,  yyyy");
		 mm=new SimpleDateFormat("MMM");
		 yy=new SimpleDateFormat("yyyy");
		
		 dtt= new SimpleDateFormat("hh:mm:ss a");
		  df=new SimpleDateFormat("MMM dd,  yyyy");
		 
		 
		 
		 
		
		    String name4[]= {"Jan", "Feb", "Mar", "Apr", "May", "Jun","Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
			box=new JComboBox<String>(name4);box.setToolTipText("Select Month");
			box.setMaximumRowCount(12);box.setSelectedItem(mm.format(timer.getTime()));
			
			ArrayList<String> years_tmp = new ArrayList<String>();
			for(int years=2020; years<=Calendar.getInstance().get(Calendar.YEAR); years++) {
			    years_tmp.add(years+"");
			}
			
			
			box1 = new JComboBox(years_tmp.toArray());box1.setToolTipText("Select Year");
			box1.setSelectedItem(yy.format(timer.getTime()));
			
			la7=new JLabel("Month");la7.setFont(new Font("verdana",Font.BOLD,14));la7.setForeground(new Color(46,139,87));
			la8=new JLabel("Year");la8.setFont(new Font("verdana",Font.BOLD,14));la8.setForeground(new Color(46,139,87));
			
			la9=new JLabel("Year");la9.setFont(new Font("verdana",Font.BOLD,14));la9.setForeground(new Color(46,139,87));
			box2= new JComboBox(years_tmp.toArray());box2.setToolTipText("Select Year");
			box2.setSelectedItem(yy.format(timer.getTime()));
		
		
		
      
		setLayout(new BorderLayout());
		
		p=new JPanel();
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		p5=new JPanel();
		p6=new JPanel();
		p7=new JPanel();
		p8=new JPanel();
		p9=new JPanel();
		p10=new JPanel();
		p11=new JPanel();
		p12=new JPanel();
		p13=new JPanel();
		p14=new JPanel();
		p15=new JPanel();
		p16=new JPanel();
		p17=new JPanel();
		p18=new JPanel();
		p19=new JPanel();
		p20=new JPanel();
		p21=new JPanel();
		p22=new JPanel();
		p23=new JPanel();
		p24=new JPanel();
		p25=new JPanel();
		p26=new JPanel();
		p27=new JPanel();
		p28=new JPanel();
		p29=new JPanel();
		p30=new JPanel();
		p31=new JPanel();
		p32=new JPanel();
		p33=new JPanel();
		p34=new JPanel();
		p35=new JPanel();
		p36=new JPanel();
		p37=new JPanel();
		p38=new JPanel();
		p39=new JPanel();
		p40=new JPanel();
		p41=new JPanel();
		p42=new JPanel();
		p43=new JPanel();
		p44=new JPanel();
		
		Border in=BorderFactory.createEmptyBorder(7,5,6,5);//p6.setBackground(Color.BLACK);
		Border ou=BorderFactory.createTitledBorder("");
		Border in1=BorderFactory.createEmptyBorder(2,4,2,4);//p6.setBackground(Color.BLACK);
		Border ou1=BorderFactory.createTitledBorder("");
		p10.setBorder(BorderFactory.createCompoundBorder(in1, ou1));
		//p1.setBackground(Color.BLACK);
		p5.setBorder(BorderFactory.createCompoundBorder(in, ou));//p5.setBackground(Color.BLACK);
		p6.setBorder(BorderFactory.createCompoundBorder(in, ou));
		p7.setBorder(BorderFactory.createCompoundBorder(in, ou));
		p4.setBorder(BorderFactory.createCompoundBorder(in1, ou1));
		p15.setBorder(BorderFactory.createCompoundBorder(in, ou));
		p19.setBorder(BorderFactory.createCompoundBorder(in, ou));
		p17.setBorder(BorderFactory.createCompoundBorder(in, ou));
		p18.setBorder(BorderFactory.createCompoundBorder(in, ou));
		p20.setBorder(BorderFactory.createCompoundBorder(in, ou));
		p21.setBorder(BorderFactory.createCompoundBorder(in, ou));
	    p35.setBorder(BorderFactory.createCompoundBorder(in, ou));
	    p36.setBorder(BorderFactory.createCompoundBorder(in, ou));
	    p40.setBorder(BorderFactory.createCompoundBorder(in, ou));
	    p41.setBorder(BorderFactory.createCompoundBorder(in, ou));
	    p38.setBorder(BorderFactory.createCompoundBorder(in, ou));
	    p33.setBorder(BorderFactory.createCompoundBorder(in, ou));
	    p42.setBorder(BorderFactory.createCompoundBorder(in, ou));
	   
		JLabel n=new JLabel("DAILY SCHOOL TRANSACTIONS  SYSTEM");//n.setFont(new Font("Poor Richard",Font.TRUETYPE_FONT+Font.PLAIN+Font.BOLD,45));
		n.setFont(new Font("Castellar",Font.ROMAN_BASELINE+Font.BOLD,47));
		n.setForeground(new Color(128,128,0));
	    p4.add(n);//p1.setBackground(Color.black);
		
	    tab=new JTabbedPane();add(tab);
		tab.addTab("Transaction Information",null, p,"Transaction Information");
		tab.addTab("Loan Information",null, p13,"Loan Information");
		tab.addTab("Pocket Money",null, p31,"Packet Money");
		
		p31.setLayout(new BorderLayout());
		p31.add(p32,BorderLayout.WEST);
		p31.add(p33,BorderLayout.CENTER);
		
		p32.setLayout(new BorderLayout());
		p32.add(p34,BorderLayout.NORTH);
		
		p34.setLayout(new BorderLayout());
		p34.add(p35,BorderLayout.NORTH);
		p34.add(p36,BorderLayout.CENTER);
		p34.add(p37,BorderLayout.SOUTH);
		
		p37.setLayout(new BorderLayout());
		p37.add(p40,BorderLayout.NORTH);
		p37.add(p41,BorderLayout.CENTER);
		p37.add(p42,BorderLayout.SOUTH);
		
		////p33.setLayout(new BorderLayout());
		//p33.add(p38,BorderLayout.NORTH);
		//p33.add(p39,BorderLayout.CENTER);
		
		//add(p);
		p.setBackground(Color.pink);
		p.setLayout(new BorderLayout());
		
		p.add(p2,BorderLayout.WEST);
		p.add(p1,BorderLayout.CENTER);//p1.setBackground(Color.red);
		
		p2.setLayout(new BorderLayout());
		p2.add(p3,BorderLayout.WEST);
		//p2.add(p4,BorderLayout.CENTER);
		
		p3.setLayout(new BorderLayout());
		p3.add(p5,BorderLayout.NORTH);
		p3.add(p6,BorderLayout.CENTER);
		p3.add(p7,BorderLayout.SOUTH);
		
		p1.setLayout(new BorderLayout());
		p1.add(p4,BorderLayout.NORTH);
		p1.add(p10,BorderLayout.CENTER);//p10.setBackground(Color.red);
		
		p13.setLayout(new BorderLayout());
		p13.add(p14,BorderLayout.WEST);
		p13.add(p15,BorderLayout.CENTER);
		
		p14.setLayout(new BorderLayout());
		p14.add(p16,BorderLayout.NORTH);
		p14.add(p17,BorderLayout.CENTER);
		p14.add(p18,BorderLayout.SOUTH);//p15.setBackground(Color.red);
		
		p16.setLayout(new BorderLayout());
		p16.add(p19,BorderLayout.NORTH);
		p16.add(p20,BorderLayout.CENTER);//p20.setBackground(Color.black);
		p16.add(p21,BorderLayout.SOUTH);
		
		Icon refresh=new ImageIcon(this.getClass().getResource("/refresh.png"));
		Icon search=new ImageIcon(this.getClass().getResource("/search.png"));
		
		la1=new JLabel();la1.setIcon(search);
		ta1=new JTextField(11);
		
		 l7=new JLabel("Select Date");l7.setFont(new Font("verdana",Font.BOLD,14));l7.setForeground(new Color(46,139,87));
		 dc=new JDateChooser();dc.setFont(new Font("serif",Font.BOLD,12));dc.setDateFormatString(dt.format(timer.getTime()));
		 Date date = new Date();
		 dc.setDate(date);
		 
		 la18=new JLabel("Select Account");la18.setFont(new Font("verdana",Font.BOLD,14));la18.setForeground(new Color(46,139,87));
		 t5=new JComboBox<String>();t5.setMaximumRowCount(10);t5.setToolTipText("Select Account");t5.setSelectedItem(null);
		 
		 label44=new JLabel("Enter  Account");label44.setFont(new Font("verdana",Font.BOLD,14));label44.setForeground(new Color(46,139,87));
		 tx44=new JTextField(10);
		 
		 p44.setLayout(new GridBagLayout());
		   GridBagConstraints ccna7=new GridBagConstraints();
			ccna7.fill=GridBagConstraints.HORIZONTAL;
			ccna7.weightx=1;ccna7.weighty=1;
			ccna7.insets=new Insets(3,2,3,2);

			ccna7.gridx=1;ccna7.gridy=1;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p44.add(label44,ccna7);
			ccna7.gridx=2;ccna7.gridy=1;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p44.add(tx44,ccna7);
		 
		  p30.setLayout(new GridBagLayout());
			ccna7.fill=GridBagConstraints.HORIZONTAL;
			ccna7.weightx=1;ccna7.weighty=1;
			ccna7.insets=new Insets(3,2,3,2);

			ccna7.gridx=1;ccna7.gridy=1;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p30.add(la18,ccna7);
			ccna7.gridx=2;ccna7.gridy=1;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p30.add(t5,ccna7);
		
			tx1=new JTextField(12);
			label1=new JLabel();
			label1.setIcon(search);
			
			label2=new JLabel("User_ID");label2.setFont(new Font("georgia",Font.BOLD,13));label2.setForeground(new Color(46,139,87));
		    tx2=new JTextField(10);tx2.setToolTipText("Enter User_ID");
		    label3=new JLabel("First Name");label3.setFont(new Font("georgia",Font.BOLD,13));label3.setForeground(new Color(46,139,87));
		    tx3=new JTextField(10);tx3.setToolTipText("Enter First Name");
		    label4=new JLabel("Last Name");label4.setFont(new Font("georgia",Font.BOLD,13));label4.setForeground(new Color(46,139,87));
		    tx4=new JTextField(10);tx4.setToolTipText("Enter Last Name");
		    label5=new JLabel("Gender");label5.setFont(new Font("georgia",Font.BOLD,13));label5.setForeground(new Color(46,139,87));
		    tx5=new JComboBox<String>(name2);tx5.setToolTipText("Enter Gender");tx5.setSelectedItem(null);
		    label6=new JLabel("Class");label6.setFont(new Font("georgia",Font.BOLD,13));label6.setForeground(new Color(46,139,87));
		    tx6=new JComboBox<String>(name3);tx6.setToolTipText("Enter Class");tx6.setSelectedItem(null);
		    label7=new JLabel("Balance");label7.setFont(new Font("georgia",Font.BOLD,13));label7.setForeground(new Color(46,139,87));
		    tx7=new JTextField(10);tx7.setToolTipText("Enter Balance");
		    
		    
		    label8=new JLabel("User_ID");label8.setFont(new Font("georgia",Font.BOLD,13));label8.setForeground(new Color(46,139,87));
		    tx8=new JTextField(10);tx8.setToolTipText("Enter User_ID");tx8.setEditable(false);
		    label9=new JLabel("First Name");label9.setFont(new Font("georgia",Font.BOLD,13));label9.setForeground(new Color(46,139,87));
		    tx9=new JTextField(10);tx9.setToolTipText("Enter First Name");
		    label10=new JLabel("Last Name");label10.setFont(new Font("georgia",Font.BOLD,13));label10.setForeground(new Color(46,139,87));
		    tx10=new JTextField(10);tx10.setToolTipText("Enter Last Name");
		    label11=new JLabel("Gender");label11.setFont(new Font("georgia",Font.BOLD,13));label11.setForeground(new Color(46,139,87));
		    tx11=new JComboBox<String>(name2);tx11.setToolTipText("Enter Gender");tx11.setSelectedItem(null);
		    label12=new JLabel("Class");label12.setFont(new Font("georgia",Font.BOLD,13));label12.setForeground(new Color(46,139,87));
		    tx12=new JComboBox<String>(name3);tx12.setToolTipText("Enter Class");tx12.setSelectedItem(null);
		    
		    b16=new JButton("Deposit");b16.setFont(new Font("verdana",Font.BOLD,12));b16.setBackground(Color.PINK);b16.setForeground(Color.BLUE);
		    b17=new JButton("Withdraw");b17.setFont(new Font("verdana",Font.BOLD,12));b17.setBackground(Color.PINK);b17.setForeground(Color.BLUE);
		
		    b18=new JButton("Save");b18.setFont(new Font("verdana",Font.BOLD,12));b18.setBackground(Color.lightGray);b18.setForeground(Color.BLUE);
		    b19=new JButton("Update");b19.setFont(new Font("verdana",Font.BOLD,12));b19.setBackground(Color.lightGray);b19.setForeground(Color.BLUE);
		    b20=new JButton("Delete");b20.setFont(new Font("verdana",Font.BOLD,12));b20.setBackground(Color.lightGray);b20.setForeground(Color.BLUE);
		    b21=new JButton("Refresh");b21.setFont(new Font("verdana",Font.BOLD,12));b21.setBackground(Color.lightGray);b21.setForeground(Color.BLUE);
		    b22=new JButton("Student Report");b22.setFont(new Font("verdana",Font.BOLD,12));b22.setBackground(Color.pink);b22.setForeground(Color.BLUE);
		    b23=new JButton("All Student Report");b23.setFont(new Font("verdana",Font.BOLD,12));b23.setBackground(Color.pink);b23.setForeground(Color.BLUE);
		    
		    
		    
		    p41.setLayout(new GridBagLayout());
			ccna7.fill=GridBagConstraints.HORIZONTAL;
			ccna7.weightx=1;ccna7.weighty=1;
			ccna7.insets=new Insets(3,2,3,2);

			ccna7.gridx=1;ccna7.gridy=1;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p41.add(b18,ccna7);
			ccna7.gridx=2;ccna7.gridy=1;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p41.add(b19,ccna7);
			ccna7.gridx=1;ccna7.gridy=2;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p41.add(b20,ccna7);
			ccna7.gridx=2;ccna7.gridy=2;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p41.add(b21,ccna7);
			
			
			 p43.setLayout(new GridBagLayout());
				ccna7.fill=GridBagConstraints.HORIZONTAL;
				ccna7.weightx=1;ccna7.weighty=1;
				ccna7.insets=new Insets(3,2,3,2);

				ccna7.gridx=1;ccna7.gridy=1;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p43.add(label8,ccna7);
				ccna7.gridx=2;ccna7.gridy=1;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p43.add(tx8,ccna7);
				ccna7.gridx=1;ccna7.gridy=2;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p43.add(label9,ccna7);
				ccna7.gridx=2;ccna7.gridy=2;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p43.add(tx9,ccna7);
				ccna7.gridx=1;ccna7.gridy=3;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p43.add(label10,ccna7);
				ccna7.gridx=2;ccna7.gridy=3;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p43.add(tx10,ccna7);
				ccna7.gridx=1;ccna7.gridy=4;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p43.add(label11,ccna7);
				ccna7.gridx=2;ccna7.gridy=4;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p43.add(tx11,ccna7);
				ccna7.gridx=1;ccna7.gridy=5;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p43.add(label12,ccna7);
				ccna7.gridx=2;ccna7.gridy=5;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p43.add(tx12,ccna7);
			
			   p42.setLayout(new GridBagLayout());
				ccna7.fill=GridBagConstraints.HORIZONTAL;
				ccna7.weightx=1;ccna7.weighty=1;
				ccna7.insets=new Insets(3,2,3,2);

				ccna7.gridx=1;ccna7.gridy=1;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p42.add(b22,ccna7);
				
				ccna7.gridx=1;ccna7.gridy=2;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p42.add(b23,ccna7);
			
			
		    p40.setLayout(new GridBagLayout());
			ccna7.fill=GridBagConstraints.HORIZONTAL;
			ccna7.weightx=1;ccna7.weighty=1;
			ccna7.insets=new Insets(3,2,3,2);

			ccna7.gridx=1;ccna7.gridy=1;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p40.add(b16,ccna7);
			ccna7.gridx=2;ccna7.gridy=1;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p40.add(b17,ccna7);
			
			
			   p35.setLayout(new GridBagLayout());
				ccna7.fill=GridBagConstraints.HORIZONTAL;
				ccna7.weightx=1;ccna7.weighty=1;
				ccna7.insets=new Insets(3,2,3,2);

				ccna7.gridx=1;ccna7.gridy=1;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p35.add(tx1,ccna7);
				ccna7.gridx=2;ccna7.gridy=1;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p35.add(label1,ccna7);
			
				
				p36.setLayout(new GridBagLayout());
				ccna7.fill=GridBagConstraints.HORIZONTAL;
				ccna7.weightx=1;ccna7.weighty=1;
				ccna7.insets=new Insets(3,2,3,2);

				ccna7.gridx=1;ccna7.gridy=1;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p36.add(label2,ccna7);
				ccna7.gridx=2;ccna7.gridy=1;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p36.add(tx2,ccna7);
				
				ccna7.gridx=1;ccna7.gridy=2;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p36.add(label3,ccna7);
				ccna7.gridx=2;ccna7.gridy=2;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p36.add(tx3,ccna7);
				
				ccna7.gridx=1;ccna7.gridy=3;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p36.add(label4,ccna7);
				ccna7.gridx=2;ccna7.gridy=3;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p36.add(tx4,ccna7);
				
				ccna7.gridx=1;ccna7.gridy=4;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p36.add(label5,ccna7);
				ccna7.gridx=2;ccna7.gridy=4;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p36.add(tx5,ccna7);
				
				ccna7.gridx=1;ccna7.gridy=5;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p36.add(label6,ccna7);
				ccna7.gridx=2;ccna7.gridy=5;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p36.add(tx6,ccna7);
				
				ccna7.gridx=1;ccna7.gridy=6;
				ccna7.anchor=GridBagConstraints.LINE_END;
				//p36.add(label7,ccna7);
				ccna7.gridx=2;ccna7.gridy=6;
				ccna7.anchor=GridBagConstraints.LINE_END;
				//p36.add(tx7,ccna7);
			
				
		   p22.setLayout(new GridBagLayout());
			ccna7.fill=GridBagConstraints.HORIZONTAL;
			ccna7.weightx=1;ccna7.weighty=1;
			ccna7.insets=new Insets(3,2,3,2);

			ccna7.gridx=1;ccna7.gridy=1;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p22.add(l7,ccna7);
			ccna7.gridx=2;ccna7.gridy=1;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p22.add(dc,ccna7);
			
		    	 p24.setLayout(new GridBagLayout());
				ccna7.fill=GridBagConstraints.HORIZONTAL;
				ccna7.weightx=1;ccna7.weighty=1;
				ccna7.insets=new Insets(3,2,3,2);

				ccna7.gridx=1;ccna7.gridy=1;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p24.add(la9,ccna7);
				ccna7.gridx=2;ccna7.gridy=1;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p24.add(box2,ccna7);
			
				
		
			
			   p23.setLayout(new GridBagLayout());
				ccna7.fill=GridBagConstraints.HORIZONTAL;
				ccna7.weightx=1;ccna7.weighty=1;
				ccna7.insets=new Insets(3,2,3,2);

				ccna7.gridx=1;ccna7.gridy=1;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p23.add(la7,ccna7);
				ccna7.gridx=2;ccna7.gridy=1;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p23.add(la8,ccna7);
				
				ccna7.gridx=1;ccna7.gridy=2;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p23.add(box,ccna7);
				ccna7.gridx=2;ccna7.gridy=2;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p23.add(box1,ccna7);
			
				
		   p19.setLayout(new GridBagLayout());
			ccna7.fill=GridBagConstraints.HORIZONTAL;
			ccna7.weightx=1;ccna7.weighty=1;
			ccna7.insets=new Insets(2,2,2,3);

			ccna7.gridx=2;ccna7.gridy=1;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p19.add(la1,ccna7);
			ccna7.gridx=1;ccna7.gridy=1;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p19.add(ta1,ccna7);
			
			  table=new JTable();
		       pane5=new JScrollPane(table);
		       p10.setLayout(new GridLayout());
		       p10.add(pane5);
		       table.getTableHeader().setReorderingAllowed(false);
		       
		       table1=new JTable();
		       pane6=new JScrollPane(table1);
		       p15.setLayout(new GridLayout());
		       p15.add(pane6);
		       table1.getTableHeader().setReorderingAllowed(false);
		       
		       table2=new JTable();
		       pane3=new JScrollPane(table2);
		       p33.setLayout(new GridLayout());
		       p33.add(pane3);
		       table2.getTableHeader().setReorderingAllowed(false);
		       
		
		l1=new JLabel("Enter Amount (Tsh.)");l1.setFont(new Font("verdana",Font.BOLD,14));l1.setForeground(new Color(46,139,87));
		t1 = new JTextField(12);t1.setForeground(Color.BLACK);
	    t1.setToolTipText("Enter Amount");t1.setFont(new Font("verdana",Font.BOLD,12));

		
	  //  String name4[]= {"Umeme", "Gari" };
	    t3=new JComboBox<String>();t3.setMaximumRowCount(10);t3.setToolTipText("Chagua Mfuko");t3.setSelectedItem(null);
	    b1=new JButton("Deposit");b1.setFont(new Font("verdana",Font.BOLD,12));b1.setBackground(Color.PINK);b1.setForeground(Color.BLUE);
	    b2=new JButton("Withdraw");b2.setFont(new Font("verdana",Font.BOLD,12));b2.setBackground(Color.PINK);b2.setForeground(Color.BLUE);
	    b3=new JButton("Refresh");b3.setFont(new Font("verdana",Font.BOLD,12));b3.setBackground(Color.PINK);b3.setForeground(Color.BLUE);
	    b4=new JButton("Daily Report");b4.setFont(new Font("verdana",Font.BOLD,12));b4.setBackground(Color.lightGray);b4.setForeground(Color.BLUE);
	    b5=new JButton("Monthly Report");b5.setFont(new Font("verdana",Font.BOLD,12));b5.setBackground(Color.lightGray);b5.setForeground(Color.BLUE);
	    b6=new JButton("Yearly Report");b6.setFont(new Font("verdana",Font.BOLD,12));b6.setBackground(Color.lightGray);b6.setForeground(Color.BLUE);
	    b7=new JButton("All Time Report");b7.setFont(new Font("verdana",Font.BOLD,12));b7.setBackground(Color.lightGray);b7.setForeground(Color.BLUE);
	    
	    b8=new JButton("Add User");b8.setFont(new Font("verdana",Font.BOLD,12));b8.setBackground(Color.PINK);b8.setForeground(Color.BLUE);
	    b9=new JButton("Refresh");b9.setFont(new Font("verdana",Font.BOLD,12));b9.setBackground(Color.PINK);b9.setForeground(Color.BLUE);
	    b10=new JButton("Take Loan");b10.setFont(new Font("verdana",Font.BOLD,12));b10.setBackground(Color.PINK);b10.setForeground(Color.BLUE);
	    b11=new JButton("Pay Loan");b11.setFont(new Font("verdana",Font.BOLD,12));b11.setBackground(Color.PINK);b11.setForeground(Color.BLUE);
	    
	    b12=new JButton("User Report");b12.setFont(new Font("verdana",Font.BOLD,12));b12.setBackground(Color.lightGray);b12.setForeground(Color.BLUE);
	    b13=new JButton("All Users Report");b13.setFont(new Font("verdana",Font.BOLD,12));b13.setBackground(Color.lightGray);b13.setForeground(Color.BLUE);
	    b14=new JButton("Account Report");b14.setFont(new Font("verdana",Font.BOLD,12));b14.setBackground(Color.lightGray);b14.setForeground(Color.BLUE);
	    b15=new JButton("All Account Report");b15.setFont(new Font("verdana",Font.BOLD,12));b15.setBackground(Color.lightGray);b15.setForeground(Color.BLUE);
	    
	    
	    JLabel b0=new JLabel("       ");//b0.setIcon(refresh);
	    
	    l4=new JLabel("Select Category to Delete");l4.setFont(new Font("georgia",Font.BOLD,13));l4.setForeground(new Color(46,139,87));
	    t4=new JComboBox<String>();t4.setMaximumRowCount(10);t4.setToolTipText("Select");
	    
	    l4=new JLabel("Select Category to Delete");l4.setFont(new Font("georgia",Font.BOLD,13));l4.setForeground(new Color(46,139,87));
	    t4=new JComboBox<String>();t4.setMaximumRowCount(10);t4.setToolTipText("Select");
	    
	     la10=new JLabel("Category");la10.setFont(new Font("verdana",Font.BOLD,14));la10.setForeground(new Color(46,139,87));
		 la11=new JLabel("Date");la11.setFont(new Font("verdana",Font.BOLD,14));la11.setForeground(new Color(46,139,87));
		 dd=new JDateChooser();dd.setFont(new Font("serif",Font.BOLD,12));dd.setDateFormatString(dt.format(timer.getTime()));
		 dd.setDate(date);
		 box3=new JComboBox<String>();box3.setMaximumRowCount(10);box3.setToolTipText("Select");
		 
		  la12=new JLabel("Category");la12.setFont(new Font("verdana",Font.BOLD,14));la12.setForeground(new Color(46,139,87));
		  la13=new JLabel("Month");la13.setFont(new Font("verdana",Font.BOLD,14));la13.setForeground(new Color(46,139,87));
		  la14=new JLabel("Year");la14.setFont(new Font("verdana",Font.BOLD,14));la14.setForeground(new Color(46,139,87));
		  box4=new JComboBox<String>();box4.setMaximumRowCount(10);box4.setToolTipText("Select Category");
		  box5=new JComboBox<String>(name4);box5.setToolTipText("Select Month");
		  box5.setMaximumRowCount(12);box5.setSelectedItem(mm.format(timer.getTime()));
		  box6= new JComboBox(years_tmp.toArray());box6.setToolTipText("Select Year");
		  box6.setSelectedItem(yy.format(timer.getTime()));
		
		  
		  la15=new JLabel("Category");la15.setFont(new Font("verdana",Font.BOLD,14));la15.setForeground(new Color(46,139,87));
		  la16=new JLabel("Year");la16.setFont(new Font("verdana",Font.BOLD,14));la16.setForeground(new Color(46,139,87));
		  box7=new JComboBox<String>();box7.setMaximumRowCount(10);box7.setToolTipText("Select Category");
		  box8= new JComboBox(years_tmp.toArray());box8.setToolTipText("Select Year");
		  box8.setSelectedItem(yy.format(timer.getTime()));
		  
		  la17=new JLabel("Category");la17.setFont(new Font("verdana",Font.BOLD,14));la17.setForeground(new Color(46,139,87));
		  box9=new JComboBox<String>();box9.setMaximumRowCount(10);box9.setToolTipText("Select Category");
		  
		    p28.setLayout(new GridBagLayout());
			ccna7.fill=GridBagConstraints.HORIZONTAL;
			ccna7.weightx=1;ccna7.weighty=1;
			ccna7.insets=new Insets(3,2,3,2);

			ccna7.gridx=1;ccna7.gridy=1;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p28.add(la17,ccna7);
			ccna7.gridx=2;ccna7.gridy=1;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p28.add(box9,ccna7);
		  
		  
		    p27.setLayout(new GridBagLayout());
			ccna7.fill=GridBagConstraints.HORIZONTAL;
			ccna7.weightx=1;ccna7.weighty=1;
			ccna7.insets=new Insets(3,2,3,2);

			ccna7.gridx=1;ccna7.gridy=1;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p27.add(la15,ccna7);
			ccna7.gridx=2;ccna7.gridy=1;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p27.add(la16,ccna7);
		
			ccna7.gridx=1;ccna7.gridy=2;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p27.add(box7,ccna7);
			ccna7.gridx=2;ccna7.gridy=2;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p27.add(box8,ccna7);
		
			
		    p26.setLayout(new GridBagLayout());
			ccna7.fill=GridBagConstraints.HORIZONTAL;
			ccna7.weightx=1;ccna7.weighty=1;
			ccna7.insets=new Insets(3,2,3,2);

			ccna7.gridx=1;ccna7.gridy=1;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p26.add(la12,ccna7);
			ccna7.gridx=2;ccna7.gridy=1;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p26.add(la13,ccna7);
			ccna7.gridx=3;ccna7.gridy=1;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p26.add(la14,ccna7);
			
			ccna7.gridx=1;ccna7.gridy=2;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p26.add(box4,ccna7);
			ccna7.gridx=2;ccna7.gridy=2;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p26.add(box5,ccna7);
			ccna7.gridx=3;ccna7.gridy=2;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p26.add(box6,ccna7);
			
			
			
			
		 
		   p25.setLayout(new GridBagLayout());
			ccna7.fill=GridBagConstraints.HORIZONTAL;
			ccna7.weightx=1;ccna7.weighty=1;
			ccna7.insets=new Insets(3,2,3,2);

			ccna7.gridx=1;ccna7.gridy=1;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p25.add(la10,ccna7);
			ccna7.gridx=2;ccna7.gridy=1;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p25.add(la11,ccna7);
			
			ccna7.gridx=1;ccna7.gridy=2;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p25.add(box3,ccna7);
			ccna7.gridx=2;ccna7.gridy=2;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p25.add(dd,ccna7);
		
	    
         
	    
	    p9.setLayout(new GridBagLayout());
		ccna7.fill=GridBagConstraints.HORIZONTAL;
		ccna7.weightx=1;ccna7.weighty=1;
		ccna7.insets=new Insets(2,2,2,3);

		ccna7.gridx=1;ccna7.gridy=1;
		ccna7.anchor=GridBagConstraints.LINE_END;
		p9.add(l4,ccna7);
		ccna7.gridx=2;ccna7.gridy=1;
		ccna7.anchor=GridBagConstraints.LINE_END;
		p9.add(t4,ccna7);
		
		la0=new JLabel("User_ID");la0.setFont(new Font("georgia",Font.BOLD,13));la0.setForeground(new Color(46,139,87));
	    ta0=new JTextField(10);ta0.setToolTipText("Enter User_ID");
		la2=new JLabel("First Name");la2.setFont(new Font("georgia",Font.BOLD,13));la2.setForeground(new Color(46,139,87));
	    ta2=new JTextField(10);ta2.setToolTipText("Enter First Name");
	    la3=new JLabel("Last Name");la3.setFont(new Font("georgia",Font.BOLD,13));la3.setForeground(new Color(46,139,87));
	    ta3=new JTextField(10);ta3.setToolTipText("Enter Last Name");
	    la4=new JLabel("Loan Type");la4.setFont(new Font("georgia",Font.BOLD,13));la4.setForeground(new Color(46,139,87));
	    ll4=new JLabel("From");ll4.setFont(new Font("georgia",Font.BOLD,13));ll4.setForeground(new Color(46,139,87));
	    ta4=new JComboBox<String>();ta4.setMaximumRowCount(10);ta4.setToolTipText("Select");ta4.setSelectedItem(null);
	    labe2=new JLabel("To");labe2.setFont(new Font("georgia",Font.BOLD,13));labe2.setForeground(new Color(46,139,87));ta4.addItem("PERSONAL");
		 tex2=new JComboBox<String>();tex2.setMaximumRowCount(10);tex2.setToolTipText("Select");tex2.setSelectedItem(null);tex2.addItem("PERSONAL");
	    la5=new JLabel("Amount");la5.setFont(new Font("georgia",Font.BOLD,13));la5.setForeground(new Color(46,139,87));
	    ta5=new JTextField(10);ta5.setToolTipText("Enter Loan Amount");
	    la6=new JLabel("Comment");la6.setFont(new Font("georgia",Font.BOLD,13));la6.setForeground(new Color(46,139,87));
	    ta6=new JTextArea(2,3);ta6.setToolTipText("Enter Loan Amount");pane3=new JScrollPane(ta6);
	    ta6.setLineWrap(true);//text2.setForeground(Color.RED);
		ta6.setWrapStyleWord(true);
		
		 labe1=new JLabel("From");labe1.setFont(new Font("georgia",Font.BOLD,13));labe1.setForeground(new Color(46,139,87));
		 tex1=new JComboBox<String>();tex1.setMaximumRowCount(10);tex1.setToolTipText("Select");tex1.setSelectedItem(null);
		
		 labe3=new JLabel("Amount");labe3.setFont(new Font("georgia",Font.BOLD,13));labe3.setForeground(new Color(46,139,87));
		 tex3=new JTextField(10);tex1.setToolTipText("Enter Amount");
		 labe4=new JLabel("Comment");labe4.setFont(new Font("georgia",Font.BOLD,13));labe4.setForeground(new Color(46,139,87));
		 tex4=new JTextArea(2,3);tex1.setMaximumRowCount(10);tex4.setToolTipText("Enter Loan Amount");
		
		 String name44[]= {"PERSONAL", "ANOTHER ACCOUNT"};
		 box10=new JComboBox<String>(name44);box10.setToolTipText("Select Month");box10.setSelectedItem(null);
	    
		    p29.setLayout(new GridBagLayout());
		    GridBagConstraints ccna77=new GridBagConstraints();
			ccna77.fill=GridBagConstraints.HORIZONTAL;
			ccna77.weightx=1;ccna77.weighty=1;
			ccna77.insets=new Insets(4,2,4,2);
			
			ccna77.gridx=1;ccna77.gridy=1;
			ccna77.anchor=GridBagConstraints.LINE_END;
			p29.add(ll4,ccna77);
			ccna77.gridx=2;ccna77.gridy=1;
			ccna77.anchor=GridBagConstraints.LINE_END;
			p29.add(ta4,ccna77);
			
			ccna77.gridx=1;ccna77.gridy=2;
			ccna77.anchor=GridBagConstraints.LINE_END;
			p29.add(labe2,ccna77);
			ccna77.gridx=2;ccna77.gridy=2;
			ccna77.anchor=GridBagConstraints.LINE_END;
			p29.add(tex2,ccna77);
			
			
			ccna77.gridx=1;ccna77.gridy=3;
			ccna77.anchor=GridBagConstraints.LINE_END;
			p29.add(la5,ccna77);
			ccna77.gridx=2;ccna77.gridy=3;
			ccna77.anchor=GridBagConstraints.LINE_END;
			p29.add(ta5,ccna77);
			
			ccna77.gridx=1;ccna77.gridy=4;
			ccna77.anchor=GridBagConstraints.LINE_END;
			p29.add(la6,ccna77);
			ccna77.gridx=2;ccna77.gridy=4;
			ccna77.anchor=GridBagConstraints.LINE_END;
			p29.add(ta6,ccna77);



		 
		 
	    p20.setLayout(new GridBagLayout());
	   // GridBagConstraints ccna77=new GridBagConstraints();
		ccna77.fill=GridBagConstraints.HORIZONTAL;
		ccna77.weightx=1;ccna77.weighty=1;
		ccna77.insets=new Insets(4,2,4,2);
		
		ccna77.gridx=1;ccna77.gridy=0;
		ccna77.anchor=GridBagConstraints.LINE_END;
		p20.add(la0,ccna77);
		ccna77.gridx=2;ccna77.gridy=0;
		ccna77.anchor=GridBagConstraints.LINE_END;
		p20.add(ta0,ccna77);

		ccna77.gridx=1;ccna77.gridy=1;
		ccna77.anchor=GridBagConstraints.LINE_END;
		p20.add(la2,ccna77);
		ccna77.gridx=2;ccna77.gridy=1;
		ccna77.anchor=GridBagConstraints.LINE_END;
		p20.add(ta2,ccna77);
		
		ccna77.gridx=1;ccna77.gridy=2;
		ccna77.anchor=GridBagConstraints.LINE_END;
		p20.add(la3,ccna77);
		ccna77.gridx=2;ccna77.gridy=2;
		ccna77.anchor=GridBagConstraints.LINE_END;
		p20.add(ta3,ccna77);
		
		ccna77.gridx=1;ccna77.gridy=3;
		ccna77.anchor=GridBagConstraints.LINE_END;
		p20.add(la4,ccna77);
		ccna77.gridx=2;ccna77.gridy=3;
		ccna77.anchor=GridBagConstraints.LINE_END;
		p20.add(box10,ccna77);
	    
		ccna77.gridx=1;ccna77.gridy=4;
		ccna77.anchor=GridBagConstraints.LINE_END;
		//p20.add(la5,ccna77);
		ccna77.gridx=2;ccna77.gridy=4;
		ccna77.anchor=GridBagConstraints.LINE_END;
		//p20.add(ta5,ccna77);
		
		ccna77.gridx=1;ccna77.gridy=5;
		ccna77.anchor=GridBagConstraints.LINE_END;
	//	p20.add(la6,ccna77);
		ccna77.gridx=2;ccna77.gridy=5;
		ccna77.anchor=GridBagConstraints.LINE_END;
	//	p20.add(pane3,ccna77);
		
		 p21.setLayout(new GridBagLayout());
			ccna7.fill=GridBagConstraints.HORIZONTAL;
			ccna7.weightx=1;ccna7.weighty=1;
			ccna7.insets=new Insets(3,2,3,2);

			ccna7.gridx=1;ccna7.gridy=2;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p21.add(b10,ccna7);
			ccna7.gridx=2;ccna7.gridy=2;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p21.add(b11,ccna7);
			
			ccna7.gridx=1;ccna7.gridy=1;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p21.add(b8,ccna7);
			ccna7.gridx=2;ccna7.gridy=1;
			ccna7.anchor=GridBagConstraints.LINE_END;
			p21.add(b9,ccna7);
			
			   p18.setLayout(new GridBagLayout());
				ccna7.fill=GridBagConstraints.HORIZONTAL;
				ccna7.weightx=1;ccna7.weighty=1;
				ccna7.insets=new Insets(3,2,3,2);

				ccna7.gridx=1;ccna7.gridy=1;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p18.add(b12,ccna7);
				ccna7.gridx=1;ccna7.gridy=2;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p18.add(b13,ccna7);
				
				ccna7.gridx=1;ccna7.gridy=3;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p18.add(b14,ccna7);
				ccna7.gridx=1;ccna7.gridy=4;
				ccna7.anchor=GridBagConstraints.LINE_END;
				p18.add(b15,ccna7);
		    
	    
		p5.setLayout(new GridBagLayout());
		GridBagConstraints ccna=new GridBagConstraints();
		ccna.fill=GridBagConstraints.HORIZONTAL;
		ccna.weightx=1;ccna.weighty=1;
		ccna.insets=new Insets(2,2,2,3);

		
		ccna.gridx=1;ccna.gridy=1;
		ccna.anchor=GridBagConstraints.LINE_END;
		p5.add(l1,ccna);
		
		ccna.gridx=1;ccna.gridy=2;
		ccna.anchor=GridBagConstraints.LINE_START;
		p5.add(t1,ccna);
		
		ccna.gridx=1;ccna.gridy=3;
		ccna.anchor=GridBagConstraints.LINE_END;
		p5.add(t3,ccna);
		
		ccna.gridx=1;ccna.gridy=4;
		ccna.anchor=GridBagConstraints.LINE_END;
		p5.add(b0,ccna);
	
		ccna.gridx=1;ccna.gridy=5;
		ccna.anchor=GridBagConstraints.LINE_END;
		p5.add(b1,ccna);
		
		ccna.gridx=1;ccna.gridy=6;
		ccna.anchor=GridBagConstraints.LINE_END;
		p5.add(b2,ccna);
		
		ccna.gridx=1;ccna.gridy=7;
		ccna.anchor=GridBagConstraints.LINE_END;
		p5.add(b3,ccna);
		
		
		
		p7.setLayout(new GridBagLayout());
		ccna7.fill=GridBagConstraints.HORIZONTAL;
		ccna7.weightx=1;ccna7.weighty=1;
		ccna7.insets=new Insets(2,2,2,3);

		ccna7.gridx=1;ccna7.gridy=1;
		ccna7.anchor=GridBagConstraints.LINE_END;
		p7.add(b4,ccna7);
		
		ccna7.gridx=1;ccna7.gridy=2;
		ccna7.anchor=GridBagConstraints.LINE_END;
		p7.add(b5,ccna7);
		
		ccna7.gridx=1;ccna7.gridy=3;
		ccna7.anchor=GridBagConstraints.LINE_END;
		p7.add(b6,ccna7);
		
		ccna7.gridx=1;ccna7.gridy=4;
		ccna7.anchor=GridBagConstraints.LINE_END;
		p7.add(b7,ccna7);
		
		l2=new JLabel("New Category");l2.setFont(new Font("georgia",Font.BOLD,13));l2.setForeground(new Color(46,139,87));
		t2=new JTextField(12);t2.setToolTipText("Enter Category Name");
		
		p8.setLayout(new GridBagLayout());
		ccna7.fill=GridBagConstraints.HORIZONTAL;
		ccna7.weightx=1;ccna7.weighty=1;
		ccna7.insets=new Insets(2,2,2,3);

		ccna7.gridx=1;ccna7.gridy=1;
		ccna7.anchor=GridBagConstraints.LINE_END;
		p8.add(l2,ccna7);
		ccna7.gridx=2;ccna7.gridy=1;
		ccna7.anchor=GridBagConstraints.LINE_END;
		p8.add(t2,ccna7);
		
		
		
		l3=new JLabel("DEPOSIT");l3.setFont(new Font("verdana",Font.BOLD,14));l3.setForeground(new Color(46,139,87));
		l5=new JLabel("");l5.setFont(new Font("verdana",Font.BOLD,14));l5.setForeground(new Color(0,0,255));
		l6=new JLabel("INTO");l6.setFont(new Font("verdana",Font.BOLD,14));l6.setForeground(new Color(46,139,87));
		l7=new JLabel("");l7.setFont(new Font("verdana",Font.BOLD,14));l7.setForeground(new Color(0,0,255));
		l8=new JLabel("COMMENT");l8.setFont(new Font("verdana",Font.BOLD,14));l8.setForeground(new Color(46,139,87));
		text1=new JTextArea(2,5);pane1=new JScrollPane(text1);text1.setForeground(Color.BLUE);
		text1.setLineWrap(true);
		text1.setWrapStyleWord(true);
		
		text4=new JTextArea(4,17);
		text4.setLineWrap(true);
		text4.setWrapStyleWord(true);
		text4.setEditable(false);
		pane4=new JScrollPane(text4);
		
		p17.setLayout(new GridLayout());
		p17.add(pane4);
		
		l9=new JLabel("WITHDRAW");l9.setFont(new Font("verdana",Font.BOLD,14));l9.setForeground(new Color(46,139,87));
		l10=new JLabel("");l10.setFont(new Font("verdana",Font.BOLD,14));l10.setForeground(new Color(0,0,0));l10.setForeground(Color.RED);
		l11=new JLabel("FROM");l11.setFont(new Font("verdana",Font.BOLD,14));l11.setForeground(new Color(46,139,87));
		l12=new JLabel("");l12.setFont(new Font("verdana",Font.BOLD,14));l12.setForeground(new Color(0,0,0));l12.setForeground(Color.RED);
		l13=new JLabel("COMMENT");l13.setFont(new Font("verdana",Font.BOLD,14));l13.setForeground(new Color(46,139,87));
		text2=new JTextArea(2,5);pane2=new JScrollPane(text2);
		text2.setLineWrap(true);text2.setForeground(Color.RED);
		text2.setWrapStyleWord(true);
		
		
		
		p11.setLayout(new GridBagLayout());
		ccna7.fill=GridBagConstraints.HORIZONTAL;
		ccna7.weightx=1;ccna7.weighty=1;
		ccna7.insets=new Insets(3,2,3,2);

		ccna7.gridx=1;ccna7.gridy=1;
		ccna7.anchor=GridBagConstraints.LINE_END;
		p11.add(l3,ccna7);
		ccna7.gridx=2;ccna7.gridy=1;
		ccna7.anchor=GridBagConstraints.LINE_END;
		p11.add(l5,ccna7);
		
		ccna7.gridx=1;ccna7.gridy=2;
		ccna7.anchor=GridBagConstraints.LINE_END;
		p11.add(l6,ccna7);
		ccna7.gridx=2;ccna7.gridy=2;
		ccna7.anchor=GridBagConstraints.LINE_END;
		p11.add(l7,ccna7);
		
		ccna7.gridx=1;ccna7.gridy=3;
		ccna7.anchor=GridBagConstraints.LINE_END;
		p11.add(l8,ccna7);
		ccna7.gridx=2;ccna7.gridy=3;
		ccna7.anchor=GridBagConstraints.LINE_END;
		p11.add(pane1,ccna7);
		
		
		p12.setLayout(new GridBagLayout());
		ccna7.fill=GridBagConstraints.HORIZONTAL;
		ccna7.weightx=1;ccna7.weighty=1;
		ccna7.insets=new Insets(3,2,3,2);

		ccna7.gridx=1;ccna7.gridy=1;
		ccna7.anchor=GridBagConstraints.LINE_END;
		p12.add(l9,ccna7);
		ccna7.gridx=2;ccna7.gridy=1;
		ccna7.anchor=GridBagConstraints.LINE_END;
		p12.add(l10,ccna7);
		
		ccna7.gridx=1;ccna7.gridy=2;
		ccna7.anchor=GridBagConstraints.LINE_END;
		p12.add(l11,ccna7);
		ccna7.gridx=2;ccna7.gridy=2;
		ccna7.anchor=GridBagConstraints.LINE_END;
		p12.add(l12,ccna7);
		
		ccna7.gridx=1;ccna7.gridy=3;
		ccna7.anchor=GridBagConstraints.LINE_END;
		p12.add(l13,ccna7);
		ccna7.gridx=2;ccna7.gridy=3;
		ccna7.anchor=GridBagConstraints.LINE_END;
		p12.add(pane2,ccna7);
		
		
		
		
		t1.addKeyListener(new KeyAdapter()
		{
		      public void keyTyped(KeyEvent ke)
		{
		    	 
		    	  char c = ke.getKeyChar();
	                if (!( (c == KeyEvent.VK_PERIOD ) ||  (Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE)|| (c == KeyEvent.VK_DELETE)   )){
	                    getToolkit().beep();
	                    ke.consume();
	                    JOptionPane.showMessageDialog(null,"Enter Numbers Only !");
		    }}});
		
		tx44.addKeyListener(new KeyAdapter()
		{
		      public void keyTyped(KeyEvent ke)
		{
		    	 
		    	  char c = ke.getKeyChar();
	                if (!( (c == KeyEvent.VK_PERIOD ) ||  (Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE)|| (c == KeyEvent.VK_DELETE)   )){
	                    getToolkit().beep();
	                    ke.consume();
	                    JOptionPane.showMessageDialog(null,"Enter Numbers Only !");
		    }}});
		
		ta5.addKeyListener(new KeyAdapter()
		{
		      public void keyTyped(KeyEvent ke)
		{
		    	  char c = ke.getKeyChar();
	                if (!( (c == KeyEvent.VK_PERIOD ) ||  (Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE)|| (c == KeyEvent.VK_DELETE)   )){
	                    getToolkit().beep();
	                    ke.consume();
	                    JOptionPane.showMessageDialog(null,"Enter Numbers Only !");
		    }}});

		
		
		bar();
		calculator();
		combo();
		combo1();
		button();
		table();
	//	refresh();
	
		
	}


	private void refresh() {
		
		ta0.setText("");ta2.setText("");ta3.setText("");box10.setSelectedItem(null);
		tx2.setText("");	tx3.setText("");	tx4.setText("");tx5.setSelectedItem(null);tx6.setSelectedItem(null);
		
	}


	private void table() {
		
		try {
			
			String sql="Select Datee as 'DATE', Fname as 'CATEGORY',Deposit as 'DEPOSIT',Withdraw as 'WITHDRAW',Comment as 'COMMENT' from Trans where Datee='"+dt.format(timer.getTime())+"'  ";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			table.setFont(new Font("verdana",Font.PLAIN,12));
			table.setForeground(new Color(0,0,139));
			
			
			String sql1="Select id as 'USER_ID', FName as 'FIRST NAME',LName as 'LAST NAME',LType as 'LOAN TYPE' from user  ";
			ps=con.prepareStatement(sql1);
			rs=ps.executeQuery();
			table1.setModel(DbUtils.resultSetToTableModel(rs));
			table1.setFont(new Font("verdana",Font.PLAIN,12));
			table1.setForeground(new Color(0,0,139));
			
			table1.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent argo)	{
			    int row=table1.getSelectedRow();

			    ta0.setText(table1.getModel().getValueAt(row,0).toString());
			    ta2.setText(table1.getModel().getValueAt(row,1).toString());
			    ta3.setText(table1.getModel().getValueAt(row,2).toString());
			    box10.setSelectedItem(table1.getModel().getValueAt(row,3).toString());
			    
				table1.setForeground(new Color(0,0,139));
				
			    }});
			
			table1.addKeyListener(new KeyAdapter(){
				public void keyReleased(KeyEvent e)	{

					try{
						

					    int row=table1.getSelectedRow();

					    ta0.setText(table1.getModel().getValueAt(row,0).toString());
					    ta2.setText(table1.getModel().getValueAt(row,1).toString());
					    ta3.setText(table1.getModel().getValueAt(row,2).toString());
					    box10.setSelectedItem(table1.getModel().getValueAt(row,3).toString());
					    
						table1.setForeground(new Color(0,0,139));
						
					    
						
					}catch(Exception esss){
					//	JOptionPane.showMessageDialog(null, esss.getMessage());
					}
					
				}
					
				});
				
			
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		
try {
			
			String sql="Select id as 'USER_ID', first as 'FIRST NAME',last as 'LAST NAME',gender as 'GENDER',clas as 'CLASS' from student  ";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			table2.setModel(DbUtils.resultSetToTableModel(rs));
			table.setFont(new Font("verdana",Font.PLAIN,12));
			table2.setForeground(new Color(0,0,139));
			
		
			table2.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent argo)	{
			    int row=table2.getSelectedRow();

			    tx2.setText(table2.getModel().getValueAt(row,0).toString());
			    tx3.setText(table2.getModel().getValueAt(row,1).toString());
			    tx4.setText(table2.getModel().getValueAt(row,2).toString());
			    tx5.setSelectedItem(table2.getModel().getValueAt(row,3).toString());
			    tx6.setSelectedItem(table2.getModel().getValueAt(row,4).toString());
			    
				table2.setForeground(new Color(0,0,139));
				
			    }});
			
			table2.addKeyListener(new KeyAdapter(){
				public void keyReleased(KeyEvent e)	{

					try{
						  int row=table2.getSelectedRow();

						    tx2.setText(table2.getModel().getValueAt(row,0).toString());
						    tx3.setText(table2.getModel().getValueAt(row,1).toString());
						    tx4.setText(table2.getModel().getValueAt(row,2).toString());
						    tx5.setSelectedItem(table2.getModel().getValueAt(row,3).toString());
						    tx6.setSelectedItem(table2.getModel().getValueAt(row,4).toString());
						    
							table2.setForeground(new Color(0,0,139));
						
					}catch(Exception esss){
					//	JOptionPane.showMessageDialog(null, esss.getMessage());
					}
					
				}
					
				});
				
			
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		
	}
     

	private void button() {
		
		b22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
         try {
        	 
        	 String id=tx2.getText();
        	 
        	 String sql22="select * from user where id ='"+id+"'  ";
        	 ps=con.prepareStatement(sql22);
        	 ResultSet rs1=ps.executeQuery();
        	 
        	 if(id!= null &&!id.trim().isEmpty()) {
        		 
	     				String sql1="select sum(Deposit),sum(Withdraw) from money  where id='"+id+"' ";
			        	 ps=con.prepareStatement(sql1);
			        	 rs=ps.executeQuery();
			        	 
			        	 String dp=rs.getString("sum(Deposit)");
			        	 Double vd=Double.parseDouble(dp);
					     String sd=String.format("%,.2f",vd);
					     
					     
	                    String wp=rs.getString("sum(Withdraw)");
			        	 Double wd=Double.parseDouble(wp);
					     String sw=String.format("%,.2f",wd);
					     
					     Double bal=vd-wd;
					     String bala=String.format("%,.2f",bal);
					     
					     String sql2="select sum(Deposit),sum(Withdraw) from money  where id='"+id+"'";
			        	 ps=con.prepareStatement(sql2);
			        	 rs=ps.executeQuery();
			        	 
			        	 String dt=rs.getString("sum(Deposit)");
			        	 Double bd=Double.parseDouble(dt);
			        	 
			        	 String wt=rs.getString("sum(Withdraw)");
			        	 Double bw=Double.parseDouble(wt);
			        	 
			        	 Double toto=bw-bd;
			        	 String total=String.format("%,.2f",toto);
			        	 
					     
					     PdfPTable mudi2 = new PdfPTable(1);
					     mudi2.setWidthPercentage(100);	
					     PdfPCell cell2=new PdfPCell(new Phrase("BALANCE INFORMATION"));
					     cell2.setColspan(1);
					     cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
					     cell2.setBackgroundColor(new BaseColor(255,250,205));
					     mudi2.addCell(cell2);
					  
					     cell2 = new PdfPCell(new Phrase("All Time Balance :  "+bala ,FontFactory.getFont("verdana", 12, Font.BOLD, BaseColor.BLACK)));
						 cell2.setColspan(6);
						 cell2.setBorder(0);
						// cell2.setHorizontalAlignment(1);
						// mudi2.addCell(cell2);
						 
						 cell2 = new PdfPCell(new Phrase("Total Account Balance : "+bala ,FontFactory.getFont("verdana", 12, Font.BOLD, BaseColor.BLACK)));
						 cell2.setColspan(6);
						 cell2.setBorder(0);
						// cell2.setHorizontalAlignment(1);
						 mudi2.addCell(cell2);
							  
						PdfPTable mudi1 = new PdfPTable(36);
						 mudi1.setWidthPercentage(100);	
					     PdfPCell cell1=new PdfPCell(new Phrase(""));
					     cell1.setColspan(36);
					     mudi1.setWidths(new int[]{ 1, 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
					     cell1.setBorder(0);
					     cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
					     cell1.setBackgroundColor(new BaseColor(255,250,205));
					     mudi1.addCell(cell1);
					   
					     
					     cell1 = new PdfPCell(new Phrase("Total " ,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
						 cell1.setColspan(12);
						 cell1.setBorder(0);
						 cell1.setHorizontalAlignment(1);
						 mudi1.addCell(cell1);
						 
						
						 cell1 = new PdfPCell(new Phrase(""+sd,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
						 cell1.setColspan(12);
						 cell1.setBorder(0);
						 cell1.setHorizontalAlignment(1);
						 mudi1.addCell(cell1);
						 
						 cell1 = new PdfPCell(new Phrase(""+sw,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
						 cell1.setColspan(12);
						 cell1.setBorder(0);
						 cell1.setHorizontalAlignment(1);
						 mudi1.addCell(cell1);
						
						 
						 
	      		    	PdfPTable mudi23 = new PdfPTable(1);
					     PdfPCell cell23=new PdfPCell(new Phrase(""));
					     cell23.setColspan(5);
					     
					     mudi23.setWidthPercentage(100);
					     Image im=Image.getInstance("other.png");
	      		    	 cell23.setBorder(0);
	       		    	 mudi23.addCell(cell23);
	      		    	 mudi23.addCell(im);
						
					 PdfPTable mudi = new PdfPTable(36);
				     PdfPCell cell=new PdfPCell(new Phrase(""));
				     cell.setColspan(10);
				     cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				     cell.setBackgroundColor(new BaseColor(240,230,140));
				     mudi.addCell(cell);
				     mudi.setWidths(new int[]{ 1, 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
					    mudi.setWidthPercentage(100);					    
					    cell.setColspan(36);
					    cell.setHorizontalAlignment(1);
					    mudi.addCell(cell);
					    
					    cell = new PdfPCell(new Phrase("DATE",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
					    cell.setColspan(12);
					    cell.setHorizontalAlignment(1);
					    mudi.addCell(cell);
					  
					    cell = new PdfPCell(new Phrase("DEPOSIT",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
					    cell.setColspan(12);
					    cell.setHorizontalAlignment(1);
					    mudi.addCell(cell);
					    
					   

					    cell = new PdfPCell(new Phrase("WITHDRAW",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
					    cell.setColspan(12);
					    cell.setHorizontalAlignment(1);
					    mudi.addCell(cell);
					    

					    
					    String sql="select * from money where id='"+id+"'  ";
					    ps=con.prepareStatement(sql);
					    rs=ps.executeQuery();
					    
					    while(rs.next()) {
					    	
			    			String date=rs.getString("Datee");
				    		String depo=rs.getString("Deposit");
				    		String with=rs.getString("Withdraw");
				    		String s1="";
				    		String s2="";
				    		
				    		if(!depo.isEmpty()) {
				    			Double value1=Double.parseDouble(depo);
					            s1=String.format("%,.2f",value1);
				    		}else {
				    			s1="";
				    		}
				    		
	                      if(!with.isEmpty()) {
	                    	  Double value2=Double.parseDouble(with);
	  						  s2=String.format("%,.2f",value2);
	  			    		
				    		}else {
				    			s2="";
				    		}
				    		
				    		
							
				    		  cell = new PdfPCell(new Phrase(""+date,FontFactory.getFont("serif", 10, Font.PLAIN, BaseColor.BLACK)));
							    cell.setColspan(12);
							   cell.setHorizontalAlignment(1);
							    mudi.addCell(cell);
							    
							    cell = new PdfPCell(new Phrase(s1,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
							    cell.setColspan(12);
							    cell.setHorizontalAlignment(1);
							    mudi.addCell(cell);
							    
							  
							    cell = new PdfPCell(new Phrase(s2,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
							    cell.setColspan(12);
							    cell.setHorizontalAlignment(1);
							    mudi.addCell(cell);
							    
							   
							    
					    }
					   
					  
					    Document document=new Document(PageSize.A4);
			            PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream("Statement.pdf"));
						document.open();
						Image img=Image.getInstance("barcode.png");
					
						document.add(mudi23);
						document.add(new Paragraph("                                                   USER STATEMENT",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,new BaseColor(0,0,150))));
						document.add(new Paragraph("\n"));
						//document.add(new Paragraph("USER_ID : "+tx2.getText(),FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,new BaseColor(0,0,150))));
						document.add(new Paragraph("NAME : "+tx3.getText()+"  "+tx4.getText()+"\nGENDER :"+tx5.getSelectedItem().toString()+"\nCLASS :"+tx6.getSelectedItem().toString(),FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,new BaseColor(0,0,150))));
						document.add(new Paragraph("\n"));
						document.add(mudi);
						//document.add(new Paragraph("\n"));
						document.add(mudi1);
						document.add(new Paragraph("\n"));
						document.add(mudi2);
						document.add(new Paragraph("\n"));
						document.add(img);
						document.add(new Paragraph(""+df.format(timer.getTime())+"::"+dtt.format(timer.getTime() )) );
						document.close();
						
						JOptionPane.showMessageDialog(null, "Loading...Please Wait !");
					      Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"Statement.pdf");
					      
	     		
        		 
        	 }else {
        		// JOptionPane.showMessageDialog(null, "Select User from the Table !");
        		 JOptionPane.showMessageDialog(null, "Select User from the Table !");
        	 }
        	 
        	 
        	 
         }catch(Exception ex) {
        	// JOptionPane.showMessageDialog(null, "No Item with that Record !");
        	 JOptionPane.showMessageDialog(null, ex.getMessage());
         }

			}
		});
		
		
		
		
		
		b17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
            	  
            	  if(
  						tx2.getText() != null &&!tx2.getText().trim().isEmpty()
  							
  							){
  					try {
  					  int result = JOptionPane.showConfirmDialog(null, p44, "Enter Amount ",
        				        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
              		  
              		  if(JOptionPane.OK_OPTION==result) {
              			  

                  		if(  (tx44.getText()!= null &&!tx44.getText().trim().isEmpty()))
                      		 {
                  			
                                  String id=tx2.getText().toUpperCase();
    						
    						String sql="select sum(deposit),sum(withdraw) from money where id= '"+id+"' ";
    						ps=con.prepareStatement(sql);
    						rs=ps.executeQuery();
    						
    						Double dep=Double.parseDouble(rs.getString("sum(deposit)"));
    						Double with=Double.parseDouble(rs.getString("sum(withdraw)"));
    						Double amo=Double.parseDouble(tx44.getText());
    						
    						Double bala=(dep-with)-amo;
    						
    						
    						
    						if(bala>=0.0) {
    							
    							String sq="insert into money(id,deposit,withdraw,datee,month,year) values (?,?,?,?,?,?)";
    							PreparedStatement ps=con.prepareStatement(sq);
    							ps.setString(1,id);
    							ps.setString(2, "");
    						    ps.setString(3,tx44.getText());
    							ps.setString(4, dt.format(timer.getTime()));
    							ps.setString(5, mm.format(timer.getTime()));
    							ps.setString(6, yy.format(timer.getTime()));
    							ps.execute();
    							
    							
    							JOptionPane.showMessageDialog(b1, "Data Saved !");
    							table();
    							
    						}else {
    							
    							JOptionPane.showMessageDialog(null, "Insufficient Amount !");
    						}
    						
    							
    							
                  			
                  		}else {
                  			JOptionPane.showMessageDialog(null, "Can't Accept Empty Value !");
                  		}
              			  
    						
              		  }
              			
              			 
  			            
  						
  					}catch(Exception ex) {
  						JOptionPane.showMessageDialog(null, ex.getMessage());//
  					}
  				
				
		}else {
			JOptionPane.showMessageDialog(null, "Select User from the Table !");
			
		}
			}});
		
		
		
		
		b16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
            	  
            	  if(
  						tx2.getText() != null &&!tx2.getText().trim().isEmpty()
  							
  							){
  					try {
  					  int result = JOptionPane.showConfirmDialog(null, p44, "Enter Amount ",
        				        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
              		  
              		  if(JOptionPane.OK_OPTION==result) {
              			  
              			  
              			if(  (tx44.getText()!= null &&!tx44.getText().trim().isEmpty()))
                 		 {
              				
              				String id=tx2.getText().toUpperCase();
    						
							String sq="insert into money(id,deposit,withdraw,datee,month,year) values (?,?,?,?,?,?)";
							PreparedStatement ps=con.prepareStatement(sq);
							ps.setString(1,id);
							ps.setString(2, tx44.getText());
						    ps.setString(3,"");
							ps.setString(4, dt.format(timer.getTime()));
							ps.setString(5, mm.format(timer.getTime()));
							ps.setString(6, yy.format(timer.getTime()));
							ps.execute();
							
							
							JOptionPane.showMessageDialog(b1, "Data Saved !");
							table();
							
              				
                 		 }else {
                 			 JOptionPane.showMessageDialog(null, "Can't Accept Empty Value !");
                 		 }
             			
              			  
    						
              		  }
              			
              			 
  			            
  						
  					}catch(Exception ex) {
  						JOptionPane.showMessageDialog(null, ex.getMessage());//
  					}
  				
				
		}else {
			JOptionPane.showMessageDialog(null, "Select User from the Table !");
			
		}
			}});
		
		
		b21.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				refresh();
				table();
				
			}
	});
		
		b20.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {

				String id=tx2.getText();
				String fn=tx3.getText();
				String s=String.format("%s   %s",fn ,"Deleted Successfully !");

					if(tx2.getText() != null &&!tx2.getText().trim().isEmpty())
					{

					try {
						String s1=String.format("%s   %s","Are you sure you want to Delete,",fn);

						int mudi=JOptionPane.showConfirmDialog(b4, s1,"Delete", JOptionPane.YES_NO_OPTION);
						if(mudi==JOptionPane.YES_OPTION)
						{
					
					String sq1="delete  from student where id='"+id+"' ";
					ps=con.prepareStatement(sq1);
					ps.execute();
					ps.close();
					table();

					JOptionPane.showMessageDialog(b1,s);
				//	refresh();
				
						}


				} catch (SQLException e) {
					e.getMessage();
					JOptionPane.showMessageDialog(b1,e.getMessage());

				}
					 finally{
		  	             try{
		  	                 rs.close();
		  	                 ps.close();
		  	             }catch(Exception ex){
		  	                 ex.getMessage();
		  	             }}

					}else{
						JOptionPane.showMessageDialog(b1, "Select User from the Table !");
					}


			}});
		
		b19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
            	  
            	  if(
  						tx2.getText() != null &&!tx2.getText().trim().isEmpty() && tx3.getText() != null &&tx4.getText() != null &&!tx4.getText().trim().isEmpty()&&!tx3.getText().trim().isEmpty() &&
  						tx5.getSelectedItem() != null &&!((String) tx5.getSelectedItem()).trim().isEmpty() && 	tx6.getSelectedItem() != null
  						&&!((String) tx6.getSelectedItem()).trim().isEmpty() 
  							
  							){
            		 
            		  tx8.setText(tx2.getText());
						tx9.setText(tx3.getText());
						tx10.setText(tx4.getText());
						tx11.setSelectedItem(tx5.getSelectedItem().toString());
						tx12.setSelectedItem(tx6.getSelectedItem().toString());

            		  int result = JOptionPane.showConfirmDialog(null, p43, "Select ",
      				        JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            		  
            		  if(JOptionPane.OK_OPTION==result) {
            			
            			  
            			  if(
            						tx8.getText() != null &&!tx8.getText().trim().isEmpty() && tx9.getText() != null &&tx10.getText() != null &&!tx10.getText().trim().isEmpty()&&!tx9.getText().trim().isEmpty() &&
            						tx11.getSelectedItem() != null &&!((String) tx11.getSelectedItem()).trim().isEmpty() && 	tx12.getSelectedItem() != null
            						&&!((String) tx12.getSelectedItem()).trim().isEmpty() 
            							
            							){
            				  
            				  
            				  try {
            						
            						
            						
            						if(tx9.getText().matches("^[\\p{L} .'-]+$") && tx10.getText().matches("^[\\p{L} .'-]+$") )
            			             {
            							
            							String sql="update  student set  first='"+tx9.getText()+"' ,last='"+tx10.getText()+"',gender='"+tx11.getSelectedItem().toString()+"',clas='"+tx12.getSelectedItem().toString()+"' where id='"+tx8.getText()+"' ";
            							ps=con.prepareStatement(sql);
            							ps.execute();
            							JOptionPane.showMessageDialog(null," Updated Successful !");
            							table();
            							refresh();
            							
            							
            							
            			             }
            						else {
            							
            							JOptionPane.showMessageDialog(null, "Enter Valid Names  !");
            						}
            						
            					}catch(Exception ex) {
            						JOptionPane.showMessageDialog(null,ex.getMessage());//
            					}
            				
          				
            				  
            				  
            			  }else {
            				  
            				  JOptionPane.showMessageDialog(null, "Can't Accept Empty Value !");
            				  
            			  }
            			  
            		  }
  					
		}else {
			JOptionPane.showMessageDialog(null, "Select User From the Table!");
			
		}
			}});
		
		
		b18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
            	  
            	  if(
  						tx2.getText() != null &&!tx2.getText().trim().isEmpty() && tx3.getText() != null &&tx4.getText() != null &&!tx4.getText().trim().isEmpty()&&!tx3.getText().trim().isEmpty() &&
  						tx5.getSelectedItem() != null &&!((String) tx5.getSelectedItem()).trim().isEmpty() && 	tx6.getSelectedItem() != null
  						&&!((String) tx6.getSelectedItem()).trim().isEmpty() 
  							
  							){
  					try {
  						

  						String id=tx2.getText().toUpperCase();
  						String fn=tx3.getText().toUpperCase();
  						String ln=tx4.getText().toUpperCase();
  						String gn=tx5.getSelectedItem().toString();
  						String cl=tx6.getSelectedItem().toString();
  					
  						
  						if(fn.matches("^[\\p{L} .'-]+$") && ln.matches("^[\\p{L} .'-]+$") )
  			             {
  							
  							
  							String sq="insert into student(id,first,last,gender,clas) values (?,?,?,?,?)";
  							PreparedStatement ps=con.prepareStatement(sq);
  							ps.setString(1,id);
  							ps.setString(2, fn);
  						    ps.setString(3,ln);
  							ps.setString(4,gn);
  							ps.setString(5,cl);
  							
  							ps.execute();
  							
  							String s=String.format("%s   %s",fn ,"Added Successfully !");
  							JOptionPane.showMessageDialog(b1, s);
  							table();
  							
  							
  			             }
  						else {
  							
  							JOptionPane.showMessageDialog(null, "Enter Valid Names  !");
  						}
  						
  					}catch(Exception ex) {
  						JOptionPane.showMessageDialog(null, "User of that ID Already Registered !");//
  					}
  				
				
		}else {
			JOptionPane.showMessageDialog(null, "Can't Accept Empty Value !");
			
		}
			}});
		
		b15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

		         try {
		        	 
		        	 String count="select count(id) from Loan   ";
		     			ps=con.prepareStatement(count);
		     			ResultSet rss=ps.executeQuery();
		     			
		     			int nam=Integer.parseInt(rss.getString("count(id)"));
		     			if(nam !=0) {
		     				

		     				 String sql1="select sum(Deposit),sum(Withdraw) from Loan  ";
				        	 ps=con.prepareStatement(sql1);
				        	 rs=ps.executeQuery();
				        	 
				        	 String dp=rs.getString("sum(Deposit)");
				        	 Double vd=Double.parseDouble(dp);
						     String sd=String.format("%,.2f",vd);
						     
						     
		                    String wp=rs.getString("sum(Withdraw)");
				        	 Double wd=Double.parseDouble(wp);
						     String sw=String.format("%,.2f",wd);
						     
						     Double bal=vd-wd;
						     String bala=String.format("%,.2f",bal);
						     
						     String sql2="select sum(Deposit),sum(Withdraw) from Loan ";
				        	 ps=con.prepareStatement(sql2);
				        	 rs=ps.executeQuery();
				        	 
				        	 String dt=rs.getString("sum(Deposit)");
				        	 Double bd=Double.parseDouble(dt);
				        	 
				        	 String wt=rs.getString("sum(Withdraw)");
				        	 Double bw=Double.parseDouble(wt);
				        	 
				        	 Double toto=bw-bd;
				        	 String total=String.format("%,.2f",toto);
				        	 
						     
						     PdfPTable mudi2 = new PdfPTable(1);
						     mudi2.setWidthPercentage(100);	
						     PdfPCell cell2=new PdfPCell(new Phrase("BALANCE INFORMATION"));
						     cell2.setColspan(1);
						     cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
						     cell2.setBackgroundColor(new BaseColor(255,250,205));
						     mudi2.addCell(cell2);
						  
						     cell2 = new PdfPCell(new Phrase("All Time Balance :  "+bala ,FontFactory.getFont("verdana", 12, Font.BOLD, BaseColor.BLACK)));
							 cell2.setColspan(6);
							 cell2.setBorder(0);
							// cell2.setHorizontalAlignment(1);
							// mudi2.addCell(cell2);
							 
							 cell2 = new PdfPCell(new Phrase("Total Loan Balance : "+total ,FontFactory.getFont("verdana", 12, Font.BOLD, BaseColor.BLACK)));
							 cell2.setColspan(6);
							 cell2.setBorder(0);
							// cell2.setHorizontalAlignment(1);
							 mudi2.addCell(cell2);
								  
							PdfPTable mudi1 = new PdfPTable(36);
							 mudi1.setWidthPercentage(100);	
						     PdfPCell cell1=new PdfPCell(new Phrase(""));
						     cell1.setColspan(36);
						     mudi1.setWidths(new int[]{ 1, 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
						     cell1.setBorder(0);
						     cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
						     cell1.setBackgroundColor(new BaseColor(255,250,205));
						     mudi1.addCell(cell1);
						     
						  
						     cell1 = new PdfPCell(new Phrase("Total " ,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
							 cell1.setColspan(9);
							 cell1.setBorder(0);
							 cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							
							 cell1 = new PdfPCell(new Phrase(""+sw,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
							 cell1.setColspan(9);
							 cell1.setBorder(0);
							 cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							 cell1 = new PdfPCell(new Phrase(""+sd,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
							 cell1.setColspan(9);
							 cell1.setBorder(0);
							 cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							 cell1 = new PdfPCell(new Phrase("",FontFactory.getFont("verdana", 11, Font.PLAIN, BaseColor.BLACK)));
							 cell1.setColspan(9);
							 cell1.setBorder(0);
							// cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							 
							 
							 
		      		    	PdfPTable mudi23 = new PdfPTable(1);
						     PdfPCell cell23=new PdfPCell(new Phrase(""));
						     cell23.setColspan(5);
						     
						     mudi23.setWidthPercentage(100);
						     Image im=Image.getInstance("other.png");
		      		    	 cell23.setBorder(0);
		       		    	 mudi23.addCell(cell23);
		      		    	 mudi23.addCell(im);
							
						 PdfPTable mudi = new PdfPTable(36);
					     PdfPCell cell=new PdfPCell(new Phrase(""));
					     cell.setColspan(10);
					     cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					     cell.setBackgroundColor(new BaseColor(240,230,140));
					     mudi.addCell(cell);
					     mudi.setWidths(new int[]{ 1, 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
						    mudi.setWidthPercentage(100);					    
						    cell.setColspan(36);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						
						    
						    cell = new PdfPCell(new Phrase("ACCOUNT",FontFactory.getFont("verdana", 13, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(9);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    
						    cell = new PdfPCell(new Phrase("LOAN",FontFactory.getFont("verdana", 13, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(9);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						   

						    cell = new PdfPCell(new Phrase("PAID",FontFactory.getFont("verdana", 13, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(9);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    

						    cell = new PdfPCell(new Phrase("REMAIN",FontFactory.getFont("verdana", 13, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(9);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						     String sql="select Fromm,sum(Deposit),sum(Withdraw) from Loan group by Fromm ";
				        	 ps=con.prepareStatement(sql);
				        	 rs=ps.executeQuery();
				        	 
						    while(rs.next()) {
						    
				    			String fund=rs.getString("Fromm");
					    		String depo=rs.getString("sum(Deposit)");
					    		String with=rs.getString("sum(Withdraw)");
					    		
					    		String s1="";
					    		String s2="";
					    		
					    		Double value1=0.0;
					    		Double value2=0.0;
					    		 
					    		if(!depo.isEmpty()) {
					    			value1=Double.parseDouble(depo);
						            s1=String.format("%,.2f",value1);
					    		}else {
					    			s1="";
					    		}
					    		
		                      if(!with.isEmpty()) {
		                    	  value2=Double.parseDouble(with);
		  						  s2=String.format("%,.2f",value2);
		  			    		
					    		}else {
					    			s2="";
					    		}
					    		
		                      Double balance=value2-value1;
		                     String s3=String.format("%,.2f", balance);
		                     
		                   
								    
								    cell = new PdfPCell(new Phrase(fund,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(9);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								    cell = new PdfPCell(new Phrase(s2,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(9);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								  
								    cell = new PdfPCell(new Phrase(s1,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(9);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								    cell = new PdfPCell(new Phrase(s3.toString(),FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(9);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
						    }
						    
						    Document document=new Document(PageSize.A4);
				            PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream("Statement.pdf"));
							document.open();
							Image img=Image.getInstance("barcode.png");
							
							document.add(mudi23);
							document.add(new Paragraph("                                          ALL ACCOUNT STATEMENT",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,new BaseColor(0,0,150))));
							document.add(new Paragraph("\n"));
							document.add(mudi);
							document.add(mudi1);
							document.add(new Paragraph("\n"));
							document.add(mudi2);
							document.add(new Paragraph("\n"));
							document.add(img);
							document.add(new Paragraph(""+df.format(timer.getTime())+"::"+dtt.format(timer.getTime() )) );
							document.close();
							
							JOptionPane.showMessageDialog(null, "Loading...Please Wait !");
						      Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"Statement.pdf");
						      
		     

		     				
		     			}else {
		     				JOptionPane.showMessageDialog(null, "No Item with that Record ");
		     			}
		     				
		        	
		        		 		        	 
		         }catch(Exception ex) {
		        	// JOptionPane.showMessageDialog(null, "No Item with that Record !");
		        	 JOptionPane.showMessageDialog(null, ex.getStackTrace());
		         }

					//
				
				
			}
			  });
		
		
		
		b14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
              try {
            	 String  id =ta0.getText();
            	  
            	  if(id!= null &&!id.trim().isEmpty()) {
            		  
            		  
            		  int result = JOptionPane.showConfirmDialog(null, p30, "Account Report",JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                 	 
                	  if(result==JOptionPane.OK_OPTION) {
                		
                		  if( t5.getSelectedItem()!= null &&!t5.getSelectedItem().toString().trim().isEmpty() ){
                			  
                			  

                     		 
      	     			   	String sql1="select sum(Deposit),sum(Withdraw) from Loan  where Too='"+t5.getSelectedItem().toString()+"'  and id ='"+ta0.getText()+"' ";
      			        	 ps=con.prepareStatement(sql1);
      			        	 rs=ps.executeQuery();
      			        	 
      			        	 String dp=rs.getString("sum(Deposit)");
      			        	 Double vd=Double.parseDouble(dp);
      					     String sd=String.format("%,.2f",vd);
      					    
      					     
      	                     String wp=rs.getString("sum(Withdraw)");
      			        	 Double wd=Double.parseDouble(wp);
      					     String sw=String.format("%,.2f",wd);
      					     
      					     Double bal=vd-wd;
      					     String bala=String.format("%,.2f",bal);
      					     
      					     String sql2="select sum(Deposit),sum(Withdraw) from Loan  where Fromm='"+t5.getSelectedItem().toString()+"'   and id ='"+ta0.getText()+"'  ";
      			        	 ps=con.prepareStatement(sql2);
      			        	 rs=ps.executeQuery();
      			        	 
      			        	 String dt=rs.getString("sum(Deposit)");
      			        	 Double bd=Double.parseDouble(dt);
      			        	 
      			        	 String wt=rs.getString("sum(Withdraw)");
      			        	 Double bw=Double.parseDouble(wt);
      			        	 String bbw=String.format("%,.2f",bw);
      			        	 
      			        	 Double toto=wd-wd;
      			        	 String total=String.format("%,.2f",toto);
      			        	 
      					     
      					     PdfPTable mudi2 = new PdfPTable(1);
      					     mudi2.setWidthPercentage(100);	
      					     PdfPCell cell2=new PdfPCell(new Phrase("BALANCE INFORMATION"));
      					     cell2.setColspan(1);
      					     cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
      					     cell2.setBackgroundColor(new BaseColor(255,250,205));
      					     mudi2.addCell(cell2);
      					  
      					     cell2 = new PdfPCell(new Phrase("All Time Balance :  "+bala ,FontFactory.getFont("verdana", 12, Font.BOLD, BaseColor.BLACK)));
      						 cell2.setColspan(6);
      						 cell2.setBorder(0);
      						// cell2.setHorizontalAlignment(1);
      						// mudi2.addCell(cell2);
      						 
      						 cell2 = new PdfPCell(new Phrase("Total Loan Balance : "+total ,FontFactory.getFont("verdana", 12, Font.BOLD, BaseColor.BLACK)));
      						 cell2.setColspan(6);
      						 cell2.setBorder(0);
      						// cell2.setHorizontalAlignment(1);
      						 mudi2.addCell(cell2);
      							  
      						PdfPTable mudi1 = new PdfPTable(36);
      						 mudi1.setWidthPercentage(100);	
      					     PdfPCell cell1=new PdfPCell(new Phrase(""));
      					     cell1.setColspan(36);
      					     mudi1.setWidths(new int[]{ 1, 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
      					     cell1.setBorder(0);
      					     cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
      					     cell1.setBackgroundColor(new BaseColor(255,250,205));
      					     mudi1.addCell(cell1);
      					    
      					     
      					     cell1 = new PdfPCell(new Phrase(" " ,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
      						 cell1.setColspan(9);
      						 cell1.setBorder(0);
      						 cell1.setHorizontalAlignment(1);
      						 mudi1.addCell(cell1);
      						 
      						
      						 cell1 = new PdfPCell(new Phrase("",FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
      						 cell1.setColspan(9);
      						 cell1.setBorder(0);
      						 cell1.setHorizontalAlignment(1);
      						 mudi1.addCell(cell1);
      						 
      						 cell1 = new PdfPCell(new Phrase("Total",FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
      						 cell1.setColspan(9);
      						 cell1.setBorder(0);
      						 cell1.setHorizontalAlignment(1);
      						 mudi1.addCell(cell1);
      						 
      						 cell1 = new PdfPCell(new Phrase(""+sd,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
      						 cell1.setColspan(9);
      						 cell1.setBorder(0);
      						 cell1.setHorizontalAlignment(1);
      						 mudi1.addCell(cell1);
      						 
      						 
      						PdfPTable mudi4 = new PdfPTable(36);
     						 mudi4.setWidthPercentage(100);	
     					     PdfPCell cell4=new PdfPCell(new Phrase(""));
     					     cell4.setColspan(36);
     					     mudi4.setWidths(new int[]{ 1, 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
     					     cell4.setBorder(0);
     					     cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
     					     cell4.setBackgroundColor(new BaseColor(255,250,205));
     					     mudi4.addCell(cell4);
     					    
     					     
     					     cell4 = new PdfPCell(new Phrase(" " ,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
     						 cell4.setColspan(9);
     						 cell4.setBorder(0);
     						 cell4.setHorizontalAlignment(1);
     						 mudi4.addCell(cell4);
     						 
     						
     						 cell4 = new PdfPCell(new Phrase("",FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
     						 cell4.setColspan(9);
     						 cell4.setBorder(0);
     						 cell4.setHorizontalAlignment(1);
     						 mudi4.addCell(cell4);
     						 
     						 cell4 = new PdfPCell(new Phrase("Total",FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
     						 cell4.setColspan(9);
     						 cell4.setBorder(0);
     						 cell4.setHorizontalAlignment(1);
     						 mudi4.addCell(cell4);
     						 
     						 cell4 = new PdfPCell(new Phrase(""+bbw,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
     						 cell4.setColspan(9);
     						 cell4.setBorder(0);
     						 cell4.setHorizontalAlignment(1);
     						 mudi4.addCell(cell1);
     						 
     						
      						
      						 
      						 
      						 
      						 
      	      		    	PdfPTable mudi23 = new PdfPTable(1);
      					     PdfPCell cell23=new PdfPCell(new Phrase(""));
      					     cell23.setColspan(5);
      					     
      					     mudi23.setWidthPercentage(100);
      					     Image im=Image.getInstance("other.png");
      	      		    	 cell23.setBorder(0);
      	       		    	 mudi23.addCell(cell23);
      	      		    	 mudi23.addCell(im);
      						
      					 PdfPTable mudi = new PdfPTable(36);
      				     PdfPCell cell=new PdfPCell(new Phrase(""));
      				     cell.setColspan(10);
      				     cell.setHorizontalAlignment(Element.ALIGN_CENTER);
      				     cell.setBackgroundColor(new BaseColor(240,230,140));
      				     mudi.addCell(cell);
      				     mudi.setWidths(new int[]{ 1, 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
      					    mudi.setWidthPercentage(100);					    
      					    cell.setColspan(36);
      					    cell.setHorizontalAlignment(1);
      					    mudi.addCell(cell);
      					    
      				   	  cell = new PdfPCell(new Phrase("DEPOSIT INFORMATION",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
    					    cell.setColspan(36);
    					    cell.setHorizontalAlignment(1);
    					    cell.setBackgroundColor(new BaseColor(255,250,205));
    					    mudi.addCell(cell);
      					    
      					    cell = new PdfPCell(new Phrase("DATE",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
      					    cell.setColspan(9);
      					    cell.setHorizontalAlignment(1);
      					    mudi.addCell(cell);
      					    
      					    cell = new PdfPCell(new Phrase("FROM",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
      					    cell.setColspan(9);
      					    cell.setHorizontalAlignment(1);
      					    mudi.addCell(cell);
      					    
      					    
      					    cell = new PdfPCell(new Phrase("TO",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
      					    cell.setColspan(9);
      					    cell.setHorizontalAlignment(1);
      					    mudi.addCell(cell);
      					    
      					    cell = new PdfPCell(new Phrase("DEPOSIT",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
      					    cell.setColspan(9);
      					    cell.setHorizontalAlignment(1);
      					    mudi.addCell(cell);
      					    
      					    String sql="select * from Loan where Too='"+t5.getSelectedItem().toString()+"' and id ='"+ta0.getText()+"' ";
      					    ps=con.prepareStatement(sql);
      					    rs=ps.executeQuery();
      					    
      					    if(vd>0.0) {
      					    	
      					      
          					    while(rs.next()) {
          					    	
          			    			String date=rs.getString("Datee");
          			    			String from=rs.getString("Fromm");
          				    		String too=rs.getString("Too");
          				    		String with=rs.getString("Deposit");
          				    		
          				    		String s1="";
          				    		String s2="";
          				    		
          				    		
          	                      if(!with.isEmpty()) {
          	                    	  Double value2=Double.parseDouble(with);
          	  						  s2=String.format("%,.2f",value2);
          	  			    		
          				    		}else {
          				    			s2="";
          				    		}
          				    		
          				    		
          							
          				    		  cell = new PdfPCell(new Phrase(date,FontFactory.getFont("serif", 10, Font.PLAIN, BaseColor.BLACK)));
          							    cell.setColspan(9);
          							   cell.setHorizontalAlignment(1);
          							    mudi.addCell(cell);
          							    
          							    cell = new PdfPCell(new Phrase(from,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
          							    cell.setColspan(9);
          							    cell.setHorizontalAlignment(1);
          							    mudi.addCell(cell);
          							    
          							    cell = new PdfPCell(new Phrase(too,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
          							    cell.setColspan(9);
          							    cell.setHorizontalAlignment(1);
          							    mudi.addCell(cell);
          							    
          							  
          							    cell = new PdfPCell(new Phrase(s2,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
          							    cell.setColspan(9);
          							    cell.setHorizontalAlignment(1);
          							    mudi.addCell(cell);
          							    
          							  
          							    
          					    }
          					    
      					    	
      					    }
      					    
      					  PdfPTable mudi3 = new PdfPTable(36);
       				     PdfPCell cell3=new PdfPCell(new Phrase(""));
       				     cell3.setColspan(10);
       				     cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
       				     cell3.setBackgroundColor(new BaseColor(240,230,140));
       				     mudi3.addCell(cell3);
       				     mudi3.setWidths(new int[]{ 1, 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
       					    mudi3.setWidthPercentage(100);					    
       					    cell3.setColspan(36);
       					    cell3.setHorizontalAlignment(1);
       					    mudi3.addCell(cell3);
       					    
       				   	  cell3 = new PdfPCell(new Phrase("WITHDRAW INFORMATION",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
     					    cell3.setColspan(36);
     					    cell3.setHorizontalAlignment(1);
     					    cell3.setBackgroundColor(new BaseColor(200,250,205));
     					    mudi3.addCell(cell3);
       					    
       					    cell3 = new PdfPCell(new Phrase("DATE",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
       					    cell3.setColspan(9);
       					    cell3.setHorizontalAlignment(1);
       					    mudi3.addCell(cell3);
       					    
       					    cell3 = new PdfPCell(new Phrase("FROM",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
       					    cell3.setColspan(9);
       					    cell3.setHorizontalAlignment(1);
       					    mudi3.addCell(cell3);
       					    
       					    
       					    cell3 = new PdfPCell(new Phrase("TO",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
       					    cell3.setColspan(9);
       					    cell3.setHorizontalAlignment(1);
       					    mudi3.addCell(cell3);
       					    
       					    cell3 = new PdfPCell(new Phrase("WITHDRAW",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
       					    cell3.setColspan(9);
       					    cell3.setHorizontalAlignment(1);
       					    mudi3.addCell(cell3);
       					    
       					    String sql3="select * from Loan where Fromm='"+t5.getSelectedItem().toString()+"' and id ='"+ta0.getText()+"' ";
       					    ps=con.prepareStatement(sql3);
       					    rs=ps.executeQuery();
       					    
       					 if(bw>0.0) {
   					    	
     					      
       					    while(rs.next()) {
       					    	
       			    			String date=rs.getString("Datee");
       			    			String from=rs.getString("Fromm");
       				    		String too=rs.getString("Too");
       				    		String with=rs.getString("Withdraw");
       				    		
       				    		String s1="";
       				    		String s2="";
       				    		
       				    		
       	                      if(!with.isEmpty()) {
       	                    	  Double value2=Double.parseDouble(with);
       	  						  s2=String.format("%,.2f",value2);
       	  			    		
       				    		}else {
       				    			s2="";
       				    		}
       				    		
       				    		
       							
       				    		  cell3 = new PdfPCell(new Phrase(date,FontFactory.getFont("serif", 10, Font.PLAIN, BaseColor.BLACK)));
       							    cell3.setColspan(9);
       							   cell3.setHorizontalAlignment(1);
       							    mudi3.addCell(cell3);
       							    
       							    cell3 = new PdfPCell(new Phrase(from,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
       							    cell3.setColspan(9);
       							    cell3.setHorizontalAlignment(1);
       							    mudi3.addCell(cell3);
       							    
       							    cell3 = new PdfPCell(new Phrase(too,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
       							    cell3.setColspan(9);
       							    cell3.setHorizontalAlignment(1);
       							    mudi3.addCell(cell3);
       							    
       							  
       							    cell3 = new PdfPCell(new Phrase(s2,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
       							    cell3.setColspan(9);
       							    cell3.setHorizontalAlignment(1);
       							    mudi3.addCell(cell3);
       							    
       							  
       							    
       					   }
       					    
   					    	
   					    }
       					    
      					  
      					   
      					    Document document=new Document(PageSize.A4);
      			            PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream("Statement.pdf"));
      						document.open();
      						Image img=Image.getInstance("barcode.png");
      						
      						document.add(mudi23);
      						document.add(new Paragraph("                                               ACCOUNT STATEMENT",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,new BaseColor(0,0,150))));
      						document.add(new Paragraph("\n"));
      						//document.add(new Paragraph("LOAN TYPE : "+rs1.getString("LType"),FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,new BaseColor(0,0,150))));
      						//document.add(new Paragraph("FOR : "+rs1.getString("FName")+"  "+rs1.getString("LName"),FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,new BaseColor(0,0,150))));
      						document.add(new Paragraph("\n"));
      						document.add(mudi);
      						//document.add(new Paragraph("\n"));
      						document.add(mudi1);
      						document.add(new Paragraph("\n"));
      						document.add(mudi3);
      						document.add(mudi4);
      						document.add(new Paragraph("\n"));
      						document.add(mudi2);
      						document.add(new Paragraph("\n"));
      						document.add(img);
      						document.add(new Paragraph(""+df.format(timer.getTime())+"::"+dtt.format(timer.getTime() )) );
      						document.close();
      						
      						JOptionPane.showMessageDialog(null, "Loading...Please Wait !");
      					      Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"Statement.pdf");
      					      
      	     		
              		 
              	 
                			  
                		  }else {
                			 // JOptionPane.showMessageDialog(null, "Cant't Accept Empty Value !");
                			  JOptionPane.showMessageDialog(null, "Cant't Accept Empty Value !");
                		  }
                		  
                	  }
            		  
            	  }else {
            		  
            		  JOptionPane.showMessageDialog(null, "Select User from the Table !");
            	  }
            	 
            	  
              }catch(Exception ex) {
            	  //JOptionPane.showMessageDialog(null, "No Records of that Account !");
            	  JOptionPane.showMessageDialog(null, ex.getStackTrace());
              }

				
			}
	});
		
		b13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

		         try {
		        	
		     		
						String count="select count(id) from Loan   ";
		     			ps=con.prepareStatement(count);
		     			ResultSet rss=ps.executeQuery();
		     			
		     			int nam=Integer.parseInt(rss.getString("count(id)"));
		     			if(nam !=0) {
		     				
		     				
		     				String sql1="select sum(Deposit),sum(Withdraw) from Loan  ";
				        	 ps=con.prepareStatement(sql1);
				        	 rs=ps.executeQuery();
				        	 
				        	 String dp=rs.getString("sum(Deposit)");
				        	 
				        	 Double vd=Double.parseDouble(dp);
						     String sd=String.format("%,.2f",vd);
						     
						     
		                    String wp=rs.getString("sum(Withdraw)");
				        	 Double wd=Double.parseDouble(wp);
						     String sw=String.format("%,.2f",wd);
						     
						     Double bal=vd-wd;
						     String bala=String.format("%,.2f",bal);
						     
						     String sql2="select sum(Deposit),sum(Withdraw) from Loan ";
				        	 ps=con.prepareStatement(sql2);
				        	 rs=ps.executeQuery();
				        	 
				        	 String dt=rs.getString("sum(Deposit)");
				        	 Double bd=Double.parseDouble(dt);
				        	 
				        	 String wt=rs.getString("sum(Withdraw)");
				        	 Double bw=Double.parseDouble(wt);
				        	 
				        	 Double toto=bw-bd;
				        	 String total=String.format("%,.2f",toto);
				        	 
						     
						     PdfPTable mudi2 = new PdfPTable(1);
						     mudi2.setWidthPercentage(100);	
						     PdfPCell cell2=new PdfPCell(new Phrase("BALANCE INFORMATION"));
						     cell2.setColspan(1);
						     cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
						     cell2.setBackgroundColor(new BaseColor(255,250,205));
						     mudi2.addCell(cell2);
						  
						     cell2 = new PdfPCell(new Phrase("All Time Balance :  "+bala ,FontFactory.getFont("verdana", 12, Font.BOLD, BaseColor.BLACK)));
							 cell2.setColspan(6);
							 cell2.setBorder(0);
							// cell2.setHorizontalAlignment(1);
							// mudi2.addCell(cell2);
							 
							 cell2 = new PdfPCell(new Phrase("Total Loan Balance : "+total ,FontFactory.getFont("verdana", 12, Font.BOLD, BaseColor.BLACK)));
							 cell2.setColspan(6);
							 cell2.setBorder(0);
							// cell2.setHorizontalAlignment(1);
							 mudi2.addCell(cell2);
								  
							PdfPTable mudi1 = new PdfPTable(36);
							 mudi1.setWidthPercentage(100);	
						     PdfPCell cell1=new PdfPCell(new Phrase(""));
						     cell1.setColspan(36);
						     mudi1.setWidths(new int[]{ 1, 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
						     cell1.setBorder(0);
						     cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
						     cell1.setBackgroundColor(new BaseColor(255,250,205));
						     mudi1.addCell(cell1);
						     
						     cell1 = new PdfPCell(new Phrase("",FontFactory.getFont("verdana", 11, Font.PLAIN, BaseColor.BLACK)));
							 cell1.setColspan(9);
							 cell1.setBorder(0);
							 cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
						     
						    
						     cell1 = new PdfPCell(new Phrase("Total " ,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
							 cell1.setColspan(6);
							 cell1.setBorder(0);
							 cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							
							 cell1 = new PdfPCell(new Phrase(""+sw,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
							 cell1.setColspan(7);
							 cell1.setBorder(0);
							 cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							 cell1 = new PdfPCell(new Phrase(""+sd,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
							 cell1.setColspan(7);
							 cell1.setBorder(0);
							 cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							 cell1 = new PdfPCell(new Phrase("",FontFactory.getFont("verdana", 11, Font.PLAIN, BaseColor.BLACK)));
							 cell1.setColspan(7);
							 cell1.setBorder(0);
							// cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							 
							 
							 
		      		    	PdfPTable mudi23 = new PdfPTable(1);
						     PdfPCell cell23=new PdfPCell(new Phrase(""));
						     cell23.setColspan(5);
						     
						     mudi23.setWidthPercentage(100);
						     Image im=Image.getInstance("other.png");
		      		    	 cell23.setBorder(0);
		       		    	 mudi23.addCell(cell23);
		      		    	 mudi23.addCell(im);
							
						 PdfPTable mudi = new PdfPTable(36);
					     PdfPCell cell=new PdfPCell(new Phrase(""));
					     cell.setColspan(10);
					     cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					     cell.setBackgroundColor(new BaseColor(240,230,140));
					     mudi.addCell(cell);
					     mudi.setWidths(new int[]{ 1, 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
						    mudi.setWidthPercentage(100);					    
						    cell.setColspan(36);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    cell = new PdfPCell(new Phrase("USER_ID",FontFactory.getFont("verdana", 13, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(6);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    
						    cell = new PdfPCell(new Phrase("FULL NAME",FontFactory.getFont("verdana", 13, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(9);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    
						    
						    cell = new PdfPCell(new Phrase("FROM",FontFactory.getFont("verdana", 13, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(6);
						    cell.setHorizontalAlignment(1);
						   // mudi.addCell(cell);
						    
						    
						    cell = new PdfPCell(new Phrase("LOAN",FontFactory.getFont("verdana", 13, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(7);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						   

						    cell = new PdfPCell(new Phrase("PAID",FontFactory.getFont("verdana", 13, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(7);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    

						    cell = new PdfPCell(new Phrase("REMAIN",FontFactory.getFont("verdana", 13, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(7);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						     String sql="select user.id,user.FNAme,user.LName,Loan.Datee,Loan.Fromm,sum(Loan.Deposit),sum(Loan.Withdraw),Loan.Comment from user,Loan where user.id=Loan.id group by loan.id ";
				        	 ps=con.prepareStatement(sql);
				        	 rs=ps.executeQuery();
				        	 
						    while(rs.next()) {
						    	String id=rs.getString("id");
						    	String first=rs.getString("FName");
				    			String last=rs.getString("LName");
				    			String date=rs.getString("Datee");
				    			String fund=rs.getString("Fromm");
					    		String depo=rs.getString("sum(Loan.Deposit)");
					    		String with=rs.getString("sum(Loan.Withdraw)");
					    		String desc=rs.getString("Comment");
					    		String s1="";
					    		String s2="";
					    		
					    		Double value1=0.0;
					    		Double value2=0.0;
					    		 
					    		if(!depo.isEmpty()) {
					    			value1=Double.parseDouble(depo);
						            s1=String.format("%,.2f",value1);
					    		}else {
					    			s1="";
					    		}
					    		
		                      if(!with.isEmpty()) {
		                    	  value2=Double.parseDouble(with);
		  						  s2=String.format("%,.2f",value2);
		  			    		
					    		}else {
					    			s2="";
					    		}
					    		
		                      Double balance=value2-value1;
		                     String s3=String.format("%,.2f", balance);
		                     
		                     cell = new PdfPCell(new Phrase(""+id,FontFactory.getFont("serif", 10, Font.PLAIN, BaseColor.BLACK)));
							    cell.setColspan(6);
							 //  cell.setHorizontalAlignment(1);
							    mudi.addCell(cell);
					    		
		                      cell = new PdfPCell(new Phrase(first+" "+last,FontFactory.getFont("serif", 10, Font.PLAIN, BaseColor.BLACK)));
							    cell.setColspan(9);
							  // cell.setHorizontalAlignment(1);
							    mudi.addCell(cell);
							    
								    
								    cell = new PdfPCell(new Phrase(fund,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(6);
								    cell.setHorizontalAlignment(1);
								   // mudi.addCell(cell);
								    
								    cell = new PdfPCell(new Phrase(s2,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(7);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								  
								    cell = new PdfPCell(new Phrase(s1,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(7);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								    cell = new PdfPCell(new Phrase(s3.toString(),FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(7);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								     
						    }
						    
						    Document document=new Document(PageSize.A4);
				            PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream("Statement.pdf"));
							document.open();
							Image img=Image.getInstance("barcode.png");
							
							document.add(mudi23);
							document.add(new Paragraph("                                               ALL USER STATEMENT",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,new BaseColor(0,0,150))));
							document.add(new Paragraph("\n"));
							document.add(mudi);
							document.add(mudi1);
							document.add(new Paragraph("\n"));
							document.add(mudi2);
							document.add(new Paragraph("\n"));
							document.add(img);
							document.add(new Paragraph(""+df.format(timer.getTime())+"::"+dtt.format(timer.getTime() )) );
							document.close();
							
							JOptionPane.showMessageDialog(null, "Loading...Please Wait !");
						      Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"Statement.pdf");
						      
		     
	        	 
		     				
		     			}else {
		     				JOptionPane.showMessageDialog(null, "No Item with that Record !");
		     			}
		        		 
			     				
		         }catch(Exception ex) {
		        	// JOptionPane.showMessageDialog(null, "No Item with that Record !");
		        	 JOptionPane.showMessageDialog(null, ex.getStackTrace());
		         }

					//
				
				
			}
			  });
		
		
		b12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
         try {
        	 
        	 String id=ta0.getText();
        	 
        	 String sql22="select * from user where id ='"+id+"'  ";
        	 ps=con.prepareStatement(sql22);
        	 ResultSet rs1=ps.executeQuery();
        	 
        	 if(id!= null &&!id.trim().isEmpty()) {
        		 
	     				String sql1="select sum(Deposit),sum(Withdraw) from Loan  where id='"+id+"' ";
			        	 ps=con.prepareStatement(sql1);
			        	 rs=ps.executeQuery();
			        	 
			        	 String dp=rs.getString("sum(Deposit)");
			        	 Double vd=0.0;
					     
					     
					     String wp=rs.getString("sum(Withdraw)");
			        	 Double wd=0.0;
					    
			        	 String sql2="select sum(Deposit),sum(Withdraw) from Loan  where id='"+id+"'";
			        	 ps=con.prepareStatement(sql2);
			        	 rs=ps.executeQuery();
			        	 
			        	 String dt=rs.getString("sum(Deposit)");
			        	 Double bd=0.0;
			        	 
			        	 String wt=rs.getString("sum(Withdraw)");
			        	 Double bw=0.0;
			        	 
					     

             			if( (dp!=null && !dp.trim().isEmpty()) ||(wp!=null && !wp.trim().isEmpty()) ||(dt!=null && !dt.trim().isEmpty()) ||(wt!=null && !wt.trim().isEmpty())) {
             				
             				vd=Double.parseDouble(dp);
             				wd=Double.parseDouble(wp);
             				bd=Double.parseDouble(dt);
             				bw=Double.parseDouble(wt);
             				
             			}
             			
             		   	String sd=String.format("%,.2f",vd);
             			 String sw=String.format("%,.2f",wd);
	                   
					     Double bal=vd-wd;
					     String bala=String.format("%,.2f",bal);
					     
					    
			        	 Double toto=bw-bd;
			        	 String total=String.format("%,.2f",toto);
			        	 
					     
					     PdfPTable mudi2 = new PdfPTable(1);
					     mudi2.setWidthPercentage(100);	
					     PdfPCell cell2=new PdfPCell(new Phrase("BALANCE INFORMATION"));
					     cell2.setColspan(1);
					     cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
					     cell2.setBackgroundColor(new BaseColor(255,250,205));
					     mudi2.addCell(cell2);
					  
					     cell2 = new PdfPCell(new Phrase("All Time Balance :  "+bala ,FontFactory.getFont("verdana", 12, Font.BOLD, BaseColor.BLACK)));
						 cell2.setColspan(6);
						 cell2.setBorder(0);
						// cell2.setHorizontalAlignment(1);
						// mudi2.addCell(cell2);
						 
						 cell2 = new PdfPCell(new Phrase("Total Loan Balance : "+total ,FontFactory.getFont("verdana", 12, Font.BOLD, BaseColor.BLACK)));
						 cell2.setColspan(6);
						 cell2.setBorder(0);
						// cell2.setHorizontalAlignment(1);
						 mudi2.addCell(cell2);
							  
						PdfPTable mudi1 = new PdfPTable(36);
						 mudi1.setWidthPercentage(100);	
					     PdfPCell cell1=new PdfPCell(new Phrase(""));
					     cell1.setColspan(36);
					     mudi1.setWidths(new int[]{ 1, 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
					     cell1.setBorder(0);
					     cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
					     cell1.setBackgroundColor(new BaseColor(255,250,205));
					     mudi1.addCell(cell1);
					     
					     cell1 = new PdfPCell(new Phrase("",FontFactory.getFont("verdana", 11, Font.PLAIN, BaseColor.BLACK)));
						 cell1.setColspan(6);
						 cell1.setBorder(0);
						// cell1.setHorizontalAlignment(1);
						 mudi1.addCell(cell1);
						 
					     
					     cell1 = new PdfPCell(new Phrase("" ,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
						 cell1.setColspan(6);
						 cell1.setBorder(0);
						 cell1.setHorizontalAlignment(1);
						 mudi1.addCell(cell1);
						 
						 cell1 = new PdfPCell(new Phrase("Total " ,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
						 cell1.setColspan(6);
						 cell1.setBorder(0);
						 cell1.setHorizontalAlignment(1);
						 mudi1.addCell(cell1);
						 
						
						 cell1 = new PdfPCell(new Phrase(""+sw,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
						 cell1.setColspan(6);
						 cell1.setBorder(0);
						 cell1.setHorizontalAlignment(1);
						 mudi1.addCell(cell1);
						 
						 cell1 = new PdfPCell(new Phrase(""+sd,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
						 cell1.setColspan(6);
						 cell1.setBorder(0);
						 cell1.setHorizontalAlignment(1);
						 mudi1.addCell(cell1);
						 
						 cell1 = new PdfPCell(new Phrase("",FontFactory.getFont("verdana", 11, Font.PLAIN, BaseColor.BLACK)));
						 cell1.setColspan(6);
						 cell1.setBorder(0);
						// cell1.setHorizontalAlignment(1);
						 mudi1.addCell(cell1);
						 
						 
						 
						 
	      		    	PdfPTable mudi23 = new PdfPTable(1);
					     PdfPCell cell23=new PdfPCell(new Phrase(""));
					     cell23.setColspan(5);
					     
					     mudi23.setWidthPercentage(100);
					     Image im=Image.getInstance("other.png");
	      		    	 cell23.setBorder(0);
	       		    	 mudi23.addCell(cell23);
	      		    	 mudi23.addCell(im);
						
					 PdfPTable mudi = new PdfPTable(36);
				     PdfPCell cell=new PdfPCell(new Phrase(""));
				     cell.setColspan(10);
				     cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				     cell.setBackgroundColor(new BaseColor(240,230,140));
				     mudi.addCell(cell);
				     mudi.setWidths(new int[]{ 1, 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
					    mudi.setWidthPercentage(100);					    
					    cell.setColspan(36);
					    cell.setHorizontalAlignment(1);
					    mudi.addCell(cell);
					    
					    cell = new PdfPCell(new Phrase("DATE",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
					    cell.setColspan(6);
					    cell.setHorizontalAlignment(1);
					    mudi.addCell(cell);
					    
					    cell = new PdfPCell(new Phrase("FROM",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
					    cell.setColspan(6);
					    cell.setHorizontalAlignment(1);
					    mudi.addCell(cell);
					    
					    cell = new PdfPCell(new Phrase("TO",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
					    cell.setColspan(6);
					    cell.setHorizontalAlignment(1);
					    mudi.addCell(cell);
					    
					    
					    cell = new PdfPCell(new Phrase("LOAN",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
					    cell.setColspan(6);
					    cell.setHorizontalAlignment(1);
					    mudi.addCell(cell);
					    
					   

					    cell = new PdfPCell(new Phrase("PAID",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
					    cell.setColspan(6);
					    cell.setHorizontalAlignment(1);
					    mudi.addCell(cell);
					    

					    cell = new PdfPCell(new Phrase("COMMENT",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
					    cell.setColspan(6);
					    cell.setHorizontalAlignment(1);
					    mudi.addCell(cell);
					    
					    String sql="select * from Loan where id='"+id+"'  ";
					    ps=con.prepareStatement(sql);
					    rs=ps.executeQuery();
					    
					    while(rs.next()) {
					    	
			    			String date=rs.getString("Datee");
			    			String fund=rs.getString("Fromm");
			    			String to=rs.getString("Too");
				    		String depo=rs.getString("Deposit");
				    		String with=rs.getString("Withdraw");
				    		String desc=rs.getString("Comment");
				    		String s1="";
				    		String s2="";
				    		
				    		if(!depo.isEmpty()) {
				    			Double value1=Double.parseDouble(depo);
					            s1=String.format("%,.2f",value1);
				    		}else {
				    			s1="";
				    		}
				    		
	                      if(!with.isEmpty()) {
	                    	  Double value2=Double.parseDouble(with);
	  						  s2=String.format("%,.2f",value2);
	  			    		
				    		}else {
				    			s2="";
				    		}
				    		
				    		
							
				    		  cell = new PdfPCell(new Phrase(""+date,FontFactory.getFont("serif", 10, Font.PLAIN, BaseColor.BLACK)));
							    cell.setColspan(6);
							   cell.setHorizontalAlignment(1);
							    mudi.addCell(cell);
							    
							    cell = new PdfPCell(new Phrase(fund,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
							    cell.setColspan(6);
							    cell.setHorizontalAlignment(1);
							    mudi.addCell(cell);
							    
							    cell = new PdfPCell(new Phrase(to,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
							    cell.setColspan(6);
							    cell.setHorizontalAlignment(1);
							    mudi.addCell(cell);
							    
							    cell = new PdfPCell(new Phrase(s2,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
							    cell.setColspan(6);
							    cell.setHorizontalAlignment(1);
							    mudi.addCell(cell);
							    
							  
							    cell = new PdfPCell(new Phrase(s1,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
							    cell.setColspan(6);
							    cell.setHorizontalAlignment(1);
							    mudi.addCell(cell);
							    
							    cell = new PdfPCell(new Phrase(desc,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
							    cell.setColspan(6);
							    cell.setHorizontalAlignment(1);
							    mudi.addCell(cell);
							    
							    
					    }
					    
					   
					    Document document=new Document(PageSize.A4);
			            PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream("Statement.pdf"));
						document.open();
						Image img=Image.getInstance("barcode.png");
						
						document.add(mudi23);
						document.add(new Paragraph("                                                   USER STATEMENT",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,new BaseColor(0,0,150))));
						document.add(new Paragraph("\n"));
						document.add(new Paragraph("LOAN TYPE : "+rs1.getString("LType"),FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,new BaseColor(0,0,150))));
						document.add(new Paragraph("FOR : "+rs1.getString("FName")+"  "+rs1.getString("LName"),FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,new BaseColor(0,0,150))));
						document.add(new Paragraph("\n"));
						document.add(mudi);
						//document.add(new Paragraph("\n"));
						document.add(mudi1);
						document.add(new Paragraph("\n"));
						document.add(mudi2);
						document.add(new Paragraph("\n"));
						document.add(img);
						document.add(new Paragraph(""+df.format(timer.getTime())+"::"+dtt.format(timer.getTime() )) );
						document.close();
						
						JOptionPane.showMessageDialog(null, "Loading...Please Wait !");
					      Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"Statement.pdf");
					      
	     		
        		 
        	 }else {
        		 JOptionPane.showMessageDialog(null, "Select User from the Table !");
        	 }
        	 
        	 
        	 
         }catch(Exception ex) {
        	// JOptionPane.showMessageDialog(null, "No Item with that Record !");
        	 JOptionPane.showMessageDialog(null, ex.getStackTrace());
         }

			}
		});
		
		
		b9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			refresh();
				
			
			}
	});
		
		
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			

				
				if( (ta0.getText()!= null &&!ta0.getText().trim().isEmpty()) && (ta2.getText()!= null &&!ta2.getText().trim().isEmpty()) &&
						(ta3.getText()!= null &&!ta3.getText().trim().isEmpty()) && (box10.getSelectedItem()!= null &&!box10.getSelectedItem().toString().trim().isEmpty())
						 ) {
					
					if(ta2.getText().matches("^[\\p{L} .'-]+$") && ta3.getText().matches("^[\\p{L} .'-]+$"))
					{
						try {
							String first=ta2.getText().toUpperCase();
						    String last=ta3.getText().toUpperCase();
							
							String sql="insert into user (id,FName,LName,LType) values (?,?,?,?)";
							ps=con.prepareStatement(sql);
							ps.setString(1, ta0.getText().toUpperCase());
							ps.setString(2,first );
							ps.setString(3, last);
							ps.setString(4, box10.getSelectedItem().toString());
							ps.execute();
							table();
							JOptionPane.showMessageDialog(b1, first+" "+last+" Added Successfuly !");
									
						}catch(Exception ex) {
							JOptionPane.showMessageDialog(null, "User of that User_ID is Already Registered !");
						}
						
					}else {
						
						JOptionPane.showMessageDialog(b1, "Please Enter Valid Name !");
					}
					
					
				}else {
					
					JOptionPane.showMessageDialog(null, "Can't Accept Empty Value !");
				}
				
			} });
		
		
		b10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
                if((box10.getSelectedItem()!= null &&!box10.getSelectedItem().toString().trim().isEmpty()) ) {
                 	int result = JOptionPane.showConfirmDialog(null, p29, "Take a Loan",
        			            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                    	
                    	if(result==JOptionPane.OK_OPTION) {
                    		
                    		if((tex2.getSelectedItem()!= null &&!tex2.getSelectedItem().toString().trim().isEmpty()) && (ta4.getSelectedItem()!= null &&!ta4.getSelectedItem().toString().trim().isEmpty()) && (ta5.getText()!= null &&!ta5.getText().trim().isEmpty())
                        		) {
                        		
                    	
                    			
                        		try {
                        			
                        			String sql1="select sum(Deposit),sum(Withdraw) from Trans where FName= '"+ta4.getSelectedItem().toString()+"'";
                        			ps=con.prepareStatement(sql1);
                        			rs=ps.executeQuery();
                        			
                        			String depo=rs.getString("sum(Deposit)");
                        			Double dep=0.0;
                        			String witho=rs.getString("sum(Withdraw)");
                        			Double with=0.0;
                        			
                        			if( (depo!=null && !depo.trim().isEmpty()) || (witho!=null && !witho.trim().isEmpty()) ) {
                        				dep=Double.parseDouble(depo);
                        				with=Double.parseDouble(witho);
                        			}
                        			
                        			Double amount=Double.parseDouble(ta5.getText());
                        			Double balance=dep-with;
                        			
                        			Double bala=balance-amount;
                        			
                        			if(bala>=0.0) {
                        				
                        				String sql="insert into loan (id,Deposit,Withdraw,Comment,Fromm,Too,Datee,Month,Year) values (?,?,?,?,?,?,?,?,?)";
                            			ps=con.prepareStatement(sql);
                            			ps.setString(1, ta0.getText());
                            			ps.setString(2, "");
                            			ps.setString(3, ta5.getText());
                            			ps.setString(4, ta6.getText());
                            			ps.setString(5, ta4.getSelectedItem().toString());
                            			ps.setString(6, tex2.getSelectedItem().toString());
                            			ps.setString(7, dt.format(timer.getTime()));
                            			ps.setString(8, mm.format(timer.getTime()));
                            			ps.setString(9, yy.format(timer.getTime()));
                            			ps.execute();
                            			
                                         if(tex2.getSelectedItem().toString().matches("PERSONAL")) {
                                        	 JOptionPane.showMessageDialog(b1,"Data Added Successfuly !");
                                  			
                                        	 
                                         }else {
                                        	 
                                        	String sql2="insert into Trans (Fname,Deposit,Withdraw,Comment,Datee,Month,Year) values (?,?,?,?,?,?,?)";
                     						ps=con.prepareStatement(sql2);
                     						ps.setString(1, ta4.getSelectedItem().toString());
                     						ps.setString(2, "");
                     						ps.setString(3,ta5.getText());
                     						ps.setString(4, ta6.getText());
                     						ps.setString(5, dt.format(timer.getTime()));
                     						ps.setString(6, mm.format(timer.getTime()));
                     						ps.setString(7, yy.format(timer.getTime()));
                     						ps.execute();
                     						
                     						String sql3="insert into Trans (Fname,Deposit,Withdraw,Comment,Datee,Month,Year) values (?,?,?,?,?,?,?)";
                     						ps=con.prepareStatement(sql3);
                     						ps.setString(1, tex2.getSelectedItem().toString());
                     						ps.setString(2, ta5.getText());
                     						ps.setString(3,"");
                     						ps.setString(4, ta6.getText());
                     						ps.setString(5, dt.format(timer.getTime()));
                     						ps.setString(6, mm.format(timer.getTime()));
                     						ps.setString(7, yy.format(timer.getTime()));
                     						ps.execute();
                     						table();
                     						
                     						JOptionPane.showMessageDialog(b1,"Data Added Successfuly !");
                                 			
                                 			
                                        	 
                                         }
                						
                        				
                        			}else {
                        				
                        				JOptionPane.showMessageDialog(null, "Insufficient Money !");
                        			}
                        			
                        			
                        			
                        			
                        		}catch(Exception ex) {
                        			JOptionPane.showMessageDialog(null, ex.getStackTrace());
                        		}
                        		
                        		
                        	}else {
                        		JOptionPane.showMessageDialog(null, "Can't Accept Empty Value !");
                        		
                        	}
                    	}
                    	
                    
                	
                }else {
                	JOptionPane.showMessageDialog(null, "Select User from the Table !");
                }
			
				
			}
	});
		
		b11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {



				
                if((box10.getSelectedItem()!= null &&!box10.getSelectedItem().toString().trim().isEmpty()) ) {
                	
                	int result = JOptionPane.showConfirmDialog(null, p29, "Pay a Loan",
    			            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                	
                	if(result==JOptionPane.OK_OPTION) {
                		
                		if( (ta4.getSelectedItem()!= null &&!ta4.getSelectedItem().toString().trim().isEmpty())&&(ta4.getSelectedItem()!= null &&!ta4.getSelectedItem().toString().trim().isEmpty()) && (ta5.getText()!= null &&!ta5.getText().trim().isEmpty())
                    		) {
                    		
                    		try {
                    			

                				String sql="insert into loan (id,Deposit,Withdraw,Comment,Fromm,Too,Datee,Month,Year) values (?,?,?,?,?,?,?,?,?)";
                    			ps=con.prepareStatement(sql);
                    			ps.setString(1, ta0.getText());
                    			ps.setString(2, ta5.getText());
                    			ps.setString(3, "");
                    			ps.setString(4, ta6.getText());
                    			ps.setString(5, ta4.getSelectedItem().toString());
                    			ps.setString(6, tex2.getSelectedItem().toString());
                    			ps.setString(7, dt.format(timer.getTime()));
                    			ps.setString(8, mm.format(timer.getTime()));
                    			ps.setString(9, yy.format(timer.getTime()));
                    			ps.execute();
                        			
                    			String sql2="insert into Trans (Fname,Deposit,Withdraw,Comment,Datee,Month,Year) values (?,?,?,?,?,?,?)";
         						ps=con.prepareStatement(sql2);
         						ps.setString(1, ta4.getSelectedItem().toString());
         						ps.setString(2, "");
         						ps.setString(3,ta5.getText());
         						ps.setString(4, ta6.getText());
         						ps.setString(5, dt.format(timer.getTime()));
         						ps.setString(6, mm.format(timer.getTime()));
         						ps.setString(7, yy.format(timer.getTime()));
         						ps.execute();
         						
         						String sql3="insert into Trans (Fname,Deposit,Withdraw,Comment,Datee,Month,Year) values (?,?,?,?,?,?,?)";
         						ps=con.prepareStatement(sql3);
         						ps.setString(1, tex2.getSelectedItem().toString());
         						ps.setString(2, ta5.getText());
         						ps.setString(3,"");
         						ps.setString(4, ta6.getText());
         						ps.setString(5, dt.format(timer.getTime()));
         						ps.setString(6, mm.format(timer.getTime()));
         						ps.setString(7, yy.format(timer.getTime()));
         						ps.execute();
            						table();
            						
            						JOptionPane.showMessageDialog(b1,"Data Added Successfuly !");
                        			
                        			
                    				
                    			
                    		}catch(Exception ex) {
                    			JOptionPane.showMessageDialog(null, ex.getStackTrace());
                    		}
                    		
                    		
                    	}else {
                    		JOptionPane.showMessageDialog(null, "Can't Accept Empty Value !");
                    		
                    	}
                	}
                	
                	
                	
                	
                }else {
                	JOptionPane.showMessageDialog(null, "Select User from the Table !");
                }
			
				
			
				
				
			}
		});
		
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
						
						String year=box2.getSelectedItem().toString();
							
						String count="select count(Fname) from Trans   ";
		     			ps=con.prepareStatement(count);
		     			ResultSet rss=ps.executeQuery();
		     			
		     			int nam=Integer.parseInt(rss.getString("count(Fname)"));
		     			if(nam !=0) {
		     				
		     				
		     				String sql1="select sum(Deposit),sum(Withdraw) from Trans ";
				        	 ps=con.prepareStatement(sql1);
				        	 rs=ps.executeQuery();
				        	 
				        	 String dp=rs.getString("sum(Deposit)");
				        	 Double vd=Double.parseDouble(dp);
						     String sd=String.format("%,.2f",vd);
						     
						     
		                    String wp=rs.getString("sum(Withdraw)");
				        	 Double wd=Double.parseDouble(wp);
						     String sw=String.format("%,.2f",wd);
								  
							PdfPTable mudi1 = new PdfPTable(36);
							 mudi1.setWidthPercentage(100);	
						     PdfPCell cell1=new PdfPCell(new Phrase(""));
						     cell1.setColspan(36);
						     mudi1.setWidths(new int[]{ 1, 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
						     cell1.setBorder(0);
						     cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
						     cell1.setBackgroundColor(new BaseColor(255,250,205));
						     mudi1.addCell(cell1);
						     
						     cell1 = new PdfPCell(new Phrase("",FontFactory.getFont("verdana", 11, Font.PLAIN, BaseColor.BLACK)));
							 cell1.setColspan(6);
							 cell1.setBorder(0);
							// cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
						     
						     cell1 = new PdfPCell(new Phrase("Total " ,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
							 cell1.setColspan(6);
							 cell1.setBorder(0);
							 cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							
							 cell1 = new PdfPCell(new Phrase(""+sd,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
							 cell1.setColspan(8);
							 cell1.setBorder(0);
							 cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							 cell1 = new PdfPCell(new Phrase(""+sw,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
							 cell1.setColspan(8);
							 cell1.setBorder(0);
							 cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							 cell1 = new PdfPCell(new Phrase("",FontFactory.getFont("verdana", 11, Font.PLAIN, BaseColor.BLACK)));
							 cell1.setColspan(8);
							 cell1.setBorder(0);
							// cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							 
		      		    	PdfPTable mudi23 = new PdfPTable(1);
						     PdfPCell cell23=new PdfPCell(new Phrase(""));
						     cell23.setColspan(5);
						     
						     mudi23.setWidthPercentage(100);
						     Image im=Image.getInstance("other.png");
		      		    	 cell23.setBorder(0);
		       		    	 mudi23.addCell(cell23);
		      		    	 mudi23.addCell(im);
							
						 PdfPTable mudi = new PdfPTable(36);
					     PdfPCell cell=new PdfPCell(new Phrase(""));
					     cell.setColspan(10);
					     cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					     cell.setBackgroundColor(new BaseColor(240,230,140));
					     mudi.addCell(cell);
					     mudi.setWidths(new int[]{ 1, 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
						    mudi.setWidthPercentage(100);					    
						    cell.setColspan(36);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    cell = new PdfPCell(new Phrase("DATE",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(6);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    cell = new PdfPCell(new Phrase("CATEGORY",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(6);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    
						    cell = new PdfPCell(new Phrase("DEPOSIT",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(8);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						   

						    cell = new PdfPCell(new Phrase("WITHDRAW",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(8);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    

						    cell = new PdfPCell(new Phrase("DESCRIPTION",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(8);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    String sql="select * from Trans  ";
						    ps=con.prepareStatement(sql);
						    rs=ps.executeQuery();
						    
						    while(rs.next()) {
						    	
				    			String date=rs.getString("Datee");
				    			String fund=rs.getString("Fname");
					    		String depo=rs.getString("Deposit");
					    		String with=rs.getString("Withdraw");
					    		String desc=rs.getString("Comment");
					    		String s1="";
					    		String s2="";
					    		
					    		if(!depo.isEmpty()) {
					    			Double value1=Double.parseDouble(depo);
						            s1=String.format("%,.2f",value1);
					    		}else {
					    			s1="";
					    		}
					    		
		                      if(!with.isEmpty()) {
		                    	  Double value2=Double.parseDouble(with);
		  						  s2=String.format("%,.2f",value2);
		  			    		
					    		}else {
					    			s2="";
					    		}
					    		
					    		
								
					    		  cell = new PdfPCell(new Phrase(""+date,FontFactory.getFont("serif", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(6);
								   cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								    cell = new PdfPCell(new Phrase(fund,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(6);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								    cell = new PdfPCell(new Phrase(s1,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(8);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								  
								    cell = new PdfPCell(new Phrase(s2,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(8);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								    cell = new PdfPCell(new Phrase(desc,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(8);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								    
						    }
						    
						   
						    Document document=new Document(PageSize.A4);
				            PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream("Statement.pdf"));
							document.open();
							Image img=Image.getInstance("barcode.png");
							
							document.add(mudi23);
							document.add(new Paragraph("                                              ALL TIME STATEMENT",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,new BaseColor(0,0,150))));
							document.add(new Paragraph("\n"));
							//document.add(new Paragraph("FOR : "+year,FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,new BaseColor(0,0,150))));
							document.add(new Paragraph("\n"));
							document.add(mudi);
							//document.add(new Paragraph("\n"));
							document.add(mudi1);
							document.add(new Paragraph("\n"));
							document.add(img);
							document.add(new Paragraph(""+df.format(timer.getTime())+"::"+dtt.format(timer.getTime() )) );
							document.close();
							
							JOptionPane.showMessageDialog(null, "Loading...Please Wait !");
						      Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"Statement.pdf");
						      
		     				
		     			}else {
		     				
		     				JOptionPane.showMessageDialog(null, "No Item with that Record !");
		     			}
						
					
					
	         
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				
				
			}	});
		
		
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				try {
					int result = JOptionPane.showConfirmDialog(null, p24, "Year Statement",
				            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
					
					if(result==JOptionPane.OK_OPTION) {
						
						String year=box2.getSelectedItem().toString();
							
						String count="select count(Fname) from Trans  where Year='"+year+"'   ";
		     			ps=con.prepareStatement(count);
		     			ResultSet rss=ps.executeQuery();
		     			
		     			int nam=Integer.parseInt(rss.getString("count(Fname)"));
		     			if(nam !=0) {
		     				
		     				
		     				String sql1="select sum(Deposit),sum(Withdraw) from Trans  where Year='"+year+"'";
				        	 ps=con.prepareStatement(sql1);
				        	 rs=ps.executeQuery();
				        	 
				        	 String dp=rs.getString("sum(Deposit)");
				        	 Double vd=Double.parseDouble(dp);
						     String sd=String.format("%,.2f",vd);
						     
						     
		                    String wp=rs.getString("sum(Withdraw)");
				        	 Double wd=Double.parseDouble(wp);
						     String sw=String.format("%,.2f",wd);
								  
							PdfPTable mudi1 = new PdfPTable(36);
							 mudi1.setWidthPercentage(100);	
						     PdfPCell cell1=new PdfPCell(new Phrase(""));
						     cell1.setColspan(36);
						     mudi1.setWidths(new int[]{ 1, 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
						     cell1.setBorder(0);
						     cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
						     cell1.setBackgroundColor(new BaseColor(255,250,205));
						     mudi1.addCell(cell1);
						     
						     cell1 = new PdfPCell(new Phrase("",FontFactory.getFont("verdana", 11, Font.PLAIN, BaseColor.BLACK)));
							 cell1.setColspan(6);
							 cell1.setBorder(0);
							// cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
						     
						     cell1 = new PdfPCell(new Phrase("Total " ,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
							 cell1.setColspan(6);
							 cell1.setBorder(0);
							 cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							
							 cell1 = new PdfPCell(new Phrase(""+sd,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
							 cell1.setColspan(8);
							 cell1.setBorder(0);
							 cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							 cell1 = new PdfPCell(new Phrase(""+sw,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
							 cell1.setColspan(8);
							 cell1.setBorder(0);
							 cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							 cell1 = new PdfPCell(new Phrase("",FontFactory.getFont("verdana", 11, Font.PLAIN, BaseColor.BLACK)));
							 cell1.setColspan(8);
							 cell1.setBorder(0);
							// cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							 
		      		    	PdfPTable mudi23 = new PdfPTable(1);
						     PdfPCell cell23=new PdfPCell(new Phrase(""));
						     cell23.setColspan(5);
						     
						     mudi23.setWidthPercentage(100);
						     Image im=Image.getInstance("other.png");
		      		    	 cell23.setBorder(0);
		       		    	 mudi23.addCell(cell23);
		      		    	 mudi23.addCell(im);
							
						 PdfPTable mudi = new PdfPTable(36);
					     PdfPCell cell=new PdfPCell(new Phrase(""));
					     cell.setColspan(10);
					     cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					     cell.setBackgroundColor(new BaseColor(240,230,140));
					     mudi.addCell(cell);
					     mudi.setWidths(new int[]{ 1, 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
						    mudi.setWidthPercentage(100);					    
						    cell.setColspan(36);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    cell = new PdfPCell(new Phrase("DATE",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(6);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    cell = new PdfPCell(new Phrase("CATEGORY",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(6);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    
						    cell = new PdfPCell(new Phrase("DEPOSIT",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(8);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						   

						    cell = new PdfPCell(new Phrase("WITHDRAW",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(8);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    

						    cell = new PdfPCell(new Phrase("DESCRIPTION",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(8);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    String sql="select * from Trans where  Year='"+year+"' ";
						    ps=con.prepareStatement(sql);
						    rs=ps.executeQuery();
						    
						    while(rs.next()) {
						    	
				    			String date=rs.getString("Datee");
				    			String fund=rs.getString("Fname");
					    		String depo=rs.getString("Deposit");
					    		String with=rs.getString("Withdraw");
					    		String desc=rs.getString("Comment");
					    		String s1="";
					    		String s2="";
					    		
					    		if(!depo.isEmpty()) {
					    			Double value1=Double.parseDouble(depo);
						            s1=String.format("%,.2f",value1);
					    		}else {
					    			s1="";
					    		}
					    		
		                      if(!with.isEmpty()) {
		                    	  Double value2=Double.parseDouble(with);
		  						  s2=String.format("%,.2f",value2);
		  			    		
					    		}else {
					    			s2="";
					    		}
					    		
					    		
								
					    		  cell = new PdfPCell(new Phrase(""+date,FontFactory.getFont("serif", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(6);
								   cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								    cell = new PdfPCell(new Phrase(fund,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(6);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								    cell = new PdfPCell(new Phrase(s1,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(8);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								  
								    cell = new PdfPCell(new Phrase(s2,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(8);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								    cell = new PdfPCell(new Phrase(desc,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(8);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								    
						    }
						    
						   
						    Document document=new Document(PageSize.A4);
				            PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream("Statement.pdf"));
							document.open();
							Image img=Image.getInstance("barcode.png");
							
							document.add(mudi23);
							document.add(new Paragraph("                                                YEARLY STATEMENT",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,new BaseColor(0,0,150))));
							document.add(new Paragraph("\n"));
							document.add(new Paragraph("FOR : "+year,FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,new BaseColor(0,0,150))));
							document.add(new Paragraph("\n"));
							document.add(mudi);
							//document.add(new Paragraph("\n"));
							document.add(mudi1);
							document.add(new Paragraph("\n"));
							document.add(img);
							document.add(new Paragraph(""+df.format(timer.getTime())+"::"+dtt.format(timer.getTime() )) );
							document.close();
							
							JOptionPane.showMessageDialog(null, "Loading...Please Wait !");
						      Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"Statement.pdf");
						      
		     				
		     			}else {
		     				
		     				JOptionPane.showMessageDialog(null, "No Item with that Record !");
		     			}
						
						
					}
					
					
	         
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
				
				
			}	});
		
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
         try {
        	 
         
				int result = JOptionPane.showConfirmDialog(null, p23, "Monthly Statement",
			            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				
				if(result==JOptionPane.OK_OPTION) {
					String month=box.getSelectedItem().toString();
					String year=box1.getSelectedItem().toString();
						
					String count="select count(Fname) from Trans  where Month='"+month+"'  and Year='"+year+"'   ";
	     			ps=con.prepareStatement(count);
	     			ResultSet rss=ps.executeQuery();
	     			
	     			int nam=Integer.parseInt(rss.getString("count(Fname)"));
	     			if(nam !=0) {
	     				
	     				
	     				String sql1="select sum(Deposit),sum(Withdraw) from Trans  where Month='"+month+"'  and Year='"+year+"'";
			        	 ps=con.prepareStatement(sql1);
			        	 rs=ps.executeQuery();
			        	 
			        	 String dp=rs.getString("sum(Deposit)");
			        	 Double vd=Double.parseDouble(dp);
					     String sd=String.format("%,.2f",vd);
					     
					     
	                    String wp=rs.getString("sum(Withdraw)");
			        	 Double wd=Double.parseDouble(wp);
					     String sw=String.format("%,.2f",wd);
							  
						PdfPTable mudi1 = new PdfPTable(36);
						 mudi1.setWidthPercentage(100);	
					     PdfPCell cell1=new PdfPCell(new Phrase(""));
					     cell1.setColspan(36);
					     mudi1.setWidths(new int[]{ 1, 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
					     cell1.setBorder(0);
					     cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
					     cell1.setBackgroundColor(new BaseColor(255,250,205));
					     mudi1.addCell(cell1);
					     
					     cell1 = new PdfPCell(new Phrase("",FontFactory.getFont("verdana", 11, Font.PLAIN, BaseColor.BLACK)));
						 cell1.setColspan(6);
						 cell1.setBorder(0);
						// cell1.setHorizontalAlignment(1);
						 mudi1.addCell(cell1);
						 
					     
					     cell1 = new PdfPCell(new Phrase("Total " ,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
						 cell1.setColspan(6);
						 cell1.setBorder(0);
						 cell1.setHorizontalAlignment(1);
						 mudi1.addCell(cell1);
						 
						
						 cell1 = new PdfPCell(new Phrase(""+sd,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
						 cell1.setColspan(8);
						 cell1.setBorder(0);
						 cell1.setHorizontalAlignment(1);
						 mudi1.addCell(cell1);
						 
						 cell1 = new PdfPCell(new Phrase(""+sw,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
						 cell1.setColspan(8);
						 cell1.setBorder(0);
						 cell1.setHorizontalAlignment(1);
						 mudi1.addCell(cell1);
						 
						 cell1 = new PdfPCell(new Phrase("",FontFactory.getFont("verdana", 11, Font.PLAIN, BaseColor.BLACK)));
						 cell1.setColspan(8);
						 cell1.setBorder(0);
						// cell1.setHorizontalAlignment(1);
						 mudi1.addCell(cell1);
						 
						 
	      		    	PdfPTable mudi23 = new PdfPTable(1);
					     PdfPCell cell23=new PdfPCell(new Phrase(""));
					     cell23.setColspan(5);
					     
					     mudi23.setWidthPercentage(100);
					     Image im=Image.getInstance("other.png");
	      		    	 cell23.setBorder(0);
	       		    	 mudi23.addCell(cell23);
	      		    	 mudi23.addCell(im);
						
					 PdfPTable mudi = new PdfPTable(36);
				     PdfPCell cell=new PdfPCell(new Phrase(""));
				     cell.setColspan(10);
				     cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				     cell.setBackgroundColor(new BaseColor(240,230,140));
				     mudi.addCell(cell);
				     mudi.setWidths(new int[]{ 1, 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
					    mudi.setWidthPercentage(100);					    
					    cell.setColspan(36);
					    cell.setHorizontalAlignment(1);
					    mudi.addCell(cell);
					    
					    cell = new PdfPCell(new Phrase("DATE",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
					    cell.setColspan(6);
					    cell.setHorizontalAlignment(1);
					    mudi.addCell(cell);
					    
					    cell = new PdfPCell(new Phrase("CATEGORY",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
					    cell.setColspan(6);
					    cell.setHorizontalAlignment(1);
					    mudi.addCell(cell);
					    
					    
					    cell = new PdfPCell(new Phrase("DEPOSIT",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
					    cell.setColspan(8);
					    cell.setHorizontalAlignment(1);
					    mudi.addCell(cell);
					    
					   

					    cell = new PdfPCell(new Phrase("WITHDRAW",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
					    cell.setColspan(8);
					    cell.setHorizontalAlignment(1);
					    mudi.addCell(cell);
					    

					    cell = new PdfPCell(new Phrase("DESCRIPTION",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
					    cell.setColspan(8);
					    cell.setHorizontalAlignment(1);
					    mudi.addCell(cell);
					    
					    String sql="select * from Trans where Month='"+month+"'  and Year='"+year+"' ";
					    ps=con.prepareStatement(sql);
					    rs=ps.executeQuery();
					    
					    while(rs.next()) {
					    	
			    			String date=rs.getString("Datee");
			    			String fund=rs.getString("Fname");
				    		String depo=rs.getString("Deposit");
				    		String with=rs.getString("Withdraw");
				    		String desc=rs.getString("Comment");
				    		String s1="";
				    		String s2="";
				    		
				    		if(!depo.isEmpty()) {
				    			Double value1=Double.parseDouble(depo);
					            s1=String.format("%,.2f",value1);
				    		}else {
				    			s1="";
				    		}
				    		
	                      if(!with.isEmpty()) {
	                    	  Double value2=Double.parseDouble(with);
	  						  s2=String.format("%,.2f",value2);
	  			    		
				    		}else {
				    			s2="";
				    		}
				    		
				    		
							
				    		  cell = new PdfPCell(new Phrase(""+date,FontFactory.getFont("serif", 10, Font.PLAIN, BaseColor.BLACK)));
							    cell.setColspan(6);
							   cell.setHorizontalAlignment(1);
							    mudi.addCell(cell);
							    
							    cell = new PdfPCell(new Phrase(fund,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
							    cell.setColspan(6);
							    cell.setHorizontalAlignment(1);
							    mudi.addCell(cell);
							    
							    cell = new PdfPCell(new Phrase(s1,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
							    cell.setColspan(8);
							    cell.setHorizontalAlignment(1);
							    mudi.addCell(cell);
							    
							  
							    cell = new PdfPCell(new Phrase(s2,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
							    cell.setColspan(8);
							    cell.setHorizontalAlignment(1);
							    mudi.addCell(cell);
							    
							    cell = new PdfPCell(new Phrase(desc,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
							    cell.setColspan(8);
							    cell.setHorizontalAlignment(1);
							    mudi.addCell(cell);
							    
							    
					    }
					    
					   
					    Document document=new Document(PageSize.A4);
			            PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream("Statement.pdf"));
						document.open();
						Image img=Image.getInstance("barcode.png");
						
						document.add(mudi23);
						document.add(new Paragraph("                                              MONTHLY STATEMENT",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,new BaseColor(0,0,150))));
						document.add(new Paragraph("\n"));
						document.add(new Paragraph("FOR : "+month+" , "+year,FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,new BaseColor(0,0,150))));
						document.add(new Paragraph("\n"));
						document.add(mudi);
						//document.add(new Paragraph("\n"));
						document.add(mudi1);
						document.add(new Paragraph("\n"));
						document.add(img);
						document.add(new Paragraph(""+df.format(timer.getTime())+"::"+dtt.format(timer.getTime() )) );
						document.close();
						
						JOptionPane.showMessageDialog(null, "Loading...Please Wait !");
					      Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"Statement.pdf");
					      
	     				
	     			}else {
	     				
	     				JOptionPane.showMessageDialog(null, "No Item with that Record !");
	     			}
					
					
				}
				
				
         }catch(Exception ex) {
        	 JOptionPane.showMessageDialog(null, ex.getMessage());
         }
				
				
			}
		});
		
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int result = JOptionPane.showConfirmDialog(null, p22, "Daily Statement",
			            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			
				
				if(result==JOptionPane.OK_OPTION) {
					 String godt = dt .format(dc.getDate());
					 
						 
					try {
						
						String count="select count(Fname) from Trans  where Datee='"+godt+"' ";
		     			ps=con.prepareStatement(count);
		     			ResultSet rss=ps.executeQuery();
		     			
		     			int nam=Integer.parseInt(rss.getString("count(Fname)"));
		     			if(nam !=0) {
		     				
		     				
		     				String sql1="select sum(Deposit),sum(Withdraw) from Trans  where Datee= '"+godt+"'";
				        	 ps=con.prepareStatement(sql1);
				        	 rs=ps.executeQuery();
				        	 
				        	 String dp=rs.getString("sum(Deposit)");
				        	 Double vd=Double.parseDouble(dp);
						     String sd=String.format("%,.2f",vd);
						     
						     
		                    String wp=rs.getString("sum(Withdraw)");
				        	 Double wd=Double.parseDouble(wp);
						     String sw=String.format("%,.2f",wd);
								  
							PdfPTable mudi1 = new PdfPTable(36);
							 mudi1.setWidthPercentage(100);	
						     PdfPCell cell1=new PdfPCell(new Phrase(""));
						     cell1.setColspan(36);
						     mudi1.setWidths(new int[]{ 1, 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
						     cell1.setBorder(0);
						     cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
						     cell1.setBackgroundColor(new BaseColor(255,250,205));
						     mudi1.addCell(cell1);
						     
						     cell1 = new PdfPCell(new Phrase("",FontFactory.getFont("verdana", 11, Font.PLAIN, BaseColor.BLACK)));
							 cell1.setColspan(6);
							 cell1.setBorder(0);
							// cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
						     
						     cell1 = new PdfPCell(new Phrase("Total " ,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
							 cell1.setColspan(6);
							 cell1.setBorder(0);
							 cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							
							 cell1 = new PdfPCell(new Phrase(""+sd,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
							 cell1.setColspan(8);
							 cell1.setBorder(0);
							 cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							 cell1 = new PdfPCell(new Phrase(""+sw,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
							 cell1.setColspan(8);
							 cell1.setBorder(0);
							 cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							 cell1 = new PdfPCell(new Phrase("",FontFactory.getFont("verdana", 11, Font.PLAIN, BaseColor.BLACK)));
							 cell1.setColspan(8);
							 cell1.setBorder(0);
							// cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							 
		      		    	PdfPTable mudi23 = new PdfPTable(1);
						     PdfPCell cell23=new PdfPCell(new Phrase(""));
						     cell23.setColspan(5);
						     
						     mudi23.setWidthPercentage(100);
						     Image im=Image.getInstance("other.png");
		      		    	 cell23.setBorder(0);
		       		    	 mudi23.addCell(cell23);
		      		    	 mudi23.addCell(im);
							
						 PdfPTable mudi = new PdfPTable(36);
					     PdfPCell cell=new PdfPCell(new Phrase(""));
					     cell.setColspan(10);
					     cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					     cell.setBackgroundColor(new BaseColor(240,230,140));
					     mudi.addCell(cell);
					     mudi.setWidths(new int[]{ 1, 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
						    mudi.setWidthPercentage(100);					    
						    cell.setColspan(36);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    cell = new PdfPCell(new Phrase("DATE",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(6);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    cell = new PdfPCell(new Phrase("CATEGORY",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(6);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    
						    cell = new PdfPCell(new Phrase("DEPOSIT",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(8);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						   

						    cell = new PdfPCell(new Phrase("WITHDRAW",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(8);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    

						    cell = new PdfPCell(new Phrase("DESCRIPTION",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(8);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    String sql="select * from Trans where Datee= '"+godt+"' ";
						    ps=con.prepareStatement(sql);
						    rs=ps.executeQuery();
						    
						    while(rs.next()) {
						    	
				    			String date=rs.getString("Datee");
				    			String fund=rs.getString("Fname");
					    		String depo=rs.getString("Deposit");
					    		String with=rs.getString("Withdraw");
					    		String desc=rs.getString("Comment");
					    		String s1="";
					    		String s2="";
					    		
					    		if(!depo.isEmpty()) {
					    			Double value1=Double.parseDouble(depo);
						            s1=String.format("%,.2f",value1);
					    		}else {
					    			s1="";
					    		}
					    		
		                      if(!with.isEmpty()) {
		                    	  Double value2=Double.parseDouble(with);
		  						  s2=String.format("%,.2f",value2);
		  			    		
					    		}else {
					    			s2="";
					    		}
					    		
					    		
								
					    		  cell = new PdfPCell(new Phrase(""+date,FontFactory.getFont("serif", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(6);
								   cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								    cell = new PdfPCell(new Phrase(fund,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(6);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								    cell = new PdfPCell(new Phrase(s1,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(8);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								  
								    cell = new PdfPCell(new Phrase(s2,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(8);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								    cell = new PdfPCell(new Phrase(desc,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(8);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								    
						    }
						    
						   
						    Document document=new Document(PageSize.A4);
				            PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream("Statement.pdf"));
							document.open();
							Image img=Image.getInstance("barcode.png");
							
							document.add(mudi23);
							document.add(new Paragraph("                                                  DAILY STATEMENT",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,new BaseColor(0,0,150))));
							document.add(new Paragraph("\n"));
							document.add(new Paragraph("FOR : "+godt,FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,new BaseColor(0,0,150))));
							document.add(new Paragraph("\n"));
							document.add(mudi);
							//document.add(new Paragraph("\n"));
							document.add(mudi1);
							document.add(new Paragraph("\n"));
							document.add(img);
							document.add(new Paragraph(""+df.format(timer.getTime())+"::"+dtt.format(timer.getTime() )) );
							document.close();
							
							JOptionPane.showMessageDialog(null, "Loading...Please Wait !");
						      Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"Statement.pdf");
						      
		     				
		     			}else {
		     				
		     				JOptionPane.showMessageDialog(null, "No Item with that Record !");
		     			}
						
						
					      
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
					
					
					
					
					
				}
				
				
			}
		});
	
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				t3.removeAllItems();
				t4.removeAllItems();
				t5.removeAllItems();
				t1.setText("");
				combo();
				
			}
	  });
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				
				if(t1.getText() != null &&!t1.getText().trim().isEmpty() && t3.getSelectedItem() != null &&!((String) t3.getSelectedItem()).trim().isEmpty()  ) {
				Double value=Double.parseDouble(t1.getText());
				String s=String.format("%,.2f %s ",value,"Tsh");
				l5.setText(s);
				l7.setText(t3.getSelectedItem().toString());
				
				
				int result = JOptionPane.showConfirmDialog(null, p11, "Deposit",
			            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				
				if(result==JOptionPane.OK_OPTION) {
					
					try {


						String sql="insert into Trans (Fname,Deposit,Withdraw,Comment,Datee,Month,Year) values (?,?,?,?,?,?,?)";
						ps=con.prepareStatement(sql);
						ps.setString(1, t3.getSelectedItem().toString());
						ps.setString(2, t1.getText());
						ps.setString(3, "");
						ps.setString(4, text1.getText());
						ps.setString(5, dt.format(timer.getTime()));
						ps.setString(6, mm.format(timer.getTime()));
						ps.setString(7, yy.format(timer.getTime()));
						ps.execute();
						table();
						JOptionPane.showMessageDialog(b1,"Data Added Successfuly !");
						
					
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
					
					
				}
				
				}
				else{
					JOptionPane.showMessageDialog(null,"Can't Accept Empty Value!");
				}

				
				
			}
	});
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(t1.getText() != null &&!t1.getText().trim().isEmpty() && t3.getSelectedItem() != null &&!((String) t3.getSelectedItem()).trim().isEmpty()  ) {
				Double value=Double.parseDouble(t1.getText());
				String s=String.format("%,.2f %s ",value,"Tsh");
				l10.setText(s);
				l12.setText(t3.getSelectedItem().toString());
				
				try {
					
					String sql1="select sum(Deposit),sum(Withdraw) from Trans where FName= '"+t3.getSelectedItem().toString()+"'";
        			ps=con.prepareStatement(sql1);
        			rs=ps.executeQuery();
        			
        			String depo=rs.getString("sum(Deposit)");Double dep=Double.parseDouble(depo);
        			String witho=rs.getString("sum(Withdraw)");Double with=Double.parseDouble(witho);
        			
        			Double balance=dep-with;
        			Double bala=balance-value;
        			
        			if(bala>=0.0) {
        				
        				
        				
        				int result = JOptionPane.showConfirmDialog(null, p12, "Withdraw",
        			            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        				
        				
        	    if(result==JOptionPane.OK_OPTION) {
        					
        					try {


        						String sql="insert into Trans (Fname,Deposit,Withdraw,Comment,Datee,Month,Year) values (?,?,?,?,?,?,?)";
        						ps=con.prepareStatement(sql);
        						ps.setString(1, t3.getSelectedItem().toString());
        						ps.setString(2, "");
        						ps.setString(3,t1.getText());
        						ps.setString(4, text2.getText());
        						ps.setString(5, dt.format(timer.getTime()));
        						ps.setString(6, mm.format(timer.getTime()));
        						ps.setString(7, yy.format(timer.getTime()));
        						ps.execute();
        						table();
        						JOptionPane.showMessageDialog(b1,"Data Added Successfuly !");
        					
        					}catch(Exception ex) {
        						JOptionPane.showMessageDialog(null, ex.getMessage());
        					}
        					
        					
        				}
        				
        				
        			}else {
        				
        				JOptionPane.showMessageDialog(null, "Insufficient Money !");
        			}
        			
					
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
		
				
				
				}
				else{
					JOptionPane.showMessageDialog(null,"Can't Accept Empty Value!");
				}

				
				
			}
	});
		
		
		
		
	}


	private void combo1() {
    try {
			
			String sql="select type from Pesa";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
			
				t4.addItem(rs.getString("type"));
				t4.setSelectedItem(null);
				box3.addItem(rs.getString("type"));
				box4.addItem(rs.getString("type"));
				box7.addItem(rs.getString("type"));
				box9.addItem(rs.getString("type"));
			//	box3.setSelectedItem(null);
				
			}
			
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		
		
	}

	private void combo() {
		
		try {
			
			String sql="select type from Pesa";
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				
				t3.addItem(rs.getString("type"));
				t3.setSelectedItem(null);
				t5.addItem(rs.getString("type"));
				t5.setSelectedItem(null);
				ta4.addItem(rs.getString("type"));
				ta4.setSelectedItem(null);
				tex2.addItem(rs.getString("type"));
				tex2.setSelectedItem(null);
				
			}
			
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
		
	}

	private void calculator() { 




		JTextArea f=new JTextArea(3,13);f.setFont(new Font("verdana",Font.BOLD,12));
		f.addKeyListener(new KeyAdapter()
		{
		      public void keyTyped(KeyEvent ke)
		{
		    	  char c = ke.getKeyChar();
	                if (!( (c == KeyEvent.VK_PERIOD ) ||  (Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE)|| (c == KeyEvent.VK_DELETE)   )){
	                    getToolkit().beep();
	                    ke.consume();
	                    JOptionPane.showMessageDialog(null,"Enter Numbers Only !");
		    }}});
		JButton h1=new JButton("1");
		JButton h2=new JButton("2");
		JButton h3=new JButton("3");
		JButton h4=new JButton("4");
		JButton h5=new JButton("5");
		JButton h6=new JButton("6");
		JButton h7=new JButton("7");
		JButton h8=new JButton("8");
		JButton h9=new JButton("9");
		JButton h0=new JButton("0");
		JButton hd=new JButton(".");
		JButton hp=new JButton("+");
		JButton hm=new JButton("-");
		JButton hdv=new JButton("/");
		JButton ht=new JButton("*");
		JButton hs=new JButton("=");
		JButton hc=new JButton("C");

		h1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			String v1=f.getText()+h1.getText();
			f.setText(v1);
			}});
		h2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			String v1=f.getText()+h2.getText();
			f.setText(v1);
			}});
		h3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			String v1=f.getText()+h3.getText();
			f.setText(v1);
			}});
		h4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			String v1=f.getText()+h4.getText();
			f.setText(v1);
			}});
		h5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			String v1=f.getText()+h5.getText();
			f.setText(v1);
			}});
		h6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			String v1=f.getText()+h6.getText();
			f.setText(v1);
			}});
		h7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			String v1=f.getText()+h7.getText();
			f.setText(v1);
			}});
		h8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			String v1=f.getText()+h8.getText();
			f.setText(v1);
			}});
		h9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			String v1=f.getText()+h9.getText();
			f.setText(v1);
			}});
		h0.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			String v1=f.getText()+h0.getText();
			f.setText(v1);
			}});
		hd.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			String v1=f.getText()+hd.getText();
			f.setText(v1);
			}});
		hc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			f.setText("");
			}});

		hp.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			n1=Double.parseDouble(f.getText());
			f.setText("");
			operation="+";

			}});

		hm.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			n1=Double.parseDouble(f.getText());
			f.setText("");
			operation="-";

			}});

		ht.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			n1=Double.parseDouble(f.getText());
			f.setText("");
			operation="*";

			}});

		hdv.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			n1=Double.parseDouble(f.getText());
			f.setText("");
			operation="/";

			}});
		hs.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
			n2=Double.parseDouble(f.getText());
			if(operation=="+"){
				ans=n1+n2;
			String res=	String.format("%s", ans);
			f.setText(res);
			}
			else if(operation=="-"){
				ans=n1-n2;
				String res=	String.format("%s", ans);
				f.setText(res);
			}
			else if(operation=="*"){
				ans=n1*n2;
				String res=	String.format("%s", ans);
				f.setText(res);
			}
			else if(operation=="/"){
				ans=n1/n2;
				String res=	String.format("%s", ans);
				f.setText(res);
			}

			}});
		p6.setLayout(new GridBagLayout());
		GridBagConstraints c20=new GridBagConstraints();
		c20.insets=new Insets(3,0,1,0);
		c20.weightx=1;c20.weighty=1;
		c20.fill=GridBagConstraints.BOTH;
		c20.gridwidth=GridBagConstraints.REMAINDER;
		p6.add(f, c20);

		c20.gridwidth=1;
		p6.add(h1,c20);
		c20.gridwidth=1;
		p6.add(h2,c20);
		c20.gridwidth=GridBagConstraints.REMAINDER;
		p6.add(hp,c20);

		c20.gridwidth=1;
		p6.add(h3,c20);
		c20.gridwidth=1;
		p6.add(h4,c20);
		c20.gridwidth=GridBagConstraints.REMAINDER;
		p6.add(hm,c20);

		c20.gridwidth=1;
		p6.add(h5,c20);
		c20.gridwidth=1;
		p6.add(h6,c20);
		c20.gridwidth=GridBagConstraints.REMAINDER;
		p6.add(ht,c20);

		c20.gridwidth=1;
		p6.add(h7,c20);
		c20.gridwidth=1;
		p6.add(h8,c20);
		c20.gridwidth=GridBagConstraints.REMAINDER;
		p6.add(hdv,c20);

		c20.gridwidth=1;
		p6.add(h9,c20);
		c20.gridwidth=1;
		p6.add(h0,c20);
		c20.gridwidth=GridBagConstraints.REMAINDER;
		p6.add(hd,c20);

		c20.gridwidth=1;
		p6.add(hc,c20);
		c20.gridwidth=GridBagConstraints.REMAINDER;
		p6.add(hs,c20);
	
		
	}

	private void bar() {
		
		JMenuBar bar=new JMenuBar();
		setJMenuBar(bar);
		
		JMenu file=new JMenu("File");
		bar.add(file);
		
		JMenu cr=new JMenu("Report");
		bar.add(cr);
		JMenuItem dr=new JMenuItem("Daily Report");
		cr.add(dr);
		JMenuItem mr=new JMenuItem("Monthly Report");
		cr.add(mr);
		JMenuItem yr=new JMenuItem("Yearly Report");
		cr.add(yr);
		JMenuItem ar=new JMenuItem("All Time Report");
		cr.add(ar);
		
		
		JMenu set=new JMenu("Setting");
		bar.add(set);
		JMenuItem add=new JMenuItem("Add Category");
		set.add(add);
		
		JMenuItem del=new JMenuItem("Delete Category");
		set.add(del);
		
		ar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int result = JOptionPane.showConfirmDialog(null, p28, "All Time Statement",
			            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);


				if(result==JOptionPane.OK_OPTION) {
					
					 String cat=box9.getSelectedItem().toString();
					
					try {
						
						String count="select count(Fname) from Trans  where Fname='"+cat+"'   ";
		     			ps=con.prepareStatement(count);
		     			ResultSet rss=ps.executeQuery();
		     			
		     			int nam=Integer.parseInt(rss.getString("count(Fname)"));
		     			if(nam !=0) {
		     				
		     				
		     				String sql1="select sum(Deposit),sum(Withdraw) from Trans  where Fname='"+cat+"' ";
				        	 ps=con.prepareStatement(sql1);
				        	 rs=ps.executeQuery();
				        	 
				        	 String dp=rs.getString("sum(Deposit)");
				        	 Double vd=Double.parseDouble(dp);
						     String sd=String.format("%,.2f",vd);
						     
						     
		                    String wp=rs.getString("sum(Withdraw)");
				        	 Double wd=Double.parseDouble(wp);
						     String sw=String.format("%,.2f",wd);
						     
						     Double bal=vd-wd;
						     String bala=String.format("%,.2f",bal);
						     
						     String sql2="select sum(Deposit),sum(Withdraw) from Trans  where Fname='"+cat+"'";
				        	 ps=con.prepareStatement(sql2);
				        	 rs=ps.executeQuery();
				        	 
				        	 String dt=rs.getString("sum(Deposit)");
				        	 Double bd=Double.parseDouble(dt);
				        	 
				        	 String wt=rs.getString("sum(Withdraw)");
				        	 Double bw=Double.parseDouble(wt);
				        	 
				        	 Double toto=bd-bw;
				        	 String total=String.format("%,.2f",toto);
				        	 
						     
						     PdfPTable mudi2 = new PdfPTable(1);
						     mudi2.setWidthPercentage(100);	
						     PdfPCell cell2=new PdfPCell(new Phrase("BALANCE INFORMATION"));
						     cell2.setColspan(1);
						     cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
						     cell2.setBackgroundColor(new BaseColor(255,250,205));
						     mudi2.addCell(cell2);
						  
						     cell2 = new PdfPCell(new Phrase("All Time Balance :  "+bala ,FontFactory.getFont("verdana", 12, Font.BOLD, BaseColor.BLACK)));
							 cell2.setColspan(6);
							 cell2.setBorder(0);
							// cell2.setHorizontalAlignment(1);
							 mudi2.addCell(cell2);
							 
							 cell2 = new PdfPCell(new Phrase("Total Net Balance : "+total ,FontFactory.getFont("verdana", 12, Font.BOLD, BaseColor.BLACK)));
							 cell2.setColspan(6);
							 cell2.setBorder(0);
							// cell2.setHorizontalAlignment(1);
							 mudi2.addCell(cell2);
								  
							PdfPTable mudi1 = new PdfPTable(36);
							 mudi1.setWidthPercentage(100);	
						     PdfPCell cell1=new PdfPCell(new Phrase(""));
						     cell1.setColspan(36);
						     mudi1.setWidths(new int[]{ 1, 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
						     cell1.setBorder(0);
						     cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
						     cell1.setBackgroundColor(new BaseColor(255,250,205));
						     mudi1.addCell(cell1);
						     
						     cell1 = new PdfPCell(new Phrase("",FontFactory.getFont("verdana", 11, Font.PLAIN, BaseColor.BLACK)));
							 cell1.setColspan(6);
							 cell1.setBorder(0);
							// cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
						     
						     cell1 = new PdfPCell(new Phrase("Total " ,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
							 cell1.setColspan(6);
							 cell1.setBorder(0);
							 cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							
							 cell1 = new PdfPCell(new Phrase(""+sd,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
							 cell1.setColspan(8);
							 cell1.setBorder(0);
							 cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							 cell1 = new PdfPCell(new Phrase(""+sw,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
							 cell1.setColspan(8);
							 cell1.setBorder(0);
							 cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							 cell1 = new PdfPCell(new Phrase("",FontFactory.getFont("verdana", 11, Font.PLAIN, BaseColor.BLACK)));
							 cell1.setColspan(8);
							 cell1.setBorder(0);
							// cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							 
							 
							 
		      		    	PdfPTable mudi23 = new PdfPTable(1);
						     PdfPCell cell23=new PdfPCell(new Phrase(""));
						     cell23.setColspan(5);
						     
						     mudi23.setWidthPercentage(100);
						     Image im=Image.getInstance("other.png");
		      		    	 cell23.setBorder(0);
		       		    	 mudi23.addCell(cell23);
		      		    	 mudi23.addCell(im);
							
						 PdfPTable mudi = new PdfPTable(36);
					     PdfPCell cell=new PdfPCell(new Phrase(""));
					     cell.setColspan(10);
					     cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					     cell.setBackgroundColor(new BaseColor(240,230,140));
					     mudi.addCell(cell);
					     mudi.setWidths(new int[]{ 1, 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
						    mudi.setWidthPercentage(100);					    
						    cell.setColspan(36);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    cell = new PdfPCell(new Phrase("DATE",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(6);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    cell = new PdfPCell(new Phrase("CATEGORY",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(6);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    
						    cell = new PdfPCell(new Phrase("DEPOSIT",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(8);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						   

						    cell = new PdfPCell(new Phrase("WITHDRAW",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(8);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    

						    cell = new PdfPCell(new Phrase("DESCRIPTION",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(8);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    String sql="select * from Trans where Fname='"+cat+"'  ";
						    ps=con.prepareStatement(sql);
						    rs=ps.executeQuery();
						    
						    while(rs.next()) {
						    	
				    			String date=rs.getString("Datee");
				    			String fund=rs.getString("Fname");
					    		String depo=rs.getString("Deposit");
					    		String with=rs.getString("Withdraw");
					    		String desc=rs.getString("Comment");
					    		String s1="";
					    		String s2="";
					    		
					    		if(!depo.isEmpty()) {
					    			Double value1=Double.parseDouble(depo);
						            s1=String.format("%,.2f",value1);
					    		}else {
					    			s1="";
					    		}
					    		
		                      if(!with.isEmpty()) {
		                    	  Double value2=Double.parseDouble(with);
		  						  s2=String.format("%,.2f",value2);
		  			    		
					    		}else {
					    			s2="";
					    		}
					    		
					    		
								
					    		  cell = new PdfPCell(new Phrase(""+date,FontFactory.getFont("serif", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(6);
								   cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								    cell = new PdfPCell(new Phrase(fund,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(6);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								    cell = new PdfPCell(new Phrase(s1,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(8);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								  
								    cell = new PdfPCell(new Phrase(s2,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(8);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								    cell = new PdfPCell(new Phrase(desc,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(8);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								    
						    }
						    
						   
						    Document document=new Document(PageSize.A4);
				            PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream("Statement.pdf"));
							document.open();
							Image img=Image.getInstance("barcode.png");
							
							document.add(mudi23);
							document.add(new Paragraph("                                              ALL TIME STATEMENT",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,new BaseColor(0,0,150))));
							document.add(new Paragraph("\n"));
							document.add(new Paragraph("ITEM : "+"FEDHA ZA "+cat,FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,new BaseColor(0,0,150))));
							document.add(new Paragraph("FOR : "+" ALL YEARS",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,new BaseColor(0,0,150))));
							document.add(new Paragraph("\n"));
							document.add(mudi);
							//document.add(new Paragraph("\n"));
							document.add(mudi1);
							document.add(new Paragraph("\n"));
							document.add(mudi2);
							document.add(new Paragraph("\n"));
							document.add(img);
							document.add(new Paragraph(""+df.format(timer.getTime())+"::"+dtt.format(timer.getTime() )) );
							document.close();
							
							JOptionPane.showMessageDialog(null, "Loading...Please Wait !");
						      Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"Statement.pdf");
						      
		     				
		     			}else {
		     				
		     				JOptionPane.showMessageDialog(null, "No Item with that Record !");
		     			}
						
						
					      
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
					
					
					
					
					
				}
				
				
				
			}
		});
		
		yr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int result = JOptionPane.showConfirmDialog(null, p27, "Yearly Statement",
			            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

				if(result==JOptionPane.OK_OPTION) {
					
					 String cat=box7.getSelectedItem().toString();
					 String year=box8.getSelectedItem().toString();
					 
						 
					try {
						
						String count="select count(Fname) from Trans  where Year='"+year+"' and Fname='"+cat+"'   ";
		     			ps=con.prepareStatement(count);
		     			ResultSet rss=ps.executeQuery();
		     			
		     			int nam=Integer.parseInt(rss.getString("count(Fname)"));
		     			if(nam !=0) {
		     				
		     				
		     				String sql1="select sum(Deposit),sum(Withdraw) from Trans  where Year='"+year+"' and Fname='"+cat+"' ";
				        	 ps=con.prepareStatement(sql1);
				        	 rs=ps.executeQuery();
				        	 
				        	 String dp=rs.getString("sum(Deposit)");
				        	 Double vd=Double.parseDouble(dp);
						     String sd=String.format("%,.2f",vd);
						     
						     
		                    String wp=rs.getString("sum(Withdraw)");
				        	 Double wd=Double.parseDouble(wp);
						     String sw=String.format("%,.2f",wd);
						     
						     Double bal=vd-wd;
						     String bala=String.format("%,.2f",bal);
						     
						     String sql2="select sum(Deposit),sum(Withdraw) from Trans  where Fname='"+cat+"'";
				        	 ps=con.prepareStatement(sql2);
				        	 rs=ps.executeQuery();
				        	 
				        	 String dt=rs.getString("sum(Deposit)");
				        	 Double bd=Double.parseDouble(dt);
				        	 
				        	 String wt=rs.getString("sum(Withdraw)");
				        	 Double bw=Double.parseDouble(wt);
				        	 
				        	 Double toto=bd-bw;
				        	 String total=String.format("%,.2f",toto);
				        	 
						     
						     PdfPTable mudi2 = new PdfPTable(1);
						     mudi2.setWidthPercentage(100);	
						     PdfPCell cell2=new PdfPCell(new Phrase("BALANCE INFORMATION"));
						     cell2.setColspan(1);
						     cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
						     cell2.setBackgroundColor(new BaseColor(255,250,205));
						     mudi2.addCell(cell2);
						  
						     cell2 = new PdfPCell(new Phrase("Yearly Balance :      "+bala ,FontFactory.getFont("verdana", 12, Font.BOLD, BaseColor.BLACK)));
							 cell2.setColspan(6);
							 cell2.setBorder(0);
							// cell2.setHorizontalAlignment(1);
							 mudi2.addCell(cell2);
							 
							 cell2 = new PdfPCell(new Phrase("Total Net Balance : "+total ,FontFactory.getFont("verdana", 12, Font.BOLD, BaseColor.BLACK)));
							 cell2.setColspan(6);
							 cell2.setBorder(0);
							// cell2.setHorizontalAlignment(1);
							 mudi2.addCell(cell2);
								  
							PdfPTable mudi1 = new PdfPTable(36);
							 mudi1.setWidthPercentage(100);	
						     PdfPCell cell1=new PdfPCell(new Phrase(""));
						     cell1.setColspan(36);
						     mudi1.setWidths(new int[]{ 1, 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
						     cell1.setBorder(0);
						     cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
						     cell1.setBackgroundColor(new BaseColor(255,250,205));
						     mudi1.addCell(cell1);
						     
						     cell1 = new PdfPCell(new Phrase("",FontFactory.getFont("verdana", 11, Font.PLAIN, BaseColor.BLACK)));
							 cell1.setColspan(6);
							 cell1.setBorder(0);
							// cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
						     
						     cell1 = new PdfPCell(new Phrase("Total " ,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
							 cell1.setColspan(6);
							 cell1.setBorder(0);
							 cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							
							 cell1 = new PdfPCell(new Phrase(""+sd,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
							 cell1.setColspan(8);
							 cell1.setBorder(0);
							 cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							 cell1 = new PdfPCell(new Phrase(""+sw,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
							 cell1.setColspan(8);
							 cell1.setBorder(0);
							 cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							 cell1 = new PdfPCell(new Phrase("",FontFactory.getFont("verdana", 11, Font.PLAIN, BaseColor.BLACK)));
							 cell1.setColspan(8);
							 cell1.setBorder(0);
							// cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							 
							 
							 
		      		    	PdfPTable mudi23 = new PdfPTable(1);
						     PdfPCell cell23=new PdfPCell(new Phrase(""));
						     cell23.setColspan(5);
						     
						     mudi23.setWidthPercentage(100);
						     Image im=Image.getInstance("other.png");
		      		    	 cell23.setBorder(0);
		       		    	 mudi23.addCell(cell23);
		      		    	 mudi23.addCell(im);
							
						 PdfPTable mudi = new PdfPTable(36);
					     PdfPCell cell=new PdfPCell(new Phrase(""));
					     cell.setColspan(10);
					     cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					     cell.setBackgroundColor(new BaseColor(240,230,140));
					     mudi.addCell(cell);
					     mudi.setWidths(new int[]{ 1, 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
						    mudi.setWidthPercentage(100);					    
						    cell.setColspan(36);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    cell = new PdfPCell(new Phrase("DATE",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(6);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    cell = new PdfPCell(new Phrase("CATEGORY",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(6);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    
						    cell = new PdfPCell(new Phrase("DEPOSIT",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(8);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						   

						    cell = new PdfPCell(new Phrase("WITHDRAW",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(8);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    

						    cell = new PdfPCell(new Phrase("DESCRIPTION",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(8);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    String sql="select * from Trans where Year='"+year+"' and Fname='"+cat+"'  ";
						    ps=con.prepareStatement(sql);
						    rs=ps.executeQuery();
						    
						    while(rs.next()) {
						    	
				    			String date=rs.getString("Datee");
				    			String fund=rs.getString("Fname");
					    		String depo=rs.getString("Deposit");
					    		String with=rs.getString("Withdraw");
					    		String desc=rs.getString("Comment");
					    		String s1="";
					    		String s2="";
					    		
					    		if(!depo.isEmpty()) {
					    			Double value1=Double.parseDouble(depo);
						            s1=String.format("%,.2f",value1);
					    		}else {
					    			s1="";
					    		}
					    		
		                      if(!with.isEmpty()) {
		                    	  Double value2=Double.parseDouble(with);
		  						  s2=String.format("%,.2f",value2);
		  			    		
					    		}else {
					    			s2="";
					    		}
					    		
					    		
								
					    		  cell = new PdfPCell(new Phrase(""+date,FontFactory.getFont("serif", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(6);
								   cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								    cell = new PdfPCell(new Phrase(fund,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(6);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								    cell = new PdfPCell(new Phrase(s1,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(8);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								  
								    cell = new PdfPCell(new Phrase(s2,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(8);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								    cell = new PdfPCell(new Phrase(desc,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(8);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								    
						    }
						    
						   
						    Document document=new Document(PageSize.A4);
				            PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream("Statement.pdf"));
							document.open();
							Image img=Image.getInstance("barcode.png");
							
							document.add(mudi23);
							document.add(new Paragraph("                                                YEARLY STATEMENT",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,new BaseColor(0,0,150))));
							document.add(new Paragraph("\n"));
							document.add(new Paragraph("ITEM : "+"FEDHA ZA "+cat,FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,new BaseColor(0,0,150))));
							document.add(new Paragraph("FOR : "+year,FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,new BaseColor(0,0,150))));
							document.add(new Paragraph("\n"));
							document.add(mudi);
							//document.add(new Paragraph("\n"));
							document.add(mudi1);
							document.add(new Paragraph("\n"));
							document.add(mudi2);
							document.add(new Paragraph("\n"));
							document.add(img);
							document.add(new Paragraph(""+df.format(timer.getTime())+"::"+dtt.format(timer.getTime() )) );
							document.close();
							
							JOptionPane.showMessageDialog(null, "Loading...Please Wait !");
						      Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"Statement.pdf");
						      
		     				
		     			}else {
		     				
		     				JOptionPane.showMessageDialog(null, "No Item with that Record !");
		     			}
						
						
					      
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
					
					
					
					
					
				}
				
				
			
				
				
			
				
			
				
				
				
			}
		});
		
		mr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int result = JOptionPane.showConfirmDialog(null, p26, "Monthly Statement",
			            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				

				if(result==JOptionPane.OK_OPTION) {
					
					 String cat=box4.getSelectedItem().toString();
					 String month = box5.getSelectedItem().toString();
					 String year=box6.getSelectedItem().toString();
					 
						 
					try {
						
						String count="select count(Fname) from Trans  where Month='"+month+"' and Year='"+year+"' and Fname='"+cat+"'   ";
		     			ps=con.prepareStatement(count);
		     			ResultSet rss=ps.executeQuery();
		     			
		     			int nam=Integer.parseInt(rss.getString("count(Fname)"));
		     			if(nam !=0) {
		     				
		     				
		     				String sql1="select sum(Deposit),sum(Withdraw) from Trans  where Month='"+month+"' and Year='"+year+"' and Fname='"+cat+"' ";
				        	 ps=con.prepareStatement(sql1);
				        	 rs=ps.executeQuery();
				        	 
				        	 String dp=rs.getString("sum(Deposit)");
				        	 Double vd=Double.parseDouble(dp);
						     String sd=String.format("%,.2f",vd);
						     
						     
		                    String wp=rs.getString("sum(Withdraw)");
				        	 Double wd=Double.parseDouble(wp);
						     String sw=String.format("%,.2f",wd);
						     
						     Double bal=vd-wd;
						     String bala=String.format("%,.2f",bal);
						     
						     String sql2="select sum(Deposit),sum(Withdraw) from Trans  where Fname='"+cat+"'";
				        	 ps=con.prepareStatement(sql2);
				        	 rs=ps.executeQuery();
				        	 
				        	 String dt=rs.getString("sum(Deposit)");
				        	 Double bd=Double.parseDouble(dt);
				        	 
				        	 String wt=rs.getString("sum(Withdraw)");
				        	 Double bw=Double.parseDouble(wt);
				        	 
				        	 Double toto=bd-bw;
				        	 String total=String.format("%,.2f",toto);
				        	 
						     
						     PdfPTable mudi2 = new PdfPTable(1);
						     mudi2.setWidthPercentage(100);	
						     PdfPCell cell2=new PdfPCell(new Phrase("BALANCE INFORMATION"));
						     cell2.setColspan(1);
						     cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
						     cell2.setBackgroundColor(new BaseColor(255,250,205));
						     mudi2.addCell(cell2);
						  
						     cell2 = new PdfPCell(new Phrase("Monthly Balance :   "+bala ,FontFactory.getFont("verdana", 12, Font.BOLD, BaseColor.BLACK)));
							 cell2.setColspan(6);
							 cell2.setBorder(0);
							// cell2.setHorizontalAlignment(1);
							 mudi2.addCell(cell2);
							 
							 cell2 = new PdfPCell(new Phrase("Total Net Balance : "+total ,FontFactory.getFont("verdana", 12, Font.BOLD, BaseColor.BLACK)));
							 cell2.setColspan(6);
							 cell2.setBorder(0);
							// cell2.setHorizontalAlignment(1);
							 mudi2.addCell(cell2);
								  
							PdfPTable mudi1 = new PdfPTable(36);
							 mudi1.setWidthPercentage(100);	
						     PdfPCell cell1=new PdfPCell(new Phrase(""));
						     cell1.setColspan(36);
						     mudi1.setWidths(new int[]{ 1, 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
						     cell1.setBorder(0);
						     cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
						     cell1.setBackgroundColor(new BaseColor(255,250,205));
						     mudi1.addCell(cell1);
						     
						     cell1 = new PdfPCell(new Phrase("",FontFactory.getFont("verdana", 11, Font.PLAIN, BaseColor.BLACK)));
							 cell1.setColspan(6);
							 cell1.setBorder(0);
							// cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
						     
						     cell1 = new PdfPCell(new Phrase("Total " ,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
							 cell1.setColspan(6);
							 cell1.setBorder(0);
							 cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							
							 cell1 = new PdfPCell(new Phrase(""+sd,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
							 cell1.setColspan(8);
							 cell1.setBorder(0);
							 cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							 cell1 = new PdfPCell(new Phrase(""+sw,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
							 cell1.setColspan(8);
							 cell1.setBorder(0);
							 cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							 cell1 = new PdfPCell(new Phrase("",FontFactory.getFont("verdana", 11, Font.PLAIN, BaseColor.BLACK)));
							 cell1.setColspan(8);
							 cell1.setBorder(0);
							// cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							 
							 
							 
		      		    	PdfPTable mudi23 = new PdfPTable(1);
						     PdfPCell cell23=new PdfPCell(new Phrase(""));
						     cell23.setColspan(5);
						     
						     mudi23.setWidthPercentage(100);
						     Image im=Image.getInstance("other.png");
		      		    	 cell23.setBorder(0);
		       		    	 mudi23.addCell(cell23);
		      		    	 mudi23.addCell(im);
							
						 PdfPTable mudi = new PdfPTable(36);
					     PdfPCell cell=new PdfPCell(new Phrase(""));
					     cell.setColspan(10);
					     cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					     cell.setBackgroundColor(new BaseColor(240,230,140));
					     mudi.addCell(cell);
					     mudi.setWidths(new int[]{ 1, 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
						    mudi.setWidthPercentage(100);					    
						    cell.setColspan(36);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    cell = new PdfPCell(new Phrase("DATE",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(6);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    cell = new PdfPCell(new Phrase("CATEGORY",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(6);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    
						    cell = new PdfPCell(new Phrase("DEPOSIT",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(8);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						   

						    cell = new PdfPCell(new Phrase("WITHDRAW",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(8);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    

						    cell = new PdfPCell(new Phrase("DESCRIPTION",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(8);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    String sql="select * from Trans where Month='"+month+"' and Year='"+year+"' and Fname='"+cat+"'  ";
						    ps=con.prepareStatement(sql);
						    rs=ps.executeQuery();
						    
						    while(rs.next()) {
						    	
				    			String date=rs.getString("Datee");
				    			String fund=rs.getString("Fname");
					    		String depo=rs.getString("Deposit");
					    		String with=rs.getString("Withdraw");
					    		String desc=rs.getString("Comment");
					    		String s1="";
					    		String s2="";
					    		
					    		if(!depo.isEmpty()) {
					    			Double value1=Double.parseDouble(depo);
						            s1=String.format("%,.2f",value1);
					    		}else {
					    			s1="";
					    		}
					    		
		                      if(!with.isEmpty()) {
		                    	  Double value2=Double.parseDouble(with);
		  						  s2=String.format("%,.2f",value2);
		  			    		
					    		}else {
					    			s2="";
					    		}
					    		
					    		
								
					    		  cell = new PdfPCell(new Phrase(""+date,FontFactory.getFont("serif", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(6);
								   cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								    cell = new PdfPCell(new Phrase(fund,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(6);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								    cell = new PdfPCell(new Phrase(s1,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(8);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								  
								    cell = new PdfPCell(new Phrase(s2,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(8);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								    cell = new PdfPCell(new Phrase(desc,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(8);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								    
						    }
						    
						   
						    Document document=new Document(PageSize.A4);
				            PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream("Statement.pdf"));
							document.open();
							Image img=Image.getInstance("barcode.png");
							
							document.add(mudi23);
							document.add(new Paragraph("                                              MONTHLY STATEMENT",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,new BaseColor(0,0,150))));
							document.add(new Paragraph("\n"));
							document.add(new Paragraph("ITEM : "+"FEDHA ZA "+cat,FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,new BaseColor(0,0,150))));
							document.add(new Paragraph("FOR : "+month+" , "+year,FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,new BaseColor(0,0,150))));
							document.add(new Paragraph("\n"));
							document.add(mudi);
							//document.add(new Paragraph("\n"));
							document.add(mudi1);
							document.add(new Paragraph("\n"));
							document.add(mudi2);
							document.add(new Paragraph("\n"));
							document.add(img);
							document.add(new Paragraph(""+df.format(timer.getTime())+"::"+dtt.format(timer.getTime() )) );
							document.close();
							
							JOptionPane.showMessageDialog(null, "Loading...Please Wait !");
						      Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"Statement.pdf");
						      
		     				
		     			}else {
		     				
		     				JOptionPane.showMessageDialog(null, "No Item with that Record !");
		     			}
						
						
					      
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
					
					
					
					
					
				}
				
				
			
				
				
			
				
			}
    	});
		
		
		dr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int result = JOptionPane.showConfirmDialog(null, p25, "Daily Statement",
			            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			
				
				if(result==JOptionPane.OK_OPTION) {
					 String godt = dt .format(dd.getDate());
					 String cat=box3.getSelectedItem().toString();
					 
						 
					try {
						
						String count="select count(Fname) from Trans  where Datee='"+godt+"' and Fname='"+cat+"'   ";
		     			ps=con.prepareStatement(count);
		     			ResultSet rss=ps.executeQuery();
		     			
		     			int nam=Integer.parseInt(rss.getString("count(Fname)"));
		     			if(nam !=0) {
		     				
		     				
		     				String sql1="select sum(Deposit),sum(Withdraw) from Trans  where Datee= '"+godt+"'  and Fname='"+cat+"'";
				        	 ps=con.prepareStatement(sql1);
				        	 rs=ps.executeQuery();
				        	 
				        	 String dp=rs.getString("sum(Deposit)");
				        	 Double vd=Double.parseDouble(dp);
						     String sd=String.format("%,.2f",vd);
						     
						     
		                    String wp=rs.getString("sum(Withdraw)");
				        	 Double wd=Double.parseDouble(wp);
						     String sw=String.format("%,.2f",wd);
						     
						     Double bal=vd-wd;
						     String bala=String.format("%,.2f",bal);
						     
						     String sql2="select sum(Deposit),sum(Withdraw) from Trans  where Fname='"+cat+"'";
				        	 ps=con.prepareStatement(sql2);
				        	 rs=ps.executeQuery();
				        	 
				        	 String dt=rs.getString("sum(Deposit)");
				        	 Double bd=Double.parseDouble(dt);
				        	 
				        	 String wt=rs.getString("sum(Withdraw)");
				        	 Double bw=Double.parseDouble(wt);
				        	 
				        	 Double toto=bd-bw;
				        	 String total=String.format("%,.2f",toto);
				        	 
						     
						     PdfPTable mudi2 = new PdfPTable(1);
						     mudi2.setWidthPercentage(100);	
						     PdfPCell cell2=new PdfPCell(new Phrase("BALANCE INFORMATION"));
						     cell2.setColspan(1);
						     cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
						     cell2.setBackgroundColor(new BaseColor(255,250,205));
						     mudi2.addCell(cell2);
						  
						     cell2 = new PdfPCell(new Phrase("Daily Balance :        "+bala ,FontFactory.getFont("verdana", 12, Font.BOLD, BaseColor.BLACK)));
							 cell2.setColspan(6);
							 cell2.setBorder(0);
							// cell2.setHorizontalAlignment(1);
							 mudi2.addCell(cell2);
							 
							 cell2 = new PdfPCell(new Phrase("Total Net Balance : "+total ,FontFactory.getFont("verdana", 12, Font.BOLD, BaseColor.BLACK)));
							 cell2.setColspan(6);
							 cell2.setBorder(0);
							// cell2.setHorizontalAlignment(1);
							 mudi2.addCell(cell2);
								  
							PdfPTable mudi1 = new PdfPTable(36);
							 mudi1.setWidthPercentage(100);	
						     PdfPCell cell1=new PdfPCell(new Phrase(""));
						     cell1.setColspan(36);
						     mudi1.setWidths(new int[]{ 1, 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
						     cell1.setBorder(0);
						     cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
						     cell1.setBackgroundColor(new BaseColor(255,250,205));
						     mudi1.addCell(cell1);
						     
						     cell1 = new PdfPCell(new Phrase("",FontFactory.getFont("verdana", 11, Font.PLAIN, BaseColor.BLACK)));
							 cell1.setColspan(6);
							 cell1.setBorder(0);
							// cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
						     
						     cell1 = new PdfPCell(new Phrase("Total " ,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
							 cell1.setColspan(6);
							 cell1.setBorder(0);
							 cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							
							 cell1 = new PdfPCell(new Phrase(""+sd,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
							 cell1.setColspan(8);
							 cell1.setBorder(0);
							 cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							 cell1 = new PdfPCell(new Phrase(""+sw,FontFactory.getFont("verdana", 11, Font.BOLD, BaseColor.BLACK)));
							 cell1.setColspan(8);
							 cell1.setBorder(0);
							 cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							 cell1 = new PdfPCell(new Phrase("",FontFactory.getFont("verdana", 11, Font.PLAIN, BaseColor.BLACK)));
							 cell1.setColspan(8);
							 cell1.setBorder(0);
							// cell1.setHorizontalAlignment(1);
							 mudi1.addCell(cell1);
							 
							 
							 
							 
		      		    	PdfPTable mudi23 = new PdfPTable(1);
						     PdfPCell cell23=new PdfPCell(new Phrase(""));
						     cell23.setColspan(5);
						     
						     mudi23.setWidthPercentage(100);
						     Image im=Image.getInstance("other.png");
		      		    	 cell23.setBorder(0);
		       		    	 mudi23.addCell(cell23);
		      		    	 mudi23.addCell(im);
							
						 PdfPTable mudi = new PdfPTable(36);
					     PdfPCell cell=new PdfPCell(new Phrase(""));
					     cell.setColspan(10);
					     cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					     cell.setBackgroundColor(new BaseColor(240,230,140));
					     mudi.addCell(cell);
					     mudi.setWidths(new int[]{ 1, 1, 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1});
						    mudi.setWidthPercentage(100);					    
						    cell.setColspan(36);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    cell = new PdfPCell(new Phrase("DATE",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(6);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    cell = new PdfPCell(new Phrase("CATEGORY",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(6);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    
						    cell = new PdfPCell(new Phrase("DEPOSIT",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(8);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						   

						    cell = new PdfPCell(new Phrase("WITHDRAW",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(8);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    

						    cell = new PdfPCell(new Phrase("DESCRIPTION",FontFactory.getFont("verdana", 14, Font.BOLD, BaseColor.BLACK)));
						    cell.setColspan(8);
						    cell.setHorizontalAlignment(1);
						    mudi.addCell(cell);
						    
						    String sql="select * from Trans where Datee= '"+godt+"' and Fname='"+cat+"' ";
						    ps=con.prepareStatement(sql);
						    rs=ps.executeQuery();
						    
						    while(rs.next()) {
						    	
				    			String date=rs.getString("Datee");
				    			String fund=rs.getString("Fname");
					    		String depo=rs.getString("Deposit");
					    		String with=rs.getString("Withdraw");
					    		String desc=rs.getString("Comment");
					    		String s1="";
					    		String s2="";
					    		
					    		if(!depo.isEmpty()) {
					    			Double value1=Double.parseDouble(depo);
						            s1=String.format("%,.2f",value1);
					    		}else {
					    			s1="";
					    		}
					    		
		                      if(!with.isEmpty()) {
		                    	  Double value2=Double.parseDouble(with);
		  						  s2=String.format("%,.2f",value2);
		  			    		
					    		}else {
					    			s2="";
					    		}
					    		
					    		
								
					    		  cell = new PdfPCell(new Phrase(""+date,FontFactory.getFont("serif", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(6);
								   cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								    cell = new PdfPCell(new Phrase(fund,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(6);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								    cell = new PdfPCell(new Phrase(s1,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(8);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								  
								    cell = new PdfPCell(new Phrase(s2,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(8);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								    cell = new PdfPCell(new Phrase(desc,FontFactory.getFont("Arial", 10, Font.PLAIN, BaseColor.BLACK)));
								    cell.setColspan(8);
								    cell.setHorizontalAlignment(1);
								    mudi.addCell(cell);
								    
								    
						    }
						    
						   
						    Document document=new Document(PageSize.A4);
				            PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream("Statement.pdf"));
							document.open();
							Image img=Image.getInstance("barcode.png");
							
							document.add(mudi23);
							document.add(new Paragraph("                                                  DAILY STATEMENT",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,new BaseColor(0,0,150))));
							document.add(new Paragraph("\n"));
							document.add(new Paragraph("ITEM : "+"FEDHA ZA "+cat,FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,new BaseColor(0,0,150))));
							document.add(new Paragraph("FOR : "+godt,FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD,new BaseColor(0,0,150))));
							document.add(new Paragraph("\n"));
							document.add(mudi);
							//document.add(new Paragraph("\n"));
							document.add(mudi1);
							document.add(new Paragraph("\n"));
							document.add(mudi2);
							document.add(new Paragraph("\n"));
							document.add(img);
							document.add(new Paragraph(""+df.format(timer.getTime())+"::"+dtt.format(timer.getTime() )) );
							document.close();
							
							JOptionPane.showMessageDialog(null, "Loading...Please Wait !");
						      Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler "+"Statement.pdf");
						      
		     				
		     			}else {
		     				
		     				JOptionPane.showMessageDialog(null, "No Item with that Record !");
		     			}
						
						
					      
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
					
					
					
					
					
				}
				
				
			
				
				
			}
	});
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				int result = JOptionPane.showConfirmDialog(null, p8, "Add Category",
			            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				
				if(result==JOptionPane.OK_OPTION ) {
					
					String name=t2.getText().toUpperCase();
					
					try {
						
					
					
				if(name != null &&!name.trim().isEmpty() ) {
					if(name.matches("^[\\p{L} .'-]+$") ) {
						
						
						try {
							
							      String sql2 ="select count(type) from Pesa where type = '"+name+"'  ";
						    	  ps=con.prepareStatement(sql2);
						    	  rs=ps.executeQuery();
						    	 int count=Integer.parseInt(rs.getString("count(type)"));
						    	 
								if(count<=0) {
									
									
									String sql="Insert into Pesa(type) values (?)";
									ps=con.prepareStatement(sql);
									ps.setString(1, name.toUpperCase());
									ps.execute();
									t3.removeAllItems();
									t4.removeAllItems();
									t5.removeAllItems();
									box3.removeAllItems();
									box4.removeAllItems();
									box7.removeAllItems();
									box9.removeAllItems();
									tex2.removeAllItems();
									ta4.removeAllItems();
									
									
									combo();
									combo1();
									JOptionPane.showMessageDialog(null, "Category Added Successfuly !");
									
									
									
									
								}else {
									JOptionPane.showMessageDialog(null, "Category Already Exist !");
								}
							
							
							
						} catch (Exception e) {
							
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
						
					}else {
						
						JOptionPane.showMessageDialog(null, "Enter Valid Name !");
					}
					
					
				}else {
					
					JOptionPane.showMessageDialog(null, "Cant't Accept Empty Value !");
				}
				
				
				
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}
				
				}		
			}
			});
		
		
		del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
                 //  combo1();
				int result = JOptionPane.showConfirmDialog(null, p9, "Delete Category",
			            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				
				if(result==JOptionPane.OK_OPTION ) {
					try {
						String name=t4.getSelectedItem().toString();
						String sql="Delete  from Pesa where type='"+name+"' ";
						ps=con.prepareStatement(sql);
						ps.execute();
					   t3.removeAllItems();
					   t4.removeAllItems();
					   t5.removeAllItems();
					   box3.removeAllItems();
					   box4.removeAllItems();
					   box7.removeAllItems();
					   box9.removeAllItems();
					 
						combo();
						combo1();
						JOptionPane.showMessageDialog(null, "Category Deleted Successfuly !");
						
						
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "Can't Accept Empty Value !");
					}
					
					
				}
				
			}
			});
		
		
	}

}
