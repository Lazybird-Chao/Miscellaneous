package myleetcode;

public class MaximumAverageSubarray {
	public double maxAverage(int[] nums, int k) {
		if(nums==null || nums.length==0)
			return 0;
		
		double[] avg = new double[nums.length];
		for(int i=0; i<k; i++)
			avg[k-1] += nums[i];
		double max = (double)avg[k-1]/k;
		for(int i=k; i<nums.length; i++) {
			avg[i] = (avg[i-1]+nums[i])-nums[i-k];
			max = Math.max(max, (double)avg[i]/k);
		}
		for(int i=k; i<nums.length; i++) {
			int sumcount = i+1;
			for(int j=i, p=k-1; j<nums.length; j++, p++) {
				avg[p] += nums[j];
				max = Math.max(max, (double)avg[p]/sumcount);
			}
		}
		return max;
		
	}

}
