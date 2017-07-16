package mylintcode;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
		if(numbers==null || numbers.length==0)
			return new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(numbers);
		int i =0;
		while(i+2 < numbers.length){
			int a = numbers[i];
			int j = i+1;
			int k = numbers.length-1;
			while(j<k){
				int sum = a + numbers[j] + numbers[k];
				if(sum==0){
					ArrayList<Integer> tmp = new ArrayList<Integer>();
					tmp.add(a);
					tmp.add(numbers[j]);
					tmp.add(numbers[k]);
					res.add(tmp);
					j++;
					k--;
					while(j<k && numbers[j]==numbers[j-1])
						j++;
					while(j<k && numbers[k]==numbers[k+1])
						k--;
				}
				else if(sum > 0){
					k--;
				}
				else{
					j++;
				}
			}
			i++;
			while(i<numbers.length && numbers[i]==numbers[i-1])
				i++;
		}
		return res;
	}

}
