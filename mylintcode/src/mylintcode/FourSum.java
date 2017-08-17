package mylintcode;

import java.util.ArrayList;

public class FourSum {
	public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
		if(numbers==null || numbers.length<4)
			return new ArrayList<ArrayList<Integer>>();
		Arrays.sort(numbers);
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		int a, b, c, d;
		d = numbers.length-1;
		while(d>=3) {
			c = d-1;
			while(c>=2) {
				a=0;
				b=c-1;
				while(a<b) {
					int sum = numbers[a]+numbers[b]+numbers[c]+numbers[d];
					if(sum==target) {
						ArrayList<Integer> tmp = new ArrayList<Integer>();
						tmp.add(numbers[a]);
						tmp.add(numbers[b]);
						tmp.add(numbers[c]);
						tmp.add(numbers[d]);
						res.add(tmp);
						++a;
						while(a<b && numbers[a-1]==numbers[a])
							++a;
						--b;
						while(a<b && numbers[b]==numbers[b+1])
							--b;
					}
					else if(sum > target)
						--b;
					else
						++a;
				}
				--c;
				while(c>=2 && numbers[c]==numbers[c+1])
					--c;
			}
			--d;
			while(d>=3 && numbers[d]==numbers[d+1])
				--d;
		}
		return res;
	}

}
