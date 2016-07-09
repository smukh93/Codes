 
 #include<stdio.h>
 #define max(a,b) (a > b) ? a : b 
int coverPoints(int* X, int n1, int* Y, int n2) {
    int i;
    int currentX = X[0];
    int currentY = Y[0];
    int totalstep = 0;
    for(i=1; i<n1; i++)
    {
        totalstep+= max(abs(currentX - X[i]), abs(currentY - Y[i]));
        printf("%d\n", totalstep );
        currentX = X[i];
        currentY = Y[i];
    }
    return totalstep;
}

int main()
{
    int X[3]={0,1,2};
    int Y[3]={0,2,2};
    int Z = coverPoints(X,3,Y,3);
    printf("%d \n", Z );
}