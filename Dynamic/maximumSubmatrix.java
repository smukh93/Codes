public class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = 0;
        if(m > 0)
        {
            n = matrix[0].length;
        }
        if(n*m==0)
            return 0;
        int M = Math.max(n,m);
        int N = Math.min(n,m);
        int ans = Integer.MIN_VALUE;
        for(int x = 0; x < N; x++)
        {
            int sums[]=new int[M];
            for(int y = x; y < N; y++)
            {
                TreeSet<Integer> set = new TreeSet<>();
                int num = 0;
                for(int z = 0; z < M; z++)
                {
                    sums[z]+=m>n?matrix[z][y]:matrix[y][z];
                    num+=sums[z];
                    if(num <=k)
                        ans=Math.max(ans,num);
                    Integer i = set.ceiling(num-k);
                    if(i!=null)
                        ans=Math.max(ans,num-i);
                    set.add(num);
                }
            }
        }
        return ans;
    }
}