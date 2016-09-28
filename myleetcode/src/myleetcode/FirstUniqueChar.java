package myleetcode;
import java.util.HashMap;

public class FirstUniqueChar {
	public int firstUniqChar(String s){
		int res =-1;
		HashMap<Character, Integer> letterCount = new HashMap<Character, Integer>();
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			int count = 0;
			if(letterCount.containsKey(c)){
				count = letterCount.get(c);
			}
			count++;
			letterCount.put(c, count);
		}
		for(int i=0; i<s.length(); i++){
			if(letterCount.get(s.charAt(i)) == 1){
				res = i;
				break;
			}
		}
		return res;		
	}
}
