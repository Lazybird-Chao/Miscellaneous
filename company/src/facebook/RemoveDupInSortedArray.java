package facebook;

public class RemoveDupInSortedArray {
	public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length ==0)
            return 0;
        int i = 1;
        int j = 1;
        while(j < nums.length){
            if(nums[j] == nums[j-1])
                j++;
            else{
                nums[i] = nums[j];
                i++;
                j++;
            }
        }
        
        return i;
    }

}
