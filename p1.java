import java.util.Random;

public class SelectionSortPerformance {

    // Method to perform Selection Sort
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find the minimum element in remaining array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {

        int size = 10000; // Large dataset (you can increase this)
        int[] arr = new int[size];

        Random rand = new Random();

        // Generate random data
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100000);
        }

        // Measure start time
        long startTime = System.nanoTime();

        // Perform Selection Sort
        selectionSort(arr);

        // Measure end time
        long endTime = System.nanoTime();

        // Calculate execution time
        long executionTime = endTime - startTime;

        System.out.println("Dataset Size: " + size);
        System.out.println("Execution Time (nanoseconds): " + executionTime);
        System.out.println("Execution Time (milliseconds): " + (executionTime / 1_000_000.0));
    }
}
