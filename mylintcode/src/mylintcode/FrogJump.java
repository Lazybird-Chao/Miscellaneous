package mylintcode;

import java.util.HashMap;
import java.util.Map;

public class FrogJump {
	public boolean canCross(int[] stones) {
		if(stones==null || stones.length==0)
			return false;
		if(stones.length==1 && stones[0]==0)
		    return true;
		Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		for(int i=0; i<stones.length; i++)
			indexMap.put(stones[i], i);
		boolean[][] jumpBy = new boolean[stones.length][stones.length];
		jumpBy[1][1] = true;
		for(int i=1; i<stones.length; i++) {
			int unit = stones[i];
			for(int j=1; j<stones.length; j++) {
				if(jumpBy[i][j]==true) {
					if(unit+j-1 == stones[stones.length-1] || unit+j == stones[stones.length-1] || unit+j+1 == stones[stones.length-1])
						return true;
					if(j>1) {
						if(indexMap.containsKey(unit+j-1))
							jumpBy[indexMap.get(unit+j-1)][j-1]=true;
					}
					if(indexMap.containsKey(unit+j))
						jumpBy[indexMap.get(unit+j)][j] = true;
					if(indexMap.containsKey(unit+j+1))
						jumpBy[indexMap.get(unit+j+1)][j+1] = true;
				}
			}
		}
		return false;
	}

}
