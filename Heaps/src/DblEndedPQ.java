 
import java.util.*; 
class solution 
{ 

static class DblEndedPQ { 
	Set<Integer> s; 
	DblEndedPQ() 
	{ 
		s= new HashSet<Integer>(); 
	} 
	// Returns size of the queue. Works in 
	// O(1) time 
	int size() 
	{ 
	return s.size(); 
	} 

	// Returns true if queue is empty. Works 
	// in O(1) time 
	boolean isEmpty() 
	{ 
	return (s.size() == 0); 
	} 

	// Inserts an element. Works in O(Log n) 
	// time 
	void insert(int x) 
	{ 
		s.add(x); 
		
	} 

	// Returns minimum element. Works in O(1) 
	// time 
	int getMin() 
	{ 
		return Collections.min(s,null); 
	} 

	// Returns maximum element. Works in O(1) 
	// time 
	int getMax() 
	{ 
		return Collections.max(s,null); 
	} 
	
	// Deletes minimum element. Works in O(Log n) 
	// time 
	void deleteMin() 
	{ 
		if (s.size() == 0) 
			return ; 
		s.remove(Collections.min(s,null)); 
		
	} 

	// Deletes maximum element. Works in O(Log n) 
	// time 
	void deleteMax() 
	{ 
		if (s.size() == 0) 
			return ; 
		s.remove(Collections.max(s,null)); 
		
	} 
}; 

public static void main(String args[]) 
{ 
	DblEndedPQ d= new DblEndedPQ(); 
	d.insert(10); 
	d.insert(50); 
	d.insert(40); 
	d.insert(20); 
	System.out.println( d.getMin() ); 
	System.out.println(d.getMax() ); 
	d.deleteMax(); 
	System.out.println( d.getMax() ); 
	d.deleteMin(); 
	System.out.println( d.getMin() ); 
} 
} 