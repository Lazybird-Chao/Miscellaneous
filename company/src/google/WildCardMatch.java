package google;

public class WildCardMatch {
	/*
	public:
	    bool isMatch(string s, string p) {
	        bool match[p.size()+1][s.size()+1];
	        for(int i=0; i<=p.size(); i++)
	            for(int j=0; j<=s.size(); j++)
	                match[i][j] = false;
	        match[0][0] = true;
	        for(int i=1; i<=s.size(); i++)
	            match[0][i] = false;
	        for(int i=1; i<=p.size(); i++){
	            if(p[i-1]=='*'){
	                if(i==1)
	                    match[i][0] = true;
	                else if(match[i-1][0] == true)
	                    match[i][0] = true;
	                for(int j=1; j<=s.size(); j++){
	                    if(match[i][j-1] || match[i-1][j])
	                        match[i][j] = true;
	                }
	            }else if(p[i-1] == '?'){
	                match[i][0] = false;
	                for(int j=1; j<=s.size(); j++){
	                    if(match[i-1][j-1])
	                        match[i][j] = true;
	                }
	            }else{
	                match[i][0] = false;
	                for(int j=1; j<=s.size(); j++){
	                    if(match[i-1][j-1] && p[i-1] == s[j-1])
	                        match[i][j] = true;
	                }
	            }
	        }
	        return match[p.size()][s.size()];
	    }
	    */
	 public boolean isMatch(String s, String p) {
	        if(s==null || p == null)
	            return false;
	        int i = 1;
	        int j= 1;
	        int stepback_i = 0;
	        int stepback_j = 0;
	        while(i<= s.length()){
	            if(j<=p.length() && p.charAt(j-1)=='*'){
	                stepback_i = i;
	                stepback_j = j+1;
	                j++;
	            }else if(j<=p.length() && (p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1))){
	                i++;
	                j++;
	            }else{
	                if(stepback_i != 0){
	                    i = stepback_i;
	                    j = stepback_j;
	                    stepback_i++;
	                }else
	                    break;
	            }
	        }
	        while(j<=p.length() && p.charAt(j-1) == '*')
	            j++;
	        return i>s.length() && j>p.length();
	    }

}
