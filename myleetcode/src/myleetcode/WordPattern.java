package myleetcode;

import java.util.HashMap;

public class WordPattern {
	static public boolean wordPattern(String pattern, String str){
		String[] subs = str.split(" ");
		if(pattern.length() != subs.length)
			return false;
		int[] charmap = new int[256];
		HashMap<String, Integer> strmap = new HashMap<String, Integer>();
		for(int i=0; i<pattern.length(); i++){
			char c = pattern.charAt(i);
			String s = subs[i];
			if(charmap[(int)c]==0)
				charmap[(int)c] = i+1;
			if(strmap.containsKey(s) == false)
				strmap.put(s, i+1);
			if(charmap[(int)c] != strmap.get(s))
				return false;				
		}
		return true;
	} 
	
	public static void main(String[] argv){
		System.out.println(wordPattern("abba","dog cat cat dog"));
	}
	
}
