import java.util.Arrays;

public class QuickSort2P extends QuickSort {
    public int[] sort(int[] arr, int left, int right) {
        if (right - left >= 1) {
            int p = arr[left];
            int q = arr[right];
            if (p > q) { // instead of arr[left] > arr[right]
                swap(arr, left, right);
                int tmp = p;
                p = q;
                q = tmp;
            }
            int l = left + 1; // i <- a left pointer, keeps truck of the begining of the array
            int g = right - 1; // j <- a right pointer, goes backwards the array
            int k = l; // its the second left pointer, it does not move then the l does
            while (k <= g) {
                if (arr[k] < p) {
                    swap(arr, k, l);
                    l = l + 1;
                } else if (arr[k] > q) {
                    while ((arr[g] > q) && (k < g)) {
                        g--;
                    }
                    swap(arr, k, g);
                    g = g - 1;
                    if (arr[k] < p) {
                        swap(arr, k, l);
                        l = l + 1;
                    }
                }
                // k = left;
                k = k + 1;
            }
            l = l - 1;
            g = g + 1;
            swap(arr, left, l);
            swap(arr, right, g);
            sort(arr, left, l - 1);
            sort(arr, l + 1, g - 1);
            sort(arr, g + 1, right);
        }
        return arr;
    }

    public String toString() {
        return "QuickSort2P";
    }

    public static void main(String[] args) {
        QuickSort2P test = new QuickSort2P();
        int[] arr = { 209, 3, 8, 5, 9, 14, 13, 7, 4, 1, 12, 6, 103, 92, 50, 1 };
        int n = arr.length - 1;
        System.out.println(n);
        System.out.println(Arrays.toString(test.sort(arr, 0, n)));
        // System.out.println(Arrays.toString(test.quickSortGeneral(arr)));
    }
}