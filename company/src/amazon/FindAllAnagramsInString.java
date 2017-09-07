package amazon;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInString {
	public List<Integer> findAnagrams(String s, String p) {
		if(s==null || p==null || p.length() > s.length())
			return new ArrayList<Integer>();
		int[] lettermap = new int[128];
		for(int i=0; i<p.length(); i++)
			lettermap[p.charAt(i)]++;
		List<Integer> res = new ArrayList<Integer>();
		int winStart, winEnd;
		winStart = 0;
		winEnd = 0;
		int satisfy = 0;
		while(winEnd < s.length()) {
			lettermap[s.charAt(winEnd)]--;
			if(lettermap[s.charAt(winEnd)] >= 0)
				satisfy++;
			if(winEnd-winStart+1 > p.length()) {
				lettermap[s.charAt(winStart)]++;
				if(lettermap[s.charAt(winStart)] > 0)
					satisfy--;
				winStart++;
			}
			if(satisfy == p.length())
				res.add(winStart);
			winEnd++;
		}
		return res;
		
	}

}
