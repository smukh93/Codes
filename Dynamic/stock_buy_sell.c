#include<stdio.h>
#define maxx(a,b) ((a<b)?b:a)


//The implementation is bit slower , optimization can be done 

/*
maxVal=0;
			for(m=0;m<j;m++)
			{
				maxVal=maxx(maxVal,((prices[j]-prices[m])+t[i-1][m]));
			}
			t[i][j]=maxx(maxVal,t[i][j-1]);

O(transactions*days^2);
*/


//Complexity: O(transations*days)

int maximizeStockProfit(int prices[],int days,int transactions)
{
	int t[transactions+1][days];
	int i,j,m,maxVal;

	for(i=0;i<=transactions;i++)
		t[i][0]=0;
	for(i=0;i<days;i++)
		t[0][i]=0;
	for(i=1;i<=transactions;i++)
	{
		maxVal=-prices[0];
		for(j=1;j<days;j++)
		{
			t[i][j]=maxx(t[i][j-1],prices[j]+maxVal);
			maxVal=maxx(t[i-1][j]-prices[j],maxVal);
		}
	}


	printf("\n The Final Matrix: \n");
	//int i,j;
	  for(i = 0;i <= transactions;i++)
 	 {
		for(j = 0; j < days;j++)
		{
		printf("%d  ", t[i][j] );
		}
		printf("\n");
	}

	printf("The maximum profit : %d \n",t[transactions][days-1]);

	return 0;
}

int main()
{
	int days,transactions,k,i;
	printf("Days: ");
	scanf("%d",&days);
	printf("How many transactions: ");
	scanf("%d",&transactions);
	
	int prices[days];
	for(i=0;i<days;i++)
	{
		printf("Enter Stock Price for day [ %d ]: ",i);
		scanf("%d",&prices[i]);
	}
	maximizeStockProfit(prices,days,transactions);
	return 0;
}