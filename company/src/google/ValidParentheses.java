package google;

public class ValidParentheses {
	public boolean isValid(String s) {
        if(s == null || s.length() == 0 || s.length() % 2 != 0)
            return false;
        char[] sa = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        int i = 0;
        while( i < sa.length){
            if(stack.isEmpty() || sa[i] == '(' || sa[i] == '{' || sa[i] == '[')
                stack.push(sa[i]);
            else if(stack.isEmpty())
                return false;
            else if(sa[i]==')' && stack.pop() != '(')
                return false;
            else if(sa[i]==']' && stack.pop() != '[')
                return false;
            else if(sa[i]=='}' && stack.pop() != '{')
                return false;
            i++;
        }
        return stack.isEmpty();
    }

}
