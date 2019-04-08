class LinkedList 
{ 
	
	class Node 
	{ 
		int data; 
		Node next; 
		Node(int d)
		{
			data = d; 
			next = null;
		} 
	} 
	Node head; 
	
	
	
	//Method to remove the duplicates from a sorted Linked List
	void removeDuplicates() 
	{ 
		Node current = head; 
		Node next_next; 

		if (head == null)	//if the list is empty 
			return; 

		
		while (current.next != null) { 

			
			if (current.data == current.next.data) // delete the duplicate
			{ 
				next_next = current.next.next; 
				current.next = null; 
				current.next = next_next; 
			} 
			else 
			current = current.next; //do nothing and move ahead
		} 
	} 
					
//Method to push the elements in a Linked List
	public void push(int new_data) 
	{ 
		
		Node new_node = new Node(new_data); //Creating new node

		new_node.next = head; //making new node as the first node in the list 
		head = new_node; //making head refer to the new node
	} 
	
	//Method to remove the duplicates from an unsorted Linked dList 
	 void remove_duplicates() { 
	        Node p1 = null, p2 = null, dup = null; 
	        p1 = head; 
	  
	       
	        while (p1 != null && p1.next != null) { 
	        	
	            p2 = p1; 
	            while (p2.next != null)//iterate through the list from p2 to end
	            { 
	  
	                if (p1.data == p2.next.data)//duplicate found
	                { 
	  
	                    dup = p2.next; 
	                    p2.next = p2.next.next; 
	                    
	                } else 
	                { 
	                    p2 = p2.next; 
	                } 
	            } 
	            p1 = p1.next; 
	        } 
	    } 
	 
	 
	 
	 //Method to Swap two nodes
	 void swap2Nodes(int n1,int n2)
	 {
		Node p1 = head;
		Node p2 = head;
		Node p3 , p4 ;
		 int counter = 0;
		 while(counter < n1)
		 {
			 p1 = p1.next;
			 counter++;
		 }
		 p3 = p1.next;
		 counter = 0;
		 while(counter < n2)
		 {
			 p2 = p2.next;
			 counter++;
		 }
		 p4 = p2 .next;
		 p1.next = p4;
		 p2.next = p2;
		 Node temp = p3.next; 
		 p3.next = p4.next;
		 p4.next = temp;
	 }
	 
	 //Method to print the  the element from the last
	void nth_from_last(int n)
	{
		Node ptr1 = head;
		Node ptr2 = head;
		int count =0;
		while(count <n)
		{
			if(ptr1.next == null)
			{
				System.out.println("The value of n is not valid");
				System.exit(1);
				
			}
			ptr1 = ptr1.next;
			count++;
		}
		while(ptr1!=null)
		{
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		System.out.println("The nth element from the last is : " + ptr2.data);
		
	}
	
	
	
	
	//Method to find the middle element of a linked list
	void midElement()
	{
		Node p1 = head,p2 = head;
		while(p1 != null && p1.next != null)
		{
			p1 = p1.next.next;
			p2 = p2.next;
			
		}
		System.out.println("The Middle Elemnt of the Linked Lis is : " + p2.data);
		
	}
	
	
	
	
	//Method to print the elements of the linked list
	void print() 
	{ 
		Node temp = head; 
		while (temp != null) 
		{ 
			System.out.print(temp.data+" "); 
			temp = temp.next; 
		} 
		System.out.println("");
	} 
	public static void main(String args[]) 
	{ 
		LinkedList sortedlist = new LinkedList(); 
		LinkedList unsortedlist = new LinkedList();
		LinkedList l1 = new LinkedList();
		LinkedList l2 = new LinkedList();
		sortedlist.push(10); 
		sortedlist.push(7); 
		sortedlist.push(7); 
		sortedlist.push(5); 
		sortedlist.push(5); 
		sortedlist.push(1); 
		unsortedlist.push(2);
		unsortedlist.push(5);
		unsortedlist.push(1);
		unsortedlist.push(5);
		unsortedlist.push(6);
		unsortedlist.push(3);
		unsortedlist.push(4);
		unsortedlist.push(9);
		System.out.println("Sorted List before removal of Duplicates"); 
		sortedlist.print(); 
		
		sortedlist.removeDuplicates(); 
		
		System.out.println("Sorted List after removal of Duplicates"); 
		sortedlist.print(); 
		
		System.out.println("UnSorted List before removal of Duplicates"); 
		unsortedlist.print(); 
		
		unsortedlist.remove_duplicates(); 
		
		System.out.println("UnSorted List after removal of Duplicates"); 
		unsortedlist.print();
		System.out.println("");
		
		//To swap two nodes
		unsortedlist.swap2Nodes(3,4);
		System.out.println("UnSorted List after Swapping");
		unsortedlist.print();
		System.out.println("");
		
		//To print the nth element from the last
		unsortedlist.nth_from_last(5);
		System.out.println("");
		
		//To find the Middle element
		unsortedlist.midElement();
		System.out.println("");
		//Code to separate even and odd nodes 
		Node ptr = unsortedlist.head;
		while(ptr != null )
		{
			if(ptr.data % 2 == 1)
			{
				l1.push(ptr.data);
			}
			else
			{
				l2.push(ptr.data);
			}
			ptr = ptr.next;
			
		}
		ptr = l2.head;
		while(ptr != null)
		{
			l1.push(ptr.data);
			ptr = ptr.next;
		}
		System.out.println("The linked list after seperation of even and odd  is: ");
		l1.print();
		
		
	} 
} 
