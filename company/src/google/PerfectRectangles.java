package google;

public class PerfectRectangles {
	class Solution {
	    /*
	    public boolean isRectangleCover(int[][] rectangles) {
	        if(rectangles == null || rectangles.length == 0 || rectangles[0].length == 0)
	            return false;
	        int xmin = Integer.MAX_VALUE;
	        int ymin = Integer.MAX_VALUE;
	        int xmax = 0;
	        int ymax = 0;
	        for(int i = 0; i < rectangles.length; i++){
	            xmin = Math.min(xmin, rectangles[i][0]);
	            ymin = Math.min(ymin, rectangles[i][1]);
	            xmax = Math.max(xmax, rectangles[i][2]);
	            ymax = Math.max(ymax, rectangles[i][3]);
	        }
	        int[][] area = new int[ymax-ymin][xmax-xmin];
	        int count = 0;
	        for(int i = 0; i < rectangles.length; i++){
	            for(int x = rectangles[i][0]; x < rectangles[i][2]; x++){
	                for(int y = rectangles[i][1]; y < rectangles[i][3]; y++){
	                    if(area[y-ymin][x-xmin] == 1)
	                        return false;
	                    else
	                        area[y-ymin][x-xmin] = 1;
	                    count++;
	                }
	            }
	        }
	        if(count == (ymax-ymin)*(xmax-xmin))
	            return true;
	        else
	            return false;
	    }
	    */
	    
	    /*
	    public boolean isRectangleCover(int[][] rectangles) {
	        if(rectangles == null || rectangles.length == 0 || rectangles[0].length == 0)
	            return false;
	        int xmin = Integer.MAX_VALUE;
	        int ymin = Integer.MAX_VALUE;
	        int xmax = 0;
	        int ymax = 0;
	        int area = 0;
	        for(int i = 0; i < rectangles.length; i++){
	            xmin = Math.min(xmin, rectangles[i][0]);
	            ymin = Math.min(ymin, rectangles[i][1]);
	            xmax = Math.max(xmax, rectangles[i][2]);
	            ymax = Math.max(ymax, rectangles[i][3]);
	            area += (rectangles[i][2]-rectangles[i][0]) * (rectangles[i][3]-rectangles[i][1]);
	        }
	        if(area != (ymax-ymin)*(xmax-xmin))
	            return false;
	        System.out.println((ymax-ymin)*(xmax-xmin));
	        System.out.println(area);
	        Arrays.sort(rectangles, new Comparator<int[]>(){
	            public int compare(int[] a, int[] b){
	                if(a[0] != b[0])
	                    return a[0] -b[0];
	                else
	                    return a[2] - b[2];
	            }
	        });
	        
	        LinkedList<int[]> list = new LinkedList<int[]>();
	        list.addLast(rectangles[0]);
	        for(int i = 1; i < rectangles.length; i++){
	            int[] cur = rectangles[i]; 
	            while(!list.isEmpty() && cur[0] >= list.getFirst()[2]){
	                list.removeFirst();
	            }
	            if(list.isEmpty()){
	                list.addLast(cur);
	                continue;
	            }
	            int j = 0;
	            while(j < list.size()){
	                int[] hoverlap = list.get(j);
	                if((cur[1] <= hoverlap[1] && cur[3] > hoverlap[1]) || 
	                       (cur[1] < hoverlap[3] && cur[3] >= hoverlap[3]))
	                    return false;
	                if(cur[2]<= list.get(j)[2]){
	                    list.add(j, cur);
	                    j++;
	                }else if(j == list.size()-1){
	                    list.addLast(cur);
	                    j++;
	                }
	                j++;
	            }  
	        }
	        
	        return true;
	    }
	    */
	    public boolean isRectangleCover(int[][] rectangles) {
	        if(rectangles == null || rectangles.length == 0 || rectangles[0].length == 0)
	            return false;
	        int xmin = Integer.MAX_VALUE;
	        int ymin = Integer.MAX_VALUE;
	        int xmax = 0;
	        int ymax = 0;
	        int area = 0;
	        for(int i = 0; i < rectangles.length; i++){
	            xmin = Math.min(xmin, rectangles[i][0]);
	            ymin = Math.min(ymin, rectangles[i][1]);
	            xmax = Math.max(xmax, rectangles[i][2]);
	            ymax = Math.max(ymax, rectangles[i][3]);
	            area += (rectangles[i][2]-rectangles[i][0]) * (rectangles[i][3]-rectangles[i][1]);
	        }
	        if(area != (ymax-ymin)*(xmax-xmin))
	            return false;
	        //System.out.println((ymax-ymin)*(xmax-xmin));
	        //System.out.println(area);
	        Arrays.sort(rectangles, new Comparator<int[]>(){
	            public int compare(int[] a, int[] b){
	                if(a[0] != b[0])
	                    return a[0] -b[0];
	                else
	                    return a[2] - b[2];
	            }
	        });
	        
	        PriorityQueue<int[]> q  = new PriorityQueue<int[]>(1, new Comparator<int[]>(){
	            public int compare(int[] a, int[] b){
	                if(a[2] != b[2])
	                    return a[2]-b[2];
	                else
	                    return a[1]-b[1];
	            }
	        });
	        TreeSet<int[]> set = new TreeSet<int[]>(new Comparator<int[]>(){
	            public int compare(int[] a , int[] b){
	                if(a[1] != b[1])
	                    return a[1] - b[1];
	                else if(a[3] != b[3])
	                    return a[3] -b[3];
	                else if(a[0] != b[0])
	                    return a[0] -b[0];
	                else
	                    return a[2]-b[2];
	            }
	        });
	        int i = 0;
	        while(i < rectangles.length){
	            int[] cur = rectangles[i]; 
	            if(q.isEmpty()){
	                q.offer(cur);
	                set.add(cur);
	                i++;
	            }else{
	                while(!q.isEmpty() && cur[0] >= q.peek()[2]){
	                    int[] tmp = q.poll();
	                    set.remove(tmp);
	                }
	                q.offer(cur);
	                int[] up = set.ceiling(cur);
	                if(up != null && up[1] < cur[3])
	                    return false;
	                int[] low = set.floor(cur);
	                if(low != null && low[3] > cur[1])
	                    return false;
	                set.add(cur);
	                i++;
	            }
	        }
	        
	        return true;
	    }
	    
