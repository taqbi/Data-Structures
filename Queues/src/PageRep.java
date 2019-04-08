import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
public class PageRep {
	static int inputString[] = new int[] {5,2,3,4,1,8,9,3,1,2,4,5,3,6,1,2,3,1,5,6};
	public static Queue<Integer> window = new LinkedList<Integer>();
	static int  WindSize;
	static int hit = 0, miss;
	//Function to push the first n elements into the window
	public static void init()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Window Size");
		WindSize = sc.nextInt();
		miss = WindSize+1;
		for(int i=0;i<WindSize;i++)
		{
			window.add(inputString[i]);
			
		}
	
	}
	//Main Function for page Replacement
	public	static boolean look(int index)
		{
			return window.contains(index);
			
		}
	
	public static void pageReplace()
	{
		int index = 0;
		for(int i = WindSize+1;i<20;i++)
		{
			index = inputString[i];
			if(look(index))
			{
				hit++;
				
			}
			else
			{
				miss++;
				window.remove(window.peek());
				window.add(index);
				
			}
			
		}
		
		
	}
	public static void printres()
	{
		System.out.println("Total Number of Page faults are : " + miss + "  and hits are : "  + hit);
	}

}
