4.11 12:38

Finish randomArray method. Produce each random number by adding $b - a$ multiplying by a double amount between [0,1] generating by Math.random() method to $a$. That would successfully produce a random integer between [a,b]. 

4.11 14:41

Finish insertSort method. and comments on its  functions, include explaining how it works as a whole part and how it works for each line. 

4.12 20:34

Finish quickSort method, and comments on its functions and explainations of all of its helper functions. 

4.14 07:55

Finish mergeSort method, and comments on its functions and explainations of all of its helper functions. 

4.14 10:53

Begin test and collect time consumption for sort method in different size of input. The debug result shows that insertSort works normally. Tend to collect several time and calculate average for same method and input, in order to decrease errors.

4.14 11:28

Discover that the upper limit of random array might influence the result of running time. In able to reduce errors I have set the upper limit of random array to 10000 for all testing. 

4.14 12:06

Find several problems when collecting data. The first problem is failure when understanding the function of System.nanoTime(), which is the current time of JVM. Second problem is that I used to input

```java
        long startTime = System.nanoTime();
		int[] randomArray = Sort.randomArray(10, 1, 10000);
        Sort.insertSort(randomArray);
        System.out.println(System.nanoTime() - startTime);
```

However, it is not accurate when deal with small scale of data, that the output include the running time of assign value to randomArray. Besides, the existence of stack would cause line 4 to be unstable for extremely small amount of time, i.e, 5000 ns. I thus recode this fragment,

```java
        int[] randomArray = Sort.randomArray(10, 1, 10000);
        long startTime = System.nanoTime();
        Sort.insertSort(randomArray);
        long endTime = System.nanoTime();
        long difference = endTime - startTime;
        System.out.println(difference);
```

The assignment of line 2 and 4 is proved to have less running time than above use of stack, which is constant time, that the data is more precised. By excluding the assignment of array, one also ensure the accuracy of data. 

4.14 12:56

Consider to measure the average time for Comparison and Assignment. However, it seems 

