import java.util.Scanner;
 
/** Class LeftHeapNode **/    
class LeftHeapNode
{
    int element, sValue;     
    LeftHeapNode left, right;             
 
    public LeftHeapNode(int ele)
    {
        this(ele, null, null);
    }
    public LeftHeapNode(int ele, LeftHeapNode left, LeftHeapNode right)
    {
        this.element = ele;
        this.left = left;
        this.right = right;
        this.sValue = 0;
    }    
}
 
/** Class LeftistHeap **/
class LeftistHeap
{
    private LeftHeapNode root; 
 
    /** Constructor **/
    public LeftistHeap() 
    {
        root = null;
    }
 
    /** Check if heap is empty **/
    public boolean isEmpty() 
    {
        return root == null;
    }
 
    /** Make heap empty **/ 
    public void clear( )
    {
        root = null;
    }
 
    /** Function to insert data **/
    public void insert(int x )
    {
        root = merge(new LeftHeapNode( x ), root);
    }
 
    /** Function merge **/
    public void merge(LeftistHeap rhs)
    {
        if (this == rhs)    
            return;
        root = merge(root, rhs.root);
        rhs.root = null;
    }
 
    /** Function merge **/
    private LeftHeapNode merge(LeftHeapNode x, LeftHeapNode y)
    {
        if (x == null)
            return y;
        if (y == null)
            return x;
        if (x.element > y.element)
        {
            LeftHeapNode temp = x;
            x = y;
            y = temp;
        }
 
        x.right = merge(x.right, y);
 
          if(x.left == null) 
          {
            x.left = x.right;
            x.right = null;         
        } 
        else 
        {
            if(x.left.sValue < x.right.sValue) 
            {
                LeftHeapNode temp = x.left;
                  x.left = x.right;
                  x.right = temp;
            }
            x.sValue = x.right.sValue + 1;
        }        
        return x;
    }
 
    /** Function to delete minimum element **/
    public int deleteMin( )
    {
        if (isEmpty() )
            return -1;
        int minItem = root.element;
        root = merge(root.left, root.right);
        return minItem;
    }
 
    /** Inorder traversal **/
    public void inorder()
    {
        inorder(root);
        System.out.println();
    }
    private void inorder(LeftHeapNode r)
    {
        if (r != null)
        {
            inorder(r.left);
            System.out.print(r.element +" ");
            inorder(r.right);
        }
    }
}
 
/** Class LeftistHeapTest **/
public class LeftistHeapTest
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("LeftistHeap");        
        LeftistHeap lh = new LeftistHeap();
 
        char ch;
        /**  Perform LeftistHeap operations  **/
        do    
        {
            System.out.println("Leftist Heap Operations\n");
            System.out.println("1. insert ");
            System.out.println("2. delete min");
            System.out.println("3. check empty");            
            System.out.println("4. clear");
 
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                lh.insert( scan.nextInt() );                                    
                break;                          
            case 2 : 
                lh.deleteMin();
                break;                         
            case 3 : 
                System.out.println("Empty status = "+ lh.isEmpty());
                break;   
            case 4 : 
                lh.clear();
                break;           
            default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /** Display heap **/
            System.out.print("\nInorder Traversal : ");
            lh.inorder();  
 
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');  
    }
}