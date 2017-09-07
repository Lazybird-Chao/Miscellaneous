package amazon;

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if(s==null || t==null)
			return false;
		if(s.length() != t.length())
			return false;
		
		int[] letters = new int[128];
		for(int i=0; i<s.length(); i++)
			letters[s.charAt(i)]++;
		for(int i=0; i<t.length(); i++) {
			letters[s.charAt(i)]--;
			if(letters[s.charAt(i)] <0)
				return false;
		}
		return true;
        
    }

}
