package mylintcode;

public class strStr2 {
	public int strStr2(String source, String target) {
		if(source==null || target==null)
			return -1;
		if(target.isEmpty())
			return 0;
		
		int[] next = new int[target.length()];
		next[0]= -1;
		for(int i=1; i<target.length(); i++) {
			int j= next[i-1];
			while(j>=0 && target.charAt(j+1)!=target.charAt(i))
				j = next[j];
			if(target.charAt(j+1)==target.charAt(i))
				next[i] = j+1;
			else
				next[i] = j;
		}
		
		int i, j;
		i=0;
		j=0;
		while(i<source.length()) {
			while(j<target.length() && i<source.length()) {
				if(source.charAt(i)!=target.charAt(j)) 
					break;
				i++;
				j++;
			}
			if(j==target.length())
				return i-j;
			else if(j==0)
				i++;
			else
				j = next[j-1]+1;
		}
		return -1;
		
	}

}
