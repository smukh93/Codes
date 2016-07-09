#include<stdio.h>

#define MAX(a,b) ((a>b)?a:b)


#define overlap(a,b) ((a<=b)?1:0)

int optimal_job_schedule(int start_time[],int finish_time[],int profit[],int no_of_jobs)
{
	int i,j;
	int temp[no_of_jobs];
	temp[0]=profit[0];
	for(i=1;i<no_of_jobs;i++)
	{
		temp[i]=MAX(profit[i],temp[i-1]);
		for(j=i-1;j>=0;j--)
		{
			if(overlap(finish_time[j],start_time[i]))
			{
				temp[i]=MAX(temp[i],temp[j]+profit[i]);
				break;
			}
		}

	}
	int max_profit=0;
	for(i=0;i<no_of_jobs;i++)
	{
		if(max_profit<temp[i])
			max_profit=temp[i];
	}

	return max_profit;
}


int main()
{
	int no_of_jobs,i;
	printf("Number of jobs that are to be scheduled: ");
	scanf("%d",&no_of_jobs);
	int start_time[no_of_jobs],finish_time[no_of_jobs],profit[no_of_jobs];
	for ( i = 0; i < no_of_jobs; ++i)
	{
		/* code */
		printf("Enter start_time of job [ %d ]: ", i );
		scanf("%d",&start_time[i]);
		printf("Enter finish_time of job [ %d ]: ", i );
		scanf("%d",&finish_time[i]);
		printf("Enter profit of job [ %d ]: ", i );
		scanf("%d",&profit[i]);
		printf("\n");
			
	}

	printf("The maximum profit is : %d\n" ,optimal_job_schedule(start_time,finish_time,profit,no_of_jobs));
}