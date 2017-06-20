package myleetcode;

public class DistributeCandies {
	public int distributeCandies(int[] candies){
		int[] category = new int[200001];
		for(int i=0; i<category.length; i++)
			category[i] =0;
		for(int i=0; i<candies.length; i++){
			category[candies[i]+100000]++;
		}
		int count =0;
		for(int i=0; i<category.length; i++){
			if(category[i]!=0)
				count++;
		}
		
		if(count>candies.length/2)
			return candies.length/2;
		else
			return count;
	}

}
