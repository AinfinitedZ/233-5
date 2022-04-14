public class Sort {
    /**
     * Insertion Sort iterates from the most left element through whole array, one by one. 
     * During the procedure, subarray in the left of the element is sorted, and in the right would remain unsorted.
     * For each iteration, insertion sort removes one element from unsorted suarray, traverse the sorted subarray 
     * to find its position - all element smaller than it are in the left , and vice versa for the right. 
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
     * quickSort works by divide-and-conquer. During the divide procedure, the iterations divide the array into two
     * half subarrays recursively. For each iteration, a 'pivot' element would be selected, which is the median element
     * of original array, that all element in the left subarray is lower than pivot, and vice versa for the right.
     * During the conquer procedure, these subarrays are then sorted from single element through original array, due
     * to the recalls of stacks. 
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
     * @return middle index
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
    
    /**
     * mergeSort works by divide-and-conquer. During the divide procedure, the iterations split the array into two
     * half subarrays recursively. In implemention, 'split' could be substituted by passing the median index to next
     * recursive iteration, to avoid large additional memory due to these subarrays. During the conquer procedure, 
     * elements of both subarrays would be assigned ascendingly to a temporary array, which would also be passed in
     * argument, from a single element through whole array. 
     * @param arr the array shall be sorted. 
     */
    public static void mergeSort(int[] arr){
    
        if(arr.length <= 1) return;                 // deal with edge case
        int[] temp = new int[arr.length];           // temp array would be passed by argument that store all sorted elements 
        mSort(arr, temp, 0, arr.length - 1);  // helper method. Could be used by recursion.
    }

    /**
     * helper method. Mainly response to divide procedure. 
     * @param arr the original array
     * @param temp temp array that have same length as the original one. 
     * @param start start index of array that tend to be divided.
     * @param end end index of array that tend to be divided.
     */
    private static void mSort(int[] arr, int[] temp, int start, int end){
        if(start == end) return;                        // base case
        int middle = (start + end) / 2;                 // keep dividing the original array into smaller array. 
        mSort(arr, temp, start, middle);                // keep divide arr to left subarray until it contains only when one element.
        mSort(arr, temp, middle+1, end);                // keep divide arr to right subarray until it contains only when one element. 
        merge(arr, temp, start, middle, middle+1, end); // stack recalls from single left and right elements through left and right half array. 
    }

    /**
     * helper method. Mainly response to conquer procedure. 
     * @param arr the original array
     * @param temp temp array that have same length as the original one. 
     * @param leftStart start index of left subarray
     * @param leftEnd end index of left subarray
     * @param rightStart start index of right subarray
     * @param rightEnd end index of right subarray
     */
    private static void merge(int[] arr, int[] temp, int leftStart, int leftEnd, int rightStart, int rightEnd){
        int i = leftStart;                      // left index
        int j = rightStart;                     // right index
        int k = leftStart;                      // Index used in temp
        while(i <= leftEnd && j <= rightEnd){   // terminal condition: when one of the index reach the end of array. 
            if(arr[i] <= arr[j]){               // Comparison : determine magnitude of element
                temp[k++] = arr[i++];           // if one in left array is smaller than one in right, insert the left one.
            } else {
                temp[k++] = arr[j++];           // and vice versa. 
            }
        }
        while(i <= leftEnd){                    // when the right index reach the end of array, all remaining left elements is bigger than the largest element in left
            temp[k++] = arr[i++];               // and we assign these values into the rest space of temp array
        }
        while(j <= rightEnd){
            temp[k++] = arr[j++];               // and vice versa. 
        }
        for(i = leftStart; i < rightEnd; i++){  // we could thus replace these unsorted elements in original array by sorted elements in temp array
            arr[i] = temp[i];                   // by assign them value one by one. 
        }
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