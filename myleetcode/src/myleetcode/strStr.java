package myleetcode;

/*
 * string match algorithm: FAM(finite automata machine) or KMP algorithm
 */
public class strStr {
	static public int strString(String haystack, String needle){
		if(haystack ==null || haystack.length()==0)
            return -1;
        if(needle==null || needle.length()==0)
            return 0;
        if(needle.length()>haystack.length())
            return -1;
        
		String pattern = needle;
		String text = haystack;
		
		/*
		 * construct the overlap array target pattern string
		 */
		int[] overlap = new int[pattern.length()];
		
		/*
		 * when compute overlap of x and y, we only consider the substr of 
		 * surffix of x and prefix of y, so for single character the overlap
		 * value is 0
		 */
		overlap[0] = 0; 
		for(int i=1; i<overlap.length; i++){
			int pre_overlap = overlap[i-1];
			while( pre_overlap>0 && pattern.charAt(i) != pattern.charAt(pre_overlap)){
				pre_overlap = overlap[pre_overlap-1];
			}
			if(pre_overlap ==0){
				if(pattern.charAt(i) == pattern.charAt(pre_overlap))
					overlap[i] = 1;
				else
					overlap[i] = 0;
			}
			else
				overlap[i] = pre_overlap +1;
		}
		
		/*
		 * now go KMP algorithm
		 */
		int i=0;
		int j=0;
		while(i<text.length() && j<pattern.length()){
			if(pattern.charAt(j)!= text.charAt(i)){
				if(j==0)
					i++;
				else
					j= overlap[j-1];
			}
			else{
				i++;
				j++;
			}
		}
		if(j == pattern.length())
			return i - pattern.length();
		else
			return -1;
		
	}
	
	static public void main(String args[]){
		System.out.println(strString("mississippi","issipi"));
	}

}
