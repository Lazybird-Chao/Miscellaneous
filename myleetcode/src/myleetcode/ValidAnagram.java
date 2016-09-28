package myleetcode;
import java.util.HashMap;
public class ValidAnagram {
	public boolean isAnagram(String s, String t){
		if(s.length() != t.length())
			return false;
		HashMap<Character, Integer> letterCount = new HashMap<Character, Integer>();
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			int count = 0;
			if(letterCount.containsKey(c))
				count = letterCount.get(c);
			count++;
			letterCount.put(c, count);
		}
		for(int i=0; i<t.length(); i++){
			char c = t.charAt(i);
			int count = 0;
			if(!letterCount.containsKey(c))
				return false;
			count = letterCount.get(c);
			count--;
			if(count<0)
				return false;
			letterCount.put(c, count);
		}
		return true;
	}
}
