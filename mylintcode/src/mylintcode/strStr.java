package mylintcode;

public class strStr {
	public int strStr(String source, String target) {
        // write your code here
		if(source ==null || target==null)
			return -1;
		if(target.isEmpty())
			return 0;
			
		return source.indexOf(target);
    }
	
	public int method2(String source, String target){
		if(source ==null || target==null)
			return -1;
		if(target.isEmpty())
			return 0;
		
		for(int i=0; i<source.length(); i++){
			int j=0;
			while(j<target.length()){
				if(target.charAt(j)!=source.charAt(i)){
					break;
				}
				j++;
				i++;
			}
			if(j==target.length())
				return i-j;
			else
				i = i-j;
		}
		return -1;
	}
	
	public int kmp(String source, String target){
		if(source ==null || target==null)
			return -1;
		if(target.isEmpty())
			return 0;
		
		int[] next = nextKmp(target);
		int i=0, j=0;
		while(  i<source.length() && j<target.length()){
			if(source.charAt(i)==target.charAt(j)){
				j++;
				i++;
			}
			else{
				if(j==0)
					i++;
				else
					j = next[j-1];
			}
			
		}
		
		if(j==target.length())
		    return i-j;
		else
		    return -1;
	}
	
	public int[] nextKmp(String target){
		if(target==null || target.isEmpty()){
			return null;
		}
		
		int[] next = new int[target.length()];
		next[0] = 0;
		for(int i=1; i<target.length(); i++){
			int j = i-1;
			while(j>=0){
				if(target.charAt(i) == target.charAt(next[j])){
					next[i] = next[j] + 1;
					break;
				}
				j = next[j]-1;
			}
			if(j<0)
				next[i] = 0;
		}
		return next;
	}
	
	public int[] nextKmp2(String target){
		if(target==null || target.isEmpty()){
			return null;
		}
		
		int[] next = new int[target.length()];
		next[0] = -1;
		int i=-1, j=0;
		while(j<target.length()){
			if(i==-1 || target.charAt(i)==target.charAt(j)){
				j++;
				i++;
				if(target.charAt(j)==target.charAt(i))
					next[j] = next[i];
				else
					next[j] = i;
			}
			else{
				i = next[i];
			}
		}
		return next;
	}
	
	public int kmp2(String source, String target){
		if(source ==null || target==null)
			return -1;
		if(target.isEmpty())
			return 0;
		
		int[] next = nextKmp2(target);
		int i=0, j=0;
		while(i<source.length() && j<target.length()){
			if(j==-1 || source.charAt(i)==target.charAt(j)){
				i++;
				j++;
			}
			else{
				j = next[j];
			}
		}
		if(j==target.length())
			return i-j;
		else
			return -1;
	}
	
}
