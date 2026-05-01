import java.util.Random;

public class InsertionSortPerformance {

    // Insertion Sort method
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Shift elements greater than key
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {

        int size = 20000; // Adjust size for testing
        int[] arr = new int[size];

        Random rand = new Random();

        // Fill array with random values
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100000);
        }

        // Measure execution time
        long startTime = System.nanoTime();

        insertionSort(arr);

        long endTime = System.nanoTime();

        long duration = endTime - startTime;

        System.out.println("Array size: " + size);
        System.out.println("Execution time (nanoseconds): " + duration);
        System.out.println("Execution time (milliseconds): " + (duration / 1_000_000));
    }
}
