package edi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.Border;


public class Login extends JFrame {
	
	    private static final long serialVersionUID = 1L;
	    private JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10;
        private Connection con;
        private PreparedStatement ps;
	    private ResultSet rs;
	    private static JLabel date;
		private static JLabel empty;
		private static JLabel time;
		private static JLabel kappa;
		private static JLabel hash;

	   public Login(){
		   

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
			 
			    JLabel n=new JLabel("DAILY SCHOOL TRANSACTION  SYSTEM");n.setFont(new Font("Segoe UI",+Font.BOLD,28));
				n.setForeground(new Color(128,128,0));
				
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
				
				
				setLayout(new BorderLayout());
				add(p1);
				
				p1.setLayout(new BorderLayout());p2.add(n);
				p1.add(p2,BorderLayout.NORTH);//p2.setBackground(Color.red);
				p1.add(p3,BorderLayout.CENTER);p3.setBackground(Color.white);
				
				p3.setLayout(new BorderLayout());
				p3.add(p4,BorderLayout.WEST);
				p3.add(p5,BorderLayout.CENTER);
				
				p5.setLayout(new BorderLayout());
				p5.add(p6,BorderLayout.NORTH);
				p5.add(p7,BorderLayout.CENTER);
				
				JLabel n1=new JLabel("ADMINISTRATOR LOGIN FORM");n1.setFont(new Font("Segoe Script",Font.BOLD,18));
				n1.setForeground(new Color(0,0,0));
				p6.add(n1);	
				
				Icon ok=new ImageIcon(this.getClass().getResource("/ok.png"));
				Icon log2=new ImageIcon(this.getClass().getResource("/log1.png"));
				JLabel ll2=new JLabel();ll2.setIcon(log2);
				p4.add(ll2);
				
				p7.setLayout(new GridBagLayout());
				JLabel l1=new JLabel("User Name");l1.setFont(new Font("Courier",Font.BOLD,17));l1.setForeground(new Color(0,0,0));
				JTextField t1=new JTextField(10);t1.setToolTipText("Enter User Name");
				
				JLabel l2=new JLabel("Password");l2.setFont(new Font("Courier",Font.BOLD,17));l2.setForeground(new Color(0,0,0));
				JPasswordField t2=new JPasswordField(10);t2.setToolTipText("Enter Password");
				
				JButton b=new JButton("Login");b.setIcon(ok);
				
				Border p7in=BorderFactory.createEmptyBorder(5,5,5,5);
				Border p7ou=BorderFactory.createTitledBorder("");
				p7.setBorder(BorderFactory.createCompoundBorder(p7in, p7ou));

				GridBagConstraints c12=new GridBagConstraints();
				c12.fill=GridBagConstraints.HORIZONTAL;
				c12.weightx=1;c12.weighty=0.2;
				c12.insets=new Insets(30,30,0,10);
				c12.gridx=1;c12.gridy=1;
				p7.add(l1, c12);
				c12.gridx=2;c12.gridy=1;
				p7.add(t1, c12);
				
				c12.insets=new Insets(0,30,0,10);
				c12.gridx=1;c12.gridy=2;
				p7.add(l2, c12);
				c12.gridx=2;c12.gridy=2;
				p7.add(t2, c12);
				
				c12.insets=new Insets(0,30,10,10);
				c12.gridx=2;c12.gridy=3;
				p7.add(b, c12);
				
				
				
				
				b.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ev) {
							
							String user=t1.getText();	
							@SuppressWarnings("deprecation")
							String pass=t2.getText();
							String sql="select username,password from account";
							
							try {
								
								String p1=t1.getText();	
								@SuppressWarnings("deprecation")
								String p2=t2.getText();
								
						    	     String sql2 ="select count(username) from account where password = '"+p2+"' and username='"+p1+"'  ";
							    	 ps=con.prepareStatement(sql2);
							    	 rs=ps.executeQuery();
							    	 int count=Integer.parseInt(rs.getString("count(username)"));
							    	 
							    	 
									if(count>0 )
									{
										
										dispose();
										Mudi m=new Mudi();
										m.setSize(1366,800);
										m.setVisible(true);
										m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
										m.setResizable(false);
									//	m.setIconImage(Toolkit.getDefaultToolkit().getImage(m.getClass().getResource("/lo.png")));
										
									}
									else{
										JOptionPane.showMessageDialog(null, "Incorrect Username or Password.!   Try Again.....");
										t1.setText("");
									  t2.setText("");
									
									}
						    	  
						    	
						    	
							} catch (Exception e) {
						      JOptionPane.showMessageDialog(null, e.getStackTrace());
							} finally{
					            try{
					                rs.close();
					                ps.close();
					            }catch(Exception ex){
					                ex.getMessage();
					            }}
						}
					});
				
				
				t2.addKeyListener(new KeyAdapter(){
					@SuppressWarnings("static-access")
					public void keyReleased(KeyEvent e)	{
						
						if(e.getKeyCode()==e.VK_ENTER){
							
							
							try {
								
								String p1=t1.getText();	
								@SuppressWarnings("deprecation")
								String p2=t2.getText();
								
						    	     String sql2 ="select count(username) from account where password = '"+p2+"' and username='"+p1+"'  ";
							    	 PreparedStatement ps=con.prepareStatement(sql2);
							    	  rs=ps.executeQuery();
							    	 int count=Integer.parseInt(rs.getString("count(username)"));
							    	 
							    	 
									if(count>0 )
									{
										
										dispose();
										  Mudi pri=new Mudi();
									      pri.setVisible(true);
											pri.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
											pri.setSize(1365,775);
											pri.setResizable(false);
										//	pri.setIconImage(Toolkit.getDefaultToolkit().getImage(pri.getClass().getResource("/lo.png")));
												
									}
									else{
										JOptionPane.showMessageDialog(null, "Incorrect Username or Password.!   Try Again.....");
										t1.setText("");
									  t2.setText("");
									
									}
						    	  
						    	
						    	
							} catch (SQLException ez) {
								System.out.print(ez.getMessage());
							}  finally{
					            try{
					                rs.close();
					                ps.close();
					            }catch(Exception ex){
					                ex.getMessage();
					            }}
						}
						
					}});
			 
	   }

	private void bar() {
		
		
	}

	}
	