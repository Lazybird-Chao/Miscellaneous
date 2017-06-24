package myleetcode;

public class ReverseString2 {
	public String reverseStr(String s, int k){
		char[] ss = s.toCharArray();
		int i, j;
		i=0;
		while(i<ss.length){
			j=i+k-1;
			if(j>=ss.length)
				j=ss.length-1;
			int endtmp = j;
			while(i<=j){
				char tmp = ss[i];
				ss[i]=ss[j];
				ss[j] = tmp;
				i++;
				j--;
			}
			i=endtmp+k+1;	
		}
		return new String(ss);
	}

}
