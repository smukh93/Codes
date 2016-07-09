import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class dictionary{
	public static void main(String [] args) throws IOException{
		BufferedReader reader=new BufferedReader(new FileReader(new File("words.txt")));
		String inputLine=null;
		Map dictionary_create=new HashMap();

		while((inputLine = reader.readLine()) != null){
			String [] words=inputLine.split("\\s+");

			if(inputLine.equals(""))
				continue;
			for(String word: words)
			{
				word=word.replace(",","");
				word=word.replace(".","");

			

				if(dictionary_create.containsKey(word)){
					Integer no_of_times=dictionary_create.get(word);
					dictionary_create.put(word,no_of_times+1);
				}
				else
					dictionary_create.put(word,1);
			}
		}

		for(String key: dictionary_create.keySet())
			System.out.println(key + " : " + dictionary_create.get(key));
		reader.close();

	}
}
