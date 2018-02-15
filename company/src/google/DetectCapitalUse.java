package google;

public class DetectCapitalUse {
	bool detectCapitalUse(string word) {
	       if(word.size() < 2)
	           return true;
	        int i=0;
	        if(word[0] <= 'z' && word[0] >='a'){
	            i++;
	            while(i<word.size()){
	                if(word[i] > 'z' || word[i] <'a')
	                    break;
	                i++;
	            }
	            return i==word.size();
	        }else if(word[1] <= 'z' && word[1] >= 'a'){
	            i = 2;
	            while(i<word.size()){
	                if(word[i] > 'z' || word[i] <'a')
	                    break;
	                i++;
	            }
	            return i==word.size();
	        }else{
	            i = 2;
	            while(i<word.size()){
	                if(word[i] <= 'z' && word[i] >= 'a')
	                    break;
	                i++;
	            }
	            return i==word.size();
	        }
	    }

}
