package myleetcode;

public class FindDidff {
	public char findTheDifference(String s, String t){
		char diffc='\0';
		char[] sarray = s.toCharArray();
		char[] tarray = t.toCharArray();
		int[] letterTable = new int[26];
		for(int i=0; i<s.length(); i++)
			letterTable[sarray[i]-'a']++;
		for(int i=0; i<t.length(); i++){
			letterTable[tarray[i]-'a']--;
			if(letterTable[tarray[i]-'a'] <0){
				diffc = tarray[i];
				break;
				}
		}
		return diffc;
	}
	
	public char method2(String s, String t){
		char diffc = '\0';
		diffc = t.charAt(t.length()-1);
		for(int i=0; i<s.length(); i++){
			diffc ^= s.charAt(i);
			diffc ^= t.charAt(i);
		}
		return diffc;
		
	}
}
