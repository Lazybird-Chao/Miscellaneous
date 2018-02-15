package google;

public class DesignCompresedStringIterator {
	class StringIterator {
		public:
		    string s;
		    int count;
		    char c;
		    StringIterator(string compressedString) {
		        s = compressedString;
		        c = 0;
		        count = 0;
		    }
		    
		    char next() {
		        if(count==0 && s.empty())
		            return ' ';
		        else if(count==0){
		            c = s[0];
		            int i=1;
		            for(; i<s.size(); i++){
		                if(s[i]>='0' && s[i]<='9'){
		                    count *= 10;
		                    count += s[i]-'0';
		                }else
		                    break;
		            }
		            s = s.substr(i);
		        }
		        count--;
		        return c;
		    }
		    
		    bool hasNext() {
		        if(count==0 && s.empty())
		            return false;
		        else
		            return true;
		    }
		};


}
