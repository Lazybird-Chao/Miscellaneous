package google;

public class CountSmallerNumber {
	public List<Integer> countSmaller(int[] nums){
        if(nums == null || nums.length == 0)
            return new ArrayList<Integer>();
        int[] counts = new int[nums.length];
        mergeSort(nums, counts, 0, nums.length-1);
        List<Integer> res = new ArrayList<Integer>();
        for(int i= 0; i<counts.length; i++){
            res.add(counts[i]);
        }
        return res;
    }
    int[] mergeSort(int[] nums, int[] counts, int left, int right){
        if(left == right){
            int[] ret = {left};
            return ret;
        }
        int mid = left + (right-left)/2;
        int[] sl = mergeSort(nums, counts, left, mid);
        int[] sr = mergeSort(nums, counts, mid+1, right);
        int i= 0;
        int j= 0;
        int k = 0;
        int[] ret = new int[sl.length+sr.length];
        while(i< sl.length && j < sr.length){
            if(nums[sl[i]] > nums[sr[j]]){
                ret[k++] = sl[i];
                counts[sl[i]] += sr.length-j;
                i++;
            }else{
                ret[k++] = sr[j];
                j++;
            }
        }
        while(i < sl.length){
            ret[k++] = sl[i];
            i++;
        }
        while(j < sr.length){
            ret[k++] = sr[j];
            j++;
        }
        return ret;
    }

}
