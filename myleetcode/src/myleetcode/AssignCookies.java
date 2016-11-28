package myleetcode;

import java.util.Arrays;

public class AssignCookies {
	public int findContentChildren(int[] g, int[] s){
		int content = 0;
		Arrays.sort(g);
		Arrays.sort(s);
		int j= g.length-1;
		for(int i= s.length-1; i>=0; i--){
			int size = s[i];
			for(;j>=0; j--){
				if(size >= g[j]){
					content++;
					j--;
					break;
				}
			}
			if( j<0)
				break;
		}
		return content;
	}
}
