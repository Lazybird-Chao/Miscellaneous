package google;

public class UTF8Validate {
	public boolean validUtf8(int[] data) {
        if(data == null || data.length == 0)
            return false;
        int i = 0;
        int b4 = 128+64+32+16;
        int b44 = 8;
        int b3 = 128+64+32;
        int b33 = 16;
        int b2 = 128+64;
        int b22 = 32;
        int b1 = 128;
        while(i < data.length){
            if((data[i] & b4)==b4 && (data[i] & b44)==0){
                if(!startWithOneZero(data, i+1, 3))
                    return false;
                i += 4;
            }else if((data[i] & b3)==b3 && (data[i] & b33)==0){
                if(!startWithOneZero(data, i+1, 2))
                    return false;
                i += 3;
            }else if((data[i] & b2)==b2 && (data[i] & b22)==0){
                if(!startWithOneZero(data, i+1, 1))
                    return false;
                i+=2;
            }else if((data[i] & b1) == 0){
                i++;
            }else
                return false;
        }
        return true;
    }
    
    boolean startWithOneZero(int[] data, int idx, int count){
        while(idx < data.length && count > 0){
            if((data[idx] & 128) != 128 || (data[idx] & 64)!=0)
                return false;
            count--;
            idx++;
        }
        return count == 0;
    }

}
