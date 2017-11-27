package google;

public class MedianOfTwoSortedArray {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null)
            return 0;
        int total = nums1.length + nums2.length;
        if(total % 2 ==0){
            int m1 = helper(nums1, nums2, 0, 0, total / 2);
            int m2 = helper(nums1, nums2, 0, 0, total / 2 +1);
            System.out.println(m1);
            System.out.println(m2);
            return ((double)m1 + m2) / 2.0;
        } else{
            return helper(nums1, nums2, 0, 0, total / 2 + 1);
        }
            
    }
    int helper(int[] nums1, int[] nums2, int i, int j, int k){
        if(i >= nums1.length)
            return nums2[j+k-1];
        else if(j >= nums2.length)
            return nums1[i+k-1];
        if(k==1){
            if(nums1[i] < nums2[j])
                return nums1[i];
            else
                return nums2[j];
        }
        int mid = k/2;
        int m1 = 0;
        int m2 = 0;
        int reduce1 = 0;
        if(i+mid-1 < nums1.length){
            m1 = nums1[i+mid-1];
            reduce1 = mid;
        }
        else {
            m1 = nums1[nums1.length-1];
            reduce1 = nums1.length -i;
        }
        int reduce2 = 0;
        if(j+mid-1 < nums2.length){
            m2 = nums2[j+mid-1];
            reduce2 = mid;
        }
        else{
            m2 = nums2[nums2.length-1];
            reduce2 = nums2.length -j;
        }
        int reduce = 0;
        if(m1 < m2){
            i = i+mid;
            reduce = reduce1;
        }
        else{
            j = j+mid;
            reduce = reduce2;
        }
        return helper(nums1, nums2, i, j, k-reduce);
    }

}
