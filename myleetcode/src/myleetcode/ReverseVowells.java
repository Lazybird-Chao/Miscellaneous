package myleetcode;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowells {
	public String reverseVowels(String s){
		ArrayList<Character> vowels = new ArrayList<Character>();
		Set<Character> vowelTable = new HashSet<Character>();
		vowelTable.add('a');
		vowelTable.add('e');
		vowelTable.add('i');
		vowelTable.add('o');
		vowelTable.add('u');
		
		char[] ss = s.toCharArray();
		for(int i=0; i<s.length(); i++){
			if(vowelTable.contains(ss[i])){
					vowels.add(ss[i]);
					ss[i] = '\0';
			}
		}
		int j=vowels.size()-1;
		for(int i=0; i<s.length(); i++){
			if(ss[i]=='\0'){
				ss[i]=vowels.get(j);
				j--;
			}
		}
		
		String ret = new String(ss);
		return ret;
	}
	
	public String method2(String s){
		Set<Character> vowelTable = new HashSet<Character>();
		vowelTable.add('a');
		vowelTable.add('e');
		vowelTable.add('i');
		vowelTable.add('o');
		vowelTable.add('u');
		vowelTable.add('A');
		vowelTable.add('E');
		vowelTable.add('I');
		vowelTable.add('O');
		vowelTable.add('U');
		
		char[] ss = s.toCharArray();
		for(int i=0, j=s.length()-1; i<j; i++){
			if(vowelTable.contains(ss[i])){
				for(;j>i; j--){
					if(vowelTable.contains(ss[j])){
						char tmp = ss[j];
						ss[j] =ss[i];
						ss[i] =tmp;
						break;
					}
				}
			}
		}
		String ret = new String(ss);
		
		return ret;
	}
}
