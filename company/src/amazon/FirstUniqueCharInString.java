package amazon;

public class FirstUniqueCharInString {
	public int firstUniqChar(String s) {
		if(s==null || s.length() ==0)
			return -1;
		int[] letter = new int[128];
		for(int i=0; i<s.length(); i++)
			letter[s.charAt(i)]++;
		for(int i=0; i<s.length(); i++)
			if(letter[s.charAt(i)]==1)
				return i;
		return -1;
	}

}
