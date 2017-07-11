package mylintcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	public List<List<String>> partition(String s) {
		if(s==null)
			return new ArrayList<List<String>>();
		List<List<String>> result = new ArrayList<List<String>>();
		List<String> currentR = new ArrayList<String>();
		tryDivide(s, 0, result, currentR);
		return result;
	}
	
	public void tryDivide(String s, int subStringStart, List<List<String>> result, List<String> currentR){
		if(subStringStart > s.length()-1){
			result.add(currentR);
			return;
		}	
		for(int divide = 1; subStringStart+divide <= s.length(); divide++){
			if(isPalindrome(s,subStringStart,subStringStart+divide-1)){
				List<String> newR = new ArrayList<String>();
				newR.addAll(currentR);
				newR.add(s.substring(subStringStart, subStringStart+divide));
				tryDivide(s, subStringStart+divide, result, newR);
			}
		}
		return;
	}
	
	public boolean isPalindrome(String s, int start, int end){
		int i= start;
		int j= end;
		while(i<=j){
			if(s.charAt(i)!= s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}

}
