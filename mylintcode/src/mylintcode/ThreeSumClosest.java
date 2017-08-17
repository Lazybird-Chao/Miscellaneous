package mylintcode;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] numbers, int target) {
		if(numbers == null || numbers.length<3)
			return -1;
		Arrays.sort(numbers);
		int i, j, k;
		k=numbers.length-1;
		int closest = numbers[0]+numbers[1]+numbers[2];
		while(k>=2) {
			i=0;
			j=k-1;
			while(i<j) {
				int tmp = numbers[k]+numbers[j]+numbers[i];
				if(tmp == target) {
					return target;
				}
				else if(tmp < target) {
					++i;
					if(Math.abs(target-closest)>target-tmp)
						closest = tmp;	
				}
				else {
					--j;
					if(Math.abs(target-closest)>tmp -target)
						closest = tmp;
				}
			}
			--k;
		}
		return closest;
	}

}
