import java.awt.event.*;  
import javax.swing.*; 
import java.awt.Color;
import java.util.*;
public class Array {
	ArrayList<Integer> ar = new ArrayList<Integer>();
	int newElement;
Array() 
	{
	JFrame f=new JFrame("Arrays");  
    final JTextField tf=new JTextField("Enter the array Here");  
    tf.setBounds(50,50, 150,20);
 
    final JTextField tf2=new JTextField("New Element");  
    tf2.setBounds(250,50, 100,20); 
 
    final JTextField tf3=new JTextField("Position ");  
    tf3.setBounds(400,50, 100,20); 
    
    JButton b=new JButton("Insert new Element");  
    b.setBounds(100,100,100,30);
    b.setBackground(Color.GREEN);
    b.setForeground(Color.BLACK);
   
    JButton b1=new JButton("Delete an Element");  
    b1.setBounds(210,100,100,30);
    b1.setBackground(Color.GREEN);
    b1.setForeground(Color.BLACK);
    
    JButton b2=new JButton("Show Elements");  
    b2.setBounds(320,100,100,30);
    b2.setBackground(Color.GREEN);
    b2.setForeground(Color.BLACK);
    
    JButton b3=new JButton("Bubble Sort");  
    b3.setBounds(430,100,100,30);
    
    JButton b4=new JButton("Selection Sort");  
    b4.setBounds(540,100,100,30);
    
    JButton b5=new JButton("Insertion Sort");  
    b5.setBounds(650,100,100,30);
    
    JTextArea l = new JTextArea();
    l.setBounds(300,300,300,20);
    l.setBackground(Color.lightGray);
    l.setForeground(Color.BLACK);
    
    b.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){  
		String data = tf.getText();
		String[] arOfStr	= data.split(" ");
			
		 for (String a : arOfStr) 
	            ar.add(Integer.parseInt(a));
		 int index = Integer.parseInt(tf3.getText());
		 int ele = Integer.parseInt(tf2.getText());
		 ar.add(index,ele);
		 
        }  
    });  
    
    b2.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){  
    	/* String data = tf.getText();
		 String[] arOfStr	= data.split(" ");
			
		 for (String a : arOfStr) 
	            ar.add(Integer.parseInt(a)); */
    	String[] str = new String[ar.size()];
    	for (int j = 0; j < ar.size(); j++) 
    	{ 
    		   str[j] =Integer.toString(ar.get(j)); 
        } 
    	for (int i = 0; i < ar.size(); i++) {
			System.out.println(ar.get(i));
		}
    	  l.setText("");
    	  
		  l.setText("The Array elements are " + Arrays.toString(str));
                 }  
    }); 
    
    
    f.add(b);
    f.add(b1);
    f.add(b2);
    f.add(b3);
    f.add(b4);
    f.add(b5);
    f.add(tf); 
    f.add(tf2);
    f.add(tf3);
    tf2.setVisible(true); 
    tf3.setVisible(true); 
    f.add(l); 
    l.setVisible(true);
    f.setSize(1000,1000);  
    f.setLayout(null);  
    f.setVisible(true);
    
	}
public static void main(String args[])
{
Array arrObj = new Array();	
}

}