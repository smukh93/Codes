import java.util.*;
import java.io.*;


public class waveArray{
	public static void main(String[] args)
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(10);
		a.add(5);
		a.add(6);
		a.add(3);
		a.add(2);
		a.add(20);
		a.add(100);
		a.add(80);
		System.out.println(wave(a));		
	}

	static ArrayList<Integer> wave(ArrayList<Integer> a)
	{
		Collections.sort(a);
		for(int i = 0 ; i < a.size()-1; i++)
		{
			if(i > 0 && a.get(i)< a.get(i-1))
				swap(a,i,i-1);
			if( a.get(i) < a.get(i+1))
				swap(a,i,i+1);
		}
		return a;
	}
	static void swap(ArrayList<Integer>a, int i , int j)
	{
		int temp = a.get(i);
		a.set(i,a.get(j));
		a.set(j,temp);
	}
}