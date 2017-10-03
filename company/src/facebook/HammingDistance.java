package facebook;

public class HammingDistance {
	public int hammingDistance(int x, int y) {
        int z = x^y;
        int c = 0;
        while(z!=0){
            if((z&1) == 1)
                c++;
            z = z>>>1;
        }
        return c;
    }

}
