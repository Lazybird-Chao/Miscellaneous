package mylintcode;

import java.util.Arrays;

public class WoodCut {
	public int woodCut(int[] L, int k) {
		if(L==null || L.length==0)
			return 0;
		
		long sum =0;
		for(int i=0; i<L.length; i++)
			sum += L[i];
		long maxAvg = sum/k;
		if(maxAvg<1)
			return 0;
		long left = 1;
		long right = maxAvg;
		while(left+1<right) {
			long mid = left+(right-left)/2;
			long count=0;
			for(int i=0; i<L.length; i++)
				count += (long)L[i]/mid;
			if(count < k)
				right = mid;
			else
				left = mid;
		}
		long count=0;
		for(int i=0; i<L.length; i++)
			count += (long)L[i]/right;
		if(count >= k)
			return (int)right;
		else
			return (int)left;
	}

}
