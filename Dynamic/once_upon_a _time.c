#include<stdio.h>


int max(int a,int b)
{

 if(a>b)

return a;

else

return b;

}

void findmax(int a[],int n,int k)
{
int dp[n+1];

int i;

for(i=1;i<=k;i++)
dp[i]=max(a[i-1],dp[i-1]);
for(i=k+1;i<=n;i++)
dp[i]=max(dp[i-1],a[i-1]+dp[i-k-1]);

printf("%d", dp[n]);


}

int main()
{

 int a[]={1,2,-3,-5,4,6,-3,2,-1,2};
 int n=sizeof(a)/sizeof(a[0]);
 int k=2;
 findmax(a,n,k);
 return 0;
}
