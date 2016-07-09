import java.util.*;

public class onlyAdd{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		System.out.println("The numbers are: " +a + " " +b);
		System.out.println("The sum is : " +sum(a,b));
		System.out.println("The difference is : " +diff(a,b));
		System.out.println(mult(a,b));
		//System.out.println(div(a,b));
		
	}

	static int negate(int b)
	{
		/*int neg = 0;
		int d = b > 0 ? -b : b;
		while(b!=0)
		{
			neg+=d;
			b+=d;
		}
		return neg;*/
		int x = -b;
		return x;
	}
	static int sum(int a , int b)
	{
		return a+b;
	}
	static int diff(int a , int b)
	{
		return a+negate(b);
	}
	static int mult(int a , int b)
	{
		int sum = 0;
		int x = 0;
		if(b < 0)
			 x = negate(b);
		else 
			x = b;
		while(x>0)
		{
			sum+=a;
			x--;
			
		}
		if(b < 0)
			return negate(sum);
		else
			return sum;
	}
}