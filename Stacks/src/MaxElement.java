import java.util.*;
public class MaxElement {		
	static Stack<Integer> s1 = new Stack<Integer>();
	static Stack<Integer> s2 = new Stack<Integer>();
	static int max=0;
	static void Push()
	{ 
		Scanner sc =  new Scanner(System.in);
		System.out.println("Enter the Elemnt to be pushed : ");
		int	n = sc.nextInt();
		if(s1.empty())
		{
		s1.push(n);
		s2.push(n);
		max = n;
		}
		else {
			s1.push(n);
			if(n>=s2.peek())
				s2.push(n);
			max = s2.peek();
		}
	}
	static void Pop()
	{
		if(s1.empty())
		{
		System.out.println("Stack is Empty");
		}
		else {
			System.out.println("Element poped : " + s1.peek());
				if(s1.peek()<s2.peek())
				{
					s1.pop();
				
				}
				else
				{
					s1.pop();
					s2.pop();
					max = s2.peek();
					
				}
		      }
		

	  }
	public static void main(String args[])  
	{
		
		for(int i=0;i<5;i++)
				{
					Push();
					System.out.println("The Maximum Elemnet in the Stack is : "+ max);
					
				}
		for(int i=0;i<5;i++)
				{
					Pop();
					System.out.println("The Maximum Elemnet in the Stack is : "+ max);
					
				}
		
		
			}
		
	
	}

