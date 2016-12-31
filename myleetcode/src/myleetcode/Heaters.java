package myleetcode;

import java.util.Arrays;

public class Heaters {
	public int findRadius(int[] houses, int[] heaters){
		if(houses.length==0 || heaters.length==0)
			return 0;
		int[] minH = new int[houses.length];
		for(int i=0; i<houses.length; i++){
			minH[i]= Math.abs(houses[i] - heaters[0]);
			for(int j=1; j<heaters.length; j++){
				int tmp = Math.abs(houses[i]-heaters[j]);
				if(minH[i] > tmp)
					minH[i] = tmp;
			}
		}
		int minR = minH[0];
		for(int i=1; i<houses.length; i++)
			if(minR < minH[i])
				minR = minH[i];
		return minR;
			
	}
	
	public int method2(int[] houses, int[] heaters){
		if(houses.length==0 || heaters.length==0)
			return 0;
		
		Arrays.sort(houses);
		Arrays.sort(heaters);
		int i,j;
		int minR = 0;
		for(i=0; i< houses.length; i++){
			if(houses[i]<heaters[0]){
				int tmp = heaters[0]-houses[i];
				if(minR < tmp)
					minR = tmp;
			}
			else
				break;
		}
		j=1;
		for(;i<houses.length; i++){
			if(j>heaters.length-1)
				break;
			if(houses[i]<heaters[j]){
				int tmp1 = houses[i] - heaters[j-1];
				int tmp2 = heaters[j]-houses[i];
				int tmp = tmp1<tmp2? tmp1: tmp2;
				if(minR < tmp)
					minR = tmp;
			}
			else{
				j++;
				i--;
			}		
		}
		for(;i<houses.length; i++){
			int tmp = houses[i] - heaters[heaters.length-1];
			if(minR < tmp)
				minR = tmp;
		}
		
		return minR;
		
	}
}
