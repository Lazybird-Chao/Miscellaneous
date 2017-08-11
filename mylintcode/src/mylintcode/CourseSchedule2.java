package mylintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		if(numCourses == 0)
			return new int[0];
		List<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<numCourses; i++)
			g.add(new ArrayList<Integer>());
		int dim[] = inDim(numCourses, prerequisites, g);
		boolean[] accessed = new boolean[numCourses];
		Queue<Integer> accList = new LinkedList<Integer>();
		int start = findStart(dim, accessed);
		int[] ret = new int[numCourses];
		int count = 0;
		while(start>=0){
			accList.offer(start);
			accessed[start] = true;
			while(accList.isEmpty()==false){
				int cur = accList.poll();
				ret[count] = cur;
				count++;
				accessed[cur] = true;
				for(int i=0; i<g.get(cur).size(); i++){
					int neighbor = g.get(cur).get(i);
					dim[neighbor]--;
					if(accessed[neighbor]==false && dim[neighbor]==0){
						accessed[neighbor] = true;
						accList.offer(neighbor);
					}
				}
			}
			start = findStart(dim, accessed);
		}
		if(count!=numCourses)
		    return new int[0];
		return ret;
	}
	
	public int[] inDim(int numCourses, int[][] prerequisites, List<ArrayList<Integer>> g){
		int[] dim = new int[numCourses];
		for(int i=0; i<prerequisites.length; i++){
			dim[prerequisites[i][0]]++;
			g.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}
		return dim;
	}
	
	public int findStart(int[] dim, boolean[] accessed){
		for(int i=0; i<dim.length; i++)
			if(dim[i]==0 && accessed[i]==false)
				return i;
		return -1;
	}

}
