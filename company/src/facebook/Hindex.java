package facebook;

public class Hindex {
	 public int hIndex(int[] citations) {
	        if(citations == null || citations.length == 0)
	            return 0;
	        Arrays.sort(citations);
	        int n = citations.length;
	        if(citations[0] >= n)
	            return n;
	        for(int i = 1; i < n; i++){
	            if(citations[i] >= n-i && citations[i-1] <= n-i)
	                return n-i;
	        }
	        return 0;
	    }

}
