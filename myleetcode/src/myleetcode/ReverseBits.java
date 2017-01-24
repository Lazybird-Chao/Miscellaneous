package myleetcode;

import java.util.HashMap;
import java.util.Map;

public class ReverseBits {
	public int reverseBits(int n){
		int res=0;
		for(int i=0; i<32; i++){
			int lastbit = n&1;
			res = (res<<1)+lastbit;
			n = n>>>1;
		}
		return res;
		
	}
	
	public int method2(int n){
		n = (n >> 16) | (n << 16);
        n = ((n & 0xff00ff00) >> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >> 1) | ((n & 0x55555555) << 1);
        return n;
	}
	
	public int method3(int n){
		Map<Byte, Byte> byteReverseMap = new HashMap<Byte, Byte>();
		
		byte[] byterep = new byte[4];
		byterep[0] = (byte)((n>>24) & 0xFF);
		byterep[1] = (byte)((n>>16) & 0xFF);
		byterep[2] = (byte)((n>>8) & 0xFF);
		byterep[3] = (byte)(n & 0xFF);
		
		int res = 0;
		for(int i=0; i<4; i++){
			if(byteReverseMap.containsKey(byterep[i]))
				res = (res<<8)+ byteReverseMap.get(byterep[i]);
			else{
				byte r = 0;
				for(int j=0; j<8; j++){
					r = (byte) ((r<<1) | ((byterep[i]>>>j)&1));
				}
				res = (res<<8) + r;
				byteReverseMap.put(byterep[i], r);
			}
		}
		
		return res;
	}
}
