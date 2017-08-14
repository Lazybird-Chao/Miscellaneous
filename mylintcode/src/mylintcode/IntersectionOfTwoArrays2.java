package mylintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays2 {
	public int[] intersection(int[] nums1, int[] nums2) {
		if(nums1==null || nums2==null)
			return new int[0];
		Map<Integer, Integer> numbers = new HashMap<Integer, Integer>();
		for(int i=0; i<nums1.length; i++) {
			if(numbers.containsKey(nums1[i]))
				numbers.put(nums1[i], numbers.get(nums1[i])+1);
			else
				numbers.put(nums1[i], 1);
		}
		List<Integer> res = new ArrayList<Integer>();
		for(int i=0; i<nums2.length; i++) {
			if(numbers.containsKey(nums2[i])) {
				res.add(nums2[i]);
				if(numbers.get(nums2[i])==1)
					numbers.remove(nums2[i]);
				else
					numbers.put(nums2[i], numbers.get(nums2[i])-1);
			}
		}
		int[] res2 = new int[res.size()];
		for(int i=0; i<res.size(); i++)
			res2[i] = res.get(i);
		return res2;
		
	}
	
	public int[] method2(int[] nums1, int[] nums2) {
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
