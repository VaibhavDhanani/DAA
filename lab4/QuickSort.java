package lab4;

public class QuickSort {
    static int comparisons = 0;
    static int swaps = 0;
    public static void main(String[] args) {
        int[] sortedArr = {1, 2, 3, 4, 5};
        int[] decreasingArr = {5, 4, 3, 2, 1};
        int[] randomArr = {3, 1, 4, 5, 2};

        System.out.println("Case 1: Sorted Order");
        quickSort(sortedArr, 0, sortedArr.length - 1);
        printResults(sortedArr);

        System.out.println("\nCase 2: Non-Increasing Order");
        resetCounters();
        quickSort(decreasingArr, 0, decreasingArr.length - 1);
        printResults(decreasingArr);

        System.out.println("\nCase 3: Randomly Ordered");
        resetCounters();
        quickSort(randomArr, 0, randomArr.length - 1);
        printResults(randomArr);
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            comparisons++;
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                swaps++;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        swaps++;
        return i + 1;
    }

    public static void resetCounters() {
        comparisons = 0;
        swaps = 0;
    }

    public static void printResults(int [] arr) {
        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println("\nNumber of comparisons: " + comparisons);
        System.out.println("Number of swaps: " + swaps);
    }
}

