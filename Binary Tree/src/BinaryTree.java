import java.util.Map.Entry; 
import java.util.*;
class BinaryTree { 
	static int  max_level = 0;
	static Vector<Integer> arr = new Vector<Integer>();
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
	BinaryTree() { 
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
	
// 2........................................................................Method for PostOrder Traversal of the Tree
	
	void postorder(Node root)
	{
		if(root!=null)
		{
			postorder(root.left);
			postorder(root.right);
			System.out.print(" "+ root.key);
		}
	}
// 3....................................................................Method for PreOrder traversal of the tree
	void preorder(Node root)
	{
		if(root != null)
		{
			System.out.print(" " + root.key);
			preorder(root.left);
			preorder(root.right);
		}
	}
//4......................................................................Method for InOrder Traversal of the tree
	

	void inorder(Node root) { 
		if (root != null) { 
			inorder(root.left); 
			System.out.print(" " + root.key); 
			arr.add(root.key);
			inorder(root.right); 
		} 
		
	}
//5............................................................................Method for Spiral LevelOrder Traversal
	void levelOrderSp(Node root)
	{
		if(root != null)
		{
			int h = height(root);
			int i;
			boolean flag = false; 
			for(i=1;i<=h;i++)
			{
				printLevelSpiral(root,i,flag);
				flag = !flag;
			}
		}
	}
	void printLevelSpiral(Node root,int level,boolean flag)
	{
		if(root == null)
			return;
		if(level == 1)
			System.out.print(" " + root.key);
		if(level>1)
		{
			if(flag)
			{
				printLevelSpiral(root.right,level-1,flag);
				printLevelSpiral(root.left,level-1,flag);
			}
			else {
			
				printLevelSpiral(root.left,level-1,flag);
				printLevelSpiral(root.right,level-1,flag);
			}
			
		}
		
	}
//6...............................................Method for level order traversal of the tree
	void levelOrder(Node root)
	{
		if(root != null)
		{
			int h = height(root);
			int i;
			for(i=1;i<=h;i++)
			{
				printLevel(root,i);
			}
		}
	}
	int height(Node root)
	{
		if(root == null)
			return 0;
		else {
			int lh = height(root.left);
			int rh = height(root.right);
			if(lh>rh)
				return(lh+1);
			else
				return(rh+1);
		}
	}
	void printLevel(Node root,int level)
	{
		if(root == null)
			return;
		if(level == 1)
			System.out.print(" " + root.key);
		if(level>1)
		{
				printLevel(root.left,level-1);
				printLevel(root.right,level-1);
						
		}
		
	}
	
//7.........................................Bottom view of the Tree.	
	 public void bottomView() 
	    { 
	        if (root == null) 
	            return; 
	  
	   
	        int hd = 0;  
	        Map<Integer, Integer> map = new TreeMap<>(); 
	        Queue<Node> queue = new LinkedList<Node>(); 
	  
	        root.hd = hd; 
	        queue.add(root); 
	  
	       
	        while (!queue.isEmpty()) 
	        { 
	            Node temp = queue.remove(); 
	  
	             
	            hd = temp.hd; 
	  
	            map.put(hd, temp.key); 
	  
	         
	            if (temp.left != null) 
	            { 
	                temp.left.hd = hd-1; 
	                queue.add(temp.left); 
	            } 
	         
	            if (temp.right != null) 
	            { 
	                temp.right.hd = hd+1; 
	                queue.add(temp.right); 
	            } 
	        } 
	  
	    
	        Set<Entry<Integer, Integer>> set = map.entrySet(); 
	        Iterator<Entry<Integer, Integer>> iterator = set.iterator(); 
	        while (iterator.hasNext()) 
	        { 
	            Map.Entry<Integer, Integer> me = iterator.next(); 
	            System.out.print(me.getValue()+" "); 
	        } 
	    }
//7.........................................Right view of a tree
	 void leftViewUtil(Node node, int level) 
	    { 
	       
	        if (node==null) return; 
	        if (max_level < level) 
	        { 
	            System.out.print(" " + node.key); 
	            max_level = level; 
	        } 
	  
	        leftViewUtil(node.left, level+1); 
	        leftViewUtil(node.right, level+1); 
	    } 
	  
	    
	    void leftView() 
	    { 
	        leftViewUtil(root, 1); 
	    }
//8.........................................Right view of a tree
		void rightViewUtil(Node node, int level) 
		    { 
		       
		        if (node==null) return; 
		        if (max_level < level) 
		        { 
		            System.out.print(" " + node.key); 
		            max_level = level; 
		        } 
		        rightViewUtil(node.right, level+1); 
		        rightViewUtil(node.left, level+1); 
		        
		    } 
		   
		    void rightView() 
		    { 
		    	max_level=0;
		        rightViewUtil(root, 1); 
		    }
//9..........................................................  Top View of a Tree
		    private void TopView(Node root) { 
		        class QueueObj { 
		            Node node; 
		            int hd; 
		  
		            QueueObj(Node node, int hd) { 
		                this.node = node; 
		                this.hd = hd; 
		            } 
		        } 
		        Queue<QueueObj> q = new LinkedList<QueueObj>(); 
		        Map<Integer, Node> topViewMap = new TreeMap<Integer, Node>(); 
		  
		        if (root == null) { 
		            return; 
		        } else { 
		            q.add(new QueueObj(root, 0)); 
		        } 
		  
		        System.out.println("The top view of the tree is : "); 
		          
		        
		        while (!q.isEmpty()) { 
		            QueueObj tmpNode = q.poll(); 
		            if (!topViewMap.containsKey(tmpNode.hd)) { 
		                topViewMap.put(tmpNode.hd, tmpNode.node); 
		            } 
		  
		            if (tmpNode.node.left != null) { 
		                q.add(new QueueObj(tmpNode.node.left, tmpNode.hd - 1)); 
		            } 
		            if (tmpNode.node.right != null) { 
		                q.add(new QueueObj(tmpNode.node.right, tmpNode.hd + 1)); 
		            } 
		  
		        } 
		        for (Entry<Integer, Node> entry : topViewMap.entrySet()) { 
		            System.out.print(" " + entry.getValue().key); 
		        } 
		    }
		    
//10...........................................Method for printing the Vertical Traversal of the Tree   
static void getVerticalOrder(Node root, int hd, TreeMap<Integer,Vector<Integer>> m) 
{ 

if(root == null) 
return; 
 
Vector<Integer> get =  m.get(hd); 
if(get == null) 
{ 
get = new Vector<>(); 
get.add(root.key); 
} 
else
get.add(root.key); 
m.put(hd, get); 
getVerticalOrder(root.left, hd-1, m); 

getVerticalOrder(root.right, hd+1, m); 
} 
void printVerticalOrder(Node root) 
{ 

	TreeMap<Integer,Vector<Integer>> m = new TreeMap<>(); 
	int hd =0; 
	getVerticalOrder(root,hd,m); 
	for (Entry<Integer, Vector<Integer>> entry : m.entrySet()) 
	{ 
			System.out.print(entry.getValue()); 
	} 
} 
//11...................................Method to Print the Predecessor and Succesor of each node
void getPredSucc()
{
for(int i=0;i<arr.size();i++)
{
System.out.print(""+arr.get(i)+"			 	"+arr.get(i-1)+"				 "+arr.get(i+1) );
}
}
	public static void main(String[] args) { 
		BinaryTree tree = new BinaryTree(); 

		/* Creating the following Tree
		  50
		 /  \
		/	 \ 
	   30	 70 
	  / \    / \ 
	 20 40  60 80 */
		tree.insert(50); 
		tree.insert(30); 
		tree.insert(20); 
		tree.insert(40); 
		tree.insert(70); 
		tree.insert(60); 
		tree.insert(80); 
		
		System.out.println("The InOreder traversal of the Tree is : ");
		tree.inorder(tree.root); 
		
		System.out.println("\n The PostOreder traversal of the Tree is : ");
		tree.postorder(tree.root);
		
		System.out.println("\n The PreOreder traversal os the Tree is : ");
		tree.preorder(tree.root);
		System.out.println("\n The LevelOreder traversal os the Tree is : ");
		tree.levelOrder(tree.root);
		
		System.out.println("\n The Spiral LevelOreder traversal os the Tree is : ");
		tree.levelOrderSp(tree.root);
		
		System.out.println("\n The Bottom View of the tree is");
		tree.bottomView();
		System.out.println("\n The Left View of the Tree is ");
		tree.leftView();
		System.out.println("\n The  Right View of the Tree is ");
		tree.rightView();
		System.out.println("\n The  Right View of the Tree is ");
		tree.TopView(tree.root);
		System.out.println("\n The Vertical Traversal of the tree is");
		tree.printVerticalOrder(tree.root);
	
	} 
} 
