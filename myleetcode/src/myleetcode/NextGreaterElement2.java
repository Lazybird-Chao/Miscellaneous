package myleetcode;

import java.util.Stack;

public class NextGreaterElement2 {
	public int[] nextGreaterElements(int[] nums){
		if(nums ==null || nums.length ==0)
			return new int[0];
		int[] res = new int[nums.length];
		for(int i=0; i<nums.length; i++){
			int j=(i+1)%nums.length;
			while(nums[j]<=nums[i]){
				j = (j+1)%nums.length;
				if(j==i)
					break;
			}
			if(j==i)
				res[i] = -1;
			else
				res[i] = nums[j];
		}
		return res;
		
	}
	
	public int[] method2(int[] nums){
		if(nums ==null || nums.length ==0)
			return new int[0];
		int[] res = new int[nums.length];
		Stack<Integer> decStack = new Stack<Integer>();
		decStack.push(0);
		for(int i=1; i<nums.length*2; i++){
			if(i%nums.length == decStack.peek())
				break;
			while(!decStack.empty() && nums[i%nums.length] > nums[decStack.peek()])
				res[decStack.pop()] = nums[i%nums.length];
			if(i<nums.length)
				decStack.push(i%nums.length);
		}
		while(!decStack.empty())
		    res[decStack.pop()] = -1;
		return res;
		
	}
}
