package mylintcode;

public class HashFunction {
	public int hashCode(char[] key,int HASH_SIZE) {
		if(key == null || key.length==0)
			return -1;
		long hashcode = 0;
		for(int i=0; i<key.length; i++)
			hashcode = (hashcode*33%HASH_SIZE + key[i])%HASH_SIZE;
		return (int)hashcode;
	}

}
