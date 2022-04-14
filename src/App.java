public class App {
    public static void main(String[] args) throws Exception {
        int[] randomArray = Sort.randomArray(500, 1, 10000);
        long startTime = System.nanoTime();
        Sort.insertSort(randomArray);
        long endTime = System.nanoTime();
        long difference = endTime - startTime;
        System.out.println(difference);
        
    }
}
