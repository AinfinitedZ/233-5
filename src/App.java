public class App {
    public static void main(String[] args) throws Exception {
        for(int i = 0; i < 100; i++){
            int[] randomArray = Sort.randomArray(10, 1, 10000);
            long startTime = System.nanoTime();
            Sort.insertSort(randomArray);
            long endTime = System.nanoTime();
            long difference = endTime - startTime;
            System.out.println(difference);
        }
    }
}
