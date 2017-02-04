package myleetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
	static public List<Integer> topKFrequent(int[] nums, int k){
		Map<Integer, Integer> freqmap = new HashMap<Integer, Integer>();
		for(int i = 0; i<nums.length; i++){
			freqmap.put(nums[i], freqmap.getOrDefault(nums[i], 0)+1);
		}
		List<Integer> topk = new ArrayList<Integer>();
		if(k==freqmap.size()){
			for(int key:freqmap.keySet())
				topk.add(key);
			return topk;
		}
		
		ArrayList<Integer>[] freqlist = new ArrayList[nums.length-freqmap.size()+1 +1];
		for(int key: freqmap.keySet()){
			int v = freqmap.get(key);
			if(freqlist[v] == null){
				freqlist[v] = new ArrayList<Integer>();
			}
			freqlist[v].add(key);
		}	
		int count = k;
		for(int i=freqlist.length-1; i>=0; i--){
			if(freqlist[i] != null){
				topk.addAll(freqlist[i]);
				count =count-freqlist[i].size();
			}
			if(count<=0)
				break;
		}
		if(topk.size()>k){
			int i = topk.size()-1;
			while(i>=k){
				topk.remove(i);
				i--;
			}
		}
		
		return topk;
	}
	
	public static void main(String args[]){
		int[] n = {1,1,1,2,2,3};
		topKFrequent(n, 2);
	}
}
