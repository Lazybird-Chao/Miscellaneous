package google;

public class Hindex {
	/*
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;
        Arrays.sort(citations);
        for(int i = 0; i < citations.length; i++){
            if(citations[i] >= citations.length-i)
                return citations.length-i;
        }
        return 0;
    }
    */
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0)
            return 0;
        int[] count = new int[citations.length+1];
        for(int i= 0; i < citations.length; i++){
            if(citations[i] >=citations.length)
                count[citations.length]++;
            else
                count[citations[i]]++;
        }
        int sum = 0;
        for(int i = count.length-1; i>=0; i--){
            count[i] += sum;
            if(count[i] >= i)
                return i;
            else
                sum = count[i];
        }
        return 0;
    }

}
