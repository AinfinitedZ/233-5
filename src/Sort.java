public class Sort {

    /**
     * implements insert sort to targeted array. The array should be ascending order after insertionSort. 
     * @param arr the array shall be sorted. 
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

    /**
     * implements quick sort to targeted array. The array should be ascending order after quickSort. 
     * @param arr the array shall be sorted. 
     */
    public static void quickSort(int[] arr){
        qSort(arr, 0, arr.length - 1);   // use a helper method because we shall use recursion here. 
    }

    /**
     * helper method which uased to implement recursion. Definition method of quick sort.
     * @param arr the array passed by quickSort method
     * @param first first index
     * @param last last index
     */
    private static void qSort(int[] arr, int first, int last){
        if(arr.length <= 1) return ;                // base conditiom of recursion
        int split = partition(arr, first, last);    // help method partition() would divide the problem by half.
        qSort(arr, first, split);                   // deal with first half of array by recursion.
        qSort(arr, split + 1, last);                // deal with second half of array by recursion. 
    
    }

    /**
     * divide the array into half, and conquer each of it by categorizing inside elements by pivot, a random element
     * in the middle of the array. 
     * @param arr the array passed by qSort. 
     * @param first first index
     * @param last last index
     * @return
     */
    private static int partition(int[] arr, int first, int last){
        int pivot = arr[(first + last) / 2];        // we always choose the pivot at the middle of array
        int i = first - 1;                          // i going from left to right. 
        int j = last + 1;                           // j going from right to left. 
        while(true){
            do{                                     // use do...while so that i++ would be executed at least once. Thus qSort would always terminate. 
                                                    // this is the reason why i should be one less from beginning, one may avoid IndexOutOfBoundException.
                i++;
            } while(arr[i] < pivot);
            do{
                j--;                                // same reason as above. 
            } while(arr[j] > pivot); 
            if(i < j){                              // after several iterations, arr[i] should 
                swap(arr, i, j);                    // use a helper method swap() to swap 
            } else {
                return j;                           // as two index overcross or meet each other at pivot, j stands for another terminar or begining of next qSort. 
            }
        }
    }
    
    /**
     * Simple swap method that take three movements. 
     * @param arr the array passed by partition method.
     * @param firstIndex first index 
     * @param secondIndex second index
     */
    private static void swap(int[] arr, int firstIndex, int secondIndex){
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    public static void mergeSort(int[] arr){
        
    }

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
