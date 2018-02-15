package google;

public class Heaters {
	 public int findRadius(int[] houses, int[] heaters) {
	        if(houses == null || heaters == null || houses.length==0 || heaters.length==0)
	            return 0;
	        Arrays.sort(heaters);
	        int minrad = 0;
	        for(int i=0; i<houses.length; i++){
	            int minheater = 0;
	            int left = 0;
	            int right = heaters.length-1;
	            while(left+1 < right){
	                int mid = left + (right-left)/2;
	                if(heaters[mid] == houses[i]){
	                    left = mid;
	                    break;
	                }else if(heaters[mid] > houses[i])
	                    right = mid;
	                else
	                    left = mid;
	            }
	            if(Math.abs(heaters[left]-houses[i]) < Math.abs(heaters[right]-houses[i]))
	                minheater = Math.abs(heaters[left]-houses[i]);
	            else
	                minheater = Math.abs(heaters[right]-houses[i]);
	            minrad = Math.max(minrad, minheater);
	        }
	        return minrad;
	    }

}
