package mylintcode;

import java.util.ArrayList;

public class PreviousPermutation {
	public ArrayList<Integer> previousPermuation(ArrayList<Integer> nums) {
		if(nums == null || nums.size()==0)
			return new ArrayList<Integer>();
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		int dessendEnd = nums.size()-2;
		while(dessendEnd>=0) {
			if(nums.get(dessendEnd) > nums.get(dessendEnd+1))
				break;
			dessendEnd--;
		}
		if(dessendEnd<0) {
			for(int i=0; i<nums.size(); i++)
				res.add(nums.get(nums.size()-1-i));
			return res;
		}
		for(int i=0; i<=dessendEnd; i++)
			res.add(nums.get(i));
		for(int i= dessendEnd+1; i<nums.size(); i++)
			res.add(nums.get(nums.size()+dessendEnd -i));
		for(int i= dessendEnd+1; i<nums.size(); i++) {
			if(res.get(i)<res.get(dessendEnd)) {
				int tmp = res.get(i);
				res.set(i, res.get(dessendEnd));
				res.set(dessendEnd, tmp);
				break;
			}
		}
		return res;
	}
	
	

}
