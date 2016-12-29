package myleetcode;

import java.util.Arrays;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs){
		if(strs == null || strs.length ==0)
			return new String();
		if(strs.length ==1)
			return strs[0];
		String scomm = strs[0];
		for(int i=1; i<strs.length; i++){
			String s1 = scomm;
			String s2 = strs[i];
			int j=0;
			for(; j<scomm.length() && j<s2.length(); j++)
				if(s1.charAt(j)!=s2.charAt(j))
					break;
			if(j==0)
				return new String();
			scomm = s1.length()<s2.length()? s1.substring(0, i):s2.substring(0, i);
		}
		return scomm;
	}
	
	public String method2(String[] strs){
		if(strs == null || strs.length ==0)
			return new String();
		for(int i=0; i<strs[0].length(); i++){
			char c = strs[0].charAt(i);
			int j;
			for( j=1; j<strs.length; j++)
				if(i>=strs[j].length()  || 
						strs[j].charAt(i) != c)
					break;
			if(j<strs.length)
				return strs[0].substring(0, i);
		}
		return strs[0];
	}
	
	public String method3(String[] strs){
		if(strs == null || strs.length ==0)
			return new String();
		Arrays.sort(strs);
		String s1 = strs[0];
		String s2 = strs[strs.length-1];
		int i;
		for( i=0; i<s1.length()&&i<s2.length(); i++){
			if(s1.charAt(i)!= s2.charAt(i))
				break;
		}
		return s1.length()<s2.length()?s1.substring(0, i):s2.substring(0, i);
	}
}
