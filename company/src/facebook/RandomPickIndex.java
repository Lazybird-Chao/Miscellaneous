package facebook;

public class RandomPickIndex {
	class Item implements Comparable<Item>{
        int value;
        List<Integer> index;
        public Item(int v){
            value = v;
            index = new ArrayList<Integer>();
        }
        public int compareTo(Item b){
            return this.value - b.value;
        }
    }
    TreeSet<Item> dataset;
    Random randGen;
    public Solution(int[] nums) {
        randGen = new Random();
        dataset = new TreeSet<Item>();
        for(int i=0; i<nums.length; i++){
            Item item = new Item(nums[i]);
            Item tmp = dataset.floor(item);
            if(tmp != null && tmp.value == item.value){
                tmp.index.add(i);
            }else{
                item.index.add(i);
                dataset.add(item);
            }
        }
    }
    
    public int pick(int target) {
        Item item = new Item(target);
        Item tmp = dataset.floor(item);
        if(tmp != null && tmp.value == item.value){
            return tmp.index.get(randGen.nextInt(tmp.index.size()));
        } else
            return -1;
    }
    
    
    /*
    public int pick(int target) {
        int result = -1;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != target){
                continue;
            }
            int k = rdm.nextInt(++count);
            if(k == 0){
                result = i;
            }
        }
        return result;
    }
    */
}

}
