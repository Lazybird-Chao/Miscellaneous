package google;

public class KEmptySlot {
	public int kEmptySlots(int[] flowers, int k) {
        if(flowers == null || flowers.length < k+2)
            return -1;
        TreeSet<Integer> bloomPos = new TreeSet<Integer>();
        for(int i = 0; i <= flowers.length - k; i++){
            if(bloomPos.isEmpty())
                bloomPos.add(flowers[i]);
            else{
                Integer left = bloomPos.lower(flowers[i]);
                if(left != null && flowers[i] - left -1 == k){
                   return i+1;
                }
                Integer right = bloomPos.higher(flowers[i]);
                if(right != null && right - flowers[i] -1 == k){
                    return i+1;
                }
                bloomPos.add(flowers[i]);
            }
        }
        return -1;
    }

}
