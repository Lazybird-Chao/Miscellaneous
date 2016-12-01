package myleetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {
	public List<Integer> getRow(int rowIndex){
		List<Integer> ret = new ArrayList<Integer>();
		ret.add(1);
		for(int i=1; i<=rowIndex/2; i++){
			int tmp=1;
			for(int j=i+1;j<=rowIndex; j++)
				tmp *=j;
			for(int j = rowIndex-i; j>=1; j--)
				tmp /= j;
			ret.add(tmp);
		}
		for(int i= rowIndex/2+1; i<=rowIndex; i++)
			ret.add(ret.get(rowIndex-i));
		return ret;
	}	
	
	public List<Integer> method2(int rowIndex){
		 List<Integer> r1;
		List<Integer> r2;
	    r1 = new ArrayList<Integer>(rowIndex+1);
		r2 = new ArrayList<Integer>(rowIndex+1);
		
		if(rowIndex<1){
			r1 = new ArrayList<Integer>();
			r1.add(1);
			return r1;
		}
		
		r1.add(1);
		r1.add(1);
		for(int i= 1; i<=rowIndex; i++){
		    r2.clear();
			r2.add(1);
			for(int j= 1; j<=i-1; j++)
				r2.add(r1.get(j)+r1.get(j-1));
			r2.add(1);
			List<Integer> tmp = r1;
			r1 = r2;
			r2=tmp;
		}
		return r1;
	}
}
