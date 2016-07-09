#include <stdio.h>
#define true 1
#define false 0

int partition(int a[])
{
	int n=sizeof(a)/sizeof(a[0]);
	int i,sum=0,j;
	for(i=0;i<n;i++)
		sum+=a[i];
	if(sum%2!=0)
		return 0;
	int part[sum/2+1][n+1];

	// Fill the partition table in botton up manner 
     for (i = 1; i <= sum/2; i++)  
     {
       for (j = 1; j <= n; j++)  
       {
         part[i][j] = part[i][j-1];
         if (i >= a[j-1])
           part[i][j] = part[i][j] + part[i - a[j-1]][j-1];
       }        
     }    
     
     // uncomment this part to print table 
     for (i = 0; i <= sum/2; i++)  
     {
       for (j = 0; j <= n; j++)  
          printf ("%4d", part[i][j]);
       printf("\n");
     } 

     return 0;
     
}
int main()
{
	int a[]={1,5,11,5};
	partition(a);
}
