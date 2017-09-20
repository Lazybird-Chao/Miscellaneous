package facebook;

public class ReadNbyRead4_2 {
	public class Solution extends Reader4 {
	    /**
	     * @param buf Destination buffer
	     * @param n   Maximum number of characters to read
	     * @return    The number of characters read
	     */
	     char[] lastread = new char[4];
	     int start = 4;
	     int end = 4;
	    public int read(char[] buf, int n) {
	        int index=0;
	        if(start < end){
	            while(index < n && start < end){
	                buf[index] = lastread[start];
	                index++;
	                start++;
	            }
	        }
	        if(index==n){
	            return index;
	        }
	        int readcount = read4(lastread);
	        while(readcount == 4 && index+readcount < n){
	            for(int i=0; i<4; i++)
	                buf[index++] = lastread[i];
	            readcount = read4(lastread);
	        }
	        for(start=0; start<readcount && index<n; start++){
	            buf[index] = lastread[start];
	            index++;
	        }
	        end = readcount;
	        
	        return index;
	    }
	}

}
