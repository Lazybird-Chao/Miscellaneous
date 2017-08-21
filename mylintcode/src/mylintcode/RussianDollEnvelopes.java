package mylintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes {
	public int maxEnvelopes(int[][] envelopes) {
		if(envelopes == null || envelopes.length ==0)
			return 0;
		
		pair[] enves = new pair[envelopes.length];
		for(int i=0; i<envelopes.length; i++)
			enves[i] = new pair(envelopes[i][0], envelopes[i][1]);
		Arrays.sort(enves, new Comparator<pair>() {
			public int compare(pair a, pair b) {
				if(a.w != b.w)
					return a.w-b.w;
				else
					return a.h-b.h;
			}
		});
		int[] maxDolls = new int[enves.length];
		for(int i=0; i<enves.length; i++)
			maxDolls[i] = 1;
		int max = 1;
		for(int i=1; i<enves.length; i++) {
			for(int j=i-1; j>=0; j--) {
				if(enves[j].w<enves[i].w && enves[j].h<enves[i].h) {
					maxDolls[i] = Math.max(maxDolls[i],  maxDolls[j]+1);
					max = Math.max(maxDolls[i], max);
				}
			}
		}
		return max;
	}
	
	class pair{
		int w;
		int h;
		public pair(int a, int b) {
			w = a;
			h = b;
		}
	}
	
	
	int method2(int[][] envelopes) {
		if(envelopes == null || envelopes.length ==0)
			return 0;
		Arrays.sort(envelopes, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				if(a[0] != b[0])
					return a[0]-b[0];
				else
					return b[1]-a[1];
			}
		});
		
		ArrayList<Integer> minH = new ArrayList<Integer>();
		minH.add(envelopes[0][1]);
		for(int i=0; i<envelopes.length; i++) {
				int p = minH.size()-1;
				while(p>=0) {
					if(minH.get(p)<envelopes[i][1])
						break;
					p--;
				}
				if(p==minH.size()-1) {
					minH.add(envelopes[i][1]);
				}
				else {
					minH.set(p+1, envelopes[i][1]);
				}
			
		}
		return minH.size();
	}

}
