package mylintcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		if(s==null || dict==null)
			return false;
		if(s.isEmpty())
			return true;
		record = new HashMap<Integer, Boolean>();
		
		return findBreak(s, 0, dict);
		
	}
	
	Map<Integer, Boolean> record;
	
	boolean findBreak(String s, int startPos, Set<String> dict) {
		if(startPos==s.length())
			return true;
		if(record.containsKey(startPos))
			return record.get(startPos);
		for(int endPos = startPos+1; endPos<=s.length(); endPos++) {
			String preString = s.substring(startPos, endPos);
			if(dict.contains(preString) && findBreak(s, endPos, dict)) {
				record.put(startPos, true);
				return true;
			}
		}
		record.put(startPos, false);
		return false;
	}
	
	
	
	Map<String, Boolean> record2;
	boolean findBreak2(String s, Set<String> dict) {
		if(s.isEmpty())
			return true;
		if(record2.containsKey(s))
			return record2.get(s);
		for(String d : dict) {
			int sbegin = s.indexOf(d, 0);
			while(sbegin!=-1) {
				int send = sbegin+d.length();
				if(findBreak2(s.substring(0, sbegin), dict) && findBreak2(s.substring(send, s.length()),dict)) {
					record2.put(s, true);
					return true;
				}
				sbegin = s.indexOf(d, sbegin+1);
			}
		}
		record2.put(s,  false);
		return false;
	}
	
	boolean dp(String s, Set<String> dict) {
		boolean[] f = new boolean[s.length()];
		if(dict.contains(s.substring(0, 1)))
			f[0] = true;
		else
			f[0] = false;
		for(int i=1; i<s.length(); i++) {
		    f[i]=false;
			String preS = s.substring(0, i+1);
			int checkpos = i;
			for(String d: dict) {
				if(preS.endsWith(d)) {
					checkpos = i - d.length();
					if(checkpos==-1 || f[checkpos]) {
						f[i]=true;
						break;
					}
				}
			}
		}
		return f[s.length()-1];
	}

}

