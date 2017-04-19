package myleetcode;

public class ReverseWordsInString3 {
	public String reverseWords(String s){
		if(s==null || s.length()==0)
			return new String();
		String[] words = s.split(" ");
		StringBuilder res = new StringBuilder();
		for(int i=0; i<words.length; i++){
			StringBuilder word = new StringBuilder(words[i]);
			res.append(word.reverse());
			if(i<words.length-1)
				res.append(" ");
		}
		return res.toString();
	}
	
	public String method2(String s){
		if(s==null || s.length()==0)
			return new String();
		char[] c1 = s.toCharArray();
		char[] c2 = s.toCharArray();
		for(int i=c1.length-1; i>=0; i--){
			int j=i;
			while(j>=0 && c2[j]!=' ')
				j--;
			int k=j+1;
			while(i!=j){
				c2[k] = c1[i];
				i--;
				k++;
			}
		}
		return new String(c2);
		
		
	}
}
