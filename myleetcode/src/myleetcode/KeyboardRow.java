package myleetcode;

public class KeyboardRow {
	public String[] findWords(String[] words){
		if(words==null || words.length ==0)
			return new String[0];
		char[] s1 = {'q','Q','w','W','e','E','r','R','t','T','y','Y','u','U','i','I','o','O','p','P'};
		char[] s2 = {'a','A','s','S','d','D','f','F','g','G','h','H','j','J','k','K','l','L'};
		char[] s3 = {'z','Z','x','X','c','C','v','V','b','B','n','N','m','M'};
		String[] res = new String[words.length];
		int k=0;
		for(int i=0; i<words.length; i++){
			char[] word = words[i].toCharArray();
			int j;
			if(checkInSet(word[0], s1)){
				for( j=1; j<word.length; j++)
					if(checkInSet(word[j], s1)==false)
						break;
				
			}
			else if(checkInSet(word[0], s2)){
				for( j=1; j<word.length; j++)
					if(checkInSet(word[j], s2)==false)
						break;
			}
			else{
				for( j=0; j<word.length; j++)
					if(checkInSet(word[j], s3)==false)
						break;
			}
			if(j==word.length){
				res[k] = words[i];
				k++;
			}
		}
		String[] r = new String[k];
		for(int i=0; i<k; i++)
			r[i] = new String(res[i]);
		return r;
	}
	
	public boolean checkInSet(char c, char[] s){
		for(int i=0; i<s.length; i++)
			if(c==s[i])
				return true;
		return false;
	}
}
