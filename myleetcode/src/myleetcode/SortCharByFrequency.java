package myleetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SortCharByFrequency {
	public String frequencySort(String s){
		Map<Character, Integer> freq = new HashMap<Character, Integer>();
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			if(freq.containsKey(c))
				freq.put(c, freq.get(c)+1);
			else
				freq.put(c, 1);
		}
		ArrayList<Character> seq_freq = new ArrayList<Character>();
		for(char k:freq.keySet()){
			int i=0; 
			while(i<seq_freq.size()){
				if(freq.get(seq_freq.get(i)) < freq.get(k))
					break;
				i++;
			}
			seq_freq.add(i,k);
		}
		char[] rc = new char[s.length()];
		for(int i=0; i<seq_freq.size(); i++){
			char c = seq_freq.get(i);
			for(int j=0; j<freq.get(c); j++)
				rc[i+j] = c;
		}
		return new String(rc);
	}
	
	public String method2(String s){
		Map<Character, Integer> freq = new HashMap<Character, Integer>();
		int maxcount=0;
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			if(freq.containsKey(c))
				freq.put(c, freq.get(c)+1);
			else
				freq.put(c, 1);
			if(maxcount<freq.get(c))
				maxcount = freq.get(c);			
		}
		
		StringBuilder[] bucket = new StringBuilder[maxcount+1];
		for(char k: freq.keySet()){
			int count = freq.get(k);
			if(bucket[count]==null)
				bucket[count] = new StringBuilder();
			for(int i=0; i<count; i++)
				bucket[count].append(k);		
		}
		StringBuilder ret=new StringBuilder();
		for(int i=maxcount; i>=0; i--)
			if(bucket[i]!=null)
				ret.append(bucket[i]);
		return ret.toString();
	}
}
