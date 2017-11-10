package google;

public class PeekingInterator {
	Iterator<Integer> internalIter;
    int nextElement;
    boolean nextValid;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    internalIter = iterator;
        nextValid = false;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(nextValid){
            return nextElement;
        }else{
            if(internalIter.hasNext()){
                nextElement = internalIter.next();
                nextValid = true;
                return nextElement;
            }else{
                return null;
            }
        }
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if(nextValid){
            nextValid = false;
            return nextElement;
        }else{
            return internalIter.next();
        }
	}

	@Override
	public boolean hasNext() {
	    if(nextValid)
            return true;
        else
            return internalIter.hasNext();
	}

}
