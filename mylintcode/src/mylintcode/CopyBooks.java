package mylintcode;

import java.util.HashMap;
import java.util.Map;

public class CopyBooks {
	public int copyBooks(int[] pages, int k) {
		if(pages==null || pages.length==0)
			return 0;
		/*
		helper(pages, k, 0, 0);
		return min;
		*/
		record = new int[k+1][pages.length+1];
		return method2(pages, k, 0);
	}
	
	int min = Integer.MAX_VALUE;
	public void helper(int[] pages, int k, int start, int curMax) {
		if(pages.length - start < k)
			return;
		if(k==1) {
			int pagek=0;
			for(int i=start; i<pages.length; i++)
				pagek += pages[i];
			curMax = Math.max(curMax, pagek);
			min = Math.min(min, curMax);
		}
		int pagek = 0;
		int tmpcurMax;
		for(int i=start; i<pages.length; i++) {
			pagek += pages[i];
			tmpcurMax = Math.max(curMax, pagek);
			helper(pages, k-1, i+1, tmpcurMax);
		}
		return;
	}
	
	
	int[][] record;
	public int method2(int[] pages, int k, int start) {
		if(k==0) {
			record[k][start] = Integer.MAX_VALUE;
			return Integer.MAX_VALUE;
		}
		else if(start==pages.length){
		    record[k][start] = 0;
		    return 0;
		}
		if(record[k][start]!=0)
			return record[k][start];
		int minK = Integer.MAX_VALUE;
		int pagek = 0;
		for(int i=start; i<pages.length; i++) {
			pagek += pages[i];
			minK = Math.min(minK, Math.max(pagek, method2(pages, k-1, i+1)));
		}
		if(k==1)
		    minK = pagek;
		record[k][start] = minK;
		return minK;
		
	}
	
	/*
	public int method3(int[] pages, int k) {
		if(k>=pages.length) {
			int max = pages[0];
			for(int i=1; i<pages.length; i++)
				max = Math.max(max, pages[i]);
			return max;
		}
		
		int sum = 0;
		float[] presum = new float[pages.length];
		for(int i=0; i<pages.length; i++) {
			sum += pages[i];
			if(i>0)
				presum[i] = presum[i-1]+pages[i];
			else
				presum[0] = pages[0];
		}
		float avg = (float)sum/k;
		int pos = -1;
		int max = 0;
		for(int i=1; i<k; i++) {
			float target = i*avg;
			int newpos = find(presum, target, pos+1, pages.length-1);
			max = Math.max(max, newpos-pos);
			pos = newpos;
		}
		return max;
	}
	
	int find(float[] n, float target, int l, int r) {
		while(l+1<r) {
			int m = l+(r-l)/2;
			if(n[m]>=target)
				m = r;
			else
				m = l;
		}
		if(target-n[l]<n[r]-target)
			return l;
		else
			return r;
	}
	*/
	
	public int method3(int[] pages, int k) {
        if (pages.length == 0) {
            return 0;  
        }
        
        int total = 0;
        int max = pages[0];
        for (int i = 0; i < pages.length; i++) {
            total += pages[i];
            if (max < pages[i]) {
                max = pages[i];
            }
        }
        
        int start = max;
        int end = total;
        
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (countCopiers(pages, mid) > k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (countCopiers(pages, start) <= k) {
            return start;
        }
        
        return end;
    }
	
	private int countCopiers(int[] pages, int limit) {
        if (pages.length == 0) {
            return 0;
        }
        
        int copiers = 1;
        int sum = pages[0]; // limit is always >= pages[0]
        for (int i = 1; i < pages.length; i++) {
            if (sum + pages[i] > limit) {
                copiers++;
                sum = 0;
            }
            sum += pages[i];
        }
        
        return copiers;
    }


}
