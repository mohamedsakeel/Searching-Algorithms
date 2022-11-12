package Java;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class LinearSearch {

    public static int search(int arr[], int x) {
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            if (arr[i] == x)
                return i;
        }
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

    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();
        long beforeUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();

        // int[] data1 = readFiles("Java/Datasets/Dataset1000.txt");
        // int[] data2 = readFiles("Java/Datasets/Dataset10000.txt");
        int[] data3 = readFiles("Java/Datasets/Dataset100000.txt");

        int x = 844691;
        // Function call
        int result = search(data3, x);
        if (result == -1)
            System.out.println(
                    "Element is not present in array");
        else
            System.out.println("Element is present at index "
                    + result);
        long endTime = System.nanoTime();
        long afterUsedMem = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        long totalTime = endTime - startTime;

        long actualMemUsed = afterUsedMem - beforeUsedMem;

        System.out.println("Execution Time: " + totalTime / 1000000 + " ms");
        System.out.println("Memory Used: " + actualMemUsed + " bytes");
        System.out.println("Memory Used: " + actualMemUsed / 1000000 + " MB");
    }

}
