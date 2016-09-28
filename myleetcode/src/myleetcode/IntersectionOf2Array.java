package myleetcode;
import java.util.HashSet;
import java.util.ArrayList;

public class IntersectionOf2Array {
	public int[] intersection(int[] nums1, int[] nums2){
		ArrayList<Integer> intersect = new ArrayList<Integer>();
		HashSet<Integer> numset = new HashSet<Integer>();
		for(int i=0; i< nums1.length; i++){
			numset.add(nums1[i]);
		}
		for(int i=0; i<nums2.length; i++){
			if(numset.contains(nums2[i])){
				intersect.add(nums2[i]);
				numset.remove(nums2[i]);
			}
		}
		int[] res = new int[intersect.size()];
		for(int i=0; i<res.length; i++)
			res[i]=intersect.get(i).intValue();
		return res;
	}
}
