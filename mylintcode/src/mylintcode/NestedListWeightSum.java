package mylintcode;

import java.util.List;

public class NestedListWeightSum {
	public int depthSum(List<NestedInteger> nestedList) {
		if(nestedList == null || nestedList.size()==0)
			return 0;
		return sumCompute(nestedList, 1);
		
	}
	
	int sumCompute(List<NestedInteger> nestedList, int curDepth) {
		int sum = 0;
		for(int i=0; i<nestedList.size(); i++) {
			NestedInteger ni = nestedList.get(i);
			if(ni.isInteger())
				sum += ni.getInteger()*curDepth;
			else
				sum += sumCompute(ni.getList(), curDepth+1);
		}
		return sum;
	}

}
