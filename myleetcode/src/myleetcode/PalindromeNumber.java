package myleetcode;

public class PalindromeNumber {
	public boolean isPalindrome(int x){
		StringBuffer s  = new StringBuffer(Integer.toString(x));
		return s.reverse().toString().equals(Integer.toString(x));
	}
	
	public boolean method2(int x){
		 if(x<0 || (x!=0 && x%10==0))
	            return false;
		int y=0;
		while(y<x){
			y =y*10 + x%10;
			x = x/10;
		}
		if(y==x || y /10 == x)
			return true;
		else
			return false;
	}
}
