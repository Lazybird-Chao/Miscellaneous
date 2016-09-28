package myleetcode;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

public class IntersectionOf2Arrays2 {
	public int[] intersect(int[] nums1, int[] nums2){
		HashMap<Integer, Integer> numCounts = new HashMap<Integer, Integer>();
		for(int i=0; i<nums1.length; i++){
			int num = nums1[i];
			int count=0;
			if(numCounts.containsKey(num)){
				count = numCounts.get(num);
			}
			count++;
			numCounts.put(num, count);
		}
		ArrayList<Integer> inters = new ArrayList<Integer>();
		for(int i=0; i<nums2.length; i++){
			int num = nums2[i];
			int count = 0;
			if(numCounts.containsKey(num)){
				count = numCounts.get(num);
				if(count>0)
					inters.add(num);
				count--;
				numCounts.put(num, count);
			}
		}
		
		int[] res = new int[inters.size()];
		for( int i=0; i<inters.size(); i++)
			res[i] = inters.get(i).intValue();
		return res;
	}
	
	public int[] method2(int[] nums1, int[] nums2){
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		ArrayList<Integer> inters = new ArrayList<Integer>();
		int i=0;
		int j=0;
		while(i<nums1.length && j<nums2.length){
			if(nums1[i] == nums2[j]){
				inters.add(nums1[i]);
				i++;
				j++;
			}
			else if(nums1[i] < nums2[j]){
				i++;
			}
			else if(nums1[i] > nums2[j]){
				j++;
			}
		}
		int[] res = new int[inters.size()];
		for( i=0; i<inters.size(); i++)
			res[i] = inters.get(i).intValue();
		return res;
	}
}
