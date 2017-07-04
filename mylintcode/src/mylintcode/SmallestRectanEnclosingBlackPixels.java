package mylintcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SmallestRectanEnclosingBlackPixels {
	public int minArea(char[][] image, int x, int y) {
        // Write your code here
		if(image==null || image.length==0 || image[0].length==0)
			return 0;
		int up,down, left, right;
		int start, end;
		
		start = 0;
		end = y;
		while(start+1<end){
			int mid = start + (end-start)/2;
			if(hasBlackInColumn(image, mid))
				end = mid;
			else
				start = mid;
		}
		if(hasBlackInColumn(image, start))
			left = start;
		else
			left = end;
		
		start = y;
		end = image[0].length-1;
		while(start+1 < end){
			int mid = start + (end-start)/2;
			if(hasBlackInColumn(image, mid))
				start = mid;
			else
				end = mid;
		}
		if(hasBlackInColumn(image, end))
			right = end;
		else
			right = start;
		
		start = 0; 
		end = x;
		while(start+1 < end){
			int mid = start + (end-start)/2;
			if(hasBlackInRow(image, mid))
				end = mid;
			else
				start = mid;
		}
		if(hasBlackInRow(image, start))
			up = start;
		else
			up = end;
		
		start = x; 
		end = image.length-1;
		while(start+1 < end){
			int mid = start + (end-start)/2;
			if(hasBlackInRow(image, mid))
				start = mid;
			else
				end = mid;
		}
		if(hasBlackInRow(image, end))
			down = end;
		else
			down = start;
		return (down-up+1)*(right-left+1);
		
    }
	
	public boolean hasBlackInRow(char[][] image, int row){
		for(int i=0; i<image[row].length; i++)
			if(image[row][i]=='1')
				return true;
		return false;
	}
	
	public boolean hasBlackInColumn(char[][] image, int col){
		for(int i=0; i<image.length; i++)
			if(image[i][col]=='1')
				return true;
		return false;
	}
	
	/*
	public class point{
		int x;
		int y;
		point(int a, int b){
			x = a;
			y = b;
		}
	}
	
	boolean isValid(char[][] image, int x, int y){
		if(x<0 || x>image.length-1 || y<0 || y> image[0].length-1)
			return false;
		return true;
	}
	
	public int method2(char[][] image, int x, int y) {
		if(image==null || image.length==0 || image[0].length==0)
			return 0;
		
		Queue<point> blackPixels = new LinkedList<point>();
		blackPixels.offer(new point(x,y));
		boolean[][] accessed = new boolean[image.length][image[0].length];
		int[][] neighber = {{-1,0},{1,0},{0,-1},{0, 1}};
		
		int up, down, left, right;
		up = down = x;
		left = right = y;
		while(blackPixels.isEmpty()!= true){
			point curPoint = blackPixels.poll();
			for(int i=0; i<4; i++){
				int tx = curPoint.x + neighber[i][0];
				int ty = curPoint.y + neighber[i][1];
				if(isValid(image, tx, ty) && image[tx][ty]=='1' && (accessed[tx][ty]==false)){
					blackPixels.offer(new point(tx, ty));
					accessed[tx][ty] = true;
				}
			}
			if(curPoint.x > down)
				down = curPoint.x;
			else if(curPoint.x < up)
				up = curPoint.x;
			if(curPoint.y > right)
				right = curPoint.y;
			else if(curPoint.y < left)
				left = curPoint.y;
		}
		return (down-up+1)*(right-left+1);
	}
*/
}
