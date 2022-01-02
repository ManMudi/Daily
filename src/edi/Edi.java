 package edi;

import java.awt.Color;

import javax.swing.JFrame;



public class Edi {
   
	
	public 
	static void main(String[] args) {
		
		   
			
			try {
				
				
				Login l=new Login();
				l.setSize(620,330);
			  //  l.setVisible(true);
				l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
				l.setResizable(false);
				l.setLocation(350,200); 
				
				 
				    Mudi m=new Mudi();
			        m.setVisible(true);
					m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					m.setSize(1365,775);
					m.setResizable(false);
					

					
					
			}catch(Exception ex) {
				
			}
			
		
	}

}
