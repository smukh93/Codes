import java.util.*;
public class SearchRange{
    public static ArrayList<Integer> searchRange(final List<Integer> A, int B) {
        //System.out.print("Entering function");
        ArrayList<Integer> result = new ArrayList<Integer>();
        //find index of the target
        int start = 0;
        int end = A.size() - 1;
        int mid = 0;
        int rStart = -1;
        while(start < end){
            mid = start +  (end - start)/2;            
            if(B > A.get(mid)){
                start = mid + 1;
            }
            else
                end = mid;
        }
        
        int low;
        if(B != A.get(start)){
            result.add(-1);
            result.add(-1);
            return result;
        }
        else 
            low = start;
      //now find loose upper bound and lower bound   
        start = 0;
        end = A.size() -1;
        while(start < end){
            mid = start + (end - start)/2;
            if(A.get(mid) < B + 1)
                start = mid + 1;
            else
                end = mid;
        }
        
        int high = 0;
        if(A.get(start) == B)
            high = start;
        else
            high = start - 1;
        System.out.print(low + " " + high);
        result.add(low);
        result.add(high);
        return result;
    }
    public static void main(String[] args){
        int B = Integer.parseInt(args[0]);
        List<Integer> A = new ArrayList<Integer>();
        A.add(5);
        A.add(7);
        A.add(7);
        A.add(8);
        A.add(8);
        A.add(10);
        ArrayList<Integer> result = searchRange(A, B);
        for(int i =0; i< result.size(); i++)
            System.out.print(result.get(i) + " ");
    }
}