package myleetcode;

import java.util.HashMap;

public class LongestPalindrome {
	public int longestPalindrome(String s){
		int oddLetterCount=0;
		HashMap<Character, Integer> letterTable = new HashMap<Character, Integer>();
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			if(letterTable.containsKey(c)){
				int count = letterTable.get(c);
				if(count ==1){
					count =0;
					oddLetterCount--;
				}
				else{
					count=1;
					oddLetterCount++;
				}
				letterTable.replace(c, count);
			}
			else{
				letterTable.put(c, 1);
				oddLetterCount++;
			}
		}
		return oddLetterCount==0 ? s.length():s.length() - oddLetterCount +1;
	}
}
