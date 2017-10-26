package google;

public class RepeatedStringMatch {
	public int repeatedStringMatch(String A, String B) {
        if(A == null || B == null)
            return -1;
        if(B.isEmpty() || A.equals(B))
            return 1;
        if(A.isEmpty())
            return -1;
        if(A.contains(B))
            return 1;
        if(B.contains(A)){
            int k = (B.length() + A.length()-1) / A.length();
            String s = "";
            for(int i = 0; i< k; i++)
                s += A;
            if(s.contains(B))
                return k;
            else{
                s += A;
                if(s.contains(B))
                    return k+1;
                else
                    return -1;
            }
        }else{
            String s = "";
            s = A+A;
            if(s.contains(B))
                return 2;
            else
                return -1;
        }
        
    }

}
