package myleetcode;

public class IsomorphicStrings {
	static public boolean isIsomorphic(String s, String t){
		int []charmap = new int[256];
		int []pos_s = new int[s.length()];
		int []pos_t = new int[t.length()];
		for(int i=0; i<s.length(); i++){
			if(charmap[(int)s.charAt(i)] >0)
				pos_s[i] = charmap[(int)s.charAt(i)];
			else{
				pos_s[i] = i+1;
				charmap[(int)s.charAt(i)] = i+1;
			}	
		}
		for(int i=0; i<256;i++)
			charmap[i]=0;
		for(int i=0; i<t.length(); i++){
			if(charmap[(int)t.charAt(i)] >0)
				pos_t[i] = charmap[(int)t.charAt(i)];
			else{
				pos_t[i] = i+1;
				charmap[(int)t.charAt(i)] = i+1;
			}	
		}
		int j;
		for( j=0; j<s.length(); j++)
			if(pos_s[j]!=pos_t[j])
				break;
		return j==s.length();
	}
	
	public boolean method2(String s, String t){
		int[] s_map = new int[256];
		int[] t_map = new int[256];
		for(int i=0; i<s.length(); i++){
			if(s_map[(int)s.charAt(i)]==0)
				s_map[(int)s.charAt(i)] = i+1;
			if(t_map[(int)s.charAt(i)]==0)
				t_map[(int)s.charAt(i)] = i+1;
			if(s_map[(int)s.charAt(i)] != t_map[(int)t.charAt(i)])
				return false;
		}
		return true;
	}
	
	public static void main(String arg[]){
		System.out.println(isIsomorphic("ab","aa"));
	}
}
