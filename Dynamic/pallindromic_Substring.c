#include<stdio.h>
#include<string.h>
#include<limits.h>

#define min(a,b) ((a>b)?b:a)
#define true 1
#define false 0

int pallindromicSubstring(char a[],int n)
{
	
	//printf("%d", n);
	
	int pallindromic_Substring[n][n];
	int i,j,l;
	int max=1;
	
	for(i = 0;i < n;i++)
 	 {
		for(j = 0; j < n;j++)
		{
		pallindromic_Substring[i][j]=0;
		}		
	}


	for(i=0;i<n;i++)
	{
		pallindromic_Substring[i][i]=1;
		if(a[i]==a[i+1])
		{
			pallindromic_Substring[i][i+1]=1;
			max=2;
		}
		else
			pallindromic_Substring[i][i+1]=0;
	}
	
	 
	

	for(l=2;l<=n;l++)
	{
		for ( i = 0; i < n-l+1; i++)
		{
			j=i+l-1;
                if((a[i] == a[j]) && pallindromic_Substring[i+1][j-1])
                {
                	pallindromic_Substring[i][j]=1;
                	max=l;
                }

            else
            	pallindromic_Substring[i][j]=0;
			}
		}

			//printf(" l: %d  i: %d j: %d\n",l,i,j);
		
	printf("\n The Final Matrix: \n");
	//int i,j;
	  for(i = 0;i < n;i++)
 	 {
		for(j = 0; j < n;j++)
		{
		printf("%d  ", pallindromic_Substring[i][j] );
		}
		printf("\n");
	}
	printf("\n Max length is %d\n \n", max );
}

int main(){
	char word[100];
	printf("Enter the word: ");
	scanf("%s",word);

	int length=strlen(word);

	pallindromicSubstring(word,length);


}