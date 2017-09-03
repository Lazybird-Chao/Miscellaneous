package mylintcode;

import java.util.HashMap;
import java.util.Map;

public class StringPermutation {
	public boolean Permutation(String A, String B) {
		if(A==null || B==null)
			return false;
		if(A.isEmpty() && B.isEmpty())
			return true;
		if(A.length()!=B.length())
			return false;	
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(int i=0; i<A.length(); i++) {
			char c = A.charAt(i);
			if(map.containsKey(c))
				map.put(c, map.get(c)+1);
			else
				map.put(c, 1);
		}
		for(int i=0; i<B.length(); i++) {
			char c = B.charAt(i);
			if(map.containsKey(c)) {
				int count  = map.get(c)-1;
				if(count==0)
					map.remove(c);
				else
					map.put(c, count);
			}
			else
				return false;
		}
		return map.isEmpty();
	}
	
	public boolean method2(String A, String B) {
		if(A==null || B==null)
			return false;
		if(A.isEmpty() && B.isEmpty())
			return true;
		if(A.length()!=B.length())
			return false;	
		
		return dfs(A.toCharArray(), 0, B);
		
	}
	
	public boolean dfs(char[] A, int start, String target) {
		if(start==A.length-1) {
			String p = new String(A);
			if(p.equals(target))
				return true;
			else
				return false;
		}
		boolean r = dfs(A, start+1, target);
		if(r)
			return r;
		for(int i=start+1; i<A.length; i++) {
			if(A[start]!=A[i]) {
				swap(A, start, i);
				r = dfs(A, start+1, target);
				swap(A, start, i);
				if(r)
					return r;
			}
		}
		return false;	
	}
	
	public void swap(char[] A, int i, int j) {
		char tmp = A[i];
		A[i] = A[j];
		A[j] = tmp;
		return;
	}
	
	public static void main(String[] args) {
		StringPermutation test = new StringPermutation();;
		System.out.println(test.method2("asdafagaabb", "asaadbgfbba"));
	}

}
