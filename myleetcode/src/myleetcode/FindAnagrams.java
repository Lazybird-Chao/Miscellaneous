package myleetcode;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
	public List<Integer> findAnagrams(String s, String p){
		if(s.length()< p.length())
			return new ArrayList<Integer>();
		List<Integer> ret = new ArrayList<Integer>();
		int[] letter = new int[256];
		for(int i=0; i<256; i++)
			letter[i] = 0;
		for(int i=0; i< p.length(); i++)
			letter[p.charAt(i)]++;
		int i=0;
		while(i<s.length()-p.length()+1 ){
			if(p.contains(Character.toString(s.charAt(i)))){
				String subs = s.substring(i, i+p.length());
				int[] tmp = letter.clone();
				int j=0;
				for(j=0; j<subs.length(); j++){
					tmp[subs.charAt(j)]--;
				}
				for( j=0; j<256; j++)
					if(tmp[j]!=0)
						break;
				if(j==256){
					ret.add(i);
				}
			}
			i++;
		}
		return ret;
	}
	
	public List<Integer> method2(String s, String p){
		if(s.length()<p.length())
			return new ArrayList<Integer>();
		List<Integer> ret = new ArrayList<Integer>();
		int[] letter = new int[256];
		for(int i=0; i<256; i++)
			letter[i]=0;
		for(int i=0; i<p.length(); i++)
			letter[p.charAt(i)]++;
		int left=0;
		int right = 0;
		int count = p.length();
		while(right < s.length()){
			if(letter[s.charAt(right)]>0){
				count--;
			}
			letter[s.charAt(right)]--;
			right++;
			if(count==0)
				ret.add(left);
			if(right-left == p.length()){
				if(letter[s.charAt(left)]>=0)
					count++;
				letter[s.charAt(left)]++;
				left++;
			}
			
		}
		return ret;
	}
}
