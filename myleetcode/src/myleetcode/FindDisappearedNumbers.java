package myleetcode;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
	static public List<Integer> findDisappearedNumbers(int[] nums){
		for(int i=0; i< nums.length; i++){
			if(nums[i]!=0 && nums[i] != i+1){
				if(nums[nums[i]-1] == nums[i])
					nums[i] = 0;
				else{
					int tmp = nums[nums[i]-1];
					nums[nums[i]-1]=nums[i];
					nums[i] = tmp;
					i--;
				}
			}
		}
		List<Integer> res = new ArrayList<Integer>();
		for(int i=0; i<nums.length; i++)
			if(nums[i] ==0)
				res.add(i+1);
		return res;
	}
	
	static public void main(String args[]){
		int[] a = {4,3,2,7,8,2,3,1};
		findDisappearedNumbers(a);
		
	}
	
	public List<Integer> method2(int[] nums){
		for(int i=0; i<nums.length; i++){
			nums[(nums[i]-1)%nums.length] += nums.length;
		}
		List<Integer> res = new ArrayList<Integer>();
		for(int i=0; i<nums.length; i++){
			if(nums[i]<=nums.length)
				res.add(i+1);
		}
		return res;
	}
}
