package myleetcode;

public class ProductOfArrayExceptSelf {
	public int[] productExceptSelf(int[] nums){
		int[] products = new int[nums.length];
		products[0] = 1;
		for(int i=1; i<nums.length; i++){
			products[i] = products[i-1]*nums[i-1];
		}
		int reversSubProduct = 1;
		for(int i = nums.length-1; i>=0; i--){
			products[i] = reversSubProduct*products[i];
			reversSubProduct *= nums[i];
		}
		return products;
	}
}
