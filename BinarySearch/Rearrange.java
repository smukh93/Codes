import java.util.*;

public class Rearrange{
	static ArrayList<Integer> arrangeArray(ArrayList<Integer> a)
	{
		int n = a.size();
		for(int i = 0; i<a.size();i++)
		{
			a.set(i, (a.get(a.get(i)) % n )*n + a.get(i));
		}
		for(int i = 0; i<a.size();i++)
		{
			a.set(i,a.get(i) / n);
		}
		return a;
	}

	public static void main(String[] args)
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(3);
		a.add(2);
		a.add(0);
		for(int value : a)
			System.out.println(value);
		System.out.println();
		arrangeArray(a);
		for(int value : a)
			System.out.println(value);
	}
}


/* Steps of execution : 

say a = 5 

count = 5/5 = 1
result = 1
a = count = 1

next step : count = 1/5 = 0
result = 1 + 0 = 1
a = 0 

next: 
a = 0
exit conidition

*/