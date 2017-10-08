package contest;

public class BinaryNumberWithAlternatingBits {
	public boolean hasAlternatingBits(int n) {
        if(n<1)
            return false;
        int lastbit = n & 1;
        n = n>>1;
        while(n > 0){
            if(lastbit == (n & 1))
                return false;
            lastbit = n&1;
            n = n>>1;
        }
        return true;
    }

}
