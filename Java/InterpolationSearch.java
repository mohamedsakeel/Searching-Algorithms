package Java;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class InterpolationSearch {
    static long startTime = System.nanoTime();

    public static int interpolationSearch(int arr[], int lo,
            int hi, int x) {
        int pos;

        // Since array is sorted, an element
        // present in array must be in range
        // defined by corner
        if (lo <= hi && x >= arr[lo] && x <= arr[hi]) {

            // Probing the position with keeping
            // uniform distribution in mind.
            pos = lo
                    + (((hi - lo) / (arr[hi] - arr[lo]))
                            * (x - arr[lo]));

            // Condition of target found
            if (arr[pos] == x)
                return pos;

            // If x is larger, x is in right sub array
            if (arr[pos] < x)
                return interpolationSearch(arr, pos + 1, hi,
                        x);

            // If x is smaller, x is in left sub array
            if (arr[pos] > x)
                return interpolationSearch(arr, lo, pos - 1,
                        x);
        }
        return -1;
    }

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

    // Driver Code
    public static void main(String[] args) {

        // Array of items on which search will
        // be conducted.
        int[] data1 = readFiles("Java/Datasets/Dataset1000.txt");
        int[] data2 = readFiles("Java/Datasets/Dataset10000.txt");
        int[] data3 = readFiles("Java/Datasets/Dataset100000.txt");

        Arrays.sort(data1);
        Arrays.sort(data2);
        Arrays.sort(data3);

        int n = data3.length;

        // Element to be searched
        int x = 44551;
        int index = interpolationSearch(data3, 0, n - 1, x);

        // If element was found
        if (index != -1)
            System.out.println("Element found at index "
                    + index);
        else
            System.out.println("Element not found.");
        System.out.println(totalTime + " ns");
    }

    static long endTime = System.nanoTime();
    static long totalTime = endTime - startTime;
}
