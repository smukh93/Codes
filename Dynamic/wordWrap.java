public class wordWrap{
	public String justify(String words[],int width){

		int cost[][]=new int[words.length][words.length];



		for (int i=0; i<words.length ; i++ ) {
			cost[i][i]=width-words[i].length();
			for (int j=i+1;j<words.length ;j++ ) {
				cost[i][j]=cost[i][j-1]-words[j].length()-1;
			}
		}


        for(int i=0 ; i < words.length; i++)
        {
            cost[i][i] = width - words[i].length();
            for(int j=i+1; j < words.length; j++){
                cost[i][j] = cost[i][j-1] - words[j].length() - 1; 
            }
        }


		for (int i=0; i<words.length ; i++ ) {
			for (int j=i;j<words.length ;j++ ) {
				if(cost[i][j] < 0)
					cost[i][j]=Integer.MAX_VALUE;
				else
					cost[i][j]=(int)Math.pow(cost[i][j],2);
			}
		}



		for (int i=0; i<words.length ; i++ ) {
			for (int j=0;j<words.length ;j++ ) {
				System.out.printf(" %5d " , cost[i][j]);
			}
			System.out.println();
		}


		int min[]=new int[words.length];
		int result[]=new int[words.length];

		for(int i=words.length-1;i>=0;i--)
		{
			min[i]=cost[i][words.length-1];
			result[i]=words.length;
			for (int j=words.length-1;j>i ;j--) {
				if(cost[i][j-1] == Integer.MAX_VALUE)
					continue;
				else
				{
					if(min[i] > min[j]+cost[i][j-1])
					{
						min[i]=min[j]+cost[i][j-1];
						result[i]=j;
					}
				}				
			}
		}

		System.out.println("The minimum cost matric is : " );
		for (int i=0;i<words.length ;i++ ) {
			System.out.printf(" %5d  " ,min[i]);
			
		}
		System.out.println("\n The minimum cost is : " +min[0]);
		System.out.println();

		int i=0;
		int j;

		StringBuilder builder = new StringBuilder();
        
        do{
            j = result[i];
            for(int k=i; k < j; k++){
                builder.append(words[k] + " ");
            }
            builder.append("\n");
            i = j;
        }while(j < words.length);
        
        return builder.toString();

		
	}

	public static void main(String[] args) {
		String words[]={"Hellow", "how","have" , "you", "been"};
		wordWrap awl=new wordWrap();
		System.out.println(awl.justify(words,10));

	}
}