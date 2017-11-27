package google;

public class FindKpairsWithSmallestSum {
	public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<int[]>();
        if(nums1 == null || nums2 == null)
            return res;
        if(k>= nums1.length*nums2.length){
            for(int i =0; i<nums1.length; i++){
                for(int j = 0; j<nums2.length; j++){
                    int[] tmp = {nums1[i], nums2[j]};
                    res.add(tmp);
                }
            }
            return res;
        }
        PriorityQueue<int[]> q = new PriorityQueue<int[]>(1, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return nums1[a[0]]+nums2[a[1]] - (nums1[b[0]] + nums2[b[1]]);
            }
        });
        boolean[][] exist = new boolean[nums1.length][nums2.length];
        int[] tmp = {0,0};
        q.offer(tmp);
        exist[0][0] = true;
        while(res.size()<k && !q.isEmpty()){
            int[] cur = q.poll();
            int[] tmp1 = {nums1[cur[0]], nums2[cur[1]]};
            res.add(tmp1);
            if(cur[0]+1 < nums1.length && exist[cur[0]+1][cur[1]] == false){
                int[] tmp2 = {cur[0]+1, cur[1]};
                q.offer(tmp2);
                exist[cur[0]+1][cur[1]] = true;
            }
            if(cur[1]+1 < nums2.length && exist[cur[0]][cur[1]+1] == false){
                int[] tmp3 = {cur[0], cur[1]+1};
                q.offer(tmp3);
                exist[cur[0]][cur[1]+1] = true;
            }
        }
        return res;
    }

}
