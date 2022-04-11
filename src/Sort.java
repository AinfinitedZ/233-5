public class Sort {
    /**
     * implements insert sort to targeted array. Each iterations would
     * shift all integers that are after targered insertion by one index right.
     * The array should be ascending order after insertionSort. 
     * @param arr the array that shall be sorted. 
     */
    public static void insertSort(int[] arr){
        // In term of insertSort, we traverse the array from left to right. The left part of the array which is already be traversed is named as 'sorted' array.
        // Two part of iterations would be done. When we find a integer that is larger than its previous one, we need to perform insertion, that is find a integer
        // lower than it and insert it after. However we also need to shift all number that larger than it for vacant position which it could be inserted.   
        if(arr.length <= 1){
            return;                          // deal with edge case. 
        }
        for(int i = 1; i < arr.length; i++){ // start from index 1, since the first integer could be seen as 'sorted'.
            if(arr[i] < arr[i - 1]){         // the case that insertion sort should be executed is when the array is not ascending. Otherwise only comparison is done.
                int toInsert = arr[i];                  
                int j = i;                              
                while(j > 0 &&               // if toInsert is locally lowest value and need to traverse whole sorted array, j > 0 prevents IndexOutOfBoundException
                    toInsert < arr[j - 1]){  // and j - 1 is not the right index of toInsert, shifts need to be done for vacant position.
                        
                        arr[j] = arr[j - 1]; // shift arr[j-1] one index right for vacant position in previous array
                        j--;                 // traverse the 'sorted' array from right to left.
                }
                arr[j] = toInsert;           // as all integer larger than toInsert is shift one index right, one could successfully be inserted. 
            }
        }
    }

    public static void quickSort(int[] arr){}

    public static void mergeSort(int[] arr){}

    /**
     * Return an array with i integers that each of them are between [a,b]
     * @param i the number need to produce
     * @param a the lower limit of random number
     * @param b the upper limit of random number
     * @return an array with random integer that between inteval [a,b]
     */
    public static int[] randomArray(int i, int a, int b){
        // deal with edge case that i might be unreasonable input.
        int inteval = (i > 0) ? i : 0;
        int[] result = new int[inteval];
        for(int j = 0; j < inteval; j++){
            // Math.random() would produce a double value that between 0 and 1
            result[j] = a + (int)(Math.random()*(b - a));
        }
        return result;
    }

}
