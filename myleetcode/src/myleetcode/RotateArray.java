package myleetcode;

public class RotateArray {
	public void rotate(int[] nums, int k){
		k = k%nums.length;
		if(k==0)
			return;
		int[] tmp = new int[k];
		for(int i=0; i<k; i++){
			tmp[i] = nums[nums.length-k+i];
			nums[nums.length-k+i] = nums[(nums.length-k+i + nums.length -k)%nums.length];
		}
		for(int i=nums.length-k-1; i>=k; i--)
			nums[i] = nums[i-k];
		for(int i=0; i<k && i<nums.length-k; i++)
			nums[i] = tmp[i];
		
	}
	
	public void method2(int[] nums, int k){
		k = k%nums.length;
		if(k==0)
			return;
		for(int i=0; i<k; i++){
			int tmp=nums[nums.length];
			for(int j=1; j<nums.length; j++)
				nums[j] = nums[j-1];
			nums[0] = tmp;
		}		
	}
	
	public void method3(int[] nums, int k){
		k = k%nums.length;
		if(k==0)
			return;
		reverse(nums, 0, nums.length-1);
		reverse(nums, 0, k-1);
		reverse(nums, k, nums.length-1);
		return;
	}
	public void reverse(int[] nums, int start, int end){
		while(start<end){
			int tmp = nums[start];
			nums[start]=nums[end];
			nums[end]=tmp;
			start++;
			end--;
		}
	}
}
