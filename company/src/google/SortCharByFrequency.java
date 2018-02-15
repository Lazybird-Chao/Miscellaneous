package google;

public class SortCharByFrequency {
	public String frequencySort(String s) {
        if(s==null || s.isEmpty())
            return "";
        char[] sa = s.toCharArray();
        Pair[] m = new Pair[256];
        for(int i=0; i<256; i++){
            m[i] = new Pair(0, (char)i);
        }
        for(int i=0; i<sa.length; i++){
            m[sa[i]].count++;
        }
        Arrays.sort(m);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<256; i++){
            if(m[i].count==0)
                break;
            for(int j=0; j<m[i].count; j++)
                sb.append(m[i].c);
        }
        return sb.toString();
    }
    class Pair implements Comparable<Pair>{
         int count;
         char c;
         public Pair(int n, char ch){
            count = n;
            c = ch;
        }
        
        public int compareTo(Pair other){
            return other.count - this.count;
        }
    }

}
