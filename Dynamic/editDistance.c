#include<stdio.h>
#include<string.h>

int mini(int a,int b,int c)
{
	if(a<b && a<c)
		return a;
	if(b<c && b<a)
		return b;
	if(c<a && c<b)
		return c;

}

void editDistance(char *x,char *y, int m , int n)
{
 
 int columns,rows;
 columns=m;
 rows=n;

 int edit_Distance[rows+1][columns+1];
 int i,j;


 
 for(i=0;i<=columns;i++){
 	edit_Distance[0][i]=i;
 }
 	

 for(i=0;i<=rows;i++){
 	
 	edit_Distance[i][0]=i;
 }
 	

 for(i = 1;i <= rows; i++ )
  {
	for(j = 1; j <= columns ;j++ )
	{
		 if( x[i-1] == y[j-1] )
			edit_Distance[i][j]=(edit_Distance[i-1][j-1]);
		else {
				edit_Distance[i][j]=mini(edit_Distance[i-1][j-1],edit_Distance[i-1][j],edit_Distance[i][j-1])+1;			 
		     }

        }

  }

  for(i = 0;i <= rows; i++ )
  {
	for(j = 0; j <= columns ;j++ )
	{
	printf("%d  ", edit_Distance[i][j] );
	}
	printf("\n");
}

	printf("\n The minimum number of edits are: %d \n", edit_Distance[rows][columns]);
}
			  
int main()
{

char x[100],y[100];

printf("Enter string 1: ");
scanf("%s",x);

printf("Enter string 2: ");
scanf("%s",y);

int m=strlen(x);
int n=strlen(y);

editDistance(x,y,m,n);
return 0;
}
