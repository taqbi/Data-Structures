import java.util.*; 


class Graph 
{ 
	private int V; 

	// We will be using Adjacency List Representation 
	private LinkedList adj[]; 
 
	Graph(int v) 
	{ 
		V = v; 
		adj = new LinkedList[v]; 
		for (int i=0; i<v; ++i) 
			adj[i] = new LinkedList(); 
	} 

	//Function to add an edge into the graph 
	void addEdge(int v, int w) 
	{ 
		adj[v].add(w); // Add w to v's adjacency list. 
	} 


	void BFS(int s) 
    { 
        
        boolean visited[] = new boolean[V]; 
 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // Mark the current node as visited and enqueue it 
        visited[s]=true; 
        queue.add(s); 
  
        while (queue.size() != 0) 
        { 
            // Dequeue a vertex from queue and print it 
            s = queue.poll(); 
            System.out.print(s+" "); 
  
            // Get all the adjacent vertices of the dequeued node and mark it visited and add to the queue
            Iterator<Integer> i = adj[s].listIterator(); 
            while (i.hasNext()) 
            { 
                int n = i.next(); 
                if (!visited[n]) 
                { 
                    visited[n] = true; 
                    queue.add(n); 
                } 
            } 
        } 
    }  
	
	 void DFS(int s) 
     { 
         Vector<Boolean> visited = new Vector<Boolean>(V); 
         for (int i = 0; i < V; i++) 
             visited.add(false); 
   
         Stack<Integer> stack = new Stack<>(); 
        
         stack.push(s); 
           
         while(stack.empty() == false) 
         { 
             // Pop a vertex from stack and print it 
             s = stack.peek(); 
             stack.pop(); 
               
             
             if(visited.get(s) == false) 
             { 
                 System.out.print(s + " "); 
                 visited.set(s, true); 
             } 
               
             // Get all adjacent vertices of the popped vertex s.If a adjacent has not been visited, then puah it to the stack. 
             Iterator<Integer> itr = adj[s].iterator(); 
               
             while (itr.hasNext())  
             { 
                 int v = itr.next(); 
                 if(!visited.get(v)) 
                     stack.push(v); 
             } 
               
         } 
     } 
 
	public static void main(String args[]) 
	{ 
		Graph g = new Graph(4); 

		/*We will create the following graph
		
		0--------->1
		^		  /
		|		 /
		|		/
		|	   /
		|	  /
		|    /
		|   /		 ___
		|  <		|  |
		 2--------->3  |
		 			^  |
		 			|__|	
		*/
		g.addEdge(0, 1); 
		g.addEdge(1, 2); 
		g.addEdge(2, 0); 
		g.addEdge(2, 3); 
		g.addEdge(3, 3); 
		

		System.out.println("Following is Depth First Traversal starting from vertex 0"); 
		g.DFS(0); 
		
		System.out.println("\nFollowing is Breadth First Traversal starting from vertex 2");
		g.BFS(2);
	} 
} 
