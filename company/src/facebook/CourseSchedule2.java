package facebook;

public class CourseSchedule2 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        if(prerequisites == null || prerequisites.length == 0){
            for(int i =0; i < numCourses; i++)
                res[i] = i;
            return res;
        }
        List[] g = new List[numCourses];
        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++){
            int to = prerequisites[i][0];
            int from = prerequisites[i][1];
            indegree[to]++;
            if(g[from]==null)
                g[from] = new ArrayList<Integer>();
            g[from].add(to);
        }
        Queue<Integer> zeroDegree = new LinkedList<Integer>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0)
                zeroDegree.add(i);
        }
        int index = 0;
        while(!zeroDegree.isEmpty()){
            int from = zeroDegree.poll();
            res[index++] = from;
            if(g[from] != null){
                for(int i =0; i< g[from].size(); i++){
                    int to = (int)g[from].get(i);
                    indegree[to]--;
                    if(indegree[to]==0)
                        zeroDegree.offer(to);
                }
            }
        }
        if(index == numCourses)
            return res;
        else
            return new int[0];
        
    }

}
