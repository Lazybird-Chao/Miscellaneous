package amazon;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
        if(s==null || s.length()%2 !=0)
        	return false;
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++) {
        	char c = s.charAt(i);
        	if(c != ')' && c != ']' && c!='}')
        		stack.push(c);
        	else {
        		if(stack.isEmpty())
        			return false;
        		char cc = stack.pop();
        		if(c == ')' && cc != '(')
        			return false;
        		else if(c==']' && cc != '[')
        			return false;
        		else if(c=='}' && cc != '{')
        			return false;
        	}
        }
        return stack.isEmpty();
    }
	
	
	public static void main(String args[]) {
		ValidParentheses test = new ValidParentheses();
		System.out.println(test.isValid("()"));
		return;
	}


}
