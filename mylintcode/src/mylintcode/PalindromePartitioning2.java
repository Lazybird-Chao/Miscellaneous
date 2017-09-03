package mylintcode;

public class PalindromePartitioning2 {
	public int minCut(String s) {
		if(s==null || s.isEmpty())
			return 0;
		
		int[] f = new int[s.length()+1];
		f[0] = 0;
		for(int i=1; i<=s.length(); i++) {
			f[i] = Integer.MAX_VALUE;
			for(int j=i-1; j>=0; j--) {
				if(isPalindrome(s.substring(j, i))) {
					f[i] = Math.min(f[i], f[j]+1);
				}
			}
		}
		return f[s.length()]-1;
		
	}
	
	boolean isPalindrome(String s) {
		int i=0;
		int j=s.length()-1;
		while(i<j) {
			if(s.charAt(i)!=s.charAt(j))
				return false;
			++i;
			--j;
		}
		return true;
	}
	
	
	/*
	 * A dp method to compute all the possible palindrome in a string
	 */
	private boolean[][] getIsPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }

        for (int length = 2; length < s.length(); length++) {
            for (int start = 0; start + length < s.length(); start++) {
                isPalindrome[start][start + length]
                    = isPalindrome[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start + length);
            }
        }

        return isPalindrome;
    }


}
