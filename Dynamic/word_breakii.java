public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> dp[]=new ArrayList[s.length()+1];
        dp[0]=new ArrayList<String>();
        for(int i = 0 ; i < s.length(); i++)
        {
            if(dp[i]==null)
                continue;
            for(String word: wordDict)
            {
                int len = word.length();
                int end = i+len;
                if(end > s.length())
                    continue;
                if(s.substring(i,end).equals(word))
                {
                    if(dp[end]==null)
                    {
                        dp[end]=new ArrayList<String>();
                    }
                    dp[end].add(word);
                }
            }
        }
        List<String> result = new LinkedList<String>();
        if(dp[s.length()]==null)
            return result;
        List<String> temp = new ArrayList<>();
        dfs(dp,s.length(),result,temp);
        return result;
    }
    
    public void dfs(List<String> dp[], int end, List<String> result, List<String> temp)
    {
        if(end <= 0)
        {
            String path = temp.get(temp.size()-1);
            for(int i = temp.size()-2; i>=0; i--)
            {
                path+=" "+temp.get(i);
            }
            result.add(path);
            return;
        }
        for(String str: dp[end])
        {
            temp.add(str);
            dfs(dp,end-str.length(),result,temp);
            temp.remove(temp.size()-1);
        }
    }
}