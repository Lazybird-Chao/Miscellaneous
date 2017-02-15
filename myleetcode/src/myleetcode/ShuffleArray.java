package myleetcode;

import java.util.Random;

public class ShuffleArray {
	public class Solution{
		int[] origArray;
		public Solution(int[] nums){
			origArray = new int[nums.length];
			for(int i=0; i<nums.length; i++)
				origArray[i] = nums[i];
		}
		
		public int[] reset(){
			return origArray;
		}
		
		public int[] shuffle(){
			int[] res = new int[origArray.length];
			Random rn = new Random();
			for(int i=0; i< origArray.length; i++){
				int j = rn.nextInt(i+1);
				res[i] = res[j];
				res[j] = origArray[i];
			}
			return res;
		}
		
		public int[] method2(){
			int[] res = origArray.clone();
			Random rn = new Random();
			for(int i=res.length-1; i>0; i--){
				int j = rn.nextInt(i+1);
				if(j!=i){
					int tmp = res[j];
					res[j] = res[i];
					res[i] = tmp;
				}
			}
			return res;
		}
	}
}
