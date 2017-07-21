package mylintcode;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Comparator;

public class KclosestPoints {
	class Point {
		      int x;
		      int y;
		      Point() { x = 0; y = 0; }
		      Point(int a, int b) { x = a; y = b; }
		  }
	
	public Point origin;
	public int myCompare(Point a, Point b) {
		int disA = (a.x-origin.x)*(a.x-origin.x)+(a.y-origin.y)*(a.y-origin.y);
		int disB = (b.x-origin.x)*(b.x-origin.x)+(b.y-origin.y)*(b.y-origin.y);
		if(disA < disB ) {
			return -1;
		}
		else if(disA == disB) {
			if(a.x<b.x)
				return -1;
			else if(a.x == b.x && a.y < b.y)
				return -1;
			else if(a.x == b.x && a.y == b.y)
				return 0;
			else
				return 1;
		}
		else
			return 1;
	}
	
	public Point[] kClosest(Point[] points, Point origin, int k) {
		if(points == null || points.length ==0)
			return new Point[0];
		if(points.length<=k)
			return points;
		this.origin = origin;
		Point[] result = new Point[k];
		Queue<Point> maxQ = new PriorityQueue<Point>(1, 
				new Comparator<Point>() {
					public int compare(Point a, Point b) {
						return -1*myCompare(a, b);
					}
		});
		for(int i=0; i<points.length; i++) {
			if(i<k) {
				maxQ.add(points[i]);
			}
			else {
				if(myCompare(points[i], maxQ.peek())<0) {
					maxQ.poll();
					maxQ.add(points[i]);
				}

			}
		}
		for(int i=k-1; i>=0; i--) {
			result[i] = maxQ.poll();
		}
		return result;
	}

}
