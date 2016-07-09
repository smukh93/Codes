import java.util.*;

public class trailingZeros{
	public static int countZeros(int a)
	{
		int result = 0;
		while(a!=0)
		{
			int count = a/5;
			result += count;
			System.out.println("R: " +result);

			a = count;
		}
		return result;
	}

	public static void main(String[] args)
	{
		int a = 24 ;
		System.out.println(countZeros(a));
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