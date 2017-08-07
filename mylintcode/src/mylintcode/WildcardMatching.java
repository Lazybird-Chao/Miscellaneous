package mylintcode;

public class WildcardMatching {
	
	public boolean isMatch(String s, String p) {
		 if(s==null || p==null)
			return false;
		
		boolean[][] status = new boolean[p.length()+1][3];
		status[0][2] = true;
		int curStat1 = 0;
		int curStat2 = 2;
		
		char nextP;
		if(curStat1 == p.length())
			nextP = p.charAt(curStat1-1);
		else
			nextP = p.charAt(curStat1);
		if(nextP == '*') {
			if(curStat2!= 0)
				status[curStat1][curStat2] = false;
			curStat1++;
			if(curStat1>p.length())
				curStat1 = p.length();
			curStat2 = 0;
			status[curStat1][curStat2] = true;
		}
		
		int i=0;
		while(i<s.length()) {
			char ch = s.charAt(i);
			if(curStat1 > p.length())
				curStat1 = p.length();
			if(curStat1 == p.length())
				nextP = p.charAt(curStat1-1);
			else
				nextP = p.charAt(curStat1);
			if(nextP == '*') {
				if(curStat2!= 0)
					status[curStat1][curStat2] = false;
				curStat1++;
				if(curStat1>p.length())
					curStat1 = p.length();
				curStat2 = 0;
				status[curStat1][curStat2] = true;
			}
			else if(nextP == '?') {
				if(curStat2!= 0)
					status[curStat1][curStat2] = false;
				curStat1++;
				if(curStat1>p.length()) {
					curStat1 = p.length();
					int k;
					for( k=curStat1-1; k>=0; k--) {
						if(status[k][0]==true) {
							status[curStat1][curStat2] = false;
							curStat1 = k;
							curStat2 = 0;
							break;
						}
					}
					if(k<0)
						return false;
				}
				else {
					curStat2 = 1;
					status[curStat1][curStat2] = true;
				}
			}
			else {
				if(ch == nextP) {
					if(curStat2!= 0)
						status[curStat1][curStat2] = false;
					curStat1++;
					if(curStat1>p.length()) {
						curStat1 = p.length();
						int k;
						for( k=curStat1-1; k>=0; k--) {
							if(status[k][0]==true) {
								break;
							}		
						}
						if(k<0)
							return false;
					}
					curStat2 = 2;
					status[curStat1][curStat2] = true;
				}
				else {
					if(curStat2==0) {
						// do nothing
					}
					else if(curStat2 ==1 || curStat2 == 2) {
						int k;
						for( k=curStat1-1; k>=0; k--) {
							if(status[k][0]==true) {
								status[curStat1][curStat2] = false;
								curStat1 = k;
								curStat2 = 0;
								break;
							}
						}
						if(k<0)
							return false;
					}
				}
			}
			i++;
		}

		if(curStat1 == p.length())
			nextP = p.charAt(curStat1-1);
		else
			nextP = p.charAt(curStat1);
		if(nextP == '*') {
			if(curStat2!= 0)
				status[curStat1][curStat2] = false;
			curStat1++;
			if(curStat1>p.length())
				curStat1 = p.length();
			curStat2 = 0;
			status[curStat1][curStat2] = true;
		}
		
		if(status[p.length()][0]==true ||
				status[p.length()][1]==true ||
				status[p.length()][2]==true)
			return true;
		else
			return false;	
			
	}
	
	public static void main(String args[]) {
		 WildcardMatching test = new WildcardMatching();
		 System.out.println(test.method2("c", "*?*"));
	}
	
	public boolean method2(String s, String p) {
		if(s==null || p==null)
			return false;
		match = new int[s.length()][p.length()];
		for(int i=0; i<s.length(); i++)
			for(int j=0; j<p.length(); j++)
				match[i][j] = -1;
		return helper(s,0, p,0);
		
		
	}
	
	int[][] match;
	boolean helper(String s, int i, String p, int j) {
		if(i==s.length() && j==p.length())
			return true;
		else if(i==s.length()) {
			for(int k=j; k<p.length(); k++)
				if(p.charAt(k)!='*')
					return false;
			return true;
		}
		else if(j==p.length())
			return false;
		
		if(match[i][j]!=-1)
			return match[i][j]==1;
		
		if(p.charAt(j)=='*') {
			match[i][j] = 0;
			for(int k=i; k<=s.length(); k++) {
				if(helper(s, k, p, j+1)==true) {
					match[i][j]=1;
					break;
				}				
			}	
		}
		else if(p.charAt(j)=='?' || p.charAt(j)==s.charAt(i)) {
			if(helper(s,i+1	, p, j+1)==true)
				match[i][j] = 1;
			else
				match[i][j] = 0;
		}
		else
			match[i][j]=0;		
		
		return match[i][j]==1;
		
	}

}
