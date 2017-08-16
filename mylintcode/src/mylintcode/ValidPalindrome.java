package mylintcode;

public class ValidPalindrome {
	 public boolean isPalindrome(String s) {
		 if(s==null)
			 return false;
		 if(s.isEmpty())
			 return true;
		 char[] s_char = s.toCharArray();
		 int i, j;
		 i=0;
		 j=s_char.length-1;
		 while(i<=j) {
			 if(validChar(s_char[i]) && validChar(s_char[j])) {
				 if(s_char[i]==s_char[j] || s_char[i]==s_char[j]+('A'-'a') ||
						 s_char[j]==s_char[i]+('A'-'a') ) {
					 ++i;
					 --j;
					 continue;
				 }
				 else
					 break;
			 }
			 if(!validChar(s_char[i]))
				 ++i;
			 if(!validChar(s_char[j]))
				 ++j;
		 }
		 if(i<=j)
			 return false;
		 else
			 return true;
	 }
	 
	 boolean validChar(char c) {
		 if(c>='a' && c<='z')
			 return true;
		 if(c>='A' && c<='Z')
			 return true;
		 if(c>='0' && c<='9')
			 return true;
		 return false;
	 }

}
