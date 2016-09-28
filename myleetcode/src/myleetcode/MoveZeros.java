package myleetcode;

public class MoveZeros {
	public void moveZeros(int[] nums){
		int i, j;
		i=0;
		while(i<nums.length){
			if(nums[i]==0)
				break;
			i++;
		}
		j=i+1;
		while(j<nums.length){
			if(nums[j]!=0){
				nums[i]=nums[j];
				nums[j]=0;
				i++;
			}
			j++;
		}
			
	}
}
