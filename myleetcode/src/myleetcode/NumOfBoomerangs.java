package myleetcode;

import java.util.HashMap;
import java.util.Map;

public class NumOfBoomerangs {
	public int numberOfBoomerangs(int[][] points){
		int res = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i< points.length; i++){
			for(int j=0; j<points.length; j++){
				if(i==j)
					continue;
				int distance = (points[i][0] - points[j][0])*(points[i][0] - points[j][0])
						+(points[i][1] - points[j][1])*(points[i][1] - points[j][1]);
				map.put(distance, map.getOrDefault(distance, 0)+1);
			}
			for(int k: map.values()){
				res += k*(k-1);
			}
			map.clear();
		}
		return res;
	}
}
