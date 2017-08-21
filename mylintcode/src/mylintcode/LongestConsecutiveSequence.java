package mylintcode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
		if(num==null)
			return 0;
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0; i<num.length; i++)
			set.add(num[i]);
		int maxlength=0;
		for(int k: set) {
			int up = 1;
			int upk = k+1;
			while(set.contains(upk)) {
				++upk;
				++up;
				set.remove(upk);
			}
			int down =1;
			int downk = k-1;
			while(set.contains(downk)) {
				--downk;
				--down;
				set.remove(downk);
			}
			maxlength = Math.max(maxlength, up+down-1);
			set.remove(k);
		}
		return maxlength;
	}

}
