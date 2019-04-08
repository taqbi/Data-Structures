import java.awt.EventQueue;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class SparseMatrix {
	ArrayList<Integer> row1 = new ArrayList<Integer>();
	ArrayList<Integer> col1 = new ArrayList<Integer>();
	ArrayList<Integer> data1 = new ArrayList<Integer>();
	ArrayList<Integer> row2 = new ArrayList<Integer>();
	ArrayList<Integer> col2 = new ArrayList<Integer>();
	ArrayList<Integer> data2 = new ArrayList<Integer>();
	ArrayList<Integer> row3 = new ArrayList<Integer>();
	ArrayList<Integer> col3 = new ArrayList<Integer>();
	ArrayList<Integer> data3 = new ArrayList<Integer>();

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	JTextArea textArea = new JTextArea();
	JTextArea textArea_1 = new JTextArea();
	JTextArea textArea_2 = new JTextArea();
	JRadioButton rdbtnNewRadioButton = new JRadioButton("Index Method");
	JRadioButton rdbtnIrregularSparseMatrix = new JRadioButton("Compressed Row Format");
	JLabel label_1 = new JLabel("");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SparseMatrix window = new SparseMatrix();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SparseMatrix() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
	
		
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(175, 238, 238));
		frame.getContentPane().setForeground(new Color(135, 206, 235));
		frame.setBounds(100, 100, 741, 510);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		textArea.setBounds(10, 54, 226, 201);
		frame.getContentPane().add(textArea);
		
		
		
		
		textArea_1.setBounds(489, 54, 226, 201);
		frame.getContentPane().add(textArea_1);
		
		JLabel lblInputMatrix = new JLabel("Input Matrix 1: ");
		lblInputMatrix.setForeground(new Color(0, 139, 139));
		lblInputMatrix.setFont(new Font("Century", Font.BOLD, 11));
		lblInputMatrix.setBounds(24, 11, 198, 14);
		frame.getContentPane().add(lblInputMatrix);
		
		JLabel lblOutputMatrix = new JLabel("Output Matrix:");
		lblOutputMatrix.setForeground(new Color(0, 139, 139));
		lblOutputMatrix.setFont(new Font("Century", Font.BOLD, 11));
		lblOutputMatrix.setBounds(489, 11, 182, 14);
		frame.getContentPane().add(lblOutputMatrix);
		
		
		textArea_2.setBounds(253, 54, 226, 201);
		frame.getContentPane().add(textArea_2);
		
		JLabel lblInputMatrix_1 = new JLabel("Input Matrix 2:");
		lblInputMatrix_1.setForeground(new Color(0, 128, 128));
		lblInputMatrix_1.setFont(new Font("Century", Font.BOLD, 11));
		lblInputMatrix_1.setBounds(253, 11, 154, 14);
		frame.getContentPane().add(lblInputMatrix_1);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnNewRadioButton.isSelected())
				{
					addIndex();
				}
				
			}
		});
		btnAdd.setBounds(253, 257, 120, 23);
		frame.getContentPane().add(btnAdd);
		
		JButton btnMultiply = new JButton("Multiply");
		btnMultiply.setBounds(253, 291, 120, 23);
		frame.getContentPane().add(btnMultiply);
		
		JButton btnTranspose = new JButton("Simple Transpose");
		btnTranspose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
			
		});
		btnTranspose.setBounds(253, 325, 120, 23);
		frame.getContentPane().add(btnTranspose);
		
		JButton btnFastTranspose = new JButton("Fast Transpose");
		btnFastTranspose.setBounds(253, 359, 120, 23);
		frame.getContentPane().add(btnFastTranspose);
		
		JLabel lblRowColumnValue = new JLabel("Row Column Value");
		lblRowColumnValue.setBounds(21, 36, 111, 14);
		frame.getContentPane().add(lblRowColumnValue);
		lblRowColumnValue.setVisible(false);
		
		JLabel label = new JLabel("Row Column Value");
		label.setBounds(263, 36, 111, 14);
		frame.getContentPane().add(label);
		label.setVisible(false);
		
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblRowColumnValue.setVisible(true);
				label.setVisible(true);
				
			}
		});
		rdbtnNewRadioButton.setBackground(new Color(175, 238, 238));
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(10, 284, 144, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		
		rdbtnIrregularSparseMatrix.setBackground(new Color(175, 238, 238));
		buttonGroup.add(rdbtnIrregularSparseMatrix);
		rdbtnIrregularSparseMatrix.setBounds(10, 257, 198, 23);
		frame.getContentPane().add(rdbtnIrregularSparseMatrix);
		
		
		label_1.setForeground(new Color(255, 69, 0));
		label_1.setBounds(221, 393, 288, 36);
		frame.getContentPane().add(label_1);
	}
	public void read()
	{
		String str = textArea.getText();
		String[] s = str.split("");
		for(int i=0;i<=s.length;i++)
		{
			if(i%3==0)
				row1.add(Integer.parseInt(s[i]));
			if(i%3==1)
				col1.add(Integer.parseInt(s[i]));
			if(i%3==2)
				data1.add(Integer.parseInt(s[i]));
		}
		String str1 = textArea.getText();
		String[] s1 = str1.split("");
		for(int i=0;i<=s.length;i++)
		{
			if(i%3==0)
				row1.add(Integer.parseInt(s1[i]));
			if(i%3==1)
					col1.add(Integer.parseInt(s1[i]));
			if(i%3==2)
				data1.add(Integer.parseInt(s1[i]));
		}
	}
	public void addIndex() {
		read();
	if(row1.get(row1.size())!=row2.get(row2.size())&&col1.get(col1.size())!=col2.get(col2.size()))
	{
		label_1.setText("Matrices Can't be added");
	
	}
	else
	{
		
		for(int i= 0;i<row1.size();i++)
		{
			for(int j= 0;j<row2.size();j++)
			{
				if(row1.get(i)==row2.get(i)&&col1.get(j)==col2.get(j))
				{
					
					row3.add(i);
					col3.add(j);
					data3.add(data1.get(i)+data2.get(j));
					
					
				}
				else
				{
					data3.add(data1.get(i));
					
					
				}
				
			}	
			
		}
		
		
	}
	textArea_2.setText(Integer.toString(row1.get(0)));
	System.out.println(row3.size());
	System.out.println(col3.size());
	System.out.println(data3.size());
	
	}
}
