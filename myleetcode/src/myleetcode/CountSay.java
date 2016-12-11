package myleetcode;

import java.util.ArrayList;

public class CountSay {
	public String countAndSay(int n){
		ArrayList<Integer> L1 = new ArrayList<Integer>();
		ArrayList<Integer> L2 = new ArrayList<Integer>();
		L1.add(1);
		for(int i=2; i<=n; i++){
			int count=1;
			L2.clear();
			for(int j=0; j<L1.size()-1; j++){
				if(L1.get(j) == L1.get(j+1)){
					count++;
				}
				else{
					L2.add(count);
					L2.add(L1.get(j));
					count = 1;
				}
			}
			L2.add(count);
			L2.add(L1.get(L1.size()-1));
			ArrayList<Integer> tmp = L2;
			L2 = L1;
			L1 = tmp;
		}
		StringBuilder ret = new StringBuilder();
		for(int i=0; i<L1.size(); i++)
			ret.append(Integer.toString(L1.get(i)));
		return ret.toString();
	}
}
