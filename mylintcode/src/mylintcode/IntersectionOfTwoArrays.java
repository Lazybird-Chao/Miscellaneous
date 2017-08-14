package mylintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArrays {
	 public int[] intersection(int[] nums1, int[] nums2) {
		if(nums1==null || nums2==null)
			return new int[0];
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		List<Integer> res = new ArrayList<Integer>();
		int i,j;
		i=j=0;
		while(i<nums1.length && j<nums2.length) {
			if(nums1[i]==nums2[j]) {
				res.add(nums1[i]);
				while(i+1<nums1.length && nums1[i]==nums1[i+1])
					++i;
				while(j+1<nums2.length && nums1[j]==nums1[j+1])
					++j;
				++i;
				++j;
			}
			else if(nums1[i]>nums2[j]) {
				++j;
			}
			else
				++i;
		}
		int[] res2 = new int[res.size()];
		for(i=0; i<res.size(); i++)
			res2[i] = res.get(i);
		return res2;
	 }

}
