package facebook;

public class MoveZeroes {
	public void moveZeroes(int[] nums) {
        if(nums == null || nums.length==0)
            return;
        int i = 0;
        int j = 0;
        while(j<nums.length){
            if(nums[j] != 0){
                if(i!=j){
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
                j++;
                i++;
            } else {
                j++;
            }
        }

        return;
        
    }

}
