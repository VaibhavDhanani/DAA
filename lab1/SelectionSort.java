public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {50,40,30,20,10};
        int[] result = selectionSort(arr);

        System.out.println("Sorted array:");
        for (int num : result) {
            System.out.print(num + " ");
        }

        System.out.println("\nNumber of comparisons: " + comparisons);
        System.out.println("Number of swaps: " + swaps);
    }

    static int comparisons = 0;
    static int swaps = 0;

    public static int[] selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                comparisons++; 
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
            swaps++; 
        }

        return arr;
    }
}
