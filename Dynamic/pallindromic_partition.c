#include<stdio.h>
#include<string.h>
#include<limits.h>

#define min(a,b) ((a>b)?b:a)
#define true 1
#define false 0

int pallindromicPartition(char a[],int n)
{
	
	//printf("%d", n);
	int P[n][n];
	int pallindromic_Partition[n][n];
	int i,j,l;

	 for(i = 0;i < n;i++)
 	 {
		for(j = 0; j < n;j++)
		{
		pallindromic_Partition[i][j]=0;
		}		
	}


	
	for(i=0;i<n;i++){
		pallindromic_Partition[i][i]=0;
		P[i][i]=true;
	}

	 
	int k;

	for(l=2;l<=n;l++)
	{
		for ( i = 0; i < n-l+1; i++)
		{
			j=i+l-1;
			

			if (l == 2)
                P[i][j] = (a[i] == a[j]);
            else
                P[i][j] = (a[i] == a[j]) && P[i+1][j-1];

            // IF str[i..j] is palindrome, then C[i][j] is 0
            if (P[i][j] == true)
                pallindromic_Partition[i][j] = 0;
           
			else
			{
				pallindromic_Partition[i][j]=INT_MAX;
				for( k = i ; k <= j-1 ; k ++)
				{
				
				pallindromic_Partition[i][j]=min(pallindromic_Partition[i][j],  
					pallindromic_Partition[i][k]+pallindromic_Partition[k+1][j]+1);
			
				}

			}
			

			//printf(" l: %d  i: %d j: %d\n",l,i,j);
		}
	}


	printf("\n The Final Matrix: \n");
	//int i,j;
	  for(i = 0;i < n;i++)
 	 {
		for(j = 0; j < n;j++)
		{
		printf("%d  ", pallindromic_Partition[i][j] );
		}
		printf("\n");
	}
	printf("\n Min cuts needed for Palindrome Partitioning is %d\n \n", pallindromic_Partition[0][n-1] );
}

int main(){
	char word[100];
	printf("Enter the word: ");
	scanf("%s",word);

	int length=strlen(word);

	pallindromicPartition(word,length);


}