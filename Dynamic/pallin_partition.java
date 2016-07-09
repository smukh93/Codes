public class Solution {
    public int minCut(String s) {
        
        if(s.length() <= 1)
            return 0;
        int n = s.length();
        int[]cuts = new int[n];
        boolean[][] pal = new boolean[n][n];
        for(int i = 0; i < n; i++)
            pal[i][i]=true;
        for(int l = 2; l <=n ; l++)
        {
            for(int i = 0; i < n-l+1; i++)
            {
                int j = i+l-1;
                if(l==2)
                {
                    pal[i][j]=(s.charAt(i)==s.charAt(j));
                }
                else
                {
                    pal[i][j]=(s.charAt(i)==s.charAt(j))&&pal[i+1][j-1];
                }
            }
        }
        for(int i = 0; i < n; i++)
        {
            if(pal[0][i])
                cuts[i]=0;
            else
            {
                cuts[i]=Integer.MAX_VALUE;
                for(int j =0; j < i; j++)
                {
                    if(pal[j+1][i] && (cuts[i] > cuts[j]+1))
                    {
                        cuts[i]=cuts[j]+1;
                    }
                }
            }
        }
        return cuts[n-1];
    }
}