package myleetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FindModeInBST {
	public int[] findMode(TreeNode root){
		if(root == null)
			return new int[0];
		
		Map<Integer, Integer> freq = helper(root);
		ArrayList<Integer> res = new ArrayList<Integer>();
		for(int k : freq.keySet()){
			if(res.size()==0)
				res.add(k);
			else if(freq.get(k)==freq.get(res.get(0)))
				res.add(k);
			else if(freq.get(k)>freq.get(res.get(0))){
				res.clear();
				res.add(k);
			}			
		}
		
		int[] resA = new int[res.size()];
		for(int i=0; i< res.size(); i++)
			resA[i]= res.get(i);
		
		return resA;		
	}
	
	Map<Integer, Integer> helper(TreeNode root){
		if(root == null)
			return null;
		Map<Integer, Integer> leftfreq, rightfreq, freq;
		
		leftfreq = helper(root.left);
		rightfreq = helper(root.right);
		freq = new HashMap<Integer, Integer>();
		if(leftfreq != null){
			freq.putAll(leftfreq);
		}
		if(rightfreq != null){
			for(int key : rightfreq.keySet()){
				if(freq.containsKey(key))
					freq.put(key, freq.get(key)+rightfreq.get(key));
				else
                    freq.put(key, rightfreq.get(key));
			}
		}
		if(freq.containsKey(root.val))
			freq.put(root.val, freq.get(root.val)+1);
		else
			freq.put(root.val, 1);
		
		return freq;
		
	}
	
	
	class freq{
		int key;
		int freq;
		freq(int k, int f){
			key = k;
			freq = f;
		}
	}
	public int[] method2(TreeNode root){
		if(root == null)
			return new int[0];
		ArrayList<freq> res = new ArrayList<freq>();
		helper2(root, res);
		ArrayList<Integer> res2 = new ArrayList<Integer>();
		int maxfreq = 0;
		for(int i=0; i<res.size(); i++){
			if(res.get(i).freq==maxfreq)
				res2.add(res.get(i).key);
			else if(res.get(i).freq>maxfreq){
				res2.clear();
				res2.add(res.get(i).key);
				maxfreq = res.get(i).freq;
			}
		}
		
		int[] resA = new int[res.size()];
		for(int i=0; i< res2.size(); i++)
			resA[i]= res2.get(i);
		
		return resA;
		
	}
	
	void helper2(TreeNode root, ArrayList<freq> res){
		if(root == null)
			return;
		helper2(root.left, res);
		if(res.size()!=0 && root.val == res.get(res.size()-1).key)
			res.get(res.size()-1).freq += 1;
		else{
			res.add(new freq(root.val, 1));
		}
		helper2(root.right, res);	
	}

}
