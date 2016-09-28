package myleetcode;
import java.util.*;

public class Roman2Int {
	public int romanToInt(String s){
		char c1, c2;
		Map<Character, Integer> keyUnit = new HashMap<Character, Integer>();
		keyUnit.put('I', 1);
		keyUnit.put('V', 5);
		keyUnit.put('X', 10);
		keyUnit.put('L', 50);
		keyUnit.put('C', 100);
		keyUnit.put('D', 500);
		keyUnit.put('M', 1000);
		
		if(s.length() == 0)
			return 0;
		c1 = s.charAt(s.length()-1);
		int v1 = keyUnit.get(c1);
		int res = v1;
		for(int i=s.length()-2; i>=0; i--){
			c2 = s.charAt(i);
			int v2 = keyUnit.get(c2);
			if(v2>=v1)
				res += v2;
			else
				res -= v2;
			v1 = v2;	
		}
		
		return res;
	}
}
