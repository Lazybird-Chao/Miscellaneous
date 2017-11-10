package google;

public class QueueReconWithHeight {
	public int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0 || people[0].length == 0)
            return new int[0][0];
        Arrays.sort(people, new Comparator<int[]>(){
           public int compare(int[] a, int[] b){
               if(a[0] != b[0])
                   return b[0] - a[0];
               else
                   return a[1] - b[1];
           } 
        });
        List<int[]> res = new LinkedList<int[]>();
        for(int i = 0; i < people.length; i++){
            int pos = people[i][1];
            res.add(pos, people[i]);
        }
        int[][] res2 = new int[people.length][people[0].length];
        for(int i = 0; i< res.size(); i++)
            res2[i] = res.get(i);
        return res2;
    }

}
