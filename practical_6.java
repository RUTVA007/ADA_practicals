public class LinearSearchExample {

    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i; // element found
            }
        }
        return -1; // not found
    }

    public static void main(String[] args) {

        int[] arr = {10, 25, 30, 45, 50};
        int key = 30;

        int result = linearSearch(arr, key);

        if (result != -1)
            System.out.println("Element found at index: " + result);
        else
            System.out.println("Element not found");
    }
}

import java.util.Arrays;

public class BinarySearchExample {

    public static int binarySearch(int[] arr, int key) {
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == key)
                return mid;
            else if (arr[mid] < key)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {10, 25, 30, 45, 50};
        int key = 45;

        // Ensure array is sorted
        Arrays.sort(arr);

        int result = binarySearch(arr, key);

        if (result != -1)
            System.out.println("Element found at index: " + result);
        else
            System.out.println("Element not found");
    }
}
