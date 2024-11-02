package Lab_Assignment_05;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Lab_Assignment_05 {

    public static int counter = 0;

    public static int LinearSearchIterative(int[] arr, int n, int target) {
        counter = 0;
        for (int i = 0; i < n; i++) {
            counter++;
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int BinarySearchIterative(int[] arr, int n, int target) {
        counter = 0;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            counter++;
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public static int LinearSearchRecursive(int[] arr, int n, int target) {
        counter++;
        if (n == -1) {
            return n;
        }
        if (arr[n] == target) {
            return n;
        }
        return LinearSearchRecursive(arr, n - 1, target);
    }

    public static int BinarySearchRecursive(int[] arr, int start, int end, int target) {
        counter++;
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return BinarySearchRecursive(arr, start, mid - 1, target);
        } else {
            return BinarySearchRecursive(arr, mid + 1, end, target);
        }
    }

    public static void main(String[] args) {
        String inputFileName = "input_arrays.txt";
        String outputFileName = "output_results.txt";
        int target = 8; // Target to search

        try (BufferedReader br = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFileName))) {

            String line;
            while ((line = br.readLine()) != null) {
                // Convert the line into an integer array
                String[] stringArray = line.split(",");
                int[] arr = new int[stringArray.length];
                for (int i = 0; i < stringArray.length; i++) {
                    arr[i] = Integer.parseInt(stringArray[i].trim());
                }

                int n = arr.length;
                bw.write("Array: " + line + "\n");
                
                // Linear Search Iterative
                int result = LinearSearchIterative(arr, n, target);
                bw.write("Linear Search Iterative: Index = " + result + ", Comparisons = " + counter + "\n");

                // Linear Search Recursive
                counter = 0;
                result = LinearSearchRecursive(arr, n - 1, target);
                bw.write("Linear Search Recursive: Index = " + result + ", Comparisons = " + counter + "\n");

                // Binary Search Iterative (must be sorted)
                java.util.Arrays.sort(arr); // Sort for binary search
                counter = 0;
                result = BinarySearchIterative(arr, n, target);
                bw.write("Binary Search Iterative: Index = " + result + ", Comparisons = " + counter + "\n");

                // Binary Search Recursive
                counter = 0;
                result = BinarySearchRecursive(arr, 0, n - 1, target);
                bw.write("Binary Search Recursive: Index = " + result + ", Comparisons = " + counter + "\n");

                bw.write("============================================================\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
