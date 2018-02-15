package google;

public class SmallestRectangleEnclosingBlackpixel {
	int minArea(vector<vector<char>>& image, int x, int y) {
        if(image.empty() || image[0].empty())
            return 0;
        int m = image.size();
        int n = image[0].size();
        int left = 0;
        int right = y;
        int bound_left = y;
        int bound_right = y;
        int bound_up = x;
        int bound_down = x;
        while(left+1 < right){
            int mid = left + (right-left)/2;
            if(checkCol(image, mid) == false)
                left = mid;
            else
                right = mid;
        }
        if(checkCol(image,left) == true)
            bound_left = left;
        else
            bound_left = right;
        left = y;
        right = n-1;
        while(left+1 < right){
            int mid = left + (right-left)/2;
            if(checkCol(image, mid) == false)
                right = mid;
            else
                left = mid;
        }
        if(checkCol(image, right))
            bound_right = right;
        else
            bound_right = left;
        int up = 0;
        int down = x;
        while(up+1 < down){
            int mid = up + (down-up)/2;
            if(checkRow(image, mid)==false)
                up = mid;
            else
                down = mid;
        }
        if(checkRow(image, up)==true)
            bound_up = up;
        else
            bound_up = down;
        up = x;
        down = m-1;
        while(up+1 < down){
            int mid = up + (down-up)/2;
            if(checkRow(image, mid)==false)
                down = mid;
            else
                up = mid;
        }
        if(checkRow(image, down)==true)
            bound_down = down;
        else
            bound_down = up;
        return (bound_down-bound_up+1)*(bound_right-bound_left+1);
    }
    bool checkRow(vector<vector<char>>& image, int r){
        for(int i=0; i<image[0].size(); i++){
            if(image[r][i] == '1')
                return true;
        }
        return false;
    }
    bool checkCol(vector<vector<char>>& image, int c){
        for(int i=0; i<image.size(); i++){
            if(image[i][c] == '1')
                return true;
        }
        return false;
    }

}
