package myleetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	public List<List<Integer>> generate(int numRows){
		// (n,k) = (n, k-1)*(n-k+1)/k
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		for(int i=0; i<numRows; i++){
			List<Integer> rowi = new ArrayList<Integer>();
			// (n, 0)=1
			rowi.add(1);
			int k=1;
			for(; k<=i/2; k++)
				rowi.add(rowi.get(k-1)*(i-1+1)/k);
			for(; k<= i; k++)
				rowi.add(rowi.get(i-k));
			ret.add(rowi);
		}
		return ret;
	}
	
	public List<List<Integer>> method2(int numRows){
		// (n, k) = (n-1, k) + (n-1, k-1)
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if(numRows>0){
			List<Integer> rowi = new ArrayList<Integer>();
			rowi.add(1);
			ret.add(rowi);
		}
		for(int i=1; i<numRows; i++){
			List<Integer> rowi = new ArrayList<Integer>();
			// (n, 0)=1
			rowi.add(1);
			int k=1;
			List<Integer> rowii = ret.get(i-1);
			for(; k<=i/2; k++)
				rowi.add(rowii.get(k)+rowii.get(k-1));
			for(; k<= i; k++)
				rowi.add(rowi.get(i-k));
			ret.add(rowi);
		}
		return ret;
	}
}
