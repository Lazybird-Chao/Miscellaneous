package mylintcode;

public class SortColors2 {
public void sortColors2(int[] colors, int k) {
        
        if(colors==null || colors.length==0)
			return;
		
		helper(colors, 0, colors.length-1, 1, k);
		
	}
	
	void helper(int[] colors, int start, int end, int sk, int mk){
		if(start>=end || sk==mk)
			return;
		int midk = (mk+sk)/2;
		int i, j;
		i= start;
		j= end;
		while(i<=j){
			while(i<=j && colors[i]<=midk)
				i++;
			while(i<=j && colors[j]>midk)
				j--;
			if(i<=j){
				int tmp = colors[i];
				colors[i] = colors[j];
				colors[j] = tmp;
				i++;
				j--;
			}
		}
		helper(colors, start, j, sk, midk);
		helper(colors, i, end, midk+1, mk);
		return;
	}
}
