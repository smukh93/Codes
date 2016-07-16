public class Solution {
    public boolean isMatch(final String s, final String p) {
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();

        
        int rightIndex = 0;
        boolean isFirst = true;
        for ( int i = 0 ; i < pattern.length; i++) {
            if (pattern[i] == '*') {
                if (isFirst) {
                    pattern[rightIndex++] = pattern[i];
                    isFirst = false;
                }
            } else {
                pattern[rightIndex++] = pattern[i];
                isFirst = true;
            }
        }

        boolean T[][] = new boolean[str.length + 1][rightIndex + 1];

        if (rightIndex > 0 && pattern[0] == '*') {
            T[0][1] = true;
        }

        T[0][0] = true;

        for (int i = 1; i < T.length; i++) {
            for (int j = 1; j < T[0].length; j++) {
                if (pattern[j-1] == '?' || str[i-1] == pattern[j-1]) {
                    T[i][j] = T[i-1][j-1];
                } else if (pattern[j-1] == '*'){
                    T[i][j] = T[i-1][j] || T[i][j-1];
                }
            }
        }

        return T[str.length][rightIndex];
    }
    
}

/*Improved Code*/
/*without using space  Time : O(n) Space O(1) */

/*Loop

keep two pointers in S and P here i and j

if S[i] == P[j] or P[j] == '?' we keep moving

if '*' exist in P then we mark the position in P as star and mark position in s as s_star

Loop over s until S[i] == P[star + 1]
otherwise
False

note that S = 'a' P = 'a*******' is still True
So we need to loop over P to check this case

if we can compare p to the end that means True
*/
public class Solution {
    public boolean isMatch(final String s, final String p) {
        int i = 0;
        int j = 0;
        int star = -1;
        int s_star = 0;
        int s_len = s.length();
        int p_len = p.length();
        while(i < s_len){
            if(i < s_len && j < p_len && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'))
            {
                i+=1;
                j+=1;
            }
            else if(j < p_len && p.charAt(j)=='*')
            {
                star = j;
                s_star = i;
                j+=1;
            }
            else if(star!=-1)
            {
                j = star+1;
                s_star+=1;
                i=s_star;
            }
            else
            {
                return false;
            }
        }
        while(j < p_len && p.charAt(j)=='*')
        {
            j=j+1;
        }
        return j==p_len;
    
}
}