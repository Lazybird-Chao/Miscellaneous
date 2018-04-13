package contest;

public class RotateString_796 {
	 bool rotateString(string A, string B) {
	        if(A.size() != B.size())
	            return false;
	        string s = A + A;
	        if(s.find(B) != -1)
	            return true;
	        else
	            return false;
	    }

}
