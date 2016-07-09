#include<stdio.h>


int staircase(int n)
{
	int no_of_ways[n+1],i;
	no_of_ways[0]=0;
	no_of_ways[1]=1;

	for(i=2;i<=n;i++)
	{
		no_of_ways[i]=no_of_ways[i-1]+no_of_ways[i-2];
		//printf("%d \n",no_of_ways[i]);

	}

	return no_of_ways[n];

}

int main()
{
	int no_of_stairs;
	printf("Enter number of stairs: ");
	scanf("%d", &no_of_stairs);
	
	printf("The number of ways is : %d\n", staircase(no_of_stairs+1) );
}

