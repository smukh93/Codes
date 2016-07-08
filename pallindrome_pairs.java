public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) 
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        for(int i = 0 ; i < words.length; i++)
            map.put(words[i],i);
        for(int i = 0; i < words.length; i++)
        {
            String s = words[i];
            if(isPalindrome(s))
            {
                if(map.containsKey(""))
                {
                    if(map.get("")!=i)
                    {
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(i);
                        l.add(map.get(""));
                        result.add(l);

                        l = new ArrayList<Integer>();
                        l.add(map.get(""));
                        l.add(i);
                        result.add(l);
                    }
                }
            }
            String reversed = new StringBuilder(s).reverse().toString();
            if(isPalindrome(s))
            {
                if(map.containsKey(reversed))
                {
                    if(map.get(reversed)!=i)
                    {
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(i);
                        l.add(map.get(reversed));
                        result.add(l);
                    }
                }
            }
            for(int k = 1; k < s.length(); k++)
            {
                String left = s.substring(0,k);
                String right = s.substring(k);
                if(isPalindrome(left))
                {
                    String revRight = new StringBuilder(left).reverse().toString();
                    if(map.containsKey(revRight))
                    {
                        if(map.get(revRight)!=i)
                        {
                            List<Integer> l = new ArrayList<Integer>();
                            l.add(map.get(revRight));
                            l.add(i);
                            result.add(l);
                        }
                    }
                }

                if(isPalindrome(right))
                {
                    String revLeft = new StringBuilder(right).reverse().toString();
                    if(map.containsKey(revLeft))
                    {
                        if(map.get(revLeft)!=i)
                        {
                            List<Integer> l = new ArrayList<Integer>();
                            l.add(i);
                            l.add(map.get(revLeft));
                            result.add(l);
                        }
                    }
                }
            }
        }
        return result;
    }
    
    public boolean isPalindrome(String s)
    {
        int i = 0;
        int j = s.length()-1;
        while( i < j)
        {
            if(s.charAt(i) != s.charAt(j) )
            {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}