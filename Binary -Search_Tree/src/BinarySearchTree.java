import java.util.Map.Entry;



import java.util.*;
class BinarySearchTree { 
	int count = 0;
	static int  max_level = 0;
	static Vector<Integer> arr = new Vector<Integer>();
	static Vector<Integer>inor = new Vector<Integer>();
	
	class Node { 
		int key; 
		Node left, right; 
		int hd;
		
		public Node(int item) { 
			key = item; 
			left = right = null; 
		} 
	} 

	
	Node root; 
	BinarySearchTree() { 
		root = null; 
	} 

// 1........................Insertion	
	void insert(int key) { 
	root = insertRec(root, key); 
	} 
	
	Node insertRec(Node root, int key) { 

		
		if (root == null) { 
			root = new Node(key); 
			return root; 
		} 

		
		if (key < root.key) 
			root.left = insertRec(root.left, key); 
		else if (key > root.key) 
			root.right = insertRec(root.right, key); 

		
		return root; 
	} 
	
	
	
//4......................................................................Method for InOrder Traversal of the tree
	

void inorder(Node root) { 
	if (root != null) { 
			inorder(root.left); 
			System.out.print(" " + root.key); 
			inor.add(root.key);
			arr.add(root.key);
			inorder(root.right); 
			} 
			
		}
void deorder(Node root) { 
	if (root != null) { 
			deorder(root.right); 
			System.out.print(" " + root.key); 
			deorder(root.left); 
			
			} 
			
		}

//Finding the Maximum ELemnet in the TRee
static int findMax(Node node) { 
	        Node current = node; 
	  
	       
	        while (current.	right!= null) { 
	            current = current.right; 
	        } 
	        return (current.key); 
	    } 
// Finding The Mininmum Element in the Tree
static	int findMin(Node node) { 
    Node current = node; 

   
    while (current.left != null) { 
        current = current.left; 
    } 
    return (current.key); 
} 




	//Finding the Kth largest ELement
	
	static Node kthLargest(Node root, int k)  
	{  
	    Node curr = root;  
	    Node Klargest = null;  
	  
	    // count variable to keep count of visited Nodes  
	    int count = 0;  
	  
	    while (curr != null) 
	    {  
	        // if right child is NULL  
	        if (curr.right == null)  
	        {  
	  
	            // first increment count and check if count = k  
	            if (++count == k)  
	                Klargest = curr;  
	  
	            // otherwise move to the left child  
	            curr = curr.left;  
	        }  
	  
	        else 
	        {  
	  
	            // find inorder successor of current Node  
	            Node succ = curr.right;  
	  
	            while (succ.left != null && succ.left != curr)  
	                succ = succ.left;  
	  
	            if (succ.left == null) 
	            {  
	  
	                // set left child of successor to the  
	                // current Node  
	                succ.left = curr;  
	  
	                // move current to its right  
	                curr = curr.right;  
	            }  
	  
	            // restoring the tree back to original binary search tree removing threaded links  
	            else
	            {  
	  
	                succ.left = null;  
	  
	                if (++count == k)  
	                    Klargest = curr;  
	  
	                // move current to its left child  
	                curr = curr.left;  
	            }  
	        }  
	    }  
	    return Klargest;  
	}	
//Finding the Floor of an input
static	int	Ceil(Node node, int input) { 
        
	        if (node == null) { 
	            return -1; 
	        } 
	  
	     
	        if (node.key	== input) { 
	            return node.key; 
	        } 
	  
	        if (node.key < input) { 
	            return Ceil(node.right, input); 
	        } 
	  
	
	        int ceil = Ceil(node.left, input); 
	        return (ceil >= input) ? ceil : node.key; 
	    }

//FInding the Floor of an Input
static	int	Floor(Node node, int input) { 
  
    if (node == null) { 
        return -1; 
    } 

    if (node.key	== input) { 
        return node.key; 
    } 

    if (node.key > input) { 
        return Floor(node.right, input); 
    } 

    
    int flr = Floor(node.right, input); 
    return (flr	<= input) ? flr : node.key; 
}
	
//...................................Method to Print the Predecessor and Succesor of each node
void getPredSucc()
{
for(int i=0;i<arr.size();i++)
{
System.out.print(""+arr.get(i)+"			 	"+arr.get(i-1)+"				 "+arr.get(i+1) );
}
}

//Counting the Number of Pairs in BST Whose Sum is Equal to k				
/* static void count_pairs_w_sum(Node	root)
{
   
    if(root!=null)
    {
        if(hash_t contains(root.key))
            count += 1;
        else 
            hash_t.add(x-root.key) 
          
        count_pairs_w_sum(root.left) ;
        count_pairs_w_sum(root.right) ;
    }
}*/

	public static void main(String[] args) { 
		BinarySearchTree tree = new BinarySearchTree(); 

		/* Creating the following Tree
		  50
		 /  \
		/	 \ 
	   30	 70 
	  / \    / \ 
	 20 40  60 80 */
		
		Vector<Integer> data =new Vector<Integer>();
		data.add(20);
		data.add(25);
		data.add(22);
		data.add(75);
		data.add(63);
		data.add(50);
		data.add(86);
		data.add(23);
		data.add(40);
		data.add(66);
		for(int i = 0;i < data.size();i++)
		{
			tree.insert(data.elementAt(i));
		}
		
		
		
		//FIND MAXIMUM
		System.out.print("The maximum Element in the tree is  : ");
		int max = findMax(tree.root);
		System.out.println("	"+max	);
		//FIND MINIMUM
		System.out.print("The minimum Element in the tree is  : ");
		int min= findMin(tree.root);
		System.out.println("	"+min);
		
		
		
		//Printing the Elements in the Increasing order
		System.out.print("The Elemnts of the Tree in Increasing order are: ");
		tree.inorder(tree.root); 
		
		//Printing the Elements in the Decreasing order
		System.out.print("\nThe Elemnts of the Tree in Deccreasing order are: ");
		tree.deorder(tree.root); 
		
		//Finding the kth Maximum Element in the tree.
		System.out.print("\nThe 5th	Maximum Element in the tree is  : ");
		System.out.println(inor.elementAt(5));
	
		//Finding the 4th Minimum Element in the tree.
		System.out.print("The Kth	Minimum Element in the tree is  : ");
		System.out.println(inor.elementAt(inor.size()-4	));
		
		//Finding the Ceil of a Value in the tree.
		System.out.println("The Ceil of value	45 in the tree is  : "	+Ceil(tree.root,45));
		
		//Finding the Floor of a Value in the tree.
		System.out.println("The Floor of the value	25 in the tree is  : "	+Floor(tree.root,25));
		
		
		
		
	} 
} 
