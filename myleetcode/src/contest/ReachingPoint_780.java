package contest;

public class ReachingPoint_780 {
	bool reachingPoints(int sx, int sy, int tx, int ty) {
        int x = tx;
        int y = ty;
        while( x >= sx && y >= sy){
            if(x==sx && y==sy)
                return true;
            int tmpx = x;
            int tmpy = y;
            if(x > y){
                if(sx < y){
                    x = x % y;
                    if(x == 0)
                        x = y;
                }else{
                    x = (x%y) + (sx/y)*y;
                }  
            }else if(x < y){
                if(sy < x){
                    y = y % x;
                    if(y==0)
                        y = x;
                }else{
                    y = (y%x) + (sy/x)*x;
                }
                
            }else
                return false;
            if(tmpx == x && tmpy == y)
                break;
        }
        return false;
    }

}
