package myleetcode;

public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n){
		if(n ==0)
			return;
		if(m == 0){
			for(int i=0; i<n; i++)
				nums1[i]= nums2[i];
			return;
		}
		int i,j;
		i=j=0;
		while(i<m){
			if(nums2[0]>=nums1[i]){
				i++;
				continue;
			}
			int tmp = nums1[i];
			nums1[i] = nums2[0];
			i++;
			int k=1;
			while(k<n){
				if(nums2[k]<= tmp)
					nums2[k-1] = nums2[k];
				else
					break;
				k++;
			}
			nums2[k-1] = tmp;
			
		}
		for(j= 0; j<nums2.length; j++)
			nums1[i+j] = nums2[j];
	}
	
	public void method2(int[] nums1, int m, int[] nums2, int n){
		int i= m-1; 
		int j= n-1;
		int k = m+n-1;
		while(i>=0 && j>=0){
			if(nums1[i]>nums2[j]){
				nums1[k]=nums1[i];
				i--;
			}
			else{
				nums1[k] = nums2[j];
				j--;
			}
			k--;
		}
		while(j>=0){
			nums1[k] = nums2[j];
			j--;
			k--;
		}
	}
}
