import java.awt.EventQueue;
import java.io.*;
import java.util.StringTokenizer;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JToggleButton;
import java.awt.Color;
import java.awt.Font;

public class Array  {	
	ArrayList<Integer> ar = new ArrayList<Integer>();
	ArrayList<Integer> sar = new ArrayList<Integer>();
	

	
	
	
	int noc=0;
	int newElement;
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField url;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Array window = new Array();
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
	public Array() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(175, 238, 238));
		frame.setBounds(100, 100, 744, 514);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][89px][86px][89px,grow][5px][89px,grow][89px][89px]", "[23px][23px][][][][][][][][][][][][][][]"));
		
		
		JLabel lblArrayDataStructure = new JLabel("ARRAY DATA STRUCTURE");
		lblArrayDataStructure.setForeground(new Color(0, 0, 128));
		lblArrayDataStructure.setFont(new Font("Century", Font.PLAIN, 17));
		frame.getContentPane().add(lblArrayDataStructure, "cell 3 0");
		
		JLabel lblArray = new JLabel("Array:");
		lblArray.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().add(lblArray, "cell 0 2,alignx right");
		
		textField = new JTextField();
		textField.setColumns(15);
		frame.getContentPane().add(textField, "cell 1 2 2 1,growx,aligny center");
		
		JLabel lblNewElement = new JLabel("New Element:");
		lblNewElement.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().add(lblNewElement, "cell 3 2 2 1,alignx right");
		
		textField_1 = new JTextField();
		frame.getContentPane().add(textField_1, "cell 5 2,growx");
		textField_1.setColumns(5);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().add(lblPosition, "cell 6 2,alignx right");
		
		textField_2 = new JTextField();
		frame.getContentPane().add(textField_2, "cell 7 2,growx");
		textField_2.setColumns(5);
		
		JLabel lblUrl = new JLabel("URL of the File");
		lblUrl.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().add(lblUrl, "cell 3 3,alignx right");
		
		url = new JTextField();
		frame.getContentPane().add(url, "cell 5 3 3 1,growx");
		url.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Insert");
		btnNewButton_3.setBackground(new Color(173, 216, 230));
		frame.getContentPane().add(btnNewButton_3, "cell 1 4,alignx left,aligny top");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Code to add the new Element into the array
				String data = textField.getText();
				String[] arOfStr	= data.split(" ");
					
				 for (String a : arOfStr) 
			            ar.add(Integer.parseInt(a));
				 int index = Integer.parseInt(textField_2.getText());
				 int ele = Integer.parseInt(textField_1.getText());
				 ar.add(index,ele);
				 
			}
		});
		
		JButton btnNewButton_5 = new JButton("Delete");
		btnNewButton_5.setBackground(new Color(173, 216, 230));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String data = textField.getText();
				String[] arOfStr	= data.split(" ");
					
				 for (String a : arOfStr) 
			            ar.add(Integer.parseInt(a));
				 int index = Integer.parseInt(textField_2.getText());
				
				 ar.remove(index);
			}
		});
		frame.getContentPane().add(btnNewButton_5, "cell 2 4,alignx left,aligny top");
		
		JButton btnNewButton_1 = new JButton("Show");
		btnNewButton_1.setBackground(new Color(173, 216, 230));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String[] str = new String[ar.size()];
		    	for (int j = 0; j < ar.size(); j++) 
		    	{ 
		    		   str[j] =Integer.toString(ar.get(j)); 
		        } 
		    	for (int i = 0; i < ar.size(); i++) {
					System.out.println(ar.get(i));
				}
		    	
		    	  
				 textField_4 .setText( Arrays.toString(str));
			}
		});
		
		JButton btnReadFile = new JButton("Read File");
		btnReadFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String str = url.getText();
				try {
					readFile(str);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		frame.getContentPane().add(btnReadFile, "cell 5 4");
		frame.getContentPane().add(btnNewButton_1, "cell 1 5,alignx left,aligny top");
		
		JButton btnNewButton_6 = new JButton("Clear");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ar.clear();
				noc=0;
			}
		});
		frame.getContentPane().add(btnNewButton_6, "cell 2 5");
		
		JButton btnNewButton_4 = new JButton("Insertion Sort");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String data = textField.getText();
				String[] arOfStr	= data.split(" ");
					
				 for (String a : arOfStr) 
			            ar.add(Integer.parseInt(a));
				sar = insertionSort(ar);						//Calling Insertion Sort Method to sort the array
				String[] str = new String[ar.size()];
		    	for (int j = 0; j < ar.size(); j++) 
		    	{ 
		    		   str[j] =Integer.toString(ar.get(j)); 
		        } 
		    	for (int i = 0; i < ar.size(); i++) {
					System.out.println(ar.get(i));
				}
		  
				textField_4.setText("");
				 textField_4 .setText( Arrays.toString(str));
			}
		});
		
		JButton btnNewButton_2 = new JButton("Bubbble Sort");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String data = textField.getText();
				String[] arOfStr	= data.split(" ");
					
				 for (String a : arOfStr) 
			            ar.add(Integer.parseInt(a));
				sar = bubbleSort(ar);						//Calling Bubble Sort Method to sort the array
				String[] str = new String[sar.size()];
		    	for (int j = 0; j < sar.size(); j++) 
		    	{ 
		    		   str[j] =Integer.toString(sar.get(j)); 
		        } 
		    	for (int i = 0; i < sar.size(); i++) {
					System.out.println(sar.get(i));
				}
		  
				textField_4.setText("");
				 textField_4 .setText( Arrays.toString(str));
			}
		});
		
		JLabel lblSelectTheSorting = new JLabel("Select the Sorting Algorithm");
		lblSelectTheSorting.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().add(lblSelectTheSorting, "cell 3 5");
		frame.getContentPane().add(btnNewButton_2, "cell 3 6,alignx left,aligny top");
		frame.getContentPane().add(btnNewButton_4, "cell 3 7,alignx left,aligny top");
		
		JButton btnShellSort = new JButton("Shell Sort");
		btnShellSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				shellSort();
				textField_3.setText(Integer.toString(noc));
			}
		});
		
		JButton btnMergeSort = new JButton("Merge Sort");
		btnMergeSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String data = textField.getText();
				String[] arOfStr	= data.split(" ");
					
				 for (String a : arOfStr) 
			            ar.add(Integer.parseInt(a));
				sar = sortGivenArray();						//Calling Merge Sort Method to sort the array
				String[] str = new String[ar.size()];
		    	for (int j = 0; j < ar.size(); j++) 
		    	{ 
		    		   str[j] =Integer.toString(ar.get(j)); 
		        } 
		    	for (int i = 0; i < ar.size(); i++) {
					System.out.println(ar.get(i));
				}
		  
				textField_4.setText("");
				 textField_4 .setText( Arrays.toString(str));
			}
		});
		
		JButton btnNewButton = new JButton("Selection Sort");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String data = textField.getText();
				String[] arOfStr	= data.split(" ");
					
				 for (String a : arOfStr) 
			            ar.add(Integer.parseInt(a));
				sar = insertionSort(ar);						//Calling Selection Sort Method to sort the array
				String[] str = new String[ar.size()];
		    	for (int j = 0; j < ar.size(); j++) 
		    	{ 
		    		   str[j] =Integer.toString(ar.get(j)); 
		        } 
		    	for (int i = 0; i < ar.size(); i++) {
					System.out.println(ar.get(i));
				}
		  
				textField_4.setText("");
				 textField_4 .setText( Arrays.toString(str));
			}
		});
		frame.getContentPane().add(btnNewButton, "cell 3 8,alignx left,aligny top");
		
		JButton btnQuickSort = new JButton("Quick Sort");
		btnQuickSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String data = textField.getText();
				String[] arOfStr	= data.split(" ");
					
				 for (String a : arOfStr) 
			            ar.add(Integer.parseInt(a));
				sar = startQuickStart(0,ar.size()-1);						//Calling Quick Sort Method to sort the array
				String[] str = new String[ar.size()];
		    	for (int j = 0; j < ar.size(); j++) 
		    	{ 
		    		   str[j] =Integer.toString(ar.get(j)); 
		        } 
		    	for (int i = 0; i < ar.size(); i++) {
					System.out.println(ar.get(i));
				}
		  
				textField_4.setText("");
				 textField_4 .setText( Arrays.toString(str));
			}
		});
		frame.getContentPane().add(btnQuickSort, "cell 3 9,aligny bottom");
		frame.getContentPane().add(btnMergeSort, "cell 3 10");
		frame.getContentPane().add(btnShellSort, "cell 3 11");
		
		JLabel lblSortedArray = new JLabel("Sorted/Updated Array");
		lblSortedArray.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().add(lblSortedArray, "cell 2 13,alignx trailing");
		
		textField_4 = new JTextField();
		frame.getContentPane().add(textField_4, "cell 3 13,growx");
		textField_4.setColumns(10);
		
		JLabel lblNoOfComparisions = new JLabel("No. of Comparisions");
		lblNoOfComparisions.setFont(new Font("Tahoma", Font.BOLD, 11));
		frame.getContentPane().add(lblNoOfComparisions, "cell 2 15");
		
		textField_3 = new JTextField();
		frame.getContentPane().add(textField_3, "cell 3 15,growx");
		textField_3.setColumns(10);
	}

	
	//Code for Bubble Sort
	public ArrayList<Integer> bubbleSort(ArrayList<Integer> arraylist)
	{
		 Integer temp;
	        if (arraylist.size()>1) 
	        {
	            for (int x=0; x<arraylist.size(); x++) // bubble sort outer loop
	            {
	                for (int i=0; i < arraylist.size()-x-1; i++) {
	                	noc++;
	                    if (arraylist.get(i).compareTo(arraylist.get(i+1)) > 0)
	                    {
	                        temp = arraylist.get(i);
	                        arraylist.set(i,arraylist.get(i+1) );
	                        arraylist.set(i+1, temp);
	                    }
	                }
	            }
	        }
		//arraylist.sort(null);
	textField_3.setText(Integer.toString(noc));
	return arraylist;	
	}
	
	//Code for Insertion Sort
	public ArrayList<Integer> insertionSort(ArrayList<Integer> arraylist)
	{
		int smallInt = 0;
        int j=0;
        int smallIntIndex = 0;      
         
        for(int i=1;i<arraylist.size();i++){
             
            smallInt = arraylist.get(i-1);
            smallIntIndex = i-1;
             
            for(j=i;j<arraylist.size();j++){
            	noc++;
                if(arraylist.get(j)<smallInt){
                    smallInt = arraylist.get(j);
                    smallIntIndex = j;
                }
            }
         
            //Swap the smallest element with the first element of unsorted sub array
            swap(i-1, smallIntIndex,arraylist);           
        }	
        textField_3.setText(Integer.toString(noc));	
	return arraylist;	
	}
	
	 public void swap(int sourceIndex,int destIndex,ArrayList<Integer> arraylist){        
	        int temp = arraylist.get(destIndex);
	        arraylist.set(destIndex, arraylist.get(sourceIndex));
	        arraylist.set(sourceIndex, temp);
	    }
	
		//Code for Selection Sort
	public ArrayList<Integer> selectionSort(ArrayList<Integer> arraylist)
	{
		
	return ar;	
	}
	//Code for Quick Sort Sort
	public ArrayList<Integer> startQuickStart(int start,int end)
	{
			
		 int q;
	        if(start<end){
	            q = partition(start, end);
	            startQuickStart(start, q);
	            startQuickStart(q+1, end);
	        }
	 textField_3.setText(Integer.toString(noc));
	return ar;
	
	}
	
	
	int partition(int start,int end){
       
         
        int init = start;
        int length = end;
         
        Random r = new Random();
        int pivotIndex = nextIntInRange(start,end,r);
        int pivot = ar.get(pivotIndex);
         
     
                 
        while(true){
            while(ar.get(length)>pivot && length>start){
                length--;
            }
             
            while(ar.get(init)<pivot && init<end){
                init++;
            }
             
            if(init<length){
                int temp;
                temp = ar.get(init);
                ar.set(init,ar.get(length));
                ar.set(length,temp);
                length--;
                init++;
                 
              
                for(int i=start;i<=end;i++){
                   
                noc++;    
                }
            }else{
                System.out.println("\n---------Iteration Ends---------");
                return length;
            }
        }
         
    }
     
    // Below method is to just find random integer from given range
    static int nextIntInRange(int min, int max, Random rng) {
           if (min > max) {
              throw new IllegalArgumentException("Cannot draw random int from invalid range [" + min + ", " + max + "].");
           }
           int diff = max - min;
           if (diff >= 0 && diff != Integer.MAX_VALUE) {
              return (min + rng.nextInt(diff + 1));
           }
           int i;
           do {
              i = rng.nextInt();
           } while (i < min || i > max);
           return i;
        }
	
	
	
	
	
	//Code for Merge Sort
    public ArrayList<Integer> sortGivenArray(){       
        divide(0, this.ar.size()-1);
        textField_3.setText(Integer.toString(noc));
        return ar;
    }
     
    public void divide(int startIndex,int endIndex){
         
        //Divide till you breakdown your list to single element
        if(startIndex<endIndex && (endIndex-startIndex)>=1){
            int mid = (endIndex + startIndex)/2;
            divide(startIndex, mid);
            divide(mid+1, endIndex);        
             
            //merging Sorted array produce above into one sorted array
            merger(startIndex,mid,endIndex);            
        }       
    }   
     
    public void merger(int startIndex,int midIndex,int endIndex){
         
        //Below is the merged array that will be sorted array Array[i-midIndex] , Array[(midIndex+1)-endIndex]
        ArrayList<Integer> mergedSortedArray = new ArrayList<Integer>();
         
        int leftIndex = startIndex;
        int rightIndex = midIndex+1;
         
        while(leftIndex<=midIndex && rightIndex<=endIndex){
        	noc++;
            if(ar.get(leftIndex)<=ar.get(rightIndex)){
                mergedSortedArray.add(ar.get(leftIndex));
                leftIndex++;
            }else{
                mergedSortedArray.add(ar.get(rightIndex));
                rightIndex++;
            }
        }       
         
        //Either of below while loop will execute
        while(leftIndex<=midIndex){
            mergedSortedArray.add(ar.get(leftIndex));
            leftIndex++;
            noc++;
        }
         
        while(rightIndex<=endIndex){
            mergedSortedArray.add(ar.get(rightIndex));
            rightIndex++;
            noc++;
        }
         
        int i = 0;
        int j = startIndex;
        //Setting sorted array to original one
        while(i<mergedSortedArray.size()){
            ar.set(j, mergedSortedArray.get(i++));
            j++;
        }
    }
    
    //Code for Shell Sort
    public void shellSort() {
    	
    	
    	
    	String data = textField.getText();
		String[] arOfStr	= data.split(" ");
			
		 for (String a : arOfStr) 
	            ar.add(Integer.parseInt(a));	
    	
    int n = ar.size(); 
    
    // Start with a big gap, then reduce the gap 
    for(int gap = n/2; gap > 0; gap /= 2) 
    { 
        
        for (int i = gap; i < n; i += 1) 
        { 
            int temp = ar.get(i);             
            int j; 
            for (j = i; j >= gap && ar.get(j - gap) > temp; j -= gap) {
                ar.set(j, ar.get(j - gap)); 
                noc++;
            }
           
            ar.set(j, temp); 
        } 
    }
    

    String[] str = new String[ar.size()];
	for (int j = 0; j < ar.size(); j++) 
	{ 
		   str[j] =Integer.toString(ar.get(j)); 
    } 
	for (int i = 0; i < ar.size(); i++) {
		System.out.println(ar.get(i));
	}
	
	  System.out.println(Arrays.toString(str));
	 textField_4 .setText( Arrays.toString(str));
    
    
    }
    //Code for Reading the file from the input url.
    public void readFile(String ur) throws Exception
    {
    	try {
    	String[] str=new String[100];
        FileReader f=new FileReader(ur);
        BufferedReader br=new BufferedReader(f);
    	
        int i=0;
        String s=new String();
        while((s=br.readLine())!=null)
        	{
       	 
       	 str[i]=s;
            System.out.println(str[i]);
            i++;
        	
       textField.setText(s);
        	}
        
        f.close(); 
    	}
    	catch(Exception e) {}	
    }
    

}

