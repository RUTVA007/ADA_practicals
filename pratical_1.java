import java.util.Random;

public class SelectionSortPerformance {

    // Selection Sort method
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {

        int size = 20000; // Large dataset (adjust as needed)
        int[] arr = new int[size];

        Random rand = new Random();

        // Fill array with random numbers
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100000);
        }

        // Measure execution time
        long startTime = System.nanoTime();

        selectionSort(arr);

        long endTime = System.nanoTime();

        long duration = endTime - startTime;

        System.out.println("Array size: " + size);
        System.out.println("Execution time (nanoseconds): " + duration);
        System.out.println("Execution time (milliseconds): " + (duration / 1_000_000));
    }
}
