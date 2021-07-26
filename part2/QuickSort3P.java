import java.util.Arrays;

public class QuickSort3P extends QuickSort {
  public int[] sort(int[] arr, int left, int right) {
    if (left >= right || left < 0)
      return arr;
    maintainInvariant(arr, left, right);
    int a = left + 2;
    int b = left + 2;
    int c = right - 1;
    int d = right - 1;
    int p = arr[left];
    int q = arr[left + 1];
    int r = arr[right];
    while (b <= c) {
      while ((arr[b] < q) && (b <= c)) {
        if (arr[b] < p) {
          swap(arr, a, b);
          a = a + 1;
        }
        b = b + 1;
      }
      while ((arr[c] > q) && (b <= c)) {
        if (arr[c] > r) {
          swap(arr, c, d);
          d = d - 1;
        }
        c = c - 1;
      }
      if (b <= c) {
        if (arr[b] > r) {
          if (arr[c] < p) {
            swap(arr, b, a);
            swap(arr, a, c);
            a = a + 1;
          } else {
            swap(arr, b, c);
          }
          swap(arr, c, d);
          b = b + 1;
          c = c - 1;
          d = d - 1;
        } else {
          if (arr[c] < p) {
            swap(arr, b, a);
            swap(arr, a, c);
            a = a + 1;
          } else {
            swap(arr, b, c);
          }
          b = b + 1;
          c = c - 1;
        }
      }
    }
    a = a - 1;
    b = b - 1;
    c = c + 1;
    d = d + 1;
    swap(arr, left + 1, a);
    swap(arr, a, b);
    a = a - 1;
    swap(arr, left, a);
    swap(arr, right, d);
    // recursion
    // subarrays are currently not sorted
    // elements are less and bigger than q but not sorted
    sort(arr, left, a);
    sort(arr, a + 1, b);
    sort(arr, c - 1, d - 1);
    sort(arr, d, right);
    return arr;
  }

  private void maintainInvariant(int[] arr, int left, int right) {
    if (arr[left] > arr[right])
      swap(arr, left, right);
    if (arr[left] > arr[left + 1])
      swap(arr, left, left + 1);
    if (arr[left + 1] > arr[right])
      swap(arr, left + 1, right);
  }

  public String toString() {
    return "QuickSort3P";
  }

  public static void main(String[] args) {
    QuickSort3P test = new QuickSort3P();
    int[] arr = { 700, 3, 500, 8, 5, 9, 3, 209, 14, 13, 5, 7, 4, 1, 12, 6, 103, 92, 50 };
    int n = arr.length - 1;
    System.out.println(n);
    int[] sort1 = test.sort(arr, 0, n);
    // int[] sort2 = test.sort(sort1, 0, n);
    System.out.println(Arrays.toString(sort1));
    // System.out.println(Arrays.toString(test.quickSortGeneral(arr)));
  }
}
