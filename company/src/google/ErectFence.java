package google;

public class ErectFence {
	public List<Point> outerTrees(Point[] points) {
        List<Point> res = new ArrayList<Point>();
        if(points==null || points.length==0)
            return res;
        Arrays.sort(points, new Comparator<Point>(){
            public int compare(Point a, Point b){
                if(a.x != b.x)
                    return a.x - b.x;
                else
                    return a.y - b.y;
            }
        });
        List<Point> top = new ArrayList<Point>();
        List<Point> bot = new ArrayList<Point>();
        bot.add(points[0]);
        for(int i =1; i<points.length; i++){
            if(points[i].x != points[i-1].x){
                top.add(points[i-1]);
                bot.add(points[i]);
            }
        }
        top.add(points[points.length-1]);
        int k=0;
        while(k < points.length && points[k].x == top.get(0).x)
            res.add(points[k++]);
        k = points.length-1;
        while(k >=0 && points[k].x == top.get(top.size()-1).x)
            res.add(points[k--]);
        
        List<Point> bounds = new ArrayList<Point>();
        Point A = null;
        Point B = null;
        Point C = null;
        A = top.get(0);
        if(top.size()>1)
            B = top.get(1);
        for(int i=2; i<top.size(); i++){
            C = top.get(i);
            if((C.y-B.y)*(B.x-A.x) <= (B.y-A.y)*(C.x-B.x)){
                bounds.add(A);
                A = B;
                B = C;
            }else{
                while(bounds.size() > 0){
                    B = A;
                    A = bounds.remove(bounds.size()-1);
                    if((C.y-B.y)*(B.x-A.x) <= (B.y-A.y)*(C.x-B.x)){
                        bounds.add(A);
                        A = B;
                        break;
                    }
                }
                B = C;
            }
        }
        if(A != null)
            bounds.add(A);
        if(B !=null)
            bounds.add(B);
        res.addAll(bounds);
        bounds.clear();
        
        A = B = null;
        A = bot.get(0);
        if(bot.size()>1)
            B = bot.get(1);
        for(int i=2; i<bot.size(); i++){
            C = bot.get(i);
            if((C.y-B.y)*(B.x-A.x) >= (B.y-A.y)*(C.x-B.x)){
                bounds.add(A);
                A = B;
                B = C;
            }else{
                while(bounds.size() > 0){
                    B = A;
                    A = bounds.remove(bounds.size()-1);
                    if((C.y-B.y)*(B.x-A.x) >= (B.y-A.y)*(C.x-B.x)){
                        bounds.add(A);
                        A = B;
                        break;
                    }
                }
                B = C;
            }
        }
        if(A!=null)
            bounds.add(A);
        if(B != null)
            bounds.add(B);
        res.addAll(bounds);
        bounds.clear();
        
        res.sort(new Comparator<Point>(){
            public int compare(Point a, Point b){
                if(a.x != b.x)
                    return a.x - b.x;
                else
                    return a.y - b.y;
            }
        });
        bounds.add(res.get(0));
        for(int i = 1; i<res.size(); i++){
            if(!res.get(i).equals(res.get(i-1)))
                bounds.add(res.get(i));
        }
        
        return bounds;
    }

}
