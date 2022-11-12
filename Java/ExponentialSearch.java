package Java;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class ExponentialSearch {

    static int exponentialSearch(int arr[],
            int n, int x) {
        // If x is present at first location itself
        if (arr[0] == x)
            return 0;

        // Find range for binary search by
        // repeated doubling
        int i = 1;
        while (i < n && arr[i] <= x)
            i = i * 2;

        // Call binary search for the found range.
        return Arrays.binarySearch(arr, i / 2,
                Math.min(i, n - 1), x);
    }

    public static int[] readFiles(String file) {
        try {
            File f = new File(file);
            try (Scanner s = new Scanner(f)) {
                int ctr = 0;
                while (s.hasNextInt()) {
                    ctr++;
                    s.nextInt();
                }
                int[] arr = new int[ctr];

                try (Scanner s1 = new Scanner(f)) {
                    for (int i = 0; i < arr.length; i++) {
                        arr[i] = s1.nextInt();
                    }
                }

                return arr;
            }

        } catch (Exception e) {
            return null;
        }
    }

    // Driver code
    public static void main(String args[]) {

        long startTime = System.nanoTime();
        long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        int[] data1 = readFiles("Java/Datasets/Dataset1000.txt");
        int[] data2 = readFiles("Java/Datasets/Dataset10000.txt");
        int[] data3 = readFiles("Java/Datasets/Dataset100000.txt");

        Arrays.sort(data1);
        Arrays.sort(data2);
        Arrays.sort(data3);

        int x = 996635;
        int result = exponentialSearch(data3,
                data3.length, x);

        System.out.println((result < 0) ? "Element is not present in array"
                : "Element is present at index " +
                        result);

        long endTime = System.nanoTime();
        long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long totalTime = endTime - startTime;

        long actualMemUsed = afterUsedMem - beforeUsedMem;

        System.out.println("Execution Time: " + totalTime / 1000000 + " ms");
        System.out.println("Memory Used: " + actualMemUsed + " bytes");
        System.out.println("Memory Used: " + actualMemUsed / 1000000 + " MB");
    }

}
