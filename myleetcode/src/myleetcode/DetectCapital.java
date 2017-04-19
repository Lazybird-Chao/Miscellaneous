package myleetcode;

public class DetectCapital {
	public boolean detectCapitalUse(String word){
		if(word == null || word.length()==0)
			return true;
		
		if(word.length()==1)
			return true;
		else{
			if(word.charAt(0)>'Z' ||
					(word.charAt(0)<='Z' && word.charAt(1)>'Z')){
				for(int i=1; i<word.length(); i++)
					if(word.charAt(i)<='Z')
						return false;
			}
			else{
				for(int i=2; i<word.length(); i++)
					if(word.charAt(i)>'Z')
						return false;
			}		
		}
		return true;
		
	}
}
