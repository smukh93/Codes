#include<stdio.h>

int no_of_ways(int rows,int columns)
{
	int ways[rows][columns];
	int i,j;

	for(i=0;i<rows;i++)
		ways[i][0]=1;
	for(j=0;j<columns;j++)
		ways[0][j]=1;
	for(i=1;i<rows;i++)
	{
		for(j=1;j<columns;j++)
			ways[i][j]=ways[i-1][j]+ways[i][j-1];
	}


  for(i = 0;i < rows; i++ )
  {
	for(j = 0; j < columns ;j++ )
	{
	printf("  %d  ", ways[i][j] );
	}
	printf("\n");
}

	printf("\n The number of ways we can reach from top left to bottom right is: %d \n",  ways[rows-1][columns-1]);
	return 0;
}

int main()
{
	/* code */
	int rows,columns;
	printf("ENTER ROWS: \n");
	scanf("%d",&rows);
	printf("ENTER COLUMNS: \n");
	scanf("%d",&columns);
	no_of_ways(rows,columns);
	return 0;
}