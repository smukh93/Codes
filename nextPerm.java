import java.util.*;
import java.io.*;


public class nextPerm{
	public static void main(String[] args)
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		/*a.add(3);
		a.add(2);
		a.add(1);
		*/
		a.add(4);
		a.add(1);
		a.add(2);
		a.add(3);/*
		a.add(1);
		a.add(5);
		a.add(7);*/
		System.out.println(nextPermutation(a));		
	}

	static ArrayList<Integer> nextPermutation(ArrayList<Integer> a)
	{
		boolean status;
		status = nextPerm(a);

		if(!status)
			Collections.sort(a);
		return a;
	}
	static boolean nextPerm(ArrayList<Integer>a)
	{
		int i = 0;
		int n = a.size();
		int k = 0;
		for(k = n-2; k >=0 ; k--)
		{ 
			if(a.get(k) < a.get(k+1))
				break;
		}
		//System.out.println(k);
		if(k==-1)
			return false;
		int l = n-2;
		for(;l>=k;--l)
		{
			if(a.get(l) < a.get(l+1))
				break;
		}

		//System.out.println(l);
		swap(a,k,l);
		++k;

		//System.out.println(k);
		int steps = (n-k+1)/2;
		for (i = 0; i < steps ; ++i) {
			swap(a,i+k,n-i-2);			
		}
		//System.out.println(a);
		return true;
	}
	static void swap(ArrayList<Integer>a, int i , int j)
	{
		int temp = a.get(i);
		a.set(i,a.get(j));
		a.set(j,temp);
	}
}