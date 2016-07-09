import java.io.*;
import java.util.*;

public class ReadWord{
	public static void main(String[] args) {

		Scanner f=null;
		String[] words=null;
        //char [] tokens = new char[];

		try {
            f = new Scanner(new File("story.txt"));
             while (f.next() != null){
            String input = f.nextLine();
            words = input.split(" ");
            System.out.println(words);
            
         	
               
        }


        } catch (FileNotFoundException e) {
            System.out.println("unable to open file");
            e.printStackTrace();
        }
       

	
		
	}
}
