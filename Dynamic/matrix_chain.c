#include<stdio.h>
#define INT_MAX 999

//display
/*
void display(int k,int a[k][k])
{
int i,j;
for(i=0;i<k;i++){
	for(j=0;j<k;j++)
	printf("%d ",a[i][j]);
 printf("\n");
}
}
*/

void mchain(int *p,int n)
{
	//printf("\n ... ");
	int m[1000][1000];
	int s[1000][1000];
	int i,j,k,l,q;
	
	for(i=1;i<n;i++)
		m[i][i]=0;

	/*printf( " M \n ");


	for(i=0;i<n;i++){
	for(j=0;j<n;j++)
	printf("%d ",m[i][j]);
	printf("\n");
	}*/


	for(l=2;l<n;l++)
	{
		for(i=1;i<=n-l+1;i++)
		{
				j=i+l-1;
				m[i][j]=999999;
			for(k=i;k<j;k++)
			{
				q=m[i][k]+m[k+1][j]+(p[i-1]*p[k]*p[j]);
				if(q<m[i][j])
				{
					m[i][j]=q;
					s[i][j]=k;
				}
			}	
		}	
	}

	//printing m

	//display(n,m);
	//display(n,s);

	printf( " M\n ");


	for(i=1;i<n;i++){
	for(j=1;j<n;j++)
	printf("%d   ",m[i][j]);
printf("\n");
}


	//printing s

	
 	printf( " S\n ");

	for(i=1;i<n;i++){
	for(j=1;j<n;j++)
	printf("%d    ",s[i][j]);
printf("\n"); 
}

}


int main()
{

	FILE *fp;
	char file[100];

	printf("Enter file name: ");
	scanf("%s",file);

	fp=fopen(file,"r");
	int n; // n is the number of elements in the array to be read

	int p[10000]; // array storing the elements 


	int k=0,i; // k is the total number of elements in the array and i is the ith order statistics 

	if(fp==NULL)
	{ 
		perror("Error while opening the file! ");
		//exit(EXIT_FAILURE);
	}

		while(fscanf(fp,"%d ",&n)>0)
		{
			p[k]=n;
			k++;
		}

	fclose(fp);	

	for(i=0;i<k;i++)
		printf("%d ",p[i]);

	mchain(p,k); //calling function for chain multiplication





	return 0;

}

