package myleetcode;

public class MiniMoveToEqual {
	public int minMoves(int[] nums){
		int res=0;
		if(nums.length ==0)
			return 0;
		while(true){
			int maxV = nums[0];
			int maxP = 0;
			int k=1;
			for(int i=1; i<nums.length; i++){
				if(nums[i] == maxV)
					k++;
				if(nums[i] > maxV){
					nums[maxP]++;
					maxV = nums[i];
					maxP = i;
				}
				else{
					nums[i]++;
				}
			}
			if(k == nums.length)
				break;
			res++;
		}
		return res;
	}
	
	public int method2(int[] nums){
		int res = 0;
		
		while(true){
			int max;
			int maxpos;
			int min;
			max = min = nums[0];
			maxpos =0;
			for(int i=1; i< nums.length; i++){
				if(nums[i]>max){
					max = nums[i];
					maxpos = i;
				}
				if(nums[i]<min)
					min = nums[i];
			}
			if(max == min)
				break;
			for(int i=0; i<nums.length; i++){
				if(i != maxpos)
					nums[i] += (max-min);
			}
			res++;
		}
		return res;
	}
	
	public int method3(int[] nums){
		int res = 0;
		
		int min;
		min = nums[0];
		for(int i=1; i<nums.length; i++)
			if(nums[i]<min)
				min = nums[i];
		for(int i=0; i< nums.length; i++)
			res += nums[i]-min;
		return res;
	}
	
}
