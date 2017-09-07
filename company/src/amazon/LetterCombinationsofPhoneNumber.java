package amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LetterCombinationsofPhoneNumber {
	public List<String> letterCombinations(String digits) {
		if(digits == null || digits.length() ==0)
			return new ArrayList<String>();
		List<Character>[] digitmap = new List[10];
		for(int i=0; i<10; i++)
			digitmap[i] = new ArrayList<Character>();
		char c = 'a';
		for(int i=2; i<10; i++) {
			int k=3;
			if(i==7 || i==9)
				k = 4;
			for(int j=0; j<k; j++) {
				digitmap[i].add(c);
				c++;
			}
		}
		for(int i=0; i<digits.length(); i++) {
			if(digits.charAt(i)=='0' || digits.charAt(i)=='1')
				return new ArrayList<String>();
		}
		
		List<String> res = new ArrayList<String>();
		Stack<Integer> stack = new Stack<Integer>();
		char[] oneres = new char[digits.length()];
		stack.push(0);
		while(!stack.isEmpty()) {
			int index = stack.size()-1;
			int mapindex = digits.charAt(index)-'0';
			int cur = stack.peek();
			if(cur==digitmap[mapindex].size()) {
				stack.pop();
				continue;
			}
			oneres[index] = digitmap[mapindex].get(cur);
			if(stack.size() == digits.length()) {
				res.add(new String(oneres));
                stack.pop();
			    stack.push(cur+1);
			} else{
                stack.pop();
			    stack.push(cur+1);
			    stack.push(0);
            }	
		}
		return res;
	}
	
	public static void main(String args[]) {
		LetterCombinationsofPhoneNumber test = new LetterCombinationsofPhoneNumber();
		List<String> res = test.letterCombinations("2444833");
		for(String s : res)
			System.out.println(s);
	}

}
