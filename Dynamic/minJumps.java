import java.util.*;
import java.io.*;


public class minJumps{
	public static void main(String[] args)
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(2);
		a.add(3);
		a.add(1);
		a.add(1);
		a.add(2);
		a.add(4);
		a.add(2);
		a.add(0);
		a.add(1);
		a.add(1);
		System.out.println(min_jumps(a));		
	}

	static int min_jumps(ArrayList<Integer> a)
	{
		int n = a.size();
		int []jumps = new int[n];
		int []paths = new int[n];
		jumps[0]=0;
		paths[0]=-1;
		if(n == 0 || a.get(0)==0)
			return 0;
		for(int i = 1;i<n;i++)
		{
			jumps[i]=Integer.MAX_VALUE;
			for(int j = 0 ; j <= i; j++)
			{
				if( i <= (j + a.get(j)) && jumps[j]!=Integer.MAX_VALUE)
				{
				jumps[i]=jumps[j]+1;
				paths[i]=j;
				break;
				}
				
			}
		}
		//print_path(paths);
		//print_jumps(jumps);
		return jumps[n-1];
	}
	/*public static void print_path(int[] paths)
	{
		for(int i = 0; i < paths.length(); i++)
			System.out.println(paths[i]+" ");
	}


	public static void print_jumps(int[] jumps)
	{
		for(int i = 0; i < jumps.length(); i++)
			System.out.println(jumps[i]+" ");
	}*/

	
	
}