package lab4;

public class MaxSumSubarray {
    static class Result {
        int maxSum;
        int leftIndex;
        int rightIndex;

        Result(int maxSum, int leftIndex, int rightIndex) {
            this.maxSum = maxSum;
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
        }
    }

    public static void main(String[] args) {
        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};
        Result result = findMaxSumSubarray(arr, 0, arr.length - 1);

        System.out.println("Maximum sum is: " + result.maxSum);
        System.out.println("Subarray from index " + result.leftIndex + " to " + result.rightIndex);
    }

    public static Result findMaxSumSubarray(int[] arr, int low, int high) {
        if (low == high) {
            return new Result(arr[low], low, high);
        }

        int mid = (low + high) / 2;

        Result leftResult = findMaxSumSubarray(arr, low, mid);
        Result rightResult = findMaxSumSubarray(arr, mid + 1, high);
        Result crossResult = findMaxCrossingSubarray(arr, low, mid, high);

        if (leftResult.maxSum >= rightResult.maxSum && leftResult.maxSum >= crossResult.maxSum) {
            return leftResult;
        } else if (rightResult.maxSum >= leftResult.maxSum && rightResult.maxSum >= crossResult.maxSum) {
            return rightResult;
        } else {
            return crossResult;
        }
    }

    public static Result findMaxCrossingSubarray(int[] arr, int low, int mid, int high) {
        int leftSum = Integer.MIN_VALUE;
        int sum = 0;
        int maxLeft = 0;

        for (int i = mid; i >= low; i--) {
            sum += arr[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }

        int rightSum = Integer.MIN_VALUE;
        sum = 0;
        int maxRight = 0;

        for (int i = mid + 1; i <= high; i++) {
            sum += arr[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }

        return new Result(leftSum + rightSum, maxLeft, maxRight);
    }
}
