package myleetcode;

public class RepeatedSubstringPattern {
	public boolean repeatedSubstringPattern(String str){
		for(int i = str.length()/2; i>0; i--){
			if(str.length()% i ==0){
				int repeat = str.length()/ i;
				String substr = str.substring(0, i);
				int j;
				for(j=1; j< repeat; j++){
					if(!substr.equals(str.substring(j*i, (j+1)*i)))
							break;
				}
				if(j==repeat)
					return true;
			}
		}
		return false;
	}
}
