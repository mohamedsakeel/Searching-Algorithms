package Java;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class JumpSearch {

    public static int jumpSearch(int[] arr, int x) {
        int n = arr.length;

        // Finding block size to be jumped
        int step = (int) Math.floor(Math.sqrt(n));

        // Finding the block where element is
        // present (if it is present)
        int prev = 0;
        while (arr[Math.min(step, n) - 1] < x) {
            prev = step;
            step += (int) Math.floor(Math.sqrt(n));
            if (prev >= n)
                return -1;
        }

        // Doing a linear search for x in block
        // beginning with prev.
        while (arr[prev] < x) {
            prev++;

            // If we reached next block or end of
            // array, element is not present.
            if (prev == Math.min(step, n))
                return -1;
        }

        // If element is found
        if (arr[prev] == x)
            return prev;

        return -1;
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

    // Driver program to test function
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        int[] data1 = readFiles("Java/Datasets/Dataset1000.txt");
        int[] data2 = readFiles("Java/Datasets/Dataset10000.txt");
        int[] data3 = readFiles("Java/Datasets/Dataset100000.txt");

        Arrays.sort(data1);
        Arrays.sort(data2);
        Arrays.sort(data3);

        int x = 712639;

        // Find the index of 'x' using Jump Search
        int index = jumpSearch(data3, x);

        // Print the index where 'x' is located
        System.out.println("\nNumber " + x +
                " is at index " + index);

        long endTime = System.nanoTime();
        long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long totalTime = endTime - startTime;

        long actualMemUsed = afterUsedMem - beforeUsedMem;

        System.out.println("Execution Time: " + totalTime / 1000000 + " ms");
        System.out.println("Memory Used: " + actualMemUsed + " bytes");
        System.out.println("Memory Used: " + actualMemUsed / 1000000 + " MB");
    }

}
