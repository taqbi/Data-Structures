
import java.util.*; 

public class LinkedListLoop { 
	
	static Node head;
		
	
	static class Node 
	{ 
		int data; 
		Node next; 
		Node(int d) {data = d; next = null; } 
	} 
	
	
	static public void push(int new_data) 
	{ 
	
		Node new_node = new Node(new_data); 
		new_node.next = head; 
		head = new_node; 
	} 

	//This Method returns true if there is a loop in linked  list else returns false. 
	static boolean detectLoop(Node h) 
	{ 
		HashSet<Node> s = new HashSet<Node>(); 
		while (h != null) 
		{ 
			
			if (s.contains(h)) //If hash map already contains the node then there is loop
				return true; 
	
			// If we are seeing the node for  the first time, insert it in hash 
			s.add(h); 
	
			h = h.next; 
		} 
	
																												return true;
	} 
	

	public static void main(String[] args) 
	{ 
		LinkedList llist = new LinkedList(); 
		
		llist.push(20); 
		llist.push(4); 
		llist.push(15); 
		llist.push(10); 
		
		/*Create loop for testing */
		llist.head.next.next.next.next = llist.head.next; 

		if (detectLoop(head)) 
			System.out.println(" Loop found"); 
		else
			System.out.println(" NO Loop Found"); 
	
	} 
} 

