package mylintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringPermutation2 {
	 public List<String> stringPermutation2(String str) {
		 if(str==null)
			 return new ArrayList<String>();
		 List<String> res = new ArrayList<String>();
		 if(str.isEmpty()) {
			 res.add("");
			 return res;
		 }
		 
		 Map<Character, Integer> letterCount = new HashMap<Character, Integer>();
		 for(int i=0; i<str.length(); i++) {
			 char c = str.charAt(i);
			 if(letterCount.containsKey(c))
				 letterCount.put(c, letterCount.get(c)+1);
			 else
				 letterCount.put(c, 1);
		 }
		 char[] cur = new char[str.length()];
		 helper(res, letterCount, cur, 0);
		 return res;
		 
		 
	 }
	 
	 void helper(List<String> res, Map<Character,Integer> letterCount, char[] cur, int i) {
		 if(i==cur.length) {
			 res.add(new String(cur));
			 return;
		 }
		 for(char c: letterCount.keySet()) {
			 if(letterCount.get(c)>0) {
				 cur[i] = c;
				 letterCount.put(c, letterCount.get(c)-1);
				 helper(res, letterCount, cur, i+1);
				 letterCount.put(c, letterCount.get(c)+1);
			 }
			 
		 }
		 return;
		 
	 }
	 
	 
	 public List<String> method2(String str) {
		 if(str==null)
			 return new ArrayList<String>();
		 List<String> res = new ArrayList<String>();
		 if(str.isEmpty()) {
			 res.add("");
			 return res;
		 }
		 
		 char[] cur = str.toCharArray();
		 Arrays.sort(cur);
		 res.add(new String(cur));
		 while ((cur = nextString(cur)) != null)
			 res.add(new String(cur));
		 return res;
	 }
	 
	 char[] nextString(char[] cur) {
		 int i= cur.length-1;
		 while(i>0) {
			 if(cur[i]>cur[i-1])
				 break;
			 i--;
		 }
		 if(i==0)
			 return null;
		 i--;
		 int j= cur.length-1;
		 while(cur[j]<=cur[i])
			 j--;
		 char tmp = cur[j];
		 cur[j] = cur[i];
		 cur[i] = tmp;
		 
		 for(int l=i+1, r=cur.length-1; l<r; l++,r--) {
			 tmp = cur[l];
			 cur[l] = cur[r];
			 cur[r] = tmp;
		 }
		 return cur;
		 
	 }

}