	     public boolean isRectangleCover(int[][] rectangles) {
	        
	         if (rectangles.length == 0 || rectangles[0].length == 0) return false;

	        int x1 = Integer.MAX_VALUE;
	        int x2 = Integer.MIN_VALUE;
	        int y1 = Integer.MAX_VALUE;
	        int y2 = Integer.MIN_VALUE;
	        
	        HashSet<String> set = new HashSet<String>();
	        int area = 0;
	        
	        for (int[] rect : rectangles) {
	            x1 = Math.min(rect[0], x1);
	            y1 = Math.min(rect[1], y1);
	            x2 = Math.max(rect[2], x2);
	            y2 = Math.max(rect[3], y2);
	            
	            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);
	            
	            String s1 = rect[0] + " " + rect[1];
	            String s2 = rect[0] + " " + rect[3];
	            String s3 = rect[2] + " " + rect[3];
	            String s4 = rect[2] + " " + rect[1];
	            
	            if (!set.add(s1)) set.remove(s1);
	            if (!set.add(s2)) set.remove(s2);
	            if (!set.add(s3)) set.remove(s3);
	            if (!set.add(s4)) set.remove(s4);
	        }
	        
	        if (!set.contains(x1 + " " + y1) || !set.contains(x1 + " " + y2) 
	                            || !set.contains(x2 + " " + y1) || !set.contains(x2 + " " + y2) 
	                            || set.size() != 4) 
	            return false;
	        
	        return area == (x2-x1) * (y2-y1);
	    }
	    
	}

}
