package myleetcode;

public class ValidParentheses {
	public boolean isValid(String s){
		if(s==null || s.length()==0)
			return true;
		if(s.length()%2 !=0)
			return false;
		int[] parenthStack = new int[s.length()];
		int j=1;
		parenthStack[0] = s.charAt(0);
		for(int i=1; i<s.length(); i++){
			char c = s.charAt(i);
			if(c=='[' || c=='(' || c=='{'){
				parenthStack[j]=c;
				j++;
			}
			else if((c==')' && parenthStack[j-1] == '(')
					|| (c==']' && parenthStack[j-1]=='[')
					|| (c=='}' && parenthStack[j-1]=='{')){
				j--;
			}
			else
				return false;
		}
		return j==0;
	}
}
