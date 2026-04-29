import java.util.Random;

public class InsertionSortPerformance {

    // Method to perform Insertion Sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements greater than key one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Place key at correct position
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {

        int size = 10000; // Large dataset
        int[] arr = new int[size];

        Random rand = new Random();

        // Generate random data
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100000);
        }

        // Measure start time
        long startTime = System.nanoTime();

        // Perform Insertion Sort
        insertionSort(arr);

        // Measure end time
        long endTime = System.nanoTime();

        // Calculate execution time
        long executionTime = endTime - startTime;

        System.out.println("Dataset Size: " + size);
        System.out.println("Execution Time (nanoseconds): " + executionTime);
        System.out.println("Execution Time (milliseconds): " + (executionTime / 1_000_000.0));
    }
}
