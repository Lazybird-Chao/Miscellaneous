package myleetcode;

public class ValidPalindrome {
	public boolean isPalindrome(String s){
		char[] s_char = s.toCharArray();
		int i,j;
		i=0;
		j=s_char.length-1;
		while(i<j){
			char t1, t2;
			if((s_char[i]<='9' && s_char[i]>='0') ||
					(s_char[i]>='a' && s_char[i]<='z') ||
					(s_char[i]>='A' && s_char[i]<='Z'))
				t1 = s_char[i];
			else{
				i++;
				continue;
			}
			if((s_char[j]<='9' && s_char[j]>='0') ||
					(s_char[j]>='a' && s_char[j]<='z') ||
					(s_char[i]>='A' && s_char[i]<='Z'))
				t2 = s_char[j];
			else{
				j--;
				continue;
			}
			
			if((t1==t2) || (t1>'9' && (t1==t2+'A'-'a' || t2 == t1 + 'A'-'a'))){
				i++;
				j--;
			}
			else
				break;
		}
		return i<j ? false:true;
	}
	
	
	public boolean method2(String s){
		String s_tmp = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		String s_tmp2 = new StringBuffer(s_tmp).reverse().toString();
		return s_tmp.equals(s_tmp2);
	}
}
