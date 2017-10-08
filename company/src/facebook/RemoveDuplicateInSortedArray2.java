package facebook;

public class RemoveDuplicateInSortedArray2 {
	public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length ==0)
            return 0;
        int i = 1;
        int j = 2;
        while(j < nums.length){
            if(nums[j] != nums[i] || nums[j] != nums[i-1]){
                nums[i+1] = nums[j];
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i+1;
    }

}
