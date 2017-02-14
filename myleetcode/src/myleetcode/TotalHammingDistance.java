package myleetcode;

import java.util.HashMap;
import java.util.Map;

public class TotalHammingDistance {
	public int totalHammingDistance(int[] nums){
		if(nums == null || nums.length<2)
			return 0;
		Map<Integer, Integer> lookuptable = new HashMap<Integer, Integer>();
		int totalhamm = 0;
		for(int i=0; i<nums.length; i++){
			int t1 = nums[i];
			for(int j=i+1; j<nums.length; j++){
				int hamm = t1 ^ nums[j];
				if(lookuptable.containsKey(hamm))
					totalhamm += lookuptable.get(hamm);
				else{
					int count=0;
					int tmp = hamm;
					while(hamm!=0){
						count += hamm&1;
						hamm = hamm>>>1;
					}
					totalhamm += count;
					lookuptable.put(tmp, count);
				}
			}
		}
		return totalhamm;
	}
	
	static public int method2(int[] nums){
		if(nums == null || nums.length<2)
			return 0;
		int totalhamm = 0;
		int k = 1;
		for(int i=0; i< 32; i++){
			int count1 = 0;
			for(int j=0; j<nums.length; j++)
				if((nums[j] & k)!=0)
					count1++;
			totalhamm += count1 * (nums.length-count1);
			k = k<<1;
		}
		return totalhamm;
	}
	
	public static void main(String args[]){
		int[] a = {4,14,2};
		System.out.println(method2(a));
	}
}
