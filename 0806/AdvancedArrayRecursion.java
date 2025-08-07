
import java.util.*;

public class RecursiveArrayOps {

    public static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = arr[high];
        int p = partition(arr, low, high, pivot);
        quickSort(arr, low, p - 1);
        quickSort(arr, p + 1, high);
    }

    private static int partition(int[] arr, int low, int high, int pivot) {
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i++, j);
            }
        }
        swap(arr, i, high);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static int[] mergeRec(int[] a, int i, int[] b, int j) {
        if (i >= a.length) {
            return Arrays.copyOfRange(b, j, b.length);
        }
        if (j >= b.length) {
            return Arrays.copyOfRange(a, i, a.length);
        }
        if (a[i] <= b[j]) {
            int[] rest = mergeRec(a, i + 1, b, j);
            int[] res = new int[rest.length + 1];
            res[0] = a[i];
            System.arraycopy(rest, 0, res, 1, rest.length);
            return res;
        } else {
            int[] rest = mergeRec(a, i, b, j + 1);
            int[] res = new int[rest.length + 1];
            res[0] = b[j];
            System.arraycopy(rest, 0, res, 1, rest.length);
            return res;
        }
    }

    public static int kthSmallest(int[] arr, int low, int high, int k) {
        if (low == high) {
            return arr[low];
        }
        int pivot = arr[high];
        int p = partition(arr, low, high, pivot);
        int leftCount = p - low + 1;
        if (k == leftCount) {
            return arr[p];
        }
        if (k < leftCount) {
            return kthSmallest(arr, low, p - 1, k); 
        }else {
            return kthSmallest(arr, p + 1, high, k - leftCount);
        }
    }

    public static boolean subsetSum(int[] arr, int idx, int target) {
        if (target == 0) {
            return true;
        }
        if (idx >= arr.length || target < 0) {
            return false;
        }
        if (subsetSum(arr, idx + 1, target)) {
            return true;
        }
        return subsetSum(arr, idx + 1, target - arr[idx]);
    }

    public static void main(String[] args) {
        int[] data = {5, 3, 8, 1, 4, 7, 2};
        System.out.println("原始陣列: " + Arrays.toString(data));

        int[] a = Arrays.copyOf(data, data.length);
        quickSort(a, 0, a.length - 1);
        System.out.println("遞迴快速排序後: " + Arrays.toString(a));

        int[] b = {0, 6, 9};
        int[] merged = mergeRec(a, 0, b, 0);
        System.out.println("遞迴合併排序陣列: " + Arrays.toString(merged));

        int k = 3;
        int[] copy = Arrays.copyOf(data, data.length);
        int kth = kthSmallest(copy, 0, copy.length - 1, k);
        System.out.println("第 " + k + " 小元素為: " + kth);

        int[] arr2 = {3, 34, 4, 12, 5, 2};
        int target = 9;
        System.out.println("是否存在子集總和 = " + target + " ? "
                + subsetSum(arr2, 0, target));
    }
}
