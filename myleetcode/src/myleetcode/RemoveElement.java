package myleetcode;

public class RemoveElement {
	public int removeElement(int[] nums, int val){
		int i,j;
		for(i=0, j=nums.length-1; i<=j; i++,j--){
			while(i<=j){
				if(nums[i]==val)
					break;
				i++;
			}
			while(i<=j){
				if(nums[j]!=val)
					break;
				j--;
			}
			if(i<=j)
				nums[i]=nums[j];
			else
			    break;
		}
		return j>=0? j+1: 0;
	}
}
