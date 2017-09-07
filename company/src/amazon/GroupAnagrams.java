package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupAnagrams {
	 public List<List<String>> groupAnagrams(String[] strs) {
		 if(strs == null || strs.length == 0)
			 return new ArrayList<List<String>>();
		 List<List<String>> res = new ArrayList<List<String>>();
		 Map<String, Integer> record = new HashMap<String, Integer>();
		 for(int i=0; i<strs.length; i++) {
			 String cur = strs[i];
			 char[] tmp = cur.toCharArray();
			 Arrays.sort(tmp);
			 String sortCur = new String(tmp);
			 int index = 0;
			 if(!record.containsKey(sortCur)) {
				 ArrayList<String> curList = new ArrayList<String>();
				 curList.add(cur);
				 res.add(curList);
				 index = res.size()-1;
				 record.put(sortCur, index);
				 
			 } else {
				 index = record.get(sortCur);
				 res.get(index).add(cur);
			 }
		 }
		 return res;
	 }

}
