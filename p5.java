import java.util.Random;

public class QuickSortPerformance {

    // Partition function
    public static int partition(int[] arr, int low, int high) {

        int pivot = arr[high]; // choose last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;

                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot at correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Quick Sort function
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
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

        // Perform Quick Sort
        quickSort(arr, 0, arr.length - 1);

        // Measure end time
        long endTime = System.nanoTime();

        // Calculate execution time
        long executionTime = endTime - startTime;

        System.out.println("Dataset Size: " + size);
        System.out.println("Execution Time (nanoseconds): " + executionTime);
        System.out.println("Execution Time (milliseconds): " + (executionTime / 1_000_000.0));
    }
}
