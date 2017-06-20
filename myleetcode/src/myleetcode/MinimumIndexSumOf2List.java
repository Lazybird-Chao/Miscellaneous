package myleetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class MinimumIndexSumOf2List {
	public String[] findRestaurant(String[] list1, String[] list2){
		if(list1 ==null || list1.length==0)
			return new String[0];
		if(list2 ==null || list2.length==0)
			return new String[0];
		
		ArrayList<Integer> recordIndex = new ArrayList<Integer>();
		int max = Integer.MAX_VALUE;
		for(int i=0; i<list1.length; i++){
			String restaurant = list1[i];
			for(int j=0; j<list2.length; j++){
				if(restaurant.equals(list2[j])){
					if(j+i==max){
						recordIndex.add(i);
					}
					else if(i+j < max){
					    max = i+j;
						recordIndex.clear();
						recordIndex.add(i);
					}
				}
			}
		}
		String[] ret = new String[recordIndex.size()];
		for(int i=0; i<recordIndex.size(); i++){
			ret[i] = list1[recordIndex.get(i)];
		}
		return ret;
	}
	
	public String[] method2(String[] list1, String[] list2){
		if(list1 ==null || list1.length==0)
			return new String[0];
		if(list2 ==null || list2.length==0)
			return new String[0];
		
		HashMap<String, Integer> restaurantCat = new HashMap<String, Integer>();
		for(int i=0; i<list1.length; i++){
			restaurantCat.put(list1[i], i);
		}
		ArrayList<Integer> recordIndex = new ArrayList<Integer>();
		int min = Integer.MAX_VALUE;
		for(int j=0; j<list2.length; j++){
			if(restaurantCat.containsKey(list2[j])){
				int indexi = restaurantCat.get(list2[j]);
				if(indexi + j ==min){
					recordIndex.add(j);
				}
				else if(indexi+j < min){
					min = indexi+j;
					recordIndex.clear();
					recordIndex.add(j);
				}
			}
		}
		String[] ret = new String[recordIndex.size()];
		for(int i=0; i<recordIndex.size(); i++){
			ret[i] = list2[recordIndex.get(i)];
		}
		return ret;
		
	}
	

}
