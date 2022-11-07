package Java;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    static long startTime = System.nanoTime();

    int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at the
            // middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than mid, then
            // it can only be present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);

            // Else the element can only be present
            // in right subarray
            return binarySearch(arr, mid + 1, r, x);
        }

        // We reach here when element is not present
        // in array
        return -1;

    }

    static long endTime = System.nanoTime();
    static long totalTime = endTime - startTime;

    public static int[] readFiles(String file) {
        try {
            File f = new File(file);
            Scanner s = new Scanner(f);
            int ctr = 0;
            while (s.hasNextInt()) {
                ctr++;
                s.nextInt();
            }
            int[] arr = new int[ctr];

            Scanner s1 = new Scanner(f);

            for (int i = 0; i < arr.length; i++) {
                arr[i] = s1.nextInt();
            }
            return arr;

        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        BinarySearch ob = new BinarySearch();
        int[] data1 = readFiles("Java/Datasets/Dataset1000.txt");
        int[] data2 = readFiles("Java/Datasets/Dataset10000.txt");
        int[] data3 = readFiles("Java/Datasets/Dataset100000.txt");

        Arrays.sort(data1);
        Arrays.sort(data2);
        Arrays.sort(data3);

        int x = 343940;
        int n = data3.length;
        int result = ob.binarySearch(data3, 0, n - 1, x);
        if (result == -1)
            System.out.println("Element not present");
        else
            System.out.println("Element found at index "
                    + result);
        System.out.println(totalTime + " ns");
    }
}
