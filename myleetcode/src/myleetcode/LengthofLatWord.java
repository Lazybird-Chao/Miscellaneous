package myleetcode;

public class LengthofLatWord {
	public int lengthOfLastWord(String s){
		String[] subs = s.split("[ ]");
		if(subs.length != 0){
			return subs[subs.length].length();
		}
		else
			return 0;
	}
	
	public int method2(String s){
		int i= s.length()-1;
		int count = 0;
		while(i>=0 && s.charAt(i)==' ')
			i--;
		while(i>=0 && s.charAt(i)!=' '){
			i--;
			count++;
		}
		return count;
	}
	
	public int method3(String s){
		return s.trim().length()-s.trim().lastIndexOf(" ")-1;
	}
}
