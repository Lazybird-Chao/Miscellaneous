package myleetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum {
	public int[] findFrequentTreeSum(TreeNode root){
		if(root == null)
			return new int[0];
		Map<Integer, Integer> treeSumFreqMap = new HashMap<Integer, Integer>();
		calSum(root, treeSumFreqMap);
		int maxFreq = Integer.MIN_VALUE;
		for(int f: treeSumFreqMap.values()){
			if(maxFreq<f)
				maxFreq = f;
		}
		List<Integer> res = new ArrayList<Integer>();
		for(int k: treeSumFreqMap.keySet())
			if(treeSumFreqMap.get(k) == maxFreq)
				res.add(k);
		int[] r = new int[res.size()];
		for(int i=0; i<res.size(); i++)
			r[i] = res.get(i);
		return r;
	}
	
	public int calSum(TreeNode root, Map<Integer, Integer> freqMap){
		int sum = root.val;
		if(root.left!=null){
			sum += calSum(root.left, freqMap);
		}
		if(root.right!=null){
			sum+= calSum(root.right, freqMap);
		}
		freqMap.put(sum, freqMap.getOrDefault(sum, 0)+1);
		return sum;
	}
}
