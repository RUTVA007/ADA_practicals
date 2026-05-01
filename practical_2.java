import java.util.Random;

public class BubbleSortPerformance {

    // Optimized Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            // If no swaps occurred, array is sorted
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {

        int size = 20000; // Try different sizes
        int[] arr = new int[size];

        Random rand = new Random();

        // Fill array with random values
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100000);
        }

        // Measure execution time
        long startTime = System.nanoTime();

        bubbleSort(arr);

        long endTime = System.nanoTime();

        long duration = endTime - startTime;

        System.out.println("Array size: " + size);
        System.out.println("Execution time (nanoseconds): " + duration);
        System.out.println("Execution time (milliseconds): " + (duration / 1_000_000));
    }
}
