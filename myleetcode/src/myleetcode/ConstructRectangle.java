package myleetcode;

public class ConstructRectangle {
	public int[] constructRectangle(int area){
		if(area<=0)
			return new int[0];
		int sqr = (int)Math.sqrt((double)area);
		int w = sqr;
		int[] ret = new int[2];
		while(w>1){
			if(area % w ==0){
				break;
			}
			w--;
		}
		ret[0] = area/w;
		ret[1] = w;
		return ret;
	}
}
