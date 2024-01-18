public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = { 50, 40, 30, 20, 10 };
        int[] result = insertionSort(arr);

        System.out.println("Sorted array:");
        for (int num : result) {
            System.out.print(num + " ");
        }

        System.out.println("\nNumber of comparisons: " + comparisons);
    }

    static int comparisons = 0;

    public static int[] insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                comparisons++;
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = key;
        }

        return arr;
    }
}
