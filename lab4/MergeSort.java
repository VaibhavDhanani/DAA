package lab4;

public class MergeSort {
    static int comparisons = 0;
    static int swaps = 0;
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println("Case 1 - Sorted Order:");
        mergeSort(arr1, 0, arr1.length - 1);
        printResults(arr1);

        int[] arr2 = {5, 4, 3, 2, 1};
        resetCounters();
        System.out.println("\nCase 2 - Non-Increasing Order:");
        mergeSort(arr2, 0, arr2.length - 1);
        printResults(arr2);

        int[] arr3 = {3, 1, 4, 5, 2};
        resetCounters();
        System.out.println("\nCase 3 - Randomly Ordered:");
        mergeSort(arr3, 0, arr3.length - 1);
        printResults(arr3);
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; ++i)
            left[i] = arr[low + i];

        for (int j = 0; j < n2; ++j)
            right[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = low;

        while (i < n1 && j < n2) {
            comparisons++;
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }

    public static void resetCounters() {
        comparisons = 0;
        swaps = 0;
    }

    public static void printResults(int [] arr) {
        System.out.println("Sorted array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }

        System.out.println("\nNumber of comparisons: " + comparisons);
        System.out.println("Number of swaps: " + swaps);
    }
}

