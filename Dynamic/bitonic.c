#include<stdio.h>


#define maxx(a,b) ((a>b)?  a: b)
int longestBitonicSubsequence(int arr[],int n)
{
	int lis[n],lds[n],i,j;
	for(i=0;i<n;i++)
	{
		lis[i]=lds[i]=1;
	}
	
	int max=0;
	
	//Calculating the lis: left sum
	for(i=1;i<n;i++)
	{
		for(j=0;j<i;j++)
		{
			if(arr[i]>arr[j])
				lis[i]=maxx(lis[i],lis[j]+1);
		}
	}
	
	//Calculating lds: right sum
	for(i=n-2;i>=0;i--)
	{
		for(j=n-1;j>i;j--)
		{
			if(arr[i]>arr[j])
				lds[i]=maxx(lds[i],lds[j]+1);
		}
	}
	
	for(i=0;i<n;i++)
	{
		if(max<lis[i]+lds[i]-1)
			max=lis[i]+lds[i]-1;
	}
	
	return max;
}



int main()
{
	int n;
	int arr[8]={2,-1,4,3,5,-1,3,2};
	n=sizeof(arr)/sizeof(arr[0]);
	printf("The max length is :  %d\n",longestBitonicSubsequence(arr,n));
	return 0;
}

