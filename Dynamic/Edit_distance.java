public class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if(len1==0)
            return len2;
        if(len2==0)
            return len1;
        int[][]table = new int[len1+1][len2+1];
        for(int i = 1; i <=len1; i++)
        {
            table[i][0]=i;
        }
        for(int j = 1; j <=len2; j++)
        {
            table[0][j]=j;
        }
        for(int i = 0; i <len1; i++)
        {
            for(int j = 0 ; j <len2; j++)
            {
                table[i+1][j+1]=Math.min(table[i][j+1],table[i+1][j])+1;
                if(word1.charAt(i)==word2.charAt(j))
                {
                    table[i+1][j+1]=Math.min(table[i+1][j+1],table[i][j]);
                }
                else
                {
                    table[i+1][j+1]=Math.min(table[i+1][j+1],table[i][j]+1);
                }
            }
        }
        return table[len1][len2];
    }
}