import java.util.*;
public class ExcelColumn {
    public static int BASE = 26;
    public static int START = 1;
	public static int titleToNumber(String a) {
	    int result = 0;
	    for(int i=0;i<a.length();i++)
	    {
	        char ch=a.charAt(i);
	        result  = result * BASE + (ch - 'A' + START);
	    }
	    return result;
	}

	public static void main(String[] args)
	{
		String a = "AB";
		System.out.println(titleToNumber(a));
	}
}
