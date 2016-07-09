#include<stdio.h>
#include<string.h>

#define maxx(a,b) ((a>b)?a:b)

int pallindromeSubsequence(char a[],int n)
{
	
	//printf("%d", n);
	int pallindrome_length[n][n];
	int i,j,l;

	 for(i = 0;i < n;i++)
 	 {
		for(j = 0; j < n;j++)
		{
		pallindrome_length[i][j]=0;
		}
		
	}


	
	for(i=0;i<n;i++)
		pallindrome_length[i][i]=1;

	 
	

	for(l=2;l<=n;l++)
	{
		for ( i = 0; i < n-l+1; i++)
		{
			j=i+l-1;
			//printf(" l: %d  i: %d j: %d\n",l,i,j);
			if(a[i]==a[j])
				pallindrome_length[i][j]=pallindrome_length[i+1][j-1]+2;
			else
				pallindrome_length[i][j]=maxx(pallindrome_length[i+1][j],pallindrome_length[i][j-1]);
			
		}

		
	
	}


	printf("\n The Final Matrix: \n");
	//int i,j;
	  for(i = 0;i < n;i++)
 	 {
		for(j = 0; j < n;j++)
		{
		printf("%d  ", pallindrome_length[i][j] );
		}
		printf("\n");
	} 
	printf("\n The maximum length of the pallidromic Subsequence is:  %d \n \n", pallindrome_length[0][n-1] );
}

int main(){
	char word[100];
	printf("Enter the word: ");
	scanf("%s",word);

	int length=strlen(word);

	pallindromeSubsequence(word,length);


}