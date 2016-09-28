package myleetcode;
import java.util.HashMap;
public class RansomNote {
	public boolean canConstruct(String ransom, String magazine){
		HashMap<Character, Integer> letterCounts = new HashMap<Character, Integer>();
		for(int i=0; i<magazine.length();i++){
			char c = magazine.charAt(i);
			int count =0;
			if(letterCounts.containsKey(c)){
				count = letterCounts.get(c);
				}
			count++;
			letterCounts.put(c, count);
		}
		for(int i=0; i<ransom.length(); i++){
			char c = ransom.charAt(i);
			int count = 0;
			if(!letterCounts.containsKey(c)){
				return false;
			}
			count = letterCounts.get(c);
			count--;
			if(count<0)
				return false;
			letterCounts.put(c, count);
		}
		return true;
	}
}
