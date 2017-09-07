package amazon;

import java.util.ArrayList;
import java.util.List;

public class LongestPalinDromicSubstring {
	public String longestPalindrome(String s) {
		if(s==null || s.isEmpty())
			return "";
		List<Integer>[] palindromePos = new List[s.length()];
		palindromePos[0] = new ArrayList<Integer>();
		palindromePos[0].add(0);
		int maxlen=1;
		int maxpos=0;
		for(int i=1; i<s.length(); i++) {
			palindromePos[i] = new ArrayList<Integer>();
			for(int pos : palindromePos[i-1]) {
				if(pos>0 && s.charAt(pos-1)==s.charAt(i)) {
					palindromePos[i].add(pos-1);
					if(i-(pos-1)+1 > maxlen) {
						maxpos = pos-1;
						maxlen = i-(pos-1)+1;
					}
				}
			}
			if(s.charAt(i-1)==s.charAt(i)) {
				palindromePos[i].add(i-1);
				if(2 > maxlen) {
					maxpos = i-1;
					maxlen = 2;
				}
			}
			palindromePos[i].add(i);
		}
		
		return s.substring(maxpos, maxpos+maxlen);
	}
	
	public String method2(String s) {
		if(s==null || s.isEmpty())
			return "";
		
		int maxlen;
		int maxpos;
		maxlen = 1;
		maxpos = 0;
		for(int i=1; i<s.length(); i++) {
			int halflen1 = expand1(s, i);
			if(halflen1*2+1 > maxlen) {
				maxlen = halflen1*2 +1;
				maxpos = i-halflen1;
			}
            int halflen2 = expand2(s, i);
            if(halflen2*2 > maxlen){
                maxlen = halflen2*2;
                maxpos = i-halflen2;
            }
			if(i+halflen1 == s.length()-1 || i+halflen2-1 == s.length()-1)
				break;
		}
		return s.substring(maxpos, maxpos+maxlen);
		
	}
	
	int expand1(String s, int pivot) {
		int i = pivot-1;
		int j = pivot+1;
		int count = 0;
		while(i>=0 && j<=s.length()-1 && s.charAt(i)==s.charAt(j)) {
			i--;
			j++;
			count++;
		}      
		return count;		
	}
    
    int expand2(String s, int pivot){
        int i = pivot-1;
        int j= pivot;
        int count = 0;
        while(i>=0 && j<=s.length()-1 && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
            count++;
        }
        return count;
    }
	

}
