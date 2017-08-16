package mylintcode;

import java.util.Arrays;

public class TriangleCount {
	public int triangleCount(int[] S) {
		if(S==null || S.length<3)
			return 0;
		
		Arrays.sort(S);
		int count = 0;
		int i,j,k;
		k=S.length-1;
		while(k>=2) {
			i=0; 
			j=k-1;
			while(i<j) {
				if(S[i]+S[j]>S[k]) {
					count += j-i;
					j--;
				}
				else {
					i++;
				}
			}
			k--;
		}
		return count;
		
	}

}
