import java.io.*;
import java.util.*;

public class SortingComparison {
    static long comparisonCount;

    // Bubble Sort - Iterative
    public static void bubbleSortIterative(int[] arr) {
        comparisonCount = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparisonCount++; // Comparison counter
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Bubble Sort - Recursive
    public static void bubbleSortRecursive(int[] arr, int n) {
        if (n == 1)
            return;
        for (int i = 0; i < n - 1; i++) {
            comparisonCount++; // Comparison counter
            if (arr[i] > arr[i + 1]) {
                int temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        bubbleSortRecursive(arr, n - 1);
    }

    // Selection Sort - Iterative
    public static void selectionSortIterative(int[] arr) {
        comparisonCount = 0;
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                comparisonCount++; // Comparison counter
                if (arr[j] < arr[minIdx])
                    minIdx = j;
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    // Selection Sort - Recursive
    public static void selectionSortRecursive(int[] arr, int n, int idx) {
        if (idx == n)
            return;
        int minIdx = idx;
        for (int i = idx + 1; i < n; i++) {
            comparisonCount++; // Comparison counter
            if (arr[i] < arr[minIdx])
                minIdx = i;
        }
        int temp = arr[minIdx];
        arr[minIdx] = arr[idx];
        arr[idx] = temp;
        selectionSortRecursive(arr, n, idx + 1);
    }

    // Insertion Sort - Iterative
    public static void insertionSortIterative(int[] arr) {
        comparisonCount = 0;
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                comparisonCount++; // Comparison counter
                arr[j + 1] = arr[j];
                j--;
            }
            comparisonCount++; // Final comparison
            arr[j + 1] = key;
        }
    }

    // Insertion Sort - Recursive
    public static void insertionSortRecursive(int[] arr, int n) {
        if (n <= 1)
            return;
        insertionSortRecursive(arr, n - 1);
        int last = arr[n - 1];
        int j = n - 2;
        while (j >= 0 && arr[j] > last) {
            comparisonCount++; // Comparison counter
            arr[j + 1] = arr[j];
            j--;
        }
        comparisonCount++; // Final comparison
        arr[j + 1] = last;
    }

    // Function to read input arrays from file
    public static List<int[]> readInputFromFile(String filename) throws IOException {
        List<int[]> arrays = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] numbers = line.split("\\s+");
            int[] arr = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                arr[i] = Integer.parseInt(numbers[i]);
            }
            arrays.add(arr);
        }
        reader.close();
        return arrays;
    }

    // Heap Sort implementation
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Build max heap
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap the current root (largest) to the end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Function to maintain the max heap property
    public static void heapify(int[] arr, int n, int i) {
        int largest = i; // Initialize largest as root
        int left = 2 * i + 1; // Left child
        int right = 2 * i + 2; // Right child

        // If the left child is larger than the root
        comparisonCount++; // Count this comparison
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If the right child is larger than the largest so far
        comparisonCount++; // Count this comparison
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root, swap it with the root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) throws IOException {
        // Read input arrays from the file
        List<int[]> inputArrays = readInputFromFile("input.txt");

        // FileWriter to export the results
        FileWriter writer = new FileWriter("comparisons.txt");

        for (int[] array : inputArrays) {
            int n = array.length;
            writer.write("Array size: " + n + "\n");

            // Bubble Sort - Iterative
            int[] bubbleArray = Arrays.copyOf(array, n);
            bubbleSortIterative(bubbleArray);
            writer.write("Bubble Sort Iterative - Comparisons: " + comparisonCount + "\n");

            // Selection Sort - Iterative
            int[] selectionArray = Arrays.copyOf(array, n);
            selectionSortIterative(selectionArray);
            writer.write("Selection Sort Iterative - Comparisons: " + comparisonCount + "\n");

            // Insertion Sort - Iterative
            int[] insertionArray = Arrays.copyOf(array, n);
            insertionSortIterative(insertionArray);
            writer.write("Insertion Sort Iterative - Comparisons: " + comparisonCount + "\n");

            writer.write("\n");
        }

        for (int[] array : inputArrays) {
            int n = array.length;
            writer.write("Array size: " + n + "\n");

            // Bubble Sort - Recursive
            comparisonCount = 0;
            int[] bubbleArray = Arrays.copyOf(array, n);
            bubbleSortRecursive(bubbleArray, n);
            writer.write("Bubble Sort Recursive - Comparisons: " + comparisonCount + "\n");

            // Selection Sort - Recursive
            comparisonCount = 0;
            int[] selectionArray = Arrays.copyOf(array, n);
            selectionSortRecursive(selectionArray, n, 0);
            writer.write("Selection Sort Recursive - Comparisons: " + comparisonCount + "\n");

            // Insertion Sort - Recursive
            comparisonCount = 0;
            int[] insertionArray = Arrays.copyOf(array, n);
            insertionSortRecursive(insertionArray, n);
            writer.write("Insertion Sort Recursive - Comparisons: " + comparisonCount + "\n");

            // Heap Sort
            comparisonCount = 0;
            int[] heapSort = Arrays.copyOf(array, n);
            heapSort(heapSort);
            writer.write("Heap Sort - Comparisons: " + comparisonCount + "\n");

            writer.write("\n");
        }

        writer.close();
        System.out.println("Comparisons exported to comparisons.txt");

    }
}
