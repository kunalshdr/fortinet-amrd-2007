

// Problem 2 - Sum of MultiDimension Array 
public Long sum(MultiDimensionArray mArray, int[] lengthOfDimension) {
    if (lengthOfDimension == null || lengthOfDimension.length == 0) {
        return 0L;
    }

    return sumUtil(mArray, lengthOfDimension, 0, new int[lengthOfDimension.length]);
}

public long sumUtil(MultiDimensionArray mArray, int[] lengthOfDimension,
                   int curIndex, int[] indexArray) {

    if (curIndex == lengthOfDimension.length) {
        return getValue(indexArray);
    }

    long sum = 0;
    for (int i = 0; i < lengthOfDimension[curIndex]; i++) {
        indexArray[curIndex] = i;
        sum += sumUtil(mArray, lengthOfDimension, curIndex + 1, indexArray);
    }

    return sum;
}

 // Time complexity: 
//Since all elements of MultiDimension array are visited exactly once and there is contant amount of work done for each element, 
//the time complexity is O(total-elements-in-array) i.e. O(product-of-all-elements-of-dimention-array)
 
 // Space complexity: 
//No explicit extra space used. Due to recursion internal stack will be used, 
//which will take up O(n) space where n is length of dimension array 