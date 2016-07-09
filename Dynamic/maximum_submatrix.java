public class Solution {
    public int maximalRectangle(char[][] matrix) {
        int area = 0;
        if(matrix == null || matrix.length==0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][]s=new int[m][n];
        for(int i = 0; i < m ; i++)
        {
            for(int j = 0; j < n ; j++)
            {
                if(matrix[i][j]=='1')
                {
                    s[i][j]= (i==0)? 1 : s[i-1][j]+1;
                }
                else
                {
                    s[i][j]=0;
                }
            }
        }
            for(int i = 0; i < m ; i++)
            {
                area = Math.max(area,largestRectangleArea(s[i]));
            }
            return area;
    }
     public int largestRectangleArea(int[] heights) {
        if(heights==null || heights.length==0)
            return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        int i = 0;
        while( i < heights.length)
        {
            if(stack.isEmpty() || heights[stack.peek()]<=heights[i])
            {
                stack.push(i);
                i++;
            }
            else
            {
                int height = heights[stack.pop()];
                int width = stack.isEmpty()? i : i-stack.peek()-1;
                max = Math.max(max,height*width);
            }
        }
        while(!stack.isEmpty())
        {
                int height = heights[stack.pop()];
                int width = stack.isEmpty()? i : i-stack.peek()-1;
                max = Math.max(max,height*width);
        }
        return max;
        
    }
}