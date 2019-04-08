
import java.util.LinkedList; 
import java.util.Queue; 
import java.util.Stack; 


public class QueueOp { 
	
	static Queue<Integer> queue; 

	// Utility function to print the queue 
	static void print() 
	{ 
		while (!queue.isEmpty()) { 
			System.out.print( queue.peek() + ", "); 
			queue.remove(); 
		
		}
		enQueue();
		System.out.println("");
	} 

	// Function to reverse the queue
	static void reversequeue() 
	{ 
		Stack<Integer> stack = new Stack<>(); 
		while (!queue.isEmpty()) { 
			stack.add(queue.peek()); 
			queue.remove(); 
		} 
		while (!stack.isEmpty()) { 
			queue.add(stack.peek()); 
			stack.pop(); 
		} 
	}
	 static void reverseQueueFirstKElements(int k) { 
	        if (queue.isEmpty() == true || k > queue.size()) 
	            return; 
	        if (k <= 0) 
	            return; 
	  
	        Stack<Integer> stack = new Stack<Integer>(); 
	  
	        // Push the first K elements into a Stack  
	        for (int i = 0; i < k; i++) { 
	            stack.push(queue.peek()); 
	            queue.remove(); 
	        } 
	  
	          
	        // Enqueue the contents of stack at the back of the queue 
	        while (!stack.empty()) { 
	            queue.add(stack.peek()); 
	            stack.pop(); 
	        } 
	  
	          
	        // Remove the remaining elements and enqueue them at the end of the Queue 
	        for (int i = 0; i < queue.size() - k; i++) { 
	            queue.add(queue.peek()); 
	            queue.remove(); 
	        } 
	    } 
	  static void enQueue() {
		  queue = new LinkedList<Integer>(); 
			queue.add(10); 
			queue.add(20); 
			queue.add(30); 
			queue.add(40); 
			queue.add(50); 
			queue.add(60); 
			queue.add(70); 
			queue.add(80); 
			queue.add(90); 
			queue.add(100); 
		  
	  }

	public static void main(String args[]) 
	{ 
		
		enQueue();
		System.out.println("The original Queue is : ");
		print();
		reversequeue(); 
		System.out.println("The Queue after Reversing all the elements is: ");
		 print();
		reverseQueueFirstKElements(5);
		System.out.println("The Queue after Reversing the first 5 elements is: ");
		 print();
		PageRep obj = new PageRep();
		obj.init();
		obj.pageReplace();
		obj.printres();
	} 
} 

