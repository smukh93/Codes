#include <stdio.h>


void countBinaryTreeGivenNKeys(int n)
{
	int T[n+1];
	
	int i,j;

	for(i=0;i<=n;i++)
	{
		T[i] = 0;
	}
	T[0]=T[1]=1;

	for(i=2;i<=n;i++)
	{
		for(j=0;j<i;j++)
		{
			T[i]+=T[j]*T[i-j-1];
		}


	}

	for(i=0;i<=n;i++)
	{
		printf(" %d ", T[i] );
	}

	printf("\nThe number of Binary Search Trees that can be formed are: %d \n", T[n]);
}
		
int main()
{
	int n;
	printf("Enter the number of keys: \n");
	scanf("%d",&n);
	countBinaryTreeGivenNKeys(n);
	return 0;
}